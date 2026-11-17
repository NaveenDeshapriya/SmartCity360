package urbantechsolution.com.model.Chain;

public class LocalStaff extends Staff {

    @Override
    public String handle(Resident resident) {

        if (resident.getTitle().equalsIgnoreCase("power details")){

            return "WelCome SmartCity360 :"+resident.getName()+"\n"+"Power cut:"+"\n"+"Sunday-20:00 PM to 21:00 PM"+"\n"+"Friday-10:00 AM to 11:00 AM";
        }else {
           return this.getStaff().handle(resident);
        }


    }

}
