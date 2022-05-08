package com.xbrain.projetoxbrain.controllers.exceptions;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;

import com.xbrain.projetoxbrain.services.exceptions.OrderItemNotFoundException;
import com.xbrain.projetoxbrain.services.exceptions.OrderNotFoundException;
import com.xbrain.projetoxbrain.services.exceptions.ProductNotFoundException;
import com.xbrain.projetoxbrain.services.exceptions.VendorNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<StandardError> orderResourceNotFound(OrderNotFoundException e, HttpServletRequest request){
        String error = "Order not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(ZoneId.of("UTC")), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<StandardError> productResourceNotFound(ProductNotFoundException e, HttpServletRequest request){
        String error = "Product not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(ZoneId.of("UTC")), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(VendorNotFoundException.class)
    public ResponseEntity<StandardError> sellerResourceNotFound(VendorNotFoundException e, HttpServletRequest request){
        String error = "Vendor not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(ZoneId.of("UTC")), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(OrderItemNotFoundException.class)
    public ResponseEntity<StandardError> orderItemResourceNotFound(OrderItemNotFoundException e, HttpServletRequest request){
        String error = "Order item not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(ZoneId.of("UTC")), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    
}
