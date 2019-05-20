=========

## Weather-Service: uses Open weather api to get weather details 

### Relevant Articles: 
- [Open Weather APi]https://openweathermap.org/api)

### Eclipse Config 
After importing the project into Eclipse, you may see the need to add lombok(https://projectlombok.org/setup/eclipse) to your eclipse.

### Modifiy open weather api details in application.properties as per your account detils
- weather.api.url-hourly
- weather.api.url-hourly-param
- weather.api.api-key

Note: Since My account was inactive, for time being used sample open weather api. So even if you pass different zip code, you might find same output.


#Steps to Run.
Its maven project, build as spring boot application. And integrated swagger UI.
Upon running, API can be accessed via http://localhost:9090/swagger-ui.html