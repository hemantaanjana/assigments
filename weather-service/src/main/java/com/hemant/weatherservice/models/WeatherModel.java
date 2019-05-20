package com.hemant.weatherservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class WeatherModel implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private ArrayList<ListObject> list = new ArrayList<>();
  private City city;
}


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
class City implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String name;
  private String country;

}


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
class ListObject implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private float dt;
  private Main main;
  private Clouds cloudsObject;
  private Wind windObject;
  private String dt_txt;
}


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
class Wind implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private float speed;
  private float deg;

}


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
class Clouds implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private float all;
}


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
class Main implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private float temp;
  private float temp_min;
  private float temp_max;
  private float pressure;
  private float sea_level;
  private float grnd_level;
  private float humidity;
  private float temp_kf;

}
