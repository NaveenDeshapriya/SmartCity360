package urbantechsolution.com.model.decorator;

import urbantechsolution.com.service.Security;

import java.util.Base64;
import java.util.Map;

public class Encryption extends SecurityDecorator {

    public Encryption(Security security) {
        super(security);
    }

    @Override
    public Map<String,String> checkData(Map<String, String> data) {

        Map<String, String> localData=this.security.checkData(data);

       if (localData==null)return null;

       String encryptPassword= Base64.getEncoder().encodeToString(localData.get("password").getBytes());
       localData.put("password",encryptPassword);

       return localData;

    }
}




