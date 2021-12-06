package com.cg.App.exception;



public class MyOrderException  extends RuntimeException {
 
    private static final long serialVersionUID = 1L;
 
    public MyOrderException () {
        super();

    }
 
    public MyOrderException (String message) {
        super(message);

    }
 
}
