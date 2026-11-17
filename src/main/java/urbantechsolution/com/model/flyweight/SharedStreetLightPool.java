package urbantechsolution.com.model.flyweight;

import java.util.ArrayList;

public class SharedStreetLightPool {

    private static final ArrayList<SharedStreetLight> sharedStreetLights= new ArrayList<>();

    public static SharedStreetLight getSharedStreetLight(String status, String type,String color,int brightness) {


        SharedStreetLight sharedStreetLight=null;

        for (SharedStreetLight ss:sharedStreetLights) {

            if (ss.getStatus().equals(status) && ss.getType().equals(type) && ss.getColor().equals(color)&& ss.getBrightness() == brightness) {
                sharedStreetLight=ss;
                break;

            }


        }

        if (sharedStreetLight==null) {
            sharedStreetLight=new SharedStreetLight(status,type,color,brightness);
            sharedStreetLights.add(sharedStreetLight);
        }

        return sharedStreetLight;
    }
}
