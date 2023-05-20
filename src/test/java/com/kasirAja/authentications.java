package com.kasirAja;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import data.kasirAja.login;
import data.baseUrl;

public class authentications  {
    Response response;
    baseUrl baseUrl = new baseUrl();
    String kasirAjaUrl = baseUrl.kasirAja;


    @BeforeMethod @Test
    public String successLogin(){
        login loginData = new login();

        response = given()
                .header("Content-Type","application/json")
                .body(login.loginData().toJSONString())
                .when()
                .post(kasirAjaUrl + "/authentications")
                .then()
                .statusCode(201)
                .extract().response();

        String respBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(respBody);
        String token = jsonPath.getString("data.accessToken");

        return token;
    }
}
