package urbantechsolution.com.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import urbantechsolution.com.model.RuleDTO;
import urbantechsolution.com.model.interpretter.NonTerminalPolicy;
import urbantechsolution.com.model.interpretter.TerminalPolicy;
import urbantechsolution.com.service.Policy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/policy")
public class PolicyController extends HttpServlet {

    private List<RuleDTO> rules;
    private Gson gson = new Gson();
    private JsonObject jsonObject;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        jsonObject = gson.fromJson(req.getReader(), JsonObject.class);

        String ruleCategory = jsonObject.get("ruleCategory").getAsString();
        String ruleNo = jsonObject.get("ruleNo").getAsString();
        String ruleName = jsonObject.get("ruleName").getAsString();
        String startLimitHour = jsonObject.get("startLimitHour").getAsString();
        String endLimitHours = jsonObject.get("endLimitHour").getAsString();

        Policy start = new TerminalPolicy(Integer.valueOf(startLimitHour));
        Policy end = new TerminalPolicy(Integer.valueOf(endLimitHours));

        urbantechsolution.com.service.Policy policy2 = new NonTerminalPolicy(start, end, ruleCategory);

        int limitTime = policy2.interpret();


        if (rules == null) {
            rules = new ArrayList<>();
        }


        if (ruleCategory.equals("Parking Limit")) {
            setRules(ruleCategory, Integer.valueOf(ruleNo), ruleName, limitTime);
        }

        if (ruleCategory.equals("Noise Limit")) {
            setRules(ruleCategory, Integer.valueOf(ruleNo), ruleName, limitTime);

        }

        JsonObject json = new JsonObject();
        json.add("rules", gson.toJsonTree(rules));
        resp.getWriter().write(gson.toJson(json));


    }

    private void setRules(String ruleCategory, int ruleNo, String ruleName, int limitTime) {

        RuleDTO rule = new RuleDTO();
        rule.setRuleCategory(ruleCategory);
        rule.setRuleNo(ruleNo);
        rule.setRuleName(ruleName);
        rule.setLimitTime(limitTime);

        rules.add(rule);


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        jsonObject = gson.fromJson(req.getReader(), JsonObject.class);

        String ruleCategory = jsonObject.get("ruleCategory").getAsString();
        String ruleName = jsonObject.get("ruleName").getAsString();
        String startLimitHour = jsonObject.get("startLimitHour").getAsString();
        String endLimitHours = jsonObject.get("endLimitHour").getAsString();
        String ruleNo = jsonObject.get("ruleNo").getAsString();


        int expireLimit = 0;


        if (rules != null) {



            Policy start = new TerminalPolicy(Integer.valueOf(startLimitHour));
            Policy end = new TerminalPolicy(Integer.valueOf(endLimitHours));

            for (RuleDTO rule : rules) {
                if (rule.getRuleNo() == Integer.valueOf(ruleNo)) {
                    expireLimit+= rule.getLimitTime();
                    break;

                }

            }



            Policy nonTerminalPolicy = new NonTerminalPolicy(start, end, ruleCategory);


            Policy policy2 = new NonTerminalPolicy(nonTerminalPolicy, new TerminalPolicy(expireLimit), ruleCategory);

            int newHoursLimit = nonTerminalPolicy.interpret();

            int newMaxLimitTime = policy2.interpret();

            int newLimitTime = newMaxLimitTime*-1;

            for (RuleDTO rule: rules) {
                if (rule.getRuleNo() == Integer.valueOf(ruleNo)) {

                    rule.setRuleCategory(ruleCategory);
                    rule.setRuleNo(Integer.valueOf(ruleNo));

                    if (newHoursLimit > rule.getLimitTime()) {
                        rule.setLimitTime(rule.getLimitTime()+newLimitTime);


                    }else{
                        rule.setLimitTime(rule.getLimitTime()-newLimitTime);
                    }

                    rule.setRuleName(ruleName);
                    break;
                }
            }


            JsonObject json = new JsonObject();
            json.add("rules", gson.toJsonTree(rules));
            resp.getWriter().write(gson.toJson(json));


        }

    }
}
