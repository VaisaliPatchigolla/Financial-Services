package com.finance.FraudDetection.service;

public class FraudDetectionResult {

    private boolean isFraudulent;

    public FraudDetectionResult(boolean isFraudulent) {
        this.isFraudulent = isFraudulent;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}
