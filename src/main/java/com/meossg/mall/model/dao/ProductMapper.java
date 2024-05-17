package com.meossg.mall.model.dao;

import com.meossg.mall.model.dto.ProductDTO;

public interface ProductMapper {
    int addProduct(ProductDTO product);

    int modifyProduct(ProductDTO product);
}
