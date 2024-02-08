package edu.icet.bo.custom.impl;

import edu.icet.bo.custom.ItemBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.ItemDao;
import edu.icet.dao.util.DaoType;
import edu.icet.dto.ItemDto;
import edu.icet.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo {
    private ItemDao itemDao= DaoFactory.getInstance().getDao(DaoType.ITEM);


    @Override
    public boolean save(ItemDto dto) throws SQLException, ClassNotFoundException {
        Item item=new Item();
        item.setName(dto.getName());
        item.setCategory(dto.getCategory());
        item.setStandardFee(dto.getStandardFee());
        return itemDao.save(item);
    }

    @Override
    public boolean update(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(
                dto.getItemId(),
                dto.getName(),
                dto.getCategory(),
                dto.getStandardFee()
        ));
    }

    @Override
    public boolean delete(Long value) throws SQLException, ClassNotFoundException {
        return itemDao.delete(value);
    }

    @Override
    public List<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        List<ItemDto> list=new ArrayList<>();
        List<Item> entityLIst=itemDao.getAll();

        for (Item item:entityLIst) {
            list.add(new ItemDto(
                    item.getItemId(),
                    item.getName(),
                    item.getCategory(),
                    item.getStandardFee()
            ));
        }
        return list;
    }

    @Override
    public Long getNextId() throws SQLException {
        return itemDao.getNextId();
    }
}
