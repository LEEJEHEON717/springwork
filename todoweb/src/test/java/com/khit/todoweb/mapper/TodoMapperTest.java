package com.khit.todoweb.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.vo.TodoVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class TodoMapperTest {
	
	@Autowired	//자동주입 - todoMapper가 new한거랑 같음
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime());
	}
	
	/*@Test
	public void testInsert() {
		//데이터 1개 생성 - setter -> builer()
		
		/*TodoVO todoVO = new TodoVO();
		//todoVO.setTno(1L);
		todoVO.setTitle("12시 전에 취침 실패");
		todoVO.setWriter("대상현");
		//todoVO.setCreatedDate(new Timestamp(System.currentTimeMillis()));*/
		
		/*TodoVO todoVO = TodoVO.builder()
				.title("20분 운동하기")
				.writer("user01")
				.build();
		
		todoMapper.insert(todoVO);
	}*/
		
	@Test
	public void testFindAll() {
		//db에 있는 데이터 추출하기(검색하기)
		List<TodoVO> todoList = todoMapper.findAll();
		
		/*for(TodoVO todo : todoList) {
			log.info(todo);
		}*/
		//todoList.forEach(todo -> log.info(todo));
	}
	
	@Test
	public void testFindById() {
		//db에서 1번 데이터 검색value="${todo.title}"
		TodoVO todoVO = todoMapper.findById(1L);
		//log.info(todoVO);
	}
	
	/*@Test
	public void testDelete() {
		todoMapper.delete(8L);
		log.info("삭제 완료");
	}*/
	
	/*@Test
	public void testUpdate() {
		TodoVO todoVO = todoMapper.findById(15L);
		todoVO.setTno(15L);
		todoVO.setTitle("test-수정");
		todoVO.setWriter("tester-수정");
		
		todoMapper.update(todoVO);
	}*/
	
	/*@Test
	public void testPagingList() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.build();
		
		List<TodoVO> todoList = todoMapper.pagingList(pageRequestDTO);

		for(TodoVO todo : todoList) {
			log.info(todo);
		}
	}*/
	@Test
	public void testSelectSearch() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.types(new String[] {"t","w"})
				.keyword("운동")
				.build();
		List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		
		for(TodoVO todoVO : voList) {
			log.info(todoVO);
		}
	}
}
