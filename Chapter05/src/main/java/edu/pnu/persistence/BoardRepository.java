package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

//JpaRepository<Board:엔티티의 클래스 타입, Long:식별자 타입.@Id로 매핑한 식별자 변수의 타입>
public interface BoardRepository extends JpaRepository<Board, Long> {

//	List<Board> findByTitle(String title);
	
//	List<Board> findByContentContaining(String searchKeyword);
	
//	List<Board> findByTitleContainingOrContentContaining(String title, String content);

//	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
//	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
	//?1이라고 하면 첫번째 파라미터를 의미함. 그래서 테스트클래스에서 title10 를 파라미터로 줬을때 이게 like title10 으로 들어가지는것
	
//	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest4(Pageable paging);
//	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
//			+ "FROM Board b "
//			+ "WHERE b.title like %?1% "
//			+ "ORDER BY b.seq DESC ")
//	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
}
