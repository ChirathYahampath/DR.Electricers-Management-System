package edu.icet.bo.custom.impl;

import edu.icet.bo.custom.OrderDetailBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.OrderDetailDao;
import edu.icet.dao.util.DaoType;
import edu.icet.dto.OrderDetailDto;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailBoImpl implements OrderDetailBo {
    private OrderDetailDao orderDetailDao= DaoFactory.getInstance().getDao(DaoType.ORDERDETAIL);
    @Override
    public boolean save(OrderDetailDto dto) throws SQLException, ClassNotFoundException {
        return orderDetailDao.save(dto);
    }

    @Override
    public boolean update(OrderDetailDto dto) throws SQLException, ClassNotFoundException {
        return orderDetailDao.update(dto);
    }

    @Override
    public boolean delete(Long value) throws SQLException, ClassNotFoundException {
        return orderDetailDao.delete(value);
    }

    @Override
    public List<OrderDetailDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Long getNextId() throws SQLException {
        return null;
    }
}
