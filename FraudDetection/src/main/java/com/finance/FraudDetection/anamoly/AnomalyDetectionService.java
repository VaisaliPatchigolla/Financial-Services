package com.finance.FraudDetection.anamoly;

public class AnomalyDetectionService {

    private AnomalyDetectionAlgorithm algorithm;

    public AnomalyDetectionService(AnomalyDetectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public boolean detectAnomaly(Object data) {
        return algorithm.detect(data);
    }
}
