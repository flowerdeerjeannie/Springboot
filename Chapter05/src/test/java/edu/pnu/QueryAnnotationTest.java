package edu.pnu;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {

	@Autowired
	private BoardRepository boardRepo;
//	
//	@Test
//	public void testQueryAnnotationTest1() {
//		List<Board> boardList = boardRepo.queryAnnotationTest1("title10");
//		
//		System.out.println("검색 결과");
//		for (Board b : boardList) {
//		System.out.println("--->"+b.toString());
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest4() { //쿼리로 페이징까지 테스트
//		Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "seq"); //3개씩 했을때 0번째 인덱스의 데이터 세개를 보여달라, seq를 기준으로 내림차순 정렬하라는 "페이징 객체"를 쿼리테스트에 전달함.
//		List<Board> boardList = boardRepo.queryAnnotationTest4(paging);
//		
//		System.out.println("검색 결과");
//		for (Board b : boardList) {
//		System.out.println("--->"+b.toString());
//		}
//	}
//	
//	@Test
//	public void testqueryAnnotationTest2() {
//		List<Object[]> boardList = boardRepo.queryAnnotationTest2("title10");
//		
//		System.out.println("검색 결과");
//		for (Object[] row : boardList) {
//			System.out.println("--->"+Arrays.toString(row));
//		}
//	}
}
