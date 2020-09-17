package com.app.reports.model;

public class Report {
	
private Long transactionReference;
	
	private String accountNumber;
	
	private Double startBalance;
	
	private String mutationSymbol;
	
	private Double mutationValue;
	
	private String description;
	
	private Double endBalance;

	public Long getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(Long transactionReference) {
		this.transactionReference = transactionReference;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(Double startBalance) {
		this.startBalance = startBalance;
	}

	public String getMutationSymbol() {
		return mutationSymbol;
	}

	public void setMutationSymbol(String mutationSymbol) {
		this.mutationSymbol = mutationSymbol;
	}

	public Double getMutationValue() {
		return mutationValue;
	}

	public void setMutationValue(Double mutationValue) {
		this.mutationValue = mutationValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(Double endBalance) {
		this.endBalance = endBalance;
	}
	
	
	public Report(Long transactionReference, String accountNumber, Double startBalance, String mutationSymbol,
			Double mutationValue, String description, Double endBalance) {
		super();
		this.transactionReference = transactionReference;
		this.accountNumber = accountNumber;
		this.startBalance = startBalance;
		this.mutationSymbol = mutationSymbol;
		this.mutationValue = mutationValue;
		this.description = description;
		this.endBalance = endBalance;
	}
	
	public Report() {
		
	}

	@Override
	public String toString() {
		return "Report [transactionReference=" + transactionReference + ", accountNumber=" + accountNumber
				+ ", startBalance=" + startBalance + ", mutationSymbol=" + mutationSymbol + ", mutationValue="
				+ mutationValue + ", description=" + description + ", endBalance=" + endBalance + "]";
	}

	
	  @Override public int hashCode() { final int prime = 31; int result = 1;
	  result = prime * result + ((accountNumber == null) ? 0 :
	  accountNumber.hashCode()); result = prime * result + ((description == null) ?
	  0 : description.hashCode()); result = prime * result + ((endBalance == null)
	  ? 0 : endBalance.hashCode()); result = prime * result + ((mutationSymbol ==
	  null) ? 0 : mutationSymbol.hashCode()); result = prime * result +
	  ((mutationValue == null) ? 0 : mutationValue.hashCode()); result = prime *
	  result + ((startBalance == null) ? 0 : startBalance.hashCode()); result =
	  prime * result + ((transactionReference == null) ? 0 :
	  transactionReference.hashCode()); return result; }
	  
	  @Override public boolean equals(Object obj) { if (this == obj) return true;
	  if (obj == null) return false; if (getClass() != obj.getClass()) return
	  false; Report other = (Report) obj; if (accountNumber == null) { if
	  (other.accountNumber != null) return false; } else if
	  (!accountNumber.equals(other.accountNumber)) return false; if (description ==
	  null) { if (other.description != null) return false; } else if
	  (!description.equals(other.description)) return false; if (endBalance ==
	  null) { if (other.endBalance != null) return false; } else if
	  (!endBalance.equals(other.endBalance)) return false; if (mutationSymbol ==
	  null) { if (other.mutationSymbol != null) return false; } else if
	  (!mutationSymbol.equals(other.mutationSymbol)) return false; if
	  (mutationValue == null) { if (other.mutationValue != null) return false; }
	  else if (!mutationValue.equals(other.mutationValue)) return false; if
	  (startBalance == null) { if (other.startBalance != null) return false; } else
	  if (!startBalance.equals(other.startBalance)) return false; if
	  (transactionReference == null) { if (other.transactionReference != null)
	  return false; } else if
	  (!transactionReference.equals(other.transactionReference)) return false;
	  return true; }

	
	  
	  
	 

	
	

}