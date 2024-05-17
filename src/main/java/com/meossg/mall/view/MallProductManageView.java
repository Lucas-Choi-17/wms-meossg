package com.meossg.mall.view;

import com.meossg.mall.controller.MallController;
import com.meossg.mall.model.dto.ProductDTO;

import java.util.Scanner;

public class MallProductManageView {

    public void productManagingMenu() {
        String menu = """
                ============================
                상품 관리
                ============================
                1. 상품 등록
                2. 상품 정보 변경
                3. 발주
                4. 재고 조회
                0. 뒤로 가기
                ============================
                선택 :\n""";

        while (true) {
            System.out.print(menu);
            String input = new Scanner(System.in).next();
            switch (input) {
                case "1":
                    // 상품 등록
                    MallController.addProduct(newProduct());
                    break;
                case "2":
                    // 상품 정보 변경
                    break;
                case "3":
                    // 발주
                    break;
                case "4":
                    // 재고 조회
                    break;
                case "0":
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }
    }

    private ProductDTO newProduct() {
        Scanner sc = new Scanner(System.in);

        ProductDTO product = new ProductDTO();
        System.out.println("----< 추가할 상품 정보를 입력하세요 >----");
        System.out.print("상품명: ");
        product.setName(sc.next());
        System.out.print("상품가격: ");
        product.setPrice(sc.nextInt());
        System.out.print("상품크기(L, M, S): ");
        product.setSize(sc.next());
        System.out.print("상품색상: ");
        product.setColor(sc.next());
        System.out.print("판매 여부(Y/N): ");
        product.setAvailability(sc.next());

        System.out.println(product);

        return product;
    }


}
