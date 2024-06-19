package com.finance.ReportingServiceMng.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class FinancialReport {
	@Id
    private Long id;
    private String reportId;
    @Column(nullable=false)
    private String reportName;
    @Column(nullable=false)
    private String generatedBy;
    
    private String generatedDate;
	public FinancialReport() {
		super();
	}
	public FinancialReport(String reportId, String reportName, String generatedBy, String generatedDate) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.generatedBy = generatedBy;
		this.generatedDate = generatedDate;
		
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getGeneratedBy() {
		return generatedBy;
	}
	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}
	public String getGeneratedDate() {
		return generatedDate;
	}
	public void setGeneratedDate(String generatedDate) {
		this.generatedDate = generatedDate;
	}
	@Override
	public String toString() {
		return "FinancialReport [reportId=" + reportId + ", reportName=" + reportName + ", generatedBy=" + generatedBy
				+ ", generatedDate=" + generatedDate + "]";
	}
    
}

