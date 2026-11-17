package urbantechsolution.com.model.decorator;

import urbantechsolution.com.service.Security;

import java.util.HashMap;
import java.util.Map;

public class Authentication extends SecurityDecorator {


    private static final String ENCRYPT_PASSWORD = "YWRtaW4=";

    public Authentication(Security security) {
        super(security);
    }


    @Override
    public Map<String,String> checkData(Map<String, String> data) {

        Map<String, String> encryptData = this.security.checkData(data);

        if (encryptData==null)return null;

        if (encryptData.get("password").equals(Authentication.ENCRYPT_PASSWORD)) {

            return encryptData;
        }

        return null;
    }


}
