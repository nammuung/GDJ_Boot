package com.winter.app.board;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Data Getter, Setter을 만들어줌 
//@AllArgsConstructor  // 모든 매개변수를 만드는 생성자를 만들어줌
//@NoArgsConstructor // 매개변수가 없는 기본 생성자
public class BoardVO {

	private Long boardNum;
	private String boardWriter;
	private String boardTitle;
	private String boardContents;
	private Date boardDate;
	private Long boardHit;
	
	private List<FileVO> fileVOs;
	
	
}
