package edu.pnu;

import java.util.Date;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

//데이터 넣어주는용도의 클래스 datainit
//이 클래스 자체가 bean객체로 올라가야되기때문에 @Component 필수

@RequiredArgsConstructor
@Component
public class DataInit implements ApplicationRunner {

	private final BoardRepository boardRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		for (int i=1; i<=5; i++) {
			boardRepo.save(Board.builder()
					.title("title1"+i)
					.writer("member1")
					.content("content1" + i)
					.createDate(new Date())
					.cnt((long)(Math.random()*100))
					.build()
			);
		}
		
		for (int i = 1; i<=5; i++) {
			boardRepo.save(Board.builder()
					.title("title2"+i)
					.writer("member2")
					.content("content2" + i)
					.createDate(new Date())
					.cnt((long)(Math.random()*100))
					.build()
				);
		}
	}
}
