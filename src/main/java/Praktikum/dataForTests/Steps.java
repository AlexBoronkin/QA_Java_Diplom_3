package Praktikum.dataForTests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static Praktikum.dataForTests.BaseDate.*;
import static io.restassured.RestAssured.given;


public class Steps {

    @Step ("Создаем нового пользователя")
    public ValidatableResponse createUser(User user) {
        return given().log().all().contentType(ContentType.JSON).baseUri(BASE_URL).body(user).when().post(REGISTER_ENDPOINT).then().log().all();
    }

    @Step ("Авторизация")
    public ValidatableResponse loginUser(Login loginUser) {
        return given().log().all().contentType(ContentType.JSON).baseUri(BASE_URL).body(loginUser).when().post(LOGIN_ENDPOINT).then().log().all();
    }

    @Step ("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return given().log().all().contentType(ContentType.JSON).baseUri(BASE_URL).header("Authorization", accessToken).when().delete(USER_ENDPOINT).then().log().all();
    }

}
