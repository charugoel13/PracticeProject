package tests;

import org.testng.asserts.SoftAssert;
import testutils.CustomComparator;
import testutils.GetWeatherOfCityResponse;
import utils.deserializer.Deserializer;

/**
 * wrapper class containing references to UTIL classes
 */
public class BaseTest {
    Deserializer deserializerObj = new Deserializer();
    CustomComparator customComparator = new CustomComparator();
    GetWeatherOfCityResponse cityWeather = new GetWeatherOfCityResponse();

}
