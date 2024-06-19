package com.finance.ComplianceService.model;

import java.time.LocalDateTime;

public class Alert {

	  private Long id;
	  private Long transactionId; 
	  private String ruleViolated; 
	  private String additionalInfo; 
	  private LocalDateTime timestamp;
	  
	  public Alert() {
			super();
		}
	  public Alert(Long id, Long transactionId, String ruleViolated, String additionalInfo, LocalDateTime timestamp) {
			super();
			this.id = id;
			this.transactionId = transactionId;
			this.ruleViolated = ruleViolated;
			this.additionalInfo = additionalInfo;
			this.timestamp = timestamp;
		}
	  public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(Long transactionId) {
			this.transactionId = transactionId;
		}
		public String getRuleViolated() {
			return ruleViolated;
		}
		public void setRuleViolated(String ruleViolated) {
			this.ruleViolated = ruleViolated;
		}
		public String getAdditionalInfo() {
			return additionalInfo;
		}
		public void setAdditionalInfo(String additionalInfo) {
			this.additionalInfo = additionalInfo;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}   
}

