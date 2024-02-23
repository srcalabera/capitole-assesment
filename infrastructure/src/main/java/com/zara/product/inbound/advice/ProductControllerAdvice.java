package com.zara.product.inbound.advice;

import com.zara.product.exception.NotFoundException;
import com.zara.product.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEmptyInput(NotFoundException emptyInputException){
        return new ResponseEntity<>(new ErrorMessage(emptyInputException.getErrorMessage(),HttpStatus.NOT_FOUND.toString()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleEmptyInput(Exception emptyInputException){
        return new ResponseEntity<>(new ErrorMessage(emptyInputException.getMessage(),HttpStatus.NOT_FOUND.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
