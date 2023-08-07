package member.model.vo;

import java.sql.Timestamp;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberNickname;
	private String memberPhone;
	private String memberAddress;
	private String postalCodeOne;
	private String postalCodeTwo;
	private String memberEmail;
	private Timestamp memberDate;
	
	
	public Member() {
	}


	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}






	public Member(String memberId, String memberPw, String memberNickname, String memberPhone, String memberAddress,
			String postalCodeOne, String postalCodeTwo, String memberEmail) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNickname = memberNickname;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.postalCodeOne = postalCodeOne;
		this.postalCodeTwo = postalCodeTwo;
		this.memberEmail = memberEmail;
	}


	public Member(String memberId, String memberPw, String memberName, String memberNickname, String memberPhone,
			String memberAddress, String postalCodeOne, String postalCodeTwo, String memberEmail) {
		
		
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberNickname = memberNickname;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.postalCodeOne = postalCodeOne;
		this.postalCodeTwo = postalCodeTwo;
		this.memberEmail = memberEmail;
	}



	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPw() {
		return memberPw;
	}


	public String getPostalCodeOne() {
		return postalCodeOne;
	}


	public void setPostalCodeOne(String postalCodeOne) {
		this.postalCodeOne = postalCodeOne;
	}


	public String getPostalCodeTwo() {
		return postalCodeTwo;
	}


	public void setPostalCodeTwo(String postalCodeTwo) {
		this.postalCodeTwo = postalCodeTwo;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberNickname() {
		return memberNickname;
	}


	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberAddress() {
		return memberAddress;
	}


	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}



	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Timestamp getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Timestamp memberDate) {
		this.memberDate = memberDate;
	}


	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberNickname=" + memberNickname + ", memberPhone=" + memberPhone + ", memberAddress="
				+ memberAddress + ", postalCodeOne=" + postalCodeOne + ", postalCodeTwo=" + postalCodeTwo
				+ ", memberEmail=" + memberEmail + ", memberDate=" + memberDate + "]";
	}




	
	
}
