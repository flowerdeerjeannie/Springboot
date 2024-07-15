package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	public void testFindByTitle() {
//		
//		List<Board> list = boardRepo.findByTitle("title10");
//		System.out.println("--> testFindByTtitle");
//		for (Board b : list)
//			System.out.println(b);
//	}
	
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("5");
//		
//		System.out.println("검색결과");
//		for (Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("5", "7");
//		
//		System.out.println("검색결과");
//		for (Board board : boardList) {
//			System.out.println("--->"+board.toString());
//		}
//	}
	
//	@Test
//	public void testfindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("7");
//		System.out.println("7 포함한 타이틀을 seq 순으로 내림차순 정렬");
//		for (Board b:boardList) {
//			System.out.println("--->"+b.toString());
//		}
//	}
	
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5); //5개로 나누어서 0번째 페이지 출력
//		List<Board> boardList = boardRepo.findByTitleContaining("title", paging);
//		
//		System.out.println("첫번째 페이지 다섯개 데이터만 출력");
//		for (Board b: boardList) {
//			System.out.println("--->"+b.toString());
//		}
//	}
}
	
