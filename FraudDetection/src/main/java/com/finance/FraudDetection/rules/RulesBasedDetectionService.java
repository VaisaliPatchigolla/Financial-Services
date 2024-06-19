package com.finance.FraudDetection.rules;

public class RulesBasedDetectionService {

    public boolean applyRules(Object data, Rule rule) {
        return rule.apply(data);
    }
}

