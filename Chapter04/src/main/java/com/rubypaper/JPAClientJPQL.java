package com.rubypaper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.rubypaper.domain.Board;

public class JPAClientJPQL {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		//b는 Board의 하나하나 객체를 말하는것이므로 list에서 b를 출력하는 for문을 따로작성해줘야됨
		//일반 sql문과는 다르게, table을 내가 이 domain-Board.java에서 만들었으므로
		//모든기준은 얘가 되어야함.. 그래서 from board하면 안되고 from Board
		try {
			String jpql = "select b from Board b where b.title like '%타이틀%'";
			TypedQuery<Board> tq = em.createQuery(jpql, Board.class);
			List<Board> list = tq.getResultList();
			
			for (Board b : list)
				System.out.println(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
