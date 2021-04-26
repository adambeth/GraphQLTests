package RequestSpecifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class Base {


    public RequestSpecification QueryEnvelGraphql;
    public RequestSpecification MutationEnvelGraphql;

    @BeforeTest
    public void SetUpTestConnections() {
        String url = "http://localhost:4000";
        QueryEnvelGraphql = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .build()
                .filter(new AllureRestAssured());
        MutationEnvelGraphql = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(url)
                .build()
                .filter(new AllureRestAssured());
    }
}
