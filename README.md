
# 프로젝트 설명
### 구현 내용
1. MyBatis 를 이용한 CRUD
2. JWT를 이용한 로그인 구현
3. ControllerAdvice를 통한 예외처리
### 주요 라이브러리
- MyBatis
- jwt
- Spring Security
- Lombok

<br>

---

### 해당 프로젝트는 아래의 기능을 구현하였습니다.

User
- 유저 생성
- 로그인
- 유저 전체 조회
- 유저 Email 을 통한 조회
- 유저 삭제
<br>

Product(상품)
- 상품 등록
- 상품 조회
- 상품명으로 조회
- 상품 삭제
- 상품 정보 수정
<br>

bucket(장바구니)
- 장바구니 목록 추가
- 장바구니 목록 전체 삭제
- 장바구니 목록 선택 삭제
- 장바구니 목록 조회
<br>

buy(구매목록)
- 장바구니 목록 구매
- 구매목록 조회

---
<br>

서버 IP 주소 : 43.201.123.163:9090 <br>
(EC2 서버의 8080 포트를 사용중이여서 EC2 서버의 9090 포트를 통해 컨테이너의 8080 포트로 포트포워딩 하였습니다.)

---
<br>

# API 명세서
(유저부분을 제외한 모든 엔드포인트는 로그인 후 기능 사용 가능합니다)
<br>
https://impartial-python-8f4.notion.site/9595e1bc1d174c3681842e48bf22f06a?v=e6b2aa98522c40bb93a5191a5fbe677a&pvs=4