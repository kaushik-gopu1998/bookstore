package com.app.bookstore.exceptions;

public class InvalidAddressIdException extends Exception {

		private static final long serialVersionUID = -1908501523570802359L;
     public InvalidAddressIdException(String errorMessage)
     {
    	 super(errorMessage);
     }
}
