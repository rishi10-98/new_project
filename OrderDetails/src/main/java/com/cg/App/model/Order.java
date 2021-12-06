package com.cg.App.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class Order{

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long orderId;

@OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
@JoinColumn(name="oid_fk",referencedColumnName="orderId")
private List<Product> product;

@OneToOne(targetEntity=Dealer.class,cascade=CascadeType.ALL)
@JoinColumn(name="oid_fk",referencedColumnName="dealerId")
private Dealer dealer;

public Order() {
	super();
	// TODO Auto-generated constructor stub
}

public Order(Long orderId, List<Product> product, Dealer dealer) {
	super();
	this.orderId = orderId;
	this.product = product;
	this.dealer = dealer;
}

public Long getOrderId() {
	return orderId;
}

public void setOrderId(Long orderId) {
	this.orderId = orderId;
}

public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}

public Dealer getDealer() {
	return dealer;
}

public void setDealer(Dealer dealer) {
	this.dealer = dealer;
}

@Override
public String toString() {
	return "Order [orderId=" + orderId + ", product=" + product + ", dealer=" + dealer + "]";
}




}

