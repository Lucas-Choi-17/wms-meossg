package com.meossg.mall.view;

import com.meossg.mall.controller.MallController;
import com.meossg.mall.model.dto.ProductDTO;

import java.util.HashMap;
import java.util.Map;
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
                선택 :\s""";

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
                    MallController.modifyProduct(modifyInformation());
                    break;
                case "3":
                    // 발주
                    MallController.placingOrder(getProductId());
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

    private Map<String, Integer> getProductId() {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.println("-----------< 상품 발주 >-----------");
        System.out.print("발주하려는 상품 번호를 입력하세요 : ");
        int productId = sc.nextInt();
        // 입력된 번호를 상품 id로 가지는 상품 존재 여부 확인
        int result = MallController.checkProductExists(productId);

        if (result > 0) {
            System.out.print("발주 수량을 입력하세요 : ");
            int count = sc.nextInt();

            map.put("id", productId);
            map.put("count", count);

            return map;
        } else {
            System.out.println("해당 id는 존재하지 않는 상품 id 입니다.");
            return null;
        }
    }

    private ProductDTO modifyInformation() {

        Scanner sc = new Scanner(System.in);
        ProductDTO product = new ProductDTO();
        System.out.println("---------< 상품 정보 변경 >---------");
        System.out.print("변경하려는 상품의 id를 입력하세요 : ");
        product.setId(sc.nextInt());
        sc.nextLine();
        System.out.print("이름: ");
        product.setName(sc.nextLine());
        System.out.print("가격: ");
        String price = sc.nextLine();
        product.setPrice(price.compareTo("") == 0 ? 0 : Integer.parseInt(price));
        System.out.print("크기: ");
        product.setSize(sc.nextLine());
        System.out.print("색상: ");
        product.setColor(sc.nextLine());
        System.out.print("판매여부: ");
        product.setAvailability(sc.nextLine());

        System.out.println(product);

        return product;
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
