package QueryTests;

import Queries.GraphQLQuery;
import Queries.Mutation;
import RequestSpecifications.Base;

import RequestSpecifications.address;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAddressTests extends Base {

    @Test
    public void GetAddressLines(){

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("{ allAddresses { id city } }");

        given()
                .spec(QueryEnvelGraphql)
                .body(query)
                .log().all()
        .when()
                .post()
        .then()
                .log().all();

    }


    @Test
    public void Mutation(){

        GraphQLQuery mutation = new GraphQLQuery();
        mutation.setQuery("mutation addUser($addressLine1 : String) {\r\n  addUser(addressLine1: $addressLine1){\r\n    active\r\n    addressLine1\r\n    addressLine2\r\n    city\r\n    \r\n  }\r\n}\r\n");
        address adi = new address("hello");
        mutation.setVariables(adi);
        given()
                .spec(MutationEnvelGraphql)
                .body(mutation)
                .log().all()
                .when()
                .post()
                .then()
                .log().all();

    }
}

