package com.vmaurop.bdd.api;

import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.configuration.GoogleConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


public class GoogleAPI extends AbstractSerenityClass {

    @Autowired
    private GoogleConfig googleConfig;


    public static String token;

    private Response responseTodos;

    public Response getResponseTodos() {
        return responseTodos;
    }

    public RequestSpecification getGenericApiReqSpec() {
        String baseUri = googleConfig.getUrlAPI().toString();
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .build();
    }

    private Response apiGenericGet(String path) {
        return SerenityRest
                .given().relaxedHTTPSValidation().contentType(ContentType.JSON).
                spec(getGenericApiReqSpec()).
                when().log().all().
                get(path)
                .then().log().all().
                extract().
                response();
    }

    private Response apiGenericPost(String bodyJson, String path) {
        return SerenityRest
                .given().relaxedHTTPSValidation().contentType(ContentType.JSON).
                spec(getGenericApiReqSpec()).
                body(bodyJson)
                .when().log().all().
                post(path)
                .then().log().all().
                extract().
                response();
    }

    private Response apiGenericGet1(String path) {
        return SerenityRest
                .given().relaxedHTTPSValidation().contentType(ContentType.JSON).
                baseUri(path).
                when().log().all().
                get()
                .then().log().all().
                extract().
                response();
    }

    private Response apiGenericPost1(String bodyJson, String path) {
        return SerenityRest
                .given().relaxedHTTPSValidation().contentType(ContentType.JSON).
                baseUri(path)
                .body(bodyJson)
                .when().log().all().
                post()
                .then().log().all().
                extract().
                response();
    }


    public void fakeRequest() {
        responseTodos = SerenityRest
                .given()
                .baseUri("https://jsonplaceholder.typicode.com/todos/1")
                .when().log().all().
                get()
                .then().log().all()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }

    public void verifyResponse() {
        Assert.assertEquals(1, responseTodos.jsonPath().getInt("userId"));
        Assert.assertEquals(1, responseTodos.jsonPath().getInt("id"));
        Assert.assertEquals("delectus aut autem", responseTodos.jsonPath().getString("title"));
        Assert.assertFalse(responseTodos.jsonPath().getBoolean("completed"));
    }

    public void postRequest() {
        responseTodos = SerenityRest
                .given()
                .baseUri("https://dummy.restapiexample.com/create")
                .when().log().all().
                body(requestBody())
                .post()
                .then().log().all()
                .extract()
                .response();
    }


    private String requestBody(){
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "John Doe");
        requestParams.put("salary", "123");
        requestParams.put("age", "23");
        return requestParams.toString();
    }

    public void verifyPost() {
        Assert.assertEquals(responseTodos.statusCode(), HttpStatus.SC_CREATED);
    }

    public void retrieveAuthTokenSample(){
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username",googleConfig.getUsers().getAdmin().getUserName());
        credentials.put("password",googleConfig.getUsers().getAdmin().getPassword());
        token = SerenityRest.given().contentType(ContentType.URLENC)
                .relaxedHTTPSValidation().queryParams(credentials).when().log().all().body(requestBody())
                .post(googleConfig.getUrlAPI().toString()).then().log().all().extract().response().path("access.Token");
    }
}
