package com.dvc;

public class BookingRequest {

	// DVC products added "beach club", "aulani", "old key","bay lake","gcal" "boulder","hilton"	
	// DCI Products added "beach club", "aulani","coronado","all star music","yacht"
		
	// DLR Products "disneyland hotel" "paradise pier hotel"
	// DLP Products "village nature paris", "disneyland hotel paris", "disney sequoia lodge", "hotel newyork", "newport bay club",
	// HKDR Products "disney explorers lodge", "disney hollywood hotel" "hongkong disneyland hotel"				
	// TKDR Products "disney ambassador hotel" "tokyo disney celebration" "toy story"  "miracost" "tokyo disneyland hotel" 			

	public String required_month = "January";
	public int day = 10; // not Accurate giving JSPath is Accurate
	// public  String dayJSPathQuery = "return <js path>";
	public String dayJSPathQuery = null;

	public String MembershipID = "486430619946";
	public String MemberID = "738253";
	
	public String prodCategory = "hkdr";
	public String productName = "disney explorers lodge";	
	public boolean isAdaRequested = false;
	public boolean isEIEnabled = false;
	
	public boolean cancelReservation = false;

	
	
	public boolean isCancelReservation() {
		return cancelReservation;
	}

	public void setCancelReservation(boolean cancelReservation) {
		this.cancelReservation = cancelReservation;
	}

	public String getRequired_month() {
		return required_month;
	}

	public void setRequired_month(String required_month) {
		this.required_month = required_month;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getDayJSPathQuery() {
		return dayJSPathQuery;
	}

	public void setDayJSPathQuery(String dayJSPathQuery) {
		this.dayJSPathQuery = dayJSPathQuery;
	}

	public String getMembershipID() {
		return MembershipID;
	}

	public void setMembershipID(String membershipID) {
		MembershipID = membershipID;
	}

	public String getMemberID() {
		return MemberID;
	}

	public void setMemberID(String memberID) {
		MemberID = memberID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isAdaRequested() {
		return isAdaRequested;
	}

	public void setAdaRequested(boolean isAdaRequested) {
		this.isAdaRequested = isAdaRequested;
	}

	public boolean isEIEnabled() {
		return isEIEnabled;
	}

	public void setEIEnabled(boolean isEIEnabled) {
		this.isEIEnabled = isEIEnabled;
	}

}
