package com.hemant.weatherservice.controllers;

import com.hemant.weatherservice.aspects.Loggable;
import com.hemant.weatherservice.models.WeatherModel;
import com.hemant.weatherservice.services.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class APIController {

  @Autowired
  private WeatherService weatherService;

  @Loggable
  @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<WeatherModel> getWeather(@RequestParam("zipCode") Long zipCode) {
    return ResponseEntity.ok(weatherService.getWeatherUsingZipCode(zipCode));
  }
}
