package com.movit.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.movit.dto.ErrorDto;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	
		@ExceptionHandler(BusinessLogicException.class)
		public final ResponseEntity<ErrorDto> BusinessLogicExceptionHandler (BusinessLogicException ex,
				WebRequest request){
			
			ErrorDto error = new ErrorDto("BAD_REQUEST", "400", ex.getMessage(), "");
			return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
		}
		
		@ExceptionHandler(ArgumentRequiredException.class)
		public final ResponseEntity<ErrorDto> ArgumentRequiredExceptionHandler (ArgumentRequiredException ex,
				WebRequest request){
			
			ErrorDto error = new ErrorDto("BAD_REQUEST", "400", ex.getMessage(), "");
			return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
		}
		
		
		@ExceptionHandler(ModelNotFoundException.class)
		public final ResponseEntity<ErrorDto> ModelNotFoundExceptionHandler (ModelNotFoundException ex,
				WebRequest request){
			
			ErrorDto error = new ErrorDto("NOT_FOUND", "404", ex.getMessage(), "");
			return new ResponseEntity<ErrorDto>(error, HttpStatus.NOT_FOUND);			
		}
		
	
		@ExceptionHandler(NullPointerException.class)
		public final ResponseEntity<ErrorDto> NullPointerExceptionHandler (NullPointerException ex,
				WebRequest request){
			
			ErrorDto error = new ErrorDto("INTERNAL_SERVER_ERROR", "500", ex.getMessage(), "");
			return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		@ExceptionHandler(ArithmeticException.class)
		public final ResponseEntity<ErrorDto> ArithmeticExceptionHandler (ArithmeticException ex,
				WebRequest request){
			
			ex.printStackTrace();
			ErrorDto error = new ErrorDto("INTERNAL_SERVER_ERROR", "500", ex.getMessage(), "");
			return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		
		@ExceptionHandler(EmptyResultDataAccessException.class)
		public final ResponseEntity<ErrorDto>EmptyResultDataAccessExceptionHandler (EmptyResultDataAccessException ex,
				WebRequest request){
			
			ErrorDto error = new ErrorDto("BAD_REQUEST", "400", ex.getMessage(), "");
			return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
		}
		
		@ExceptionHandler(DataIntegrityViolationException.class)
		public final ResponseEntity<ErrorDto> BusinessLogicExceptionHandler (DataIntegrityViolationException ex,
				WebRequest request){
			
			ErrorDto error = new ErrorDto("BAD_REQUEST", "400", ex.getMessage(), "");
			return new ResponseEntity<ErrorDto>(error, HttpStatus.BAD_REQUEST);			
		}				

		
		@ExceptionHandler(Exception.class)
		public final ResponseEntity<ErrorDto>ExceptionHandler (Exception ex,
				WebRequest request){
			
			ErrorDto error = new ErrorDto("INTERNAL_SERVER_ERROR", "500", ex.getMessage(), "");
			return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);			
		}

		@Override
		protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			// TODO Auto-generated method stub
			//return super.handleHttpMessageNotReadable(ex, headers, status, request);
			ErrorDto error = new ErrorDto("BAD_REQUEST", "400", ex.getMessage(), "");
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);			
			
		}	
		
		//Pendiente
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {				
			ErrorDto er = new ErrorDto("BAD_REQUEST", HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), "");
			return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
		}
		
		
		
		
	
}
