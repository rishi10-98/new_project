package com.cg.App.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.App.exception.DealerNotFoundException;
import com.cg.App.model.Dealer;
import com.cg.App.service.IDealerService;




@RestController//combinatin of @Controller and @ResponseBody
//contoller return  view and restcontroller return response body
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/dealer")
public class DealerController {

		 private static final Logger logger = LoggerFactory.getLogger(DealerController.class);
		    @Autowired
		    private IDealerService dealerService;
		    /*
		     * http://localhost:8080/dealer/add
		     * This particular url is response for adding dealer
		     * HTTP Method post is required
		     */
		    //ResponseEntity represent the whole http responce:status code,header,body=>this is generic Type

		    @PostMapping(value = "/add")
		    public ResponseEntity<Dealer> addDealer( @RequestBody Dealer dealer) throws DealerNotFoundException {
		        try {
		            logger.info("Trying to add Record  : " + dealer);
		            Dealer addedDealer = dealerService.addDealer(dealer);
		            return new ResponseEntity<>(dealer, HttpStatus.CREATED);//201
		        } catch (Exception e) {
		            logger.error("Record NOT Added  : " +dealer);
		            return new ResponseEntity<>(dealer, HttpStatus.EXPECTATION_FAILED);    //417
		        }
		    }
		    
		    /*
		     * http://localhost:8080/dealer/getAll
		     * This particular url is response for getting all dealer 
		     * HTTP Method get is required
		     */

		        @GetMapping(path = "/getAll", produces = "application/json")
		        public ResponseEntity<List<Dealer>> getAllDealer() throws DealerNotFoundException {
		            logger.info("Trying to fetch Ward Report list ");
		            try {
		                List<Dealer> dealer = dealerService.getDealerList();
		                if (dealer.isEmpty()) {
		                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		                }
		                return new ResponseEntity<>(dealer, HttpStatus.OK);//200
		            } catch (Exception e) {
		                logger.error("Record NOT found : ");
		                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);//500,server encountered an unexpected condition
		 
		            }
		        }
		        /*
		         * http://localhost:8080/Dealer/singleRecord/{dealerId}
		         * This particular url is response for getting single dealer
		         * HTTP Method get is required
		         */
		        @GetMapping(path = "/singleRecord/{dealerId}", produces = "application/json")
		        public ResponseEntity<Dealer> getDealerById(@PathVariable Long dealerId) throws DealerNotFoundException {
		            Optional<Dealer> dealer = null;
		            logger.info("Trying to search Record with Id : " + dealerId);
		            try {
		            	dealer= dealerService.getDealerById(dealerId);
		 
		                if (dealer.isPresent()) {
		                    return new ResponseEntity<>(dealer.get(), HttpStatus.OK);
		                } else {
		                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		                }
		            } 
		            catch (Exception e) {
		            	logger.error("Record NOT Found with Id : " + dealerId);


		            	}
		            return new ResponseEntity<Dealer>(new Dealer(), HttpStatus.EXPECTATION_FAILED);
		        }
		 
		        /*
		         * http://localhost:8080/dealer/delete/{dealerId}
		         * This particular url is response for deleting dealer
		         * HTTP Method get is required
		         */
		        @DeleteMapping(path="/delete/{dealerId}")
		        public ResponseEntity<String> deleteDealer(@PathVariable Long dealerId) throws DealerNotFoundException {

		            try {
		            	dealerService.delete(dealerId);
		                Optional<Dealer> delDealer = dealerService.getDealerById(dealerId);
		                logger.info("Record Deleted with Id : " +dealerId);
		                return new ResponseEntity<>("Record Deleted...with id : "+dealerId,HttpStatus.OK);
		            } catch (Exception e) {
		                logger.error("Record NOT Deleted with Id : " + dealerId);
		                return new ResponseEntity<>("Record not found with id : "+dealerId,HttpStatus.EXPECTATION_FAILED);
		            }
		        }
		        
		        
		       // http://localhost:8080/dealer/update/{dealerId}
		        @PutMapping("/update/{dealerId}")
				public ResponseEntity<Object> updateDealer(@RequestBody Dealer dealer, @PathVariable Long dealerId)
						throws DealerNotFoundException {
					logger.info("trying to update Dealer : " + dealer);
					try {
						Optional<Dealer> dealerFound = dealerService.getDealerById(dealerId);

						if (dealerFound.isPresent()) {
							dealerService.updateDealer(dealer,dealerId);
							System.out.println("Record Updated : " + dealer);
							return ResponseEntity.ok(dealer);
						} else {
							return new ResponseEntity<>("Record NOT updated with Id : " + dealer,HttpStatus.NO_CONTENT);
						}
					} catch (Exception e) {
						logger.error("Record NOT updated with Id : " + dealer);
						return new ResponseEntity<>("Record NOT updated with Id : " + dealer, HttpStatus.EXPECTATION_FAILED);
					}

				}
		 
}
