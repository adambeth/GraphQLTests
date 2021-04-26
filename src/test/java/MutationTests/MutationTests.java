package MutationTests;

import RequestSpecifications.Base;
import RequestSpecifications.UserAddress;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MutationTests extends Base {



    @Test
    public void Mutation() {


        query.setQuery("mutation addUser($addressLine1 : String) {\r\n  addUser(addressLine1: $addressLine1){\r\n    active\r\n    addressLine1\r\n    addressLine2\r\n    city\r\n    \r\n  }\r\n}\r\n");
        UserAddress variables = new UserAddress("hello");
        query.setVariables(variables);
        given()
                .spec(MutationEnvelGraphql)
                .body(query)
                .log().all()
                .when()
                .post()
                .then()
                .log().all();

    }
}
