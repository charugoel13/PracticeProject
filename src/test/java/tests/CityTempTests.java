package tests;

import CustomedExceptions.OutOfPermissibleRange;
import io.restassured.response.Response;
import org.apache.juneau.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.api.queryparam.city.CityResponse;

/**
 * TestNG class containing demo tests
 * compareTempOfMexicoDelhi_WithinRange - passes
 * compareTempOfMexicoDelhi_OutOfRange - fails throwing exception
 */
public class CityTempTests extends BaseTest {

    @Test
    public void compareTempOfMexicoDelhi_WithinRange() {
        try{
            String city1 = "mexico";
            String city2 = "delhi";
            Double permissibleRange = 16.0;

            System.out.println(String.format("Getting temperature for %s city", city1));
            Response mexicoRes = cityWeather.getWeatherofCityResponse(city1);
            Assert.assertEquals(mexicoRes.getStatusCode(), 200,
                    "Status code mismatch for 1st request.");
            CityResponse mexicoWeatherObj = deserializerObj.getDeserializedObj(mexicoRes.getBody().asString(),
                    CityResponse.class);

            System.out.println(String.format("Getting temperature for %s city", city2));
            Response delhiRes = cityWeather.getWeatherofCityResponse(city2);
            Assert.assertEquals(mexicoRes.getStatusCode(), 200,
                    "Status code mismatch for 2nd request.");
            CityResponse delhiWeatherObj = deserializerObj.getDeserializedObj(delhiRes.getBody().asString(),
                    CityResponse.class);

            System.out.println(mexicoWeatherObj.getMain().getTemp());
            System.out.println(delhiWeatherObj.getMain().getTemp());
            boolean isPermisible = customComparator.comparePermissibleRange(mexicoWeatherObj.getMain().getTemp(),
                    delhiWeatherObj.getMain().getTemp(), permissibleRange);

            System.out.println("Is temp(Kelvin) within " + permissibleRange + " permissible range - " + isPermisible);
            if (!isPermisible){
                throw new OutOfPermissibleRange("Permissible temp out of range among two cities" +
                        "temperatures = [" + delhiWeatherObj.getMain().getTemp() + "," +
                        mexicoWeatherObj.getMain().getTemp()+ "]");
            }


        }catch(ParseException parseExcep){
            parseExcep.printStackTrace();
            Assert.fail();
        } catch (OutOfPermissibleRange outOfPermissibleRange) {
            outOfPermissibleRange.printStackTrace();
            Assert.fail();
        } finally{

        }
    }

    @Test
    public void compareTempOfMexicoDelhi_OutOfRange() {
        try{
            String city1 = "mexico";
            String city2 = "delhi";
            Double permissibleRange = 0.1;

            System.out.println(String.format("Getting temperature for %s city", city1));
            Response mexicoRes = cityWeather.getWeatherofCityResponse(city1);
            Assert.assertEquals(mexicoRes.getStatusCode(), 200,
                    "Status code mismatch for 1st request.");
            CityResponse mexicoWeatherObj = deserializerObj.getDeserializedObj(mexicoRes.getBody().asString(),
                    CityResponse.class);

            System.out.println(String.format("Getting temperature for %s city", city2));
            Response delhiRes = cityWeather.getWeatherofCityResponse(city2);
            Assert.assertEquals(mexicoRes.getStatusCode(), 200,
                    "Status code mismatch for 2nd request.");
            CityResponse delhiWeatherObj = deserializerObj.getDeserializedObj(delhiRes.getBody().asString(),
                    CityResponse.class);

            boolean isPermisible = customComparator.comparePermissibleRange(mexicoWeatherObj.getMain().getTemp(),
                    delhiWeatherObj.getMain().getTemp(), permissibleRange);
            System.out.println("mexicoWeatherObj"+mexicoWeatherObj.getMain().getTemp());
            System.out.println("delhiWeatherObj"+delhiWeatherObj.getMain().getTemp());
            System.out.println(mexicoWeatherObj.getMain().getTemp() - delhiWeatherObj.getMain().getTemp());
            System.out.println("Is temp(Kelvin) within " + permissibleRange + " permissible range - " + isPermisible);
            if (!isPermisible){
                throw new OutOfPermissibleRange("Permissible temp out of range among two cities" +
                        "temperatures = [" + delhiWeatherObj.getMain().getTemp() + "," +
                        mexicoWeatherObj.getMain().getTemp()+ "]");
            }


        }catch(ParseException parseExcep){
            Assert.fail();
        } catch (OutOfPermissibleRange outOfPermissibleRange) {
            //outOfPermissibleRange.printStackTrace();
            Assert.fail();
        } finally{

        }


    }

}
