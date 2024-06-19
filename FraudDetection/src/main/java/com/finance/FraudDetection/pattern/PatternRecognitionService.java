package com.finance.FraudDetection.pattern;

public class PatternRecognitionService {

    private PatternRecognitionAlgorithm algorithm;

    public PatternRecognitionService(PatternRecognitionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void recognizePattern(Object data) {

        algorithm.recognize(data);
    }
}
