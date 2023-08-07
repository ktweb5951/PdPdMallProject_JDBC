package freeBoard.model.vo;

import java.sql.*;

public class FreeBoard {
	private int freeBoardNo;
	private String freeBoardTitle;
	private String freeBoardContent;
	private String freeBoardWriter;
	private int viewCount;
	private int rcmndCount;
	private Timestamp freeBoardDate;
	private Timestamp updateDate;
	
	public FreeBoard() {
	}
	

	public FreeBoard(String freeBoardTitle, String freeBoardContent) {
		super();
		this.freeBoardTitle = freeBoardTitle;
		this.freeBoardContent = freeBoardContent;
	}


	public FreeBoard(String freeBoardTitle, String freeBoardContent, String freeBoardWriter) {
		super();
		this.freeBoardTitle = freeBoardTitle;
		this.freeBoardContent = freeBoardContent;
		this.freeBoardWriter = freeBoardWriter;
	}


	public int getFreeBoardNo() {
		return freeBoardNo;
	}

	public void setFreeBoardNo(int freeBoardNo) {
		this.freeBoardNo = freeBoardNo;
	}

	public String getFreeBoardTitle() {
		return freeBoardTitle;
	}

	public void setFreeBoardTitle(String freeBoardTitle) {
		this.freeBoardTitle = freeBoardTitle;
	}

	public String getFreeBoardContent() {
		return freeBoardContent;
	}

	public void setFreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}

	public String getFreeBoardWriter() {
		return freeBoardWriter;
	}

	public void setFreeBoardWriter(String freeBoardWriter) {
		this.freeBoardWriter = freeBoardWriter;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getRcmndCount() {
		return rcmndCount;
	}

	public void setRcmndCount(int rcmndCount) {
		this.rcmndCount = rcmndCount;
	}

	public Timestamp getFreeBoardDate() {
		return freeBoardDate;
	}

	public void setFreeBoardDate(Timestamp freeBoardDate) {
		this.freeBoardDate = freeBoardDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	


	@Override
	public String toString() {
		return "FreeBoard [freeBoardNo=" + freeBoardNo + ", freeBoardTitle=" + freeBoardTitle + ", freeBoardContent="
				+ freeBoardContent + ", freeBoardWriter=" + freeBoardWriter + ", viewCount=" + viewCount
				+ ", rcmndCount=" + rcmndCount + ", freeBoardDate=" + freeBoardDate + ", updateDate=" + updateDate
				+ "]";
	}

	
}
