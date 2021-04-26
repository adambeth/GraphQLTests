package RequestSpecifications;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserAddress {
     private String addressLine1;
     private String addressLine2;
     private String addressLine3;
     private String addressLine4;
     private String addressType;
     private String city;
     private String country;
     private Date create;


     public UserAddress(String addressLine1) {
          this.addressLine1 = addressLine1;
     }

     public UserAddress(String addressLine1, String addressLine2) {
          this.addressLine1 = addressLine1;
          this.addressLine2 = addressLine2;
     }

     public UserAddress(String addressLine1, String addressLine2, String addressLine3) {
          this.addressLine1 = addressLine1;
          this.addressLine2 = addressLine2;
          this.addressLine3 = addressLine3;
     }

     public UserAddress(String addressLine1, String addressLine2, String addressLine3, String addressLine4) {
          this.addressLine1 = addressLine1;
          this.addressLine2 = addressLine2;
          this.addressLine3 = addressLine3;
          this.addressLine4 = addressLine4;
     }
}
