package urbantechsolution.com.model.composite;

import urbantechsolution.com.model.Status;
import urbantechsolution.com.service.ZoneControl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Building implements ZoneControl {

    private String name;
    private String status;
    private List<String> description=new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    @Override
    public void shutdownPower() {
        this.status= Status.SHUTDOWN.name();

    }

    @Override
    public List<String> reportUsage() {
        this.description.add(this.name+" Building has been shut down At: "+ LocalDateTime.now()+" Current Power Status: "+this.status);
        return this.description;
    }


}
