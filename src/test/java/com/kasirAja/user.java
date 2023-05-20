package com.kasirAja;

import data.kasirAja.login;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import data.baseUrl;


public class user {
    Response response;
    baseUrl baseUrl = new baseUrl();
    String kasirAjaUrl = baseUrl.kasirAja;

    @Test
    public void getUserList() {
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

        response = given()
                .header("Authorization", "Bearer " + token)
                .get(kasirAjaUrl + "/users")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
    }

    @Test
    public void getUserDetail() {
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
        String userID = "5ec5770b-9af8-4735-bc8c-ae70e30eb546";

        response = given()
                .header("Authorization", "Bearer " + token)
                .get(kasirAjaUrl + "/users/" + userID)
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
    }
}
