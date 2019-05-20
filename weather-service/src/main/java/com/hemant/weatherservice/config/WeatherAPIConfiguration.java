package com.hemant.weatherservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "weather.api")
@Getter
@Setter
public class WeatherAPIConfiguration {

  private String apiKey;
  private String urlHourly;
  private String urlHourlyParam;

}
