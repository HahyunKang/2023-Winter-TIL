# Admin 페이지 개발

## 📝Interceptor:  웹 애플리케이션 내에서 특정한 URI 호출을 말 그대로 가로채는 역할
- 기존 컨트롤러의 로직을 수정하지 않고도, 사전이나 사후에 제어가 가능
- 인증/인가 등과 같은 공통 작업, Controller로 넘겨주는 정보의 가공, API 호출에 대한 로깅 또는 검사 등의 역할을 함.

💻 코드 분석
1. postHandle
   - 지정된 컨트롤러의 동작 이후에 처리하며,
     Spring MVC의 Front Controller인 DispatcherServlet이 화면을 처리하기 전에 동작
   - postHandle(request, response, handler, modelAndView)

2. afterComplete(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
   - Controller 진입 후 View가 정상적으로 Rendering 된 후 수행된다.
   

## 📝Table DTO 생성 
- 주어진 클래스 정보와 엔티티 목록을 기반으로 테이블 데이터를 생성하고 관리하는 것
-TableDto 클래스는 테이블의 이름, 열(columns), 그리고 레코드(records)를 속성으로 가지고 있습니다. 따라서 이 클래스는 특정 구조의 데이터를 테이블 형태로 표현하고자 할 때 사용

💻 코드 분석
1. fun <T:Any> from(classInfo : KClass<T>, entities : List<Any>, vararg filterings : String ):TableDto 
   - 주어진 클래스 정보(classInfo), 엔티티 목록(entities), 그리고 필터링할 열 이름(filterings)을 입력으로 받아 TableDto 인스턴스를 생성
   -테이블의 이름을 클래스 이름으로, 테이블의 열 이름을 클래스의 속성 이름으로, 테이블의 레코드를 각 엔티티의 속성 값으로 설정

2.createColumns(classInfo:KClass<T>,vararg filterings : String):MutableList<String>
 - 주어진 클래스 정보와 필터링할 열 이름을 입력으로 받아 테이블의 열 이름 목록을 생성
- 클래스의 속성 이름을 열 이름으로 사용