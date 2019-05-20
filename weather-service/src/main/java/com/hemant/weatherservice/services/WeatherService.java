package com.hemant.weatherservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.hemant.weatherservice.aspects.Loggable;
import com.hemant.weatherservice.connectors.WeatherConnector;
import com.hemant.weatherservice.models.CustomException;
import com.hemant.weatherservice.models.ValidationException;
import com.hemant.weatherservice.models.WeatherModel;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
  @Autowired
  private WeatherConnector weatherConnector;
  @Autowired
  private ObjectMapper objectMapper;

  @Loggable
  public WeatherModel getWeatherUsingZipCode(Long zipCode) {
    if (zipCode == null || zipCode <= 0) {
      throw new ValidationException("Provide Zip Code to get weather informaton");
    }

    JSONObject jsonObject = weatherConnector.connect(zipCode);
    try {
      WeatherModel weatherModel = objectMapper.readValue(jsonObject.toString(), WeatherModel.class);
      // apply filter here to show next day's weather
      return weatherModel;
    } catch (IOException e) {
      throw new CustomException("Not in operation");
    }
  }

}
