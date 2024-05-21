package com.meossg.mall.model.dao;

import com.meossg.mall.model.dto.MallOrderDTO;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    List<MallOrderDTO> getAllOrderList();

    List<MallOrderDTO> getAllOrderListWithStatus();

    int approveMemberOrder(int orderId);

    int makeOrderDeliver(int orderId);

    int getTotalProfit();

    Integer getPeriodProfit(Map<String, Integer> period);
}
