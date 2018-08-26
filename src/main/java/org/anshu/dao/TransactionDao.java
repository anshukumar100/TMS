/**
 * 
 */
package org.anshu.dao;

import java.util.List;

import org.anshu.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author C37283
 *
 */

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Long>{

	/**
	 * This method is used to find all the transaction by a given sender ID
	 * @param id input sender ID for which all the transactions needs to be found
	 * @return List of transactions if exist or else will return NULL
	 */
	public List<Transaction> findBySenderAccountAccountId(Long id);

	/**
	 * This method is used to find all the transaction by a given receiver ID
	 * @param id input receiver ID for which all the transactions needs to be found
	 * @return List of transactions if exist or else will return NULL
	 */
	public List<Transaction> findByReceiverAccountAccountId(Long id);

}
