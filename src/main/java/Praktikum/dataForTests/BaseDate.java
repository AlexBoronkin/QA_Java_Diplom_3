package Praktikum.dataForTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseDate {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    public static final String REGISTER_ENDPOINT = "/api/auth/register";
    public static final String LOGIN_ENDPOINT = "/api/auth/login";
    public static final String USER_ENDPOINT = "/api/auth/user";
    public static final String ORDER_ENDPOINT = "/api/orders"; //POST запрос для создания, GET запрос для получения списка заказов
    public static final String INGREDIENTS_ENDPOINT = "/api/ingredients";

    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    public static final String EMAIL_FOR_TEST = "boronkin_60@gmail.com";
    public static final String PASSWORD_FOR_TEST = "1234567";

}
