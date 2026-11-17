package urbantechsolution.com.model;

import java.io.Serializable;

public class RuleDTO implements Serializable {

    private String ruleName;
    private int ruleNo;
    private String ruleCategory;

    private int limitTime;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(int ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getRuleCategory() {
        return ruleCategory;
    }

    public void setRuleCategory(String ruleCategory) {
        this.ruleCategory = ruleCategory;
    }

    public int getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }
}
