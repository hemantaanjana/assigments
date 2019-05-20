package com.hemant.weatherservice.connectors;

import com.hemant.weatherservice.aspects.Loggable;
import com.hemant.weatherservice.config.WeatherAPIConfiguration;
import com.hemant.weatherservice.models.CustomException;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class OpenWeatherConnector implements WeatherConnector {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(OpenWeatherConnector.class);
  private WeatherAPIConfiguration weatherAPIConfiguration;

  public OpenWeatherConnector(WeatherAPIConfiguration weatherAPIConfiguration) {
    this.weatherAPIConfiguration = weatherAPIConfiguration;
  }

  @Override
  @Loggable
  public JSONObject connect(Long zipCode) {
    String url = this.weatherAPIConfiguration.getUrlHourly() + "?"
        + this.weatherAPIConfiguration.getUrlHourlyParam() + "=" + zipCode + "&appid="
        + this.weatherAPIConfiguration.getApiKey();
    try {
      LOG.info("");
      return makeGetRequest(url);
    } catch (IOException | JSONException ex) {
      LOG.error("Error ", ex);
      throw new CustomException("Not in operation");
    } catch (Exception ex) {
      LOG.error("Error ", ex);
      throw new CustomException("Not in operation");
    }
  }

  public JSONObject makeGetRequest(String url) throws IOException, JSONException {
    Request request = new Request.Builder().url(url).get().build();
    OkHttpClient client = new OkHttpClient();
    Response response = client.newCall(request).execute();
    return new JSONObject(response.body().string());
  }
}
