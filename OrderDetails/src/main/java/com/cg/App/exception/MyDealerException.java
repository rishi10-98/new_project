package com.cg.App.exception;

public class MyDealerException extends RuntimeException {
 
    private static final long serialVersionUID = 1L;
 
    public MyDealerException () {
        super();

    }
 
    public MyDealerException (String message) {
        super(message);

    }
 
}
