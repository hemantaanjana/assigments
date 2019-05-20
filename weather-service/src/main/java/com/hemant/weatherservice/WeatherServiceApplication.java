package com.hemant.weatherservice;

import com.hemant.weatherservice.config.WeatherAPIConfiguration;
import com.hemant.weatherservice.connectors.OpenWeatherConnector;
import com.hemant.weatherservice.connectors.WeatherConnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeatherServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatherServiceApplication.class, args);
  }

  @Bean
  public WeatherConnector openWeather(@Autowired WeatherAPIConfiguration weatherAPIConfiguration) {
    return new OpenWeatherConnector(weatherAPIConfiguration);
  }
}
