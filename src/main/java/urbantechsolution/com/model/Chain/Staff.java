package urbantechsolution.com.model.Chain;

public abstract class Staff {

    private Staff staff;

    public Staff getStaff() {

        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public abstract String handle(Resident resident);
}
