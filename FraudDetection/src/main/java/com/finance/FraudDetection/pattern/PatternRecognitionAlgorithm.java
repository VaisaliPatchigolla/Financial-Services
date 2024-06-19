package com.finance.FraudDetection.pattern;

public interface PatternRecognitionAlgorithm {

    /**
     * Recognizes patterns in the given data.
     * 
     * @param data the input data to be analyzed for patterns
     */
    void recognize(Object data);
}
