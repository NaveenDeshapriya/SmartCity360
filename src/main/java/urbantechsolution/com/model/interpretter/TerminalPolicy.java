package urbantechsolution.com.model.interpretter;

import urbantechsolution.com.service.Policy;

public class TerminalPolicy implements Policy {


    private int limitHours;

    public TerminalPolicy(int limitsHours) {

        this.limitHours = limitsHours;
    }


    @Override
    public int interpret() {
        return limitHours;
    }
}
