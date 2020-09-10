package com.app.reports.model;

public class ReportResponse {
	private Report report;

	public ReportResponse(Report report) {
		this.report = report;
	}
	public Long getTransactionReference() {
		return this.report.getTransactionReference();
	}
	public String getDescription() {
		return this.report.getDescription();
	}
}
