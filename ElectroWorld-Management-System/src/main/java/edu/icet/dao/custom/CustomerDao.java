package edu.icet.dao.custom;

import edu.icet.dao.CrudDao;
import edu.icet.entity.Customer;
import edu.icet.entity.Customer;

import java.sql.SQLException;

public interface CustomerDao extends CrudDao<Customer> {

    boolean save(Customer entity) throws SQLException, ClassNotFoundException;
}
