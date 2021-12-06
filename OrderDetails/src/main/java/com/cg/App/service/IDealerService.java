package com.cg.App.service;

import java.util.List;
import java.util.Optional;

import com.cg.App.exception.MyDealerException;
import com.cg.App.model.Dealer;




public interface IDealerService {

	public Dealer addDealer(Dealer dealer) throws MyDealerException;
	public List<Dealer> getDealerList()throws MyDealerException;
	public Optional<Dealer> getDealerById(Long dealerId) throws MyDealerException;
	public void delete(Long dealerId)throws MyDealerException;
	public Dealer updateDealer(Dealer dealer, Long dealerId)throws MyDealerException;
	
}
