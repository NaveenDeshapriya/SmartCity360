package urbantechsolution.com.model.decorator;

import urbantechsolution.com.service.Security;

import java.util.Map;

public class Compression extends SecurityDecorator{


    public Compression(Security security) {
        super(security);
    }


    @Override
    public Map<String, String> checkData(Map<String, String> data) {

        Map<String, String> authData = this.security.checkData(data);

        if (authData==null)return null;

        authData.remove("password");
        authData.remove("username");
        authData.put("status","Active");
        authData.put("ID","EM01"+System.currentTimeMillis());

       return authData;
    }
}
