package edu.pnu;

import java.util.Date;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

//데이터 넣어주는용도의 클래스 datainit
//이 클래스 자체가 bean객체로 올라가야되기때문에 @Component 필수

@RequiredArgsConstructor
@Component
public class DataInit2 implements ApplicationRunner {

	private final BoardRepository boardRepo;
	private final MemberRepository memberRepo;
	//멤버엔티티가 생겼기때문에 얘를 영속적으로 저장해줄 멤버레포가 있어야됨
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Member m1 = Member.builder()
				.id("member1")
				.password("member111")
				.name("둘리")
				.role("User").build();
		memberRepo.save(m1);
		
		Member m2 = Member.builder() //멤버객체 m1, m2를 만들어서 builder로 데이터를 넣어줌
				.id("member2")
				.password("member222")
				.name("도우너")
				.role("Admin").build();
		memberRepo.save(m2); //repo에 저장한다.
		
		
		for (int i=1; i<=100; i++) {
			boardRepo.save(Board.builder()
					.title("title"+i)
					.content("content" + i)
					.createDate(new Date())
					.cnt((long)(Math.random()*100))
					.member(m1) //member를 join하기 위해서는 여기서 boardRepo에도 이 .member를 추가해줘야됨!! 
					.build()
			);
		}
		
		for (int i = 1; i<=100; i++) {
			boardRepo.save(Board.builder()
					.title("title"+i)
					.content("content" + i)
					.createDate(new Date())
					.cnt((long)(Math.random()*100))
					.member(m2)
					.build()
				);
		}
	}
}
