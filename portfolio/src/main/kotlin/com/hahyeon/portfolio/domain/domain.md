# 도메인 영역

## 📝Entity : 실제 DB의 테이블과 매칭될 클래스
- JPA를 사용할 경우, 이 Entity 클래스의 수정을 통해 DB 데이터에 작업한다.


💻 코드 분석
1. @Entity 
   - 테이블과 링크될 클래스
2. @Id
   - 해당 테이블의 Primary Key
3. @GeneratedValue
   - PK의 생성 규칙 표시
   - GenerationType.IDENTITY의 의미는 auto_increment하도록 관리
4. @Column
   - 테이블의 칼럼임을 표시
   - 필수는 아니지만 변수명과 매핑하기 위해 사용
5. @ManyToOne, @OneToMany
   - mapping 관계를 위해 사용
   - **name** 속성 : 대상 엔티티와 “매핑할 외래 키(자기 필드명)” 이름을 지정   
   ex) @OneToMany(targetEntity = ProjectDetail::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
     @JoinColumn(name = "project_id")
     var details : MutableList<ProjectDetail> = mutableListOf()   
   --> ProjectDetail의 테이블에 **project table을 참조할 project_id라는 이름의 외래 키 칼럼**을 생성해라.
## 📝Repository : DB Layer 접근자 

- 인터페이스를 생성 후 JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성
- *@Query("select e from Experience e left join fetch e.details where e.isActive = :isActive")**
  --> 이 어노테이션을 쓰면 db 조회할 때 성능 개선할 수 있다. 한 번에 여러 쿼리 실행 가능!
 
💻 코드 분석
1. save(entity) : entity 저장
2. delete(key): entity 삭제
3. findAll() : 모든 엔티티 반환