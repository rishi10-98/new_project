package com.cg.App.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.App.exception.MyDealerException;
import com.cg.App.model.Dealer;
import com.cg.App.repository.DealerRepository;

@Service
public class DealerService implements IDealerService {
 
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);


    @Autowired
    private DealerRepository dealerRepository;


	@Override
	public Dealer addDealer(Dealer dealer) throws MyDealerException {
		logger.info("Add dealer in service layer "+ dealer);
        return dealerRepository.save(dealer);
	}


	@Override
	public List<Dealer> getDealerList() throws MyDealerException {
		 logger.info("Fetch all dealer in service layer ");
	        return dealerRepository.findAll();
	}


	@Override
	public Optional<Dealer> getDealerById(Long dealerId) throws MyDealerException {
	    logger.info("Trying to fetch dealer in service layer ");
        return dealerRepository.findById(dealerId);
	}


	@Override
	public void delete(Long dealerId) throws MyDealerException {
		 logger.info("Delete dealer in service layer ");
		 dealerRepository.deleteById(dealerId);
		
	}


	@Override
	public Dealer updateDealer(Dealer dealer, Long dealerId) throws MyDealerException {
		logger.info("Trying to update Dealer in service layer ");
	    Optional<Dealer> dealerFound = getDealerById(dealerId);
	    Dealer exRecord=dealerRepository.getOne(dealerId);
	    BeanUtils.copyProperties(dealer, exRecord,"dealerId");
	    return dealerRepository.save(exRecord);
	}


}
