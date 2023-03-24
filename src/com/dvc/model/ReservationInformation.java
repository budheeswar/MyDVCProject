package com.dvc.model;

public class ReservationInformation {
	
	public String reservation_info;
	public String memberID;
	public String productName;
	public boolean isEIEnabled;
	public boolean isADARequested;
	public String getReservation_info() {
		return reservation_info;
	}
	public void setReservation_info(String reservation_info) {
		this.reservation_info = reservation_info;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public boolean isEIEnabled() {
		return isEIEnabled;
	}
	public void setEIEnabled(boolean isEIEnabled) {
		this.isEIEnabled = isEIEnabled;
	}
	public boolean isADARequested() {
		return isADARequested;
	}
	public void setADARequested(boolean isADARequested) {
		this.isADARequested = isADARequested;
	}
	public ReservationInformation(String reservation_info, String memberID, String productName, boolean isEIEnabled,
			boolean isADARequested) {
		super();
		this.reservation_info = reservation_info;
		this.memberID = memberID;
		this.productName = productName;
		this.isEIEnabled = isEIEnabled;
		this.isADARequested = isADARequested;
	}
	public ReservationInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
