# MyBlogBackendServer 기초 개인 과제
![Usecase in Miro](https://user-images.githubusercontent.com/117057843/206074412-e14f2694-c4df-42e3-8546-5227bd6d029d.jpg)
# **API 명세서**

| 기능 | method | URL | Return |
| --- | --- | --- | --- |
| 게시글 작성 | POST | /api/board | Post |
| 게시글 조회 | GET | /api/board{id} | List<Post> |
| 게시글 수정 | PUT | /api/board{id} | Post |
| 게시글 삭제 | DELETE | /api/board{id} | Post |

답안 예시: https://www.notion.so/Spring-edd2732a352e4f78a2b237cc75af6826

---
# MyBlogBackendServer 숙련 개인 과제 LV1
| 기능 | method | URL | Request Header | Request | Response | Response Header |
| --- | --- | --- | --- | --- | --- | --- |
| 회원가입 | POST | /api/user/signup | - | { "username": "username", "password": "password" } | { "msg": "회원가입 완료", "statusCode": 200 } | - |
| 로그인 | POST | /api/user/login | - | { "username": "username", "password": "password" } | { "msg": "로그인 완료", "statusCode": 200 } | Authorization: Token |
| 게시글 작성 | POST | /api/post | Authorization: Token | { "title": "제목", "content": "내용" } | { "msg": "게시글 작성 완료", "statusCode": 200 } | - |
| 전체 게시글 조회 | GET | /api/posts | Authorization: Token  | List<{ "id": 1, "title": "제목", "content": "내용", "username": "username", "createdAt": "2022-12-01", "modifiedAt": "2022-12-02" }> | - |
| 게시글 조회 | GET | /api/post{id} |  | { "id": 1, "title": "제목", "content": "내용", "username": "username", "createdAt": "2022-12-01", "modifiedAt": "2022-12-02" } | - |
| 게시글 수정 | PUT | /api/post{id} | Authorization: Token | { "title": "title ", "content": "content 수정" } | { "msg": "게시글 수정 완료", "statusCode": 200 } | - |
| 게시글 삭제 | DELETE | /api/board{id} | Authorization: Token | - | { "msg": "게시글 삭제 완료", "statusCode": 200 } | - |

---
# MyBlogBackendServer 숙련 개인 과제 LV2
| 기능 | method | URL | Request Header | Request | Response | Response Header |
| --- | --- | --- | --- | --- | --- | --- |
| 회원가입 | POST | /api/user/signup | - | { "username": "username", "password": "password" } | { "msg": "회원가입 완료", "statusCode": 200 } | - |
| 로그인 | POST | /api/user/login | - | { "username": "username", "password": "password" } | { "msg": "로그인 완료", "statusCode": 200 } | Authorization: Token |
| 게시글 작성 | POST | /api/post | Authorization: Token | { "title": "제목", "content": "내용" } | { "msg": "게시글 작성 완료", "statusCode": 200 } | - |
| 전체 게시글 조회 | GET | /api/posts | Authorization: Token  | List<{ "id": 1, "title": "제목", "content": "내용", "username": "username", "createdAt": "2022-12-01", "modifiedAt": "2022-12-02" }> | - |
| 게시글 조회 | GET | /api/post{id} |  | { "id": 1, "title": "제목", "content": "내용", "username": "username", "createdAt": "2022-12-01", "modifiedAt": "2022-12-02" } | - |
| 게시글 수정 | PUT | /api/post{id} | Authorization: Token | { "title": "title ", "content": "content 수정" } | { "msg": "게시글 수정 완료", "statusCode": 200 } | - |
| 게시글 삭제 | DELETE | /api/board{id} | Authorization: Token | - | { "msg": "게시글 삭제 완료", "statusCode": 200 } | - |
