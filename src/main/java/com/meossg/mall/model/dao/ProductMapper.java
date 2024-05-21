package com.meossg.mall.model.dao;

import com.meossg.mall.model.dto.MallPlacingOrderDTO;
import com.meossg.mall.model.dto.ProductDTO;
import com.meossg.mall.model.dto.SalesRateDTO;
import com.meossg.mall.model.dto.StockDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int addProduct(ProductDTO product);

    int modifyProduct(ProductDTO product);

    int placingOrder(Map<String, Integer> map);

    ProductDTO checkProductExists(int productId);

    List<StockDTO> getAllStockList();
    List<ProductDTO> selectAllProducts();

    List<MallPlacingOrderDTO> selectAllPlacingOrder();

    MallPlacingOrderDTO isPlacingOrderNull(int mallPlacingOrderId);

    int deletePlacingOrder(HashMap<String, Integer> mallPlacingOrder);

    List<SalesRateDTO> salesTotalSalesRate();
}
