package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClientUpdate {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			//매니저 em이 Board라는 이름의 class를 찾는데, primary id=1이고 long type인거 찾아서 seachBoard라고 하겠다.
			//그 내용은 toString메소드를 통해 출력되도록 설정되어있음.
			Board searchBoard = em.find(Board.class, 1L);
			System.out.println("--->" + searchBoard);
			//seachBoard의 타이틀을 아래와 같이 변경한다.
			searchBoard.setTitle("수정된 타이틀");
			
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
