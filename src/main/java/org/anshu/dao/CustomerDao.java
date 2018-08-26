/**
 * 
 */
package org.anshu.dao;

import org.anshu.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 
 * This class provide default implementation of the basic CURD operations provided by CrudRepository. 
 * Also it contains all the blue print of business methods for Customer entity
 * @author Anshu Kumar
 *
 */

@Repository
@Component
public interface CustomerDao extends CrudRepository<Customer, Long>{


}
