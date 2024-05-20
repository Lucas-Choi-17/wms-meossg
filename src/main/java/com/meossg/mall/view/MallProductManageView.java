package com.meossg.mall.view;

import com.meossg.mall.controller.MallController;
import com.meossg.mall.model.dto.ProductDTO;

import java.util.HashMap;
import java.util.InputMismatchException;
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
                    MallController.getAllStockList();
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
        System.out.println("변경하려는 상품의 id를 입력하세요 : ");

        try {
            System.out.print("상품 id: ");
            int id = sc.nextInt();
            product.setId(id);
            sc.nextLine();
        } catch (InputMismatchException e){
            System.out.println("문자는 입력할 수 없습니다. 정보 변경을 다시 시작합니다.");
            modifyInformation();
            sc.nextLine();
        }
        System.out.print("이름: ");
        product.setName(sc.nextLine());
        System.out.print("가격: ");
        String price = sc.nextLine();
        product.setPrice(price.compareTo("") == 0 ? 0 : Integer.parseInt(price));
        System.out.print("상품크기(L, M, S): ");
        String size = sc.nextLine().charAt(0)+"";
        while (true) {
            if (size.equalsIgnoreCase("L") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("S")) {
                product.setSize(size);
                break;
            }
            else {
                System.out.println("상품 크기는 (L, M, S)중 선택해주세요.");
                System.out.print("상품크기(L, M, S): ");
                size = sc.nextLine().charAt(0) + "";
            }
        }
        System.out.print("색상: ");
        product.setColor(sc.nextLine().toUpperCase());
        System.out.print("판매 여부(Y/N): ");
        String YN = sc.nextLine().toUpperCase().charAt(0)+"";
        while (true) {
            if (YN.equalsIgnoreCase("Y") || YN.equalsIgnoreCase("N")) {
                product.setAvailability(YN);
                break;
            } else {
                System.out.println("판매 여부는 (Y, N)중 선택해주세요.");
                YN = sc.nextLine().charAt(0) + "";
            }
        }
        System.out.println(product);

        return product;
    }


    private ProductDTO newProduct() {
        Scanner sc = new Scanner(System.in);

        ProductDTO product = new ProductDTO();
        System.out.println("----< 추가할 상품 정보를 입력하세요 >----");
        System.out.print("상품명: ");
        product.setName(sc.nextLine());
        try {
            System.out.print("상품가격: ");
            int price = sc.nextInt();
            if (price == 0){
                System.out.println("가격은 0이 될 수 없습니다. 상품 등록을 다시 진행합니다.");
            }
            product.setPrice(price);
            sc.nextLine();
        } catch (InputMismatchException e){
            System.out.println("가격에 문자는 입력할 수 없습니다. 상품 등록을 다시 진행합니다.");
            newProduct();
            sc.nextLine();
        }
        System.out.print("상품크기(L, M, S): ");
        String size = sc.nextLine().charAt(0)+"";
        while (true) {
            if (size.equalsIgnoreCase("L") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("S")) {
                product.setSize(size);
                break;
            }
            else {
                System.out.println("상품 크기는 (L, M, S)중 선택해주세요.");
                System.out.print("상품크기(L, M, S): ");
                size = sc.nextLine().charAt(0) + "";
            }
        }
        System.out.print("상품색상: ");
        product.setColor(sc.nextLine().toUpperCase());
        System.out.print("판매 여부(Y/N): ");
        String YN = sc.nextLine().toUpperCase().charAt(0)+"";
        while (true) {
            if (YN.equalsIgnoreCase("Y") || YN.equalsIgnoreCase("N")) {
                product.setAvailability(YN);
                break;
            } else {
                System.out.println("판매 여부는 (Y, N)중 선택해주세요.");
                YN = sc.nextLine().charAt(0) + "";
            }
        }
        System.out.println(product);

        return product;
    }


}
