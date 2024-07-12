package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {
	
	//boardrepository는 영속으로 넘어간 persistence 상태에 있는것들
	
	private final BoardRepository boardRepo;
	
	@GetMapping("/board")
	public List<Board> getBoards(){
		return boardRepo.findAll();
	}
	
	@GetMapping("/board/{seq}")
	public Board getBoard (@PathVariable Long seq) { //@PathVariable- params 아니고 주소 경로상에 변수를 설정하겠다는 의미 
		return boardRepo.findById(seq).get();
	}
	
	@PostMapping("/board")
	public Board postBoard(@RequestBody Board board) {
		return boardRepo.save(board);
	}
	
	@PutMapping("/board")
	public Board putBoard(@RequestBody Board board) { //@RequestBody는 body-raw-json. json으로 데이터를 받겠다는 의미 
		Board b = boardRepo.findById(board.getSeq()).orElseThrow(); //내가 놓친 점- 수정할 객체인 b를 변수로명시안해줘서. 
		if (board.getTitle() != null) b.setTitle(board.getTitle());
		if (board.getContent() != null) b.setContent(board.getContent());
		return boardRepo.save(b);
	}
	
	@DeleteMapping("/board/{seq}")
	public Board deleteBoard(@PathVariable Long seq) {
		Board b = boardRepo.findById(seq).orElseThrow();
		boardRepo.deleteById(seq);
		return b; 
		//내가 틀린 점-자꾸 return을 boardRepo.findAll()로 해서
		//1. 내가 넣은 seq로 찾아지는 해당 객체를 b라고 먼저 설정해주어야 걔를 지울수있다.
		//2. 영속상태 repo에서 내가넣은 seq를 지우고
		//3. 그 객체 b를 리턴해 주도록.
	}
}

	