package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClientPersist { 
	
	public static void main(String[] args) {
		//EntityManager생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			
			for (int i=2; i<11; i++) { //보드하나가 엔티티하나. em은매니저 한테 말해줘야됨.
				Board board = new Board();
				board.setTitle("JPA 제목" + i);
				board.setWriter("Writer" + i);
				board.setContent("Content" + i);
				board.setCreateDate(new Date());
				board.setCnt(0L);
				em.persist(board);
				}
			//글 등록
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
