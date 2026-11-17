package urbantechsolution.com.model.flyweight;

import urbantechsolution.com.model.LightDTO;
import urbantechsolution.com.service.LightService;

import java.util.ArrayList;
import java.util.List;

public class StreetLight implements LightService {


    private String location;

    private SharedStreetLight sharedStreetLight;

    public StreetLight(String status, String type,String color,int brightness, String location) {
        this.location = location;
        this.sharedStreetLight= SharedStreetLightPool.getSharedStreetLight(status,type,color,brightness);

    }

    @Override
    public LightDTO getStreetLights() {

        System.out.println("SharedData :"+sharedStreetLight.hashCode());

        LightDTO lightDTO = new LightDTO();
        lightDTO.setLocation(this.location);
        lightDTO.setType(this.sharedStreetLight.getType());
        lightDTO.setColor(this.sharedStreetLight.getColor());
        lightDTO.setStatus(this.sharedStreetLight.getStatus());
        lightDTO.setBrightness(this.sharedStreetLight.getBrightness());

       return lightDTO;

    }
}
