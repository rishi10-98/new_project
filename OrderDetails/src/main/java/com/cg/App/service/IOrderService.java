
package com.cg.App.service;
import java.util.Optional;


import com.cg.App.exception.MyOrderException;

import com.cg.App.model.Order;

import java.util.List;


public interface IOrderService{
	
	public Order addOrder(Order order) throws MyOrderException;
	public List<Order> getOrderList()throws MyOrderException;
	public Optional<Order> getOrderById(Long orderId) throws MyOrderException;
	public void deleteOrder(Long orderId)throws MyOrderException;
	public Order updateOrder(Order order, Long orderId)throws MyOrderException;
	
}




	
	
