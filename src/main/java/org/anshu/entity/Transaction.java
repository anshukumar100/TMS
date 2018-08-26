/**
 * 
 */
package org.anshu.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity class to represent the Transaction table
 * @author Anshu Kumar
 *
 */

@Entity
@Table(name = "TMS_TRANSACTION")
public class Transaction  implements TMSEntity{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2504157429464570734L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long Id;
	
	@Column(name="TRANSACTION_TIME")
	private Date transactionTime;
	
	@Column(name="TRANSACTION_DESCRIPTION")
	@NotNull (message="Please enter the transaction description")
	private String transactionDescription;
	
	@Column(name="TRANSACTION_TYPE")
	private String transactionType;
	
	@Column(name="SENDER_ID")
	private Long senderId;
	
	@Column(name="RECEIVER_ID")
	private Long receiverId;
	
	@Column(name="amount")
	@NotNull
	private BigDecimal amount;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TMS_TRANSACTION_SENDER_ID")
	@NotNull(message="Sender account can not be empty")
	private Account senderAccount;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TMS_TRANSACTION_RECEIVER_ID")
	@NotNull(message="receiver account can not be empty")
	private Account receiverAccount;

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}

	/**
	 * @return the transactionTime
	 */
	public Date getTransactionTime() {
		return transactionTime;
	}

	/**
	 * @param transactionTime the transactionTime to set
	 */
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	/**
	 * @return the transactionDescription
	 */
	public String getTransactionDescription() {
		return transactionDescription;
	}

	/**
	 * @param transactionDescription the transactionDescription to set
	 */
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	/**
	 * @return the senderAccount
	 */
	public Account getSenderAccount() {
		return senderAccount;
	}

	/**
	 * @param senderAccount the senderAccount to set
	 */
	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}

	/**
	 * @return the receiverAccount
	 */
	public Account getReceiverAccount() {
		return receiverAccount;
	}

	/**
	 * @param receiverAccount the receiverAccount to set
	 */
	public void setReceiverAccount(Account receiverAccount) {
		this.receiverAccount = receiverAccount;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the senderId
	 */
	public Long getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId the senderId to set
	 */
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	/**
	 * @return the receiverId
	 */
	public Long getReceiverId() {
		return receiverId;
	}

	/**
	 * @param receiverId the receiverId to set
	 */
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
	
	
}
