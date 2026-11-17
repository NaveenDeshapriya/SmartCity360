package urbantechsolution.com.model.Chain;

public class Supervisor extends Staff {
    @Override
    public String handle(Resident resident) {

        if (resident.getTitle().equalsIgnoreCase("Street problem")){
            return "WelCome SmartCity360 :"+resident.getName()+"\n"+"Check 1 weeks";
        }else{
          return  this.getStaff().handle(resident);
        }
    }


}
