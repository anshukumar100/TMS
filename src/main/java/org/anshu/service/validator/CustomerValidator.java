/**
 * 
 */
package org.anshu.service.validator;

import java.math.BigDecimal;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.anshu.entity.Account;
import org.anshu.entity.Customer;


/**
 * Validator class which is used to validte the input parameters of customer
 * @author Anshu Kumar
 * @version : 1.0.0
 */

public class CustomerValidator {

	/**
	 * This method validates if the customer input is valid or not
	 * @param customer input customer details
	 * @return true if customer data is valid else will return false
	 */
	public static boolean validateCustomerData(Customer customer) {
		boolean isValidCustomerData = true;
		boolean isValidEmailAddress = isValidEmailAddress(customer.getEmailId());
		boolean isValidBalance = true;
		
		for(Account account : customer.getAccounts()) {
			isValidBalance = (account.getBalance().compareTo(BigDecimal.ZERO) != -1) ? true : false;
			if(!isValidBalance) {
				break;
			}
	    }
		
		if((!isValidEmailAddress)) {
			isValidCustomerData = false;
		}
		return isValidCustomerData;
	}
	
	
	/**
	 * This method validates if the given email ID is valid or not
	 * @param email input email ID
	 * @return true if email is valid else will return false
	 */
	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

}
