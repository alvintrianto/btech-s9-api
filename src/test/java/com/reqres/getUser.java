package com.reqres;

import data.baseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getUser {
    Response response;
    data.baseUrl baseUrl = new baseUrl();
    String reqresUrl = baseUrl.reqres;

    @Test(priority = 1)
    public void getListUser(){
        response = given()
                .when()
                .get(reqresUrl+"/api/users?page=2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 2)
    public void getSingleUser(){
        response = given()
                .when()
                .get(reqresUrl+"/api/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
    }
}
