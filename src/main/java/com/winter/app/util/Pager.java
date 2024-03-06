package com.winter.app.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {

	private Long page; //Page 번호
	private Long perPage; //한 페이지당 출력 갯수 (몇개씩 출력 하고싶냐)
	private Long startIndex; //시작번호
	
	private Long totalPage;
	private Long startNum;
	private Long lastNum;
	
	//이전 블럭이 없으면 true;
	private boolean start;
	//다음 블럭이 없으면 true;
	private boolean last;
	
	//검색 관련
	private String search;
	private String kind;
	
	
	
	
	public void makeIndex() {
		this.startIndex=(this.getPage()-1)*this.getPerPage();
	}

	//값을 일부러 넣어줘야해서 만듬
	//Getter/Setter
	//public 리턴타입 get,set멤버변수명[첫글자 대문자](){}
	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return this.page;
	}
	public Long getPerPage() {
		if(this.perPage==null || this.perPage<1) {
			this.perPage=10L;
		}
		return this.perPage;
	}
	
	
	
	public void makeNum(Long totalCount) {
		if(totalCount<1) {
			totalCount=1L;
		}
		
		totalPage = totalCount/this.getPerPage();
		
		
		if(totalCount%this.getPerPage() != 0) {
			//totalPage=totalPage+1;
			totalPage++;
		}
		
		//this.setTotalPage(totalPage);
	}
	
	
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return this.search;
	}
	
}
