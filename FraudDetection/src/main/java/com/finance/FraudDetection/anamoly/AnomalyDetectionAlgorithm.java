package com.finance.FraudDetection.anamoly;

public interface AnomalyDetectionAlgorithm {

    /**
     * Detects anomalies in the given data.
     * 
     * @param data the input data to be analyzed for anomalies
     * @return true if anomalies are detected, false otherwise
     */
    boolean detect(Object data);
}

