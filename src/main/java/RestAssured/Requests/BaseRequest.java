package RestAssured.Requests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

/**
 * This is base class for API request.
 * This contains reference variable of RequestSpecification
 * Common methods can be written here.
 */
public class BaseRequest{
    RequestSpecification requestSpecification = null;

    public BaseRequest(){
    }

    public BaseRequest(String baseUrl){
        this.requestSpecification = RestAssured.given().baseUri(baseUrl);
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * returns boolean value after comparing two int values
     * @param expectedStatusCode
     * @param actualStatusCode
     * @return
     */
    public boolean validateResponseCode(int expectedStatusCode, int actualStatusCode){
        return actualStatusCode == expectedStatusCode;
    }
}
