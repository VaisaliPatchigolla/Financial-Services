package com.finance.FraudDetection.behavioral;

public class BehavioralAnalysisService {

    private BehavioralAnalysisAlgorithm algorithm;

    public BehavioralAnalysisService(BehavioralAnalysisAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void analyzeBehavior(Object data) {
        algorithm.analyze(data);
    }
}
