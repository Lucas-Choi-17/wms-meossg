package com.meossg.mall.model.dao;

import com.meossg.mall.model.dto.OrderDTO;

import java.util.List;

public interface OrderMapper {
    List<OrderDTO> getAllOrderList();
}
