package Queries;

import RequestSpecifications.Base;
import RequestSpecifications.UserAddressInt;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class QueryHelper extends Base {

    public QueryHelper() {
    }

    @Step("Perform Query")
    public Response query(GraphQLQuery query, Integer httpCode) {
        Response response = given()
                .spec(GraphQl)
                .body(query)
                .log().all()
                .when()
                .post()
                .then()
                .assertThat()
                .log().all()
                .statusCode(httpCode)
                .extract().response();
        return response;
    }


}
