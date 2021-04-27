package QueryTests;

import Queries.GraphQLQuery;
import RequestSpecifications.Base;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAddressTests extends Base {


    @Test
    public void GetAddressLines() {
        GraphQLQuery query1 = new GraphQLQuery();
        query1.setQuery("{ allAddresses { id city } }");
        given()
                .spec(MutationEnvelGraphql)
                .body(query1)
                .when()
                .post();

    }


}

