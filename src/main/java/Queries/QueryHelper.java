package Queries;

import RequestSpecifications.Base;
import RequestSpecifications.UserAddressInt;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class QueryHelper extends Base {

    public QueryHelper() {
    }

    public Response query(GraphQLQuery query, Integer httpCode) {
        Response response = given()
                .spec(GraphQl)
                .body(query)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(httpCode)
                .extract().response();
        return response;
    }


}
