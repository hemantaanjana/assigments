package com.hemant.weatherservice.connectors;

import org.springframework.boot.configurationprocessor.json.JSONObject;

public interface WeatherConnector {

  public JSONObject connect(Long zipCode);
}
