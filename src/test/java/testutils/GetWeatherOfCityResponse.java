package testutils;

import Constants.AWConstants;
import RestAssured.AccuWeather.GetRequestAW;
import io.restassured.response.Response;

import java.util.Map;

/**
 * wrapper class containing different get methods depending on need
 */
public class GetWeatherOfCityResponse {
    final String baseUrl = AWConstants.baseURl;
    final String basePath = AWConstants.basePath;
    final String apiKey = AWConstants.apiKey;

    /**
     * Get response by passing city name
     * @param city
     * @return
     */
    public Response getWeatherofCityResponse(String city){
        GetRequestAW weatherObj = new GetRequestAW(baseUrl);
        weatherObj.setBasePath(basePath);
        weatherObj.setQueryParameter("appid", apiKey);
        weatherObj.setQueryParameter("q", city);
        Response response = weatherObj.get();
        return response;
    }

    /**
     * overloaded method to pass as much as query parameters into argument
     * @param queryParams
     * @param <T>
     * @return
     */
    public <T> Response getWeatherofCityResponse(Map<String, T> queryParams){
        GetRequestAW weatherObj = new GetRequestAW(baseUrl);
        weatherObj.setBasePath(basePath);
        weatherObj.setQueryParameter("appid", apiKey);

        for (Map.Entry<String, T> entry :  queryParams.entrySet()){
            weatherObj.setQueryParameter(entry.getKey(), entry.getValue());
        }

        Response response = weatherObj.get();
        return response;
    }

}
