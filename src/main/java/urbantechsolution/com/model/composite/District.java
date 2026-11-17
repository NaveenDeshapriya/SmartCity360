package urbantechsolution.com.model.composite;

import urbantechsolution.com.model.Status;
import urbantechsolution.com.service.ZoneControl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class District implements ZoneControl {

    private List<ZoneControl> zoneControlList = new ArrayList<ZoneControl>();
    private String name;
    private String status;
    private List<String> description = new ArrayList<>();

    public District(String name) {
        this.name = name;
    }


    public void addZoneControl(ZoneControl zoneControl) {
        zoneControlList.add(zoneControl);
    }

    @Override
    public void shutdownPower() {

        this.status = Status.SHUTDOWN.name();

        for (ZoneControl zoneControl : zoneControlList) {
            zoneControl.shutdownPower();
        }

    }

    @Override
    public  List<String> reportUsage() {

        this.description.add(this.name + " District has been shut down At: " + LocalDateTime.now() + " Current Power Status: " + this.status);


        for (ZoneControl zoneControl : zoneControlList) {
            for(String report : zoneControl.reportUsage()) {
                this.description.add(report);
            }
        }

        return this.description;


    }


}
