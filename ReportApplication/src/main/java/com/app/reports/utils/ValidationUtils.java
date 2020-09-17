package com.app.reports.utils;

import java.util.regex.Pattern;

import com.app.reports.exception.ValidationException;

/**
 * @author Ganapathi T
 *
 */
public class ValidationUtils {

	private static final Pattern TRANSACTION_REF_PATTERN = Pattern.compile("\\d+");
	private static final Pattern ACCOUNT_NUMBER_PATTERN = Pattern.compile("[A-Z]{2}[0-9]{2}[A-Z]{4}[0-9]{10}");
	
	public static Long validateAndGetTransactionReference(String transactionRef) {
		if(TRANSACTION_REF_PATTERN.matcher(transactionRef).matches()) {
			return Long.parseLong(transactionRef);
		} else {
			throw new ValidationException(String.format("Transaction Reference '%s' is not valid. Should only contains numeric value.", transactionRef));
		}
	}
	
	public static String validateAndGetAccountNumber(String accountNumber) {
		if(ACCOUNT_NUMBER_PATTERN.matcher(accountNumber).matches()) {
			return accountNumber;
		} else {
			throw new ValidationException(String.format("Account Number '%s' is not valid. Should have this [A-Z]{2}[0-9]{2}[A-Z]{4}[0-9]{10} format.", accountNumber));
		}
	}
	
	public static String getMutationSymbol(String mutationValue) {
		char symbol = mutationValue.charAt(0);
		
		return String.valueOf(symbol);
		/*
		 * if(symbol == '+' || symbol == '-') { return String.valueOf(symbol); } else {
		 * throw new ValidationException(String.
		 * format("Mutation System '%s' is not valid. Should have either + or -.",
		 * mutationValue)); }
		 */
	}

	public static Double getMutationValue(String mutationValue) {
		return Double.valueOf(mutationValue);
	}
}
