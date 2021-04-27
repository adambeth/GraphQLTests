package QueryTests;

import Queries.QueryHelper;
import RequestSpecifications.Base;
import org.testng.annotations.Test;

public class GetAddressTests extends Base {


    @Test
    public void GetAddressLines() {

        query.setQuery("{ allAddresses { id city } }");
        queryHelper.query(query);

    }


}

