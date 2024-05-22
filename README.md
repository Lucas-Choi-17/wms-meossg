# meossg


# 🏭창고 관리 프로그램

## 📉프로젝트 소개
* 개발기간 : 2024.05.16 - 2024.05.21 (6일)
* 이 프로젝트는 Java, MySQL, MyBatis를 이용하여 개발된 쇼핑몰 관리 시스템으로, 회원, 쇼핑몰 관리자, 창고 관리자가 각각의 역할을 수행할 수 있는 기능을 제공합니다. 시스템은 쇼핑몰의 원활한 운영과 효율적인 관리, 그리고 원활한 물류 처리를 목적으로 하고 있습니다.

### 주요 목적
1.	회원 관리: 쇼핑몰 회원들이 물품을 구매하고 개인 정보를 관리할 수 있는 기능을 제공합니다.
2.	쇼핑몰 운영 관리: 쇼핑몰 관리자가 상품을 등록 및 수정하고, 주문을 승인하며 회원 정보를 관리할 수 있도록 합니다.
3.	창고 관리: 창고 관리자가 물품의 입출고와 재고를 관리하고, 회원의 주문에 따라 물품을 배송할 수 있도록 합니다.

### 주요 기능
#### 회원 기능
1.	물품 구매: 회원은 쇼핑몰에서 다양한 물품을 검색하고 구매할 수 있습니다.
2.	회원 정보 변경: 회원은 자신의 개인정보(이름, 주소, 연락처 등)를 조회하고 수정할 수 있습니다.
   
#### 쇼핑몰 기능
1.	상품 등록 및 변경: 새로운 상품을 등록하거나 기존 상품의 정보를 수정할 수 있습니다.
2.	상품 발주: 새로운 상품이나 기존 상품을 창고에 비축하도록 할 수 있습니다.
3.	주문 승인: 회원이 주문한 상품을 확인하고 승인합니다.
4.	회원 정보 변경: 쇼핑몰 관리자는 필요에 따라 회원의 개인정보를 수정할 수 있습니다.
5.	통계: 쇼핑몰의 매출이나 상품별 판매량을 확인할 수 있습니다.

#### 창고 기능
1.	입출고 관리: 창고로 들어오는 상품의 입고와 출고를 관리합니다.
2.	재고 관리: 현재 재고 상태를 확인하고 필요한 조치를 취합니다.
3.	배송 처리: 쇼핑몰에서 주문한 상품을 회원의 주소로 배송합니다.

### 데이터베이스 구성
<img src="https://github.com/ssg-240304-java2/wms-meossg/assets/83406742/cbbd4ba4-43e3-4fe1-90a0-6f3a9db0720f">

### 기대효과
* 효율성 증가: 쇼핑몰과 창고의 통합 관리를 통해 운영 효율성을 높입니다.
* 편의성 제공: 사용자(회원)에게 편리한 쇼핑 환경을 제공하고, 관리자의 업무 부담을 줄입니다.
* 정확성 향상: 데이터베이스를 활용하여 정확한 재고 관리와 주문 처리를 보장합니다.

* * *

## 🧑‍💻팀원 구성
1. 장윤지 (elliaaa)
2. 이창민 (l2chmnl)
3. 석현균 (gusrbstjr)
4. 고경호 (yoaruku)
5. 최승인 (Lucas-Choi-17)

## ⚙️ 개발 환경
* Develop : IntelliJ IDEA 2024.1.1 (Ultimate Edition)
* JAVA JDK: Temurin version '17.0.10'
* MySQL-connector-j : 8.0.33
* Mybatis : 3.5.6
* Build Tool : gradle
* Version Control : Git
* Communicate : Slack, Zoom, Kakaotalk
* Collaboration Tool : Figma, ERDCLOUD, Github, Notion

## 프로젝트 구조

```
JD-5racle
├── README.md
└── src/main/java
      ├── com/meossg
      |    ├── accountSelectView
      |    |    └── SelectAccountView.java
      |    |
      |    ├── common
      |    |    └── MyBatisTemplate.java
      |    |
      |    ├── run
      |    |    └── Application.java
      |    |
      |    ├── member
      |    |    ├── controller
      |    |    |    ├── MemberController.java
      |    |    |    ├── PrintResult.java
      |    |    |    └── PrintResult.java
      |    |    |
      |    |    ├── model
      |    |    |    ├── dao
      |    |    |    |    └── MemberMapper.java
      |    |    |    |
      |    |    |    ├── dto
      |    |    |    |    ├── ItemDTO.java
      |    |    |    |    ├── OrderPurchaseDTO.java
      |    |    |    |    └── UserDTO.java
      |    |    |    |
      |    |    |    └── service
      |    |    |         └── MemberService.java
      |    |    |
      |    |    └── view
      |    |         └── MemberMenuView.java
      |    |
      |    ├── mall
      |    |    ├── controller
      |    |    |    └── mallController.java
      |    |    |
      |    |    ├── model
      |    |    |    ├── dao
      |    |    |    |    ├── AdminMapper.java
      |    |    |    |    ├── DeliveryMapper.java
      |    |    |    |    ├── MallMapper.java
      |    |    |    |    ├── OrderMapper.java
      |    |    |    |    └── ProductMapper.java
      |    |    |    |
      |    |    |    ├── dto
      |    |    |    |    ├── AdminDTO.java
      |    |    |    |    ├── DeliveryDTO.java
      |    |    |    |    ├── MallOrderDTO.java
      |    |    |    |    ├── MallPlacingOrderDTO.java
      |    |    |    |    ├── MemberDTO.java
      |    |    |    |    ├── ProductDTO.java
      |    |    |    |    ├── SalesRateDTO.java
      |    |    |    |    └── StockDTO.java
      |    |    |    |
      |    |    |    └── service
      |    |    |         └── MallService.java
      |    |    |
      |    |    └── view
      |    |         ├── MallAnalysisView.java
      |    |         ├── MallLoginView.java
      |    |         ├── MallMemberMenuView.java
      |    |         ├── MallMenuView.java
      |    |         ├── MallOrderManageView.java
      |    |         └── MallProductManageView.java
      |    └── warehouse
      |         ├── controller
      |         |    ├── OutWarehouseController.java
      |         |    └── WarehouseController.java
      |         |
      |         ├── model
      |         |    ├── mapper
      |         |    |    └── WarehouseMapper.java
      |         |    |
      |         |    ├── dto
      |         |    |    ├── InWarehouseDTO.java
      |         |    |    ├── MemberOrderDTO.java
      |         |    |    ├── OrderListDTO.java
      |         |    |    ├── OutwarehouseDTO.java
      |         |    |    ├── PlacingOrderDTO.java
      |         |    |    ├── WhAdminDTO.java
      |         |    |    └── WhStockDTO.java
      |         |    |
      |         |    └── service
      |         |         ├── InWarehouseService.java
      |         |         └── WarehouseService.java
      |         |
      |         └── view
      |              ├── OutWarehouseView.java
      |              ├── WarehouseLoginView.java
      |              ├── WarehouseMenuView.java
      |              └── WarehouseResultMessage.java
      |
      └── resources
           ├── sql
           |    ├── member
           |    |   └── member-mapper.xml
           |    ├── mall
           |    |   ├── admin-mapper.xml
           |    |   ├── delivery-mapper.xml
           |    |   ├── mall-mapper.xml
           |    |   ├── order-mapper.xml
           |    |   └── product-mapper.xml
           |    └── warehouse
           |        └── warehouse-mapper.xml
           └── mybatis-config.xml
```


## 📋역할 분담

#### 장윤지
* 회원
  1. 회원 로그인,회원가입 기능 구현
  2. 개인 정보 변경
  3. 구매 정보 확인 후 내역 조회 후 구매 취소


#### 이창민
* 기능
  1. 내용
  2.

#### 석현균
* 기능
  1. 내용
  2.

#### 고경호
* 기능
  1. 내용
  2.

#### 최승인
* 기능
  1. 쇼핑몰 상품 및 주문 관리 기능
  2. 쇼핑몰 매출 확인 기능
  3. 회원 구매 및 구매 내역 확인 기능


## 📕 프로젝트 후기

#### 장윤지
* 데이터 베이스를 연결해서 사용하는 프로젝트를 시도해본적이 처음이다 보니 기본 이해도부터 많이 부족한 상태로 프로젝트를 시작했습니다.
  원래 맡았던 회원 파트 기능을 다 끝내지 못한 상태였는데 개발 기간이 촉박하다보니 팀원분들의 도움을 많이 받을 수 밖에 없는 상황이라 죄송한 마음이 크게 남은 채로 프로젝트를 마무리하게되었습니다.
  하지만 작은 기능이라도 조금씩 구현해보면서 아예 감도 잡지 못했던 부분들을 조금이나마 시도해 볼 수 있었다는 사실에 의의를 두고자 합니다.
  다음 프로젝트때는 이번 프로젝트보다 어떤 식으로 데이터를 불러와서 필요한 부분만 사용가능한지에 대한 로직 파악을 잘 해서 부족한 지식들을 보완해 다른 분들이 맡은 기능을 끝내지 못했을때 도와줄 수 있는 포지션에 자리하고 싶은 마음이 큽니다.
  개발하는 기간동안 고생해주신 팀원분들 덕분에 소통에 있어서 불편함없이 하나부터 열까지 배우는 마음으로 프로젝트 끝까지 마무리 할 수 있었습니다. 감사합니다~

#### 이창민


#### 석현균
* 창고 재고 관리를 주제로 추가할 기능들을 자유롭게 토론하여 기능들을 정하였다.
생각 했던거와 달리 기능들을 구현하는게 어려웠고, 팀 프로젝트인 만큼 팀원들과 소통이 중요하다는걸 다시 알게 되었다.
진행 도중 어려운 부분에서 막혔을때 팀원에게 도움을 받아 진행을 하였고 팀원 덕분에 이번 프로젝트를 통해 나의 부족한 점을 자세히 알게 되었고 실력 또한 팀원들의 도움 덕분에 많이 향상 시킬 수 있는 경험이 되었다.
다음 프로젝트때는 나도 도움을 줄 수 있게 노력해야 겠다고 생각한다.

#### 고경호
* 후기

#### 최승인
* 후기

