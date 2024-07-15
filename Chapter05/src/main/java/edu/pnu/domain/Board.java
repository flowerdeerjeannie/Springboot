package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Builder는 생성자 안만들어주므로, @NO랑@all로 생성자 따로 만들어줘야 실행가능함
public class Board { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
//	private String writer;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	
	//다대일 매핑 추가
	@ManyToOne
	@JoinColumn(name="MEMBER_ID") //Member테이블의 id 필드와 연결될 필드명. 
	private Member member;
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}

}
