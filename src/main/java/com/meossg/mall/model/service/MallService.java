package com.meossg.mall.model.service;

import com.meossg.mall.model.dao.AdminMapper;
import com.meossg.mall.model.dao.DeliveryMapper;
import com.meossg.mall.model.dao.OrderMapper;
import com.meossg.mall.model.dao.ProductMapper;
import com.meossg.mall.model.dto.*;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.meossg.common.MyBatisTemplate.getSqlSession;

public class MallService {

    private AdminMapper adminMapper;

    public static void addProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.addProduct(product);
        if (result > 0) {
            System.out.println("상품 등록 성공!!");
            sqlSession.commit();
        } else {
            System.out.println("상품 등록 실패!!");
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    public static int isPlacingOrderNull(int mallPlacingOrderId) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        MallPlacingOrderDTO mallPlacingOrder = productMapper.isPlacingOrderNull(mallPlacingOrderId);

        if (mallPlacingOrder != null) {
            sqlSession.close();
            return 1;
        } else {
            sqlSession.close();
            return 0;
        }
    }

    public static int deletePlacingOrder(HashMap<String, Integer> mallPlacingOrderId) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        int result = productMapper.deletePlacingOrder(mallPlacingOrderId);


        if (result > 0) {
            sqlSession.commit();
            sqlSession.close();
            return 1;
        } else {
            sqlSession.rollback();
            sqlSession.close();
            return 0;
        }
    }

    public List<MemberDTO> selectMemberByName(MemberDTO findName) {
        SqlSession sqlSession = getSqlSession();
        AdminMapper memberMapper = sqlSession.getMapper(AdminMapper.class);

        List<MemberDTO> memberList = memberMapper.selectMemberByName(findName);

        return memberList;
    }

    public static int modifyProduct(ProductDTO product) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        try {
            int result = productMapper.modifyProduct(product);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public static int placingOrder(Map<String, Integer> map) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        try {
            int result = productMapper.placingOrder(map);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public static int checkProductExists(int productId) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        try {
            ProductDTO productDTO = productMapper.checkProductExists(productId);
            sqlSession.commit();
            return productDTO != null ? 1 : 0;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

    }

    public static List<StockDTO> getAllStockList() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<StockDTO> stockList = productMapper.getAllStockList();

        sqlSession.close();
        return stockList;
    }

    public AdminDTO verifyLogin(AdminDTO admin) {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
        AdminDTO adminDTO = adminMapper.verifyLogin(admin);

        sqlSession.close();
        return adminDTO;
    }

    public List<MemberDTO> selectAllMember() {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<MemberDTO> memberList = adminMapper.selectAllMember();

        sqlSession.close();
        return memberList;
    }


    public List<MallOrderDTO> getAllOrderList() {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<MallOrderDTO> orderList = orderMapper.getAllOrderList();

        sqlSession.close();
        if (orderList != null && orderList.size() > 0) {
            return orderList;
        } else return null;
    }

    public List<DeliveryDTO> showPostStatus() {
        SqlSession sqlSession = getSqlSession();
        DeliveryMapper deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        List<DeliveryDTO> deliveryList = deliveryMapper.showDeliveryList();

        sqlSession.close();
        return deliveryList;
    }

    public List<MallOrderDTO> getAllOrderListWithStatus() {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<MallOrderDTO> orderList = orderMapper.getAllOrderListWithStatus();
        sqlSession.close();
        if (orderList != null && orderList.size() > 0) {
            return orderList;
        }
        return null;
    }

    public void approveOrder(int orderId) {

        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result1 = orderMapper.approveMemberOrder(orderId);
        if (result1 > 0) {
            int result2 = orderMapper.makeOrderDeliver(orderId);
            if (result2 > 0) {
                System.out.println("주문 승인!!");
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    public boolean updateAllInfo(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);

        int result = adminMapper.updateAllInfo(member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }

    public boolean updatePassword(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);

        int result = adminMapper.updateMemberPassword(member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }

    public boolean updatePhone(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);

        int result = adminMapper.updateMemberPhone(member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }

    public boolean updateAddress(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);

        int result = adminMapper.updateMemberAddress(member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;
    }

    public List<ProductDTO> selectAllProducts() {

        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        List<ProductDTO> productList = productMapper.selectAllProducts();

        sqlSession.close();
        return productList;
    }

    public List<MallPlacingOrderDTO> selectAllPlacingOrder() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        List<MallPlacingOrderDTO> placingOrderList = productMapper.selectAllPlacingOrder();

        sqlSession.close();
        return placingOrderList;
    }

    public int getTotalProfit() {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        int total = orderMapper.getTotalProfit();
        sqlSession.close();
        return total;
    }

    public int getPeriodProfit(Map<String, Integer> period) {
        SqlSession sqlSession = getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        int total = orderMapper.getPeriodProfit(period) == null ? 0 : orderMapper.getPeriodProfit(period);
        sqlSession.close();
        return total;
    }

    public List<SalesRateDTO> selectTotalSalesRate() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        List<SalesRateDTO> salesRateList = productMapper.salesTotalSalesRate();

        if (salesRateList != null && !salesRateList.isEmpty()) {
            sqlSession.close();
            return salesRateList;
        } else {
            sqlSession.close();
            return null;
        }
    }
}


