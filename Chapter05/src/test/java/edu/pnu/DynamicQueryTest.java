package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;
import edu.pnu.persistence.DynamicBoardRepository;

@SpringBootTest
public class DynamicQueryTest {
	
	@Autowired
	private DynamicBoardRepository boardRepo;
//	
//	@Test
//	public void testDynamicQuery() {
//		String searchCondition = "TITLE";
//		String serachKeyword = "title10";
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		//booleanbuilder 객체를 이용하면 동적으로 and나 or 조건을 추가할 수 있음.
//		
//		QBoard qboard = QBoard.board;		
//		
//		if(searchCondition.equals("TITLE")) {
//			builder.and(qboard.title.contains(serachKeyword));
//		} else if (searchCondition.equals("CONTENT")) {
//			builder.and(qboard.content.like("%"+ serachKeyword + "%"));	
//		}
//		
//		Pageable paging = PageRequest.of(0, 5);
//		//페이징 처리를 위한 paging객체 만들어 전달, boardRepo에 builder(동적쿼리)와 paging 함께 전달함 
//		Page<Board> boardList = boardRepo.findAll(builder, paging);
//		System.out.println("검색 결과");
//		for (Board board : boardList)
//			System.out.println("--->" + board);
//		}
}
