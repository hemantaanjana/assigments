package com.hemant.weatherservice.models;

public class ValidationException extends CustomException {

  /**
   * 
   */
  private static final long serialVersionUID = -8997664246117728073L;

  public ValidationException(String message) {
    super(message);
  }

}
