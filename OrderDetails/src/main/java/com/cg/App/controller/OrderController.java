package com.cg.App.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.App.exception.OrderNotFoundException;
import com.cg.App.model.Order;
import com.cg.App.service.IOrderService;


@RestController//combinatin of @Controller and @ResponseBody
//contoller return  view and restcontroller return response body
@RequestMapping(value="/order")
public class OrderController {
	 private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	    @Autowired
	    private IOrderService orderService;
	    /*
	     * http://localhost:8080/order/add
	     * This particular url is response for adding Order
	     * HTTP Method post is required
	     */
	    //ResponseEntity represent the whole http responce:status code,header,body=>this is generic Type

	    @PostMapping(value = "/add")
	    public ResponseEntity<Order> addOrder( @RequestBody Order order) throws OrderNotFoundException {
	        try {
	            logger.info("Trying to add Record  : " + order);
	            Order addedOrder = orderService.addOrder(order);
	            return new ResponseEntity<>(order, HttpStatus.CREATED);//201
	        } catch (Exception e) {
	            logger.error("Record NOT Added  : " +order);
	            return new ResponseEntity<>(order, HttpStatus.EXPECTATION_FAILED);    //417
	        }
	    }
	    
	    /*
	     * http://localhost:8080/order/getAll
	     * This particular url is response for getting all order 
	     * HTTP Method get is required
	     */

	        @GetMapping(path = "/getAll", produces = "application/json")
	        public ResponseEntity<List<Order>> getAllOrder() throws OrderNotFoundException {
	            logger.info("Trying to fetch Ward Report list ");
	            try {
	                List<Order> order = orderService.getOrderList();
	                if (order.isEmpty()) {
	                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	                }
	                return new ResponseEntity<>(order, HttpStatus.OK);//200
	            } catch (Exception e) {
	                logger.error("Record NOT found : ");
	                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);//500,server encountered an unexpected condition
	 
	            }
	        }
	        /*
	         * http://localhost:8080/Order/
	         * This particular url is response for getting single Order
	         * HTTP Method get is required
	         */
	        @GetMapping(path = "/singleRecord{orderId}", produces = "application/json")
	        public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) throws OrderNotFoundException {
	            Optional<Order> order = null;
	            logger.info("Trying to search Record with Id : " + orderId);
	            try {
	            	order= orderService.getOrderById(orderId);
	 
	                if (order.isPresent()) {
	                    return new ResponseEntity<>(order.get(), HttpStatus.OK);
	                } else {
	                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	                }
	            } 
	            catch (Exception e) {
	            	logger.error("Record NOT Found with Id : " + orderId);


	            	}
	            return new ResponseEntity<Order>(new Order(), HttpStatus.EXPECTATION_FAILED);
	        }
	 
	        /*
	         * http://localhost:8080/order/getAll
	         * This particular url is response for deleting order
	         * HTTP Method get is required
	         */
	        @DeleteMapping(path="/delete/{orderId}")
	        public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) throws OrderNotFoundException {

	            try {
	            	orderService.deleteOrder(orderId);
	                Optional<Order> delAdmin = orderService.getOrderById(orderId);
	                logger.info("Record Deleted with Id : " +orderId);
	                return new ResponseEntity<>("Record Deleted...with id : "+orderId,HttpStatus.OK);
	            } catch (Exception e) {
	                logger.error("Record NOT Deleted with Id : " + orderId);
	                return new ResponseEntity<>("Record not found with id : "+orderId,HttpStatus.EXPECTATION_FAILED);
	            }
	        }
	 
	        

}
