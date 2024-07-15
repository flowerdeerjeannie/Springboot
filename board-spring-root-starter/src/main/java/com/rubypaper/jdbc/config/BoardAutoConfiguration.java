package com.rubypaper.jdbc.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Configuration
public class BoardAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	
	//bean을 찾을수없으면 얘를 만들어라 라고 condition을 다는 것, 있으면 있는거쓰고 
	JDBCConnectionManager getJDBCConectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setUrl("jdbc:mysql://localhost:3306/musthave");
		manager.setUsername("scott");
		manager.setPassword("tiger");
		return manager;
	}
}
