package com.hemant.weatherservice.aspects;


import com.hemant.weatherservice.models.CustomException;
import com.hemant.weatherservice.models.ExceptionResponse;
import com.hemant.weatherservice.models.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Controller Advice for Exception Handling.
 * 
 * @author anjana_h
 *
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

  /**
   * {@link ValidationException} handler.
   *
   * @param ex {@link ValidationException}
   * @return ResponseEntity with message and 422 error code.
   */
  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ExceptionResponse> validationExceptionHandler(CustomException ex) {
    LOG.error("Service unavilable Exception: ", ex);
    ExceptionResponse response = ExceptionResponse.builder().withErrorMessage(ex.getMessage())
        .withExceptionCode(HttpStatus.NOT_ACCEPTABLE.value()).build();

    return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
  }

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ExceptionResponse> customExceptionHandler(CustomException ex) {
    LOG.error("Service unavilable Exception: ", ex);
    ExceptionResponse response = ExceptionResponse.builder().withErrorMessage(ex.getMessage())
        .withExceptionCode(HttpStatus.SERVICE_UNAVAILABLE.value()).build();

    return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
  }



}
