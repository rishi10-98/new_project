package com.cg.App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "DETAIL")
public class Dealer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long dealerId;

	@Column(name="DEALER_NAME", nullable = false, length = 255)
	private String dealerName;

	@Column(name="DEALER_EMAIL", nullable = false, length = 255)
	private String email;
	
	@Column(name="CONTACT_NUMBER", nullable = false, length = 255)
	private Long contactNumber;

	
	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Dealer(Long dealerId, String dealerName, String email, Long contactNumber) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.email = email;
		this.contactNumber = contactNumber;
	}


	public Long getDealerId() {
		return dealerId;
	}


	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}


	public String getDealerName() {
		return dealerName;
	}


	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}


	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", email=" + email + ", contactNumber="
				+ contactNumber + "]";
	}
	

}
