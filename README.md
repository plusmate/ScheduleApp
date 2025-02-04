| 기능 | Method | URL | response | 상태코드 |
| :-: | :-: | :-: | :-: | :-: |
| 일정 생성 | POST | http://localhost:8080/newSchedule?name={name}&password={password}&content={content}| 등록 완료 여부 | 200: 정상 조회 |
| 날짜, 이름을 이용한 검색 | GET | http://localhost:8080/search/{name}/{시작 날짜}/{끝 날짜}| 검색된 일정 데이터 | 200: 정상 조회 |
| id를 이용한 검색 | GET | http://localhost:8080/search/2 | 검색된 일정 데이터 | 200: 정상 조회 |
| 일정 수정 | POST | http://localhost:8080/edit?id={id}&pw={password}&name={name}&content={할일} | 수정 완료된 일정 데이터 | 200: 정상 조회 |
| 일정 삭제 | DELETE | http://localhost:8080/delete?id={id}&pw={password} | 삭제 완료 여부 | 200: 정상 조회 |
