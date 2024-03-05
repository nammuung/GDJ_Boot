package com.winter.app.board.notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.winter.app.board.BoardDAO;

@Mapper  //Repository 역할을 함 상속받은 DAO에서 패키지명, 메서드명, 매개변수 받아옴
public interface NoticeDAO extends BoardDAO{

	
	
	
}
