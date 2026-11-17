package urbantechsolution.com.model.Chain;

public class CityManager extends Staff {
    @Override
    public String handle(Resident resident) {
        if (resident.getTitle().equalsIgnoreCase("Build new building")) {

            return "WelCome SmartCity360  :" + resident.getName() + "\n" + "Rules: 1. Required income tax document" + "\n" + "2. Should  have a space park";

        } else {
            return "WelCome SmartCity360 :" + resident.getName() + " This is not my work";
        }
    }

}
