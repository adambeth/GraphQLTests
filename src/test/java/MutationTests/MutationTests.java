package MutationTests;

import RequestSpecifications.Base;
import RequestSpecifications.UserAddress;
import RequestSpecifications.UserAddressInt;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class MutationTests extends Base {


    @DataProvider(name = "String Data")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Line1",200},
                {"   ",200},
                {"  LeadingSpaces",200},
                {"Trailing Spaces   ",200},
                {"!@#$   $%^&",200},

        };
    }


    @Test(dataProvider = "String Data",threadPoolSize=3,invocationCount=1)
    public void Address_Line1_Tests(String addressLine1, Integer code) {

        UserAddress address = new UserAddress(addressLine1);
        query.setQuery("mutation addUser($addressLine1 : String) {\r\n  addUser(addressLine1: $addressLine1){\r\n    active\r\n    addressLine1\r\n    addressLine2\r\n    city\r\n    \r\n  }\r\n}\r\n");
        query.setVariables(address);
        queryHelper.query(query,code);

    }
    @Test()
    public void Address_Line1_NULL_Tests() {

        UserAddressInt address = new UserAddressInt(20);
        query.setQuery("mutation addAddressNull($addressLine1 : String) {\r\n  addUser(addressLine1: $addressLine1){\r\n    active\r\n    addressLine1\r\n    addressLine2\r\n    city\r\n    \r\n  }\r\n}\r\n");
        query.setVariables(address);
        queryHelper.query(query,400);

    }
}
