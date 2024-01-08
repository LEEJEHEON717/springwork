package com.khit.todoweb.unittest;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class MyBatisTest {
	//try ~ resource문 - close()를 사용하지 않음
	@Autowired
	private SqlSessionFactory sql;
	
	@Test
	public void testMyBatis() {
		try(SqlSession session = sql.openSession()){
			Connection con = session.getConnection();
			log.info("session=" + session);
			log.info("con=" + con);
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
