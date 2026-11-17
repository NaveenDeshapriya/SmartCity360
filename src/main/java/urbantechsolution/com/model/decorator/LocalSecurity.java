package urbantechsolution.com.model.decorator;

import urbantechsolution.com.service.Security;

import java.util.Map;

public class LocalSecurity implements Security {

    @Override
    public Map<String,String> checkData(Map<String, String> data) {
        return data;
    }
}
