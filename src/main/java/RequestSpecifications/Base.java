package RequestSpecifications;

import Queries.GraphQLQuery;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class Base {



    public RequestSpecification MutationEnvelGraphql;

    public GraphQLQuery query;


    @BeforeClass
    public void SetUpTestConnections() {

        String url = "http://52.191.233.11:4000/";
        query = new GraphQLQuery();
        MutationEnvelGraphql = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .build()
                .filter(new AllureRestAssured());
    }
}
