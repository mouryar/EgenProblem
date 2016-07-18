package com.egen.problem.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.egen.problem.ws.model.ExceptionData;

import java.net.UnknownHostException;
import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) 
    @ExceptionHandler(UnknownHostException.class )
    public ResponseEntity<ExceptionData> handleUnknownHostException() {
        ExceptionData data = new ExceptionData();
        data.setException(true);
        data.setMessage("Unable to connect to database");
		return new ResponseEntity<ExceptionData>(data,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
    @ExceptionHandler(Exception.class )
    public ResponseEntity<ExceptionData> handleException() {
        ExceptionData data = new ExceptionData();
        data.setException(true);
        data.setMessage("Internal Error");
		return new ResponseEntity<ExceptionData>(data,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
    @ExceptionHandler(ParseException.class )
    public ResponseEntity<ExceptionData> handleParseException() {
        ExceptionData data = new ExceptionData();
        data.setException(true);
        data.setMessage("Enable to pass the data in MMddYY formate");
		return new ResponseEntity<ExceptionData>(data,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
    @ExceptionHandler(IllegalArgumentException.class )
    public ResponseEntity<ExceptionData> handleIllegalArgumentException() {
        ExceptionData data = new ExceptionData();
        data.setException(true);
        data.setMessage("Invlid arguments");
		return new ResponseEntity<ExceptionData>(data,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
