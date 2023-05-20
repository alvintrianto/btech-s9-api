package com.reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import data.createUser.createUser;
import data.baseUrl;

public class postUser  {
    Response response;
    baseUrl baseUrl = new baseUrl();
    String reqresUrl = baseUrl.reqres;


    @Test(priority = 5)
    public void createUserSingle(){
        createUser reqresCreateUser = new createUser();

        response = given()
                .header("Content-Type","application/json")
                .body(createUser.newUser().toJSONString())
                .when()
                .post(reqresUrl+ "/api/users")
                .then()
                .log().body()
                .statusCode(201)
                .extract().response();
    }

}
