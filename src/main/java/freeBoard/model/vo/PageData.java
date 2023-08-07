package freeBoard.model.vo;

import java.util.List;

public class PageData {
	private List<FreeBoard> fList;
	private String pageNavi;
	
	public PageData() {
	}

	public PageData(List<FreeBoard> fList, String pageNavi) {
		super();
		this.fList = fList;
		this.pageNavi = pageNavi;
	}

	public List<FreeBoard> getfList() {
		return fList;
	}

	public void setfList(List<FreeBoard> fList) {
		this.fList = fList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [fList=" + fList + ", pageNavi=" + pageNavi + "]";
	}
	
}
