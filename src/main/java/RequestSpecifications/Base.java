/*
https://www.javadoc.io/doc/io.rest-assured/rest-assured/latest/io/restassured/builder/RequestSpecBuilder.html
 */


package RequestSpecifications;

import Queries.GraphQLQuery;
import Queries.QueryHelper;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Base {


    public static RequestSpecification GraphQl;
    public static QueryHelper queryHelper;
    public GraphQLQuery query;


    @BeforeClass
    public void SetUpTestConnections() {

        String url = "http://52.191.233.11:4000/";
//        String url = "http://localhost:4000/";
        query = new GraphQLQuery();
;       queryHelper = new QueryHelper();

        GraphQl = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .build()
                .filter(new AllureRestAssured());


        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Company", "ENVEL")
                        .put("Server", "MockQL")
                        .put("URL", "http://52.191.233.11:4000/")
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }
}
