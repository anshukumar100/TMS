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
 * @author C37283
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
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorDetails handleResourceNotFound(final ResourceNotFoundException exception,final HttpServletRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), "Resource Not Found",exception.getMessage());
		return error;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorDetails handleException(final Exception exception,final HttpServletRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), "Unexpected error",exception.getMessage());
		return error;
	}
}

