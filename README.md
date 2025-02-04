# 레벨별 구현
- 최근 구현한 레벨 이전 레벨(Lv1)은 충돌을 피하기 위하여 압축파일로 첨부 (Lv1.zip)

# 구조
- 컨트롤러 / 레포지토리 / dto / schema.sql
- dto를 통한 데이터를 전달
- src/main/resources/schema.sql 경로를 통해 테이블 생성 sql 삽입

# API 명세
| 기능 | Method | URL | response | 상태코드 |
| :-: | :-: | :-: | :-: | :-: |
| 일정 생성 | POST | http://localhost:8080/newSchedule?name={name}&password={password}&content={content}| 등록 완료 여부 | 200: 정상 조회 |
| 날짜, 이름을 이용한 검색 | GET | http://localhost:8080/search/{name}/{시작날짜}/{끝날짜}| 검색된 일정 데이터 | 200: 정상 조회 |
| id를 이용한 검색 | GET | http://localhost:8080/search/{id} | 검색된 일정 데이터 | 200: 정상 조회 |
| 일정 수정 | POST | http://localhost:8080/edit?id={id}&pw={password}&name={name}&content={할일} | 수정 완료된 일정 데이터 | 200: 정상 조회 |
| 일정 삭제 | DELETE | http://localhost:8080/delete?id={id}&pw={password} | 삭제 완료 여부 | 200: 정상 조회 |
