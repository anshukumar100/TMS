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
 * @author C37283
 *
 */
public class CustomerValidator {

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
