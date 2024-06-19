package com.finance.FraudDetection.behavioral;


public interface BehavioralAnalysisAlgorithm {

    /**
     * Analyzes the behavior represented by the given data.
     * 
     * @param data the input data representing the behavior to be analyzed
     */
    void analyze(Object data);
}
