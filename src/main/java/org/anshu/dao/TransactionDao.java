/**
 * 
 */
package org.anshu.dao;

import org.anshu.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * This class provide default implementation of the basic CURD operations provided by CrudRepository. 
 * Also it contains all the blue print of business methods for Transaction entity
 * @author Anshu Kumar
 *
 */

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Long>{

}
