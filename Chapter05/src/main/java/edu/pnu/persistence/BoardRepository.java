package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.pnu.domain.Board;

//JpaRepository<Board:엔티티의 클래스 타입, Long:식별자 타입.@Id로 매핑한 식별자 변수의 타입>
public interface BoardRepository extends JpaRepository<Board, Long> {

}
