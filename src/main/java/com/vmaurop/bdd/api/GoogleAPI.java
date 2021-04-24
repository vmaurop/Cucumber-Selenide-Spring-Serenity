package com.vmaurop.bdd.api;

import com.vmaurop.bdd.AbstractSerenityClass;
import com.vmaurop.bdd.configuration.GoogleConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.springframework.beans.factory.annotation.Autowired;


public class GoogleAPI extends AbstractSerenityClass {

    @Autowired
    private GoogleConfig googleConfig;


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


}
