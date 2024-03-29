package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.winter.app.board.BoardVO;
import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest

class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	void getListTest() throws Exception{
		Pager pager = new Pager();
		/* pager.setPage(); */
		pager.makeIndex();
		
		
		Long totalCount =  noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		
		
		List<BoardVO> ar = noticeDAO.getList(pager);
		assertEquals(10, ar.size());
	}
	
	
	//@Test
	void addTest() throws Exception{
		for(int i=0;i<120;i++) {
		NoticeVO notcieVO = new NoticeVO();
		notcieVO.setBoardWriter("tester"+i);
		notcieVO.setBoardTitle("title"+i);
		notcieVO.setBoardContents("test Content"+i);
		int result = noticeDAO.add(notcieVO);
		}
		System.out.println("종료");
//		assertEquals(1, result);
	}

}
