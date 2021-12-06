package com.cg.App.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  productId;
	
	@Column(name = "prodName", nullable = false, length = 255)
	@NotBlank(message = "Product name can not be blank")
	private String prodName;
	
	@Column(name = "price", nullable = false, length = 255)
	@NotBlank(message = "Price can not be blank")
	private double price;
	
	@Column(name = "batchno", nullable = false, length = 255)
	@NotBlank(message = "Batch No. can not be blank")
	private long batchNo;
	
	@Column(name = "mfgName", nullable = false, length = 255)
	@NotBlank(message = "Manufacturer Name can not be blank")
	private String manufacturerName;
	
	@Column(name="mfgDate")
	private Date mfgDate;
	
	@Column (name ="expDate")
	private Date expDate;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long productId, String prodName, double price, long batchNo, String manufacturerName, Date mfgDate,
			Date expdate) {
		super();
		this.productId = productId;
		this.prodName = prodName;
		this.price = price;
		this.batchNo = batchNo;
		this.manufacturerName = manufacturerName;
		this.mfgDate = mfgDate;
		this.expDate = expdate;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(long batchNo) {
		this.batchNo = batchNo;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public Date getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}
	public Date getExpdate() {
		return expDate;
	}
	public void setExpdate(Date expdate) {
		this.expDate = expdate;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodName=" + prodName + ", price=" + price + ", batchNo="
				+ batchNo + ", manufacturerName=" + manufacturerName + ", mfgDate=" + mfgDate + ", expdate=" + expDate
				+ "]";
	}
	
	
}
