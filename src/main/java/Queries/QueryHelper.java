package Queries;

import RequestSpecifications.Base;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public  class QueryHelper extends Base {

    public QueryHelper() {
    }

    public Response query(GraphQLQuery query) {
        Response response = given()
                .spec(GraphQl)
                .body(query)
                .when()
                .post();
        return response;
    }
}
