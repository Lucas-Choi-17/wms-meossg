package com.meossg.warehouse.view;

import com.meossg.warehouse.model.dto.InWarehouseDTO;

import java.util.List;

public class WarehouseResultMessage {

    public void errorMessage(String error) {
        String errorMsg = "";
        switch (error) {
            case "addRequestStock":
                errorMsg="입고처리할 상품정보가 없습니다.";
                break;
            case "addRequestStock2":
                errorMsg = "입고처리에 실패하였습니다";
                break;

        }
        System.out.println(errorMsg);
    }

    public void susccessMessage(String success){
        String successMsg = "";
        switch (success) {

            case "addRequestStock":
                successMsg = "입고처리가 성공적으로 완료되었습니다.";
                break;
        }
        System.out.println(successMsg);
    }

    public void printSelectStockList(List<InWarehouseDTO> selectStockList) {

    }
}
