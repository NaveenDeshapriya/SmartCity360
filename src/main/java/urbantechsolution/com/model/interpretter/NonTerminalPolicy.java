package urbantechsolution.com.model.interpretter;

import urbantechsolution.com.service.Policy;

public class NonTerminalPolicy implements Policy {

    private Policy startPolicy;
    private Policy endPolicy;
    private String ruleType;

    public NonTerminalPolicy(Policy startPolicy, Policy endPolicy, String ruleType) {
        this.startPolicy = startPolicy;
        this.endPolicy = endPolicy;
        this.ruleType = ruleType;

    }


    @Override
    public int interpret() {

        if (ruleType.equalsIgnoreCase("Parking Limit")) {
            return this.endPolicy.interpret() - this.startPolicy.interpret();

        } else {
            if (startPolicy.interpret() < 8 && startPolicy.interpret() > 6) {
                return 0;
            } else {
                return endPolicy.interpret() / startPolicy.interpret();

            }

        }

    }
}
