/**
 * 
 */
package org.anshu.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.anshu.service.exception.ErrorDetails;
import org.anshu.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception from controller layer
 * @author Anshu Kumar
 * @version : 1.0.0
 *
 */

@ControllerAdvice
@RestController
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",ex.getBindingResult().toString());
	    return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	  } 
	
	/**
	 * This method is used to throw the generic exception when resource in not found
	 * @param exception resouces not found exception
	 * @param request servlet request object
	 * @return the error detail
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorDetails handleResourceNotFound(final ResourceNotFoundException exception,final HttpServletRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), "Resource Not Found",exception.getMessage());
		return error;
	}
	
	/**
	 * This method is used to throw any unexpected error within application 
	 * @param exception the generic exception object
	 * @param request servlet request object
	 * @return the error detail
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDetails handleException(final Exception exception,final HttpServletRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), "Unexpected error",exception.getMessage());
		return error;
	}
}

