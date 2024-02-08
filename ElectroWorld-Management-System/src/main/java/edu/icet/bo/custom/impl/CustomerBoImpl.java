package edu.icet.bo.custom.impl;

import edu.icet.bo.custom.CustomerBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.CustomerDao;
import edu.icet.dao.util.DaoType;
import edu.icet.dto.CustomerDto;
import edu.icet.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDao customerDao= DaoFactory.getInstance().getDao(DaoType.CUSTOMER);

    @Override
    public boolean save(CustomerDto dto) throws SQLException, ClassNotFoundException {
        Customer customer=new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setContact(dto.getContact());
        return customerDao.save(customer);
    }

    @Override
    public boolean update(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.update(new Customer(
                dto.getCustomerId(),
                dto.getName(),
                dto.getContact(),
                dto.getEmail()
        ));
    }

    @Override
    public boolean delete(Long value) throws SQLException, ClassNotFoundException {
        return customerDao.delete(value);
    }

    @Override
    public List<CustomerDto> getAll() throws SQLException, ClassNotFoundException {
        List<CustomerDto> list=new ArrayList<>();
        List<Customer> entityLIst=customerDao.getAll();

        for (Customer customer:entityLIst) {
            list.add(new CustomerDto(
                    customer.getCustomerId(),
                    customer.getName(),
                    customer.getContact(),
                    customer.getEmail()
            ));
        }
        return list;
    }

    @Override
    public Long getNextId() throws SQLException {
        return customerDao.getNextId();
    }
}
