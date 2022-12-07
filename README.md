# MyBlogBackendServer
![Usecase in Miro](https://user-images.githubusercontent.com/117057843/206074412-e14f2694-c4df-42e3-8546-5227bd6d029d.jpg)
# **API 명세서**

| 기능 | method | URL | Return |
| --- | --- | --- | --- |
| 메인페이지 | GET | / | index.html |
| 게시글 작성 | POST | /api/board | Post |
| 게시글 조회 | GET | /api/board{id} | List<Post> |
| 게시글 수정 | PUT | /api/board{id} | Post |
| 게시글 삭제 | DELETE | /api/board{id} | Post |
