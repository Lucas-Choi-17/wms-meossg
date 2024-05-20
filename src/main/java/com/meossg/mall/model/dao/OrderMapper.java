package com.meossg.mall.model.dao;

import com.meossg.mall.model.dto.OrderDTO;

import java.util.List;

public interface OrderMapper {
    List<OrderDTO> getAllOrderList();

    List<OrderDTO> getAllOrderListWithStatus();

    int approveMemberOrder(int orderId);

    int makeOrderDeliver(int orderId);
}
