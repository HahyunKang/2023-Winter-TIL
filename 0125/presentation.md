# 프레젠테이션 영역

## 📝Controller : 사용자의 요청이 진입하는 Entry Point
- 요청을 받아서 실질적으로 처리하는 역할을 service layer에 넘겨주고, service layer에서 처리한 결과를 응답하는 역할

💻 코드 분석
1. @Controller
   - 컨트롤러 레이어에 해당함을 명시
2. @RestController
   -  데이터의 처리만을 담당하는 API를 개발할 때 사용
   - return 되는 값은 그대로 HTTP 응답 메시지의 Body에 들어감.
3. @RequestMapping
   - HTTP 요청을 정의하는 역할
   - 이 때 클래스에 붙이면, 정의한 경로가 클래스 내부의 모든 메소드에 공통적으로 붙음.


## 📝Service : 서비스의 비지니스 로직 

- Controller와 도메인 레이어 사이에 추상화 계층을 제공
- Controller가 요청된 작업을 수행하기 위해 호출할 수 있는 메소드 집합 제공
- 사용자가 전달받은 데이터를 가공하여 처리. JpaRepository를 상속하는 객체를 가져와 어떤 처리를 할지 비지니스 로직 처리

💻 코드 분석
1. @Transactional : 트랜잭션을 간편하게 열고 닫을 수 있움.
  -  rollbackFor: 어떤 예외가 발생했을 때 롤백할지를 정의
  - readOnly: 읽기 전용 트랜잭션으로 설정
  - isolation: 트랜잭션 고립 수준을 정의

## 📝DTO : 계층간 데이터 교환을 위해 사용하는 객체
- 한 번의 호출로 해당 호출에 관련된 모든 데이터를 담은 객체를 리턴 받아 사용하는 것
- 다양한 비지니스 로직과 요구사항에 대해 유연하게 대응 가능
- Controller와 Service 사이에서 강한 의존을 방지할 수 있다.

