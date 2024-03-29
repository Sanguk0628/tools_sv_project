###  tools_sv_project _ 툴스 개인프로젝트
###  21102076 박상욱

## 1. 프로젝트 제목
#### VS 계산기 

## 2. 개발 동기
> 1학년 미시경제 교양 과목을 들었는데, 그때 기회비용을 배우면서 합리적인 선택을 위한 툴에 대해서 많은 고민을 했다. 실제로 편익과 비용을 전부 고려해서 여러 선택지 중 하나를 선택을 해야 하는 상황에서, 이런 것을 비교할 수 있는 계산기 같은 게 있으면 좋겠다고 생각했다.

> 칼로리 계산기처럼 이런 기회비용 계산기가 시중에 있나 확인해봤는데 생각했던 것은 없었다. 그래서 이 프로젝트를 통해 자바 복습은 물론 아이디어를 구현해보면 좋겠다는 막연한 생각으로 이 프로젝트를 하게 되었다.

## 3. 프로젝트 개요
#### 실생활에서 기회비용을 계산 및 비교할 수 있는 계산기 앱 제작

## 4. 개발 과정 
### 4-1. 개발환경
* IDE: Android Studio
* Language: JAVA

### 4-2. 사용법
* 추가 버튼을 눌러서 선택지들별로 세부 항목과 **사용자가 생각하는 가치**를 입력한다.
![ㄱ](https://user-images.githubusercontent.com/107661799/188784325-7de50344-ead1-4a4f-8dea-8f23457065a5.png)
![ㄴ](https://user-images.githubusercontent.com/107661799/188784338-0d0572b4-be33-4dbd-b323-c082dc86331d.png)

* 항목별로 터치하여 수정 및 삭제를 할 수 있다.
![ㄹ](https://user-images.githubusercontent.com/107661799/188784402-73b800e1-047d-4ed7-a26d-fc3ded12cbfe.png)

* 좌우로 각각의 선택지들의 순편익 결과를 보고 비교한다.
![ㅁ](https://user-images.githubusercontent.com/107661799/188784423-1cf8fb94-94da-4a28-aaff-a6f9f934ac36.png)

### 4-3. 메인 기능
* 사용자가 비교하려는 대상들의 편익, 명시적 비용, 암묵적 비용을 Add로 입력받아 DB에 저장
![1](https://user-images.githubusercontent.com/107661799/188818936-8cdda6fb-f1c5-4171-8cbe-183a77c9979e.png)
![2](https://user-images.githubusercontent.com/107661799/188819026-12ff6f6d-f4e0-4dcf-807d-bff5c818141b.png)

* 그리고 데이터를 받아와 RecyclerView에 반영
![3](https://user-images.githubusercontent.com/107661799/188819034-4d643add-e830-4528-8682-20653d1c7037.png)

* 항목별로 수정 및 삭제, 전체 삭제 가능
![4](https://user-images.githubusercontent.com/107661799/188819560-6db52751-e7da-4939-88f1-bfb0fa5e3990.png)

* DB 쿼리문을 호출하여 DB에서 기회비용 계산 및 메인화면으로 비교 결과 불러오기
![5](https://user-images.githubusercontent.com/107661799/188819573-2696268c-bf1b-41e1-b94f-e09513d7a4e9.png)

## 5. 개발 과정
[7월 1주차 ~ 8월 4주차 ,2022]
* 1~3주차: 자바 복습 및 안드로이드 전체 기능 공부
* 4~6주차: 학습한 내용을 바탕으로 기본적인 구조 및 디자인 구현
* 7~8주차: RecyclerView, SQLite Database 등 기능 구현

## 6. 배운 점 및 아쉬운 점
* 머리에서 생각한 것을 화면에서 전부 다 구현할 수 있을 것 같았는데, 각 기능마다 또 기능을 연결할 때마다 삽질을 너무 많이 해서 엄청 기본적인 것만 구현할 수 밖에 없었다. 여기에는 이렇게 하면 되고 저렇게 하면 되겠지 입과 눈으로 코딩했는데, 다시 한번 코딩은 손으로 한다는 것을 뼈로 배웠다.

<img width="737" alt="sket" src="https://user-images.githubusercontent.com/107661799/188700817-63be9a89-5b17-49d8-b82d-1c27a25f63a2.png">

* 시나리오를 여러 개 세워놓고 시도해보면서 화면과 기능을 맞췄는데, 한 시나리오가 안되면 전부 다 갈아엎어서 엄청나게 돌아갔다. 아무리 갈아엎더라도 다시 쓸 만한 기능이라면 잘 정리해놔야 했는데 그러지 못했다. 그러면서 자연스럽게 버전관리의 필요성과 깃을 제대로 배워놔야겠다고 다짐했다.

![333333333333333](https://user-images.githubusercontent.com/107661799/188700938-e326f981-68b5-4303-bc92-6c174eaa3939.png)

* 기본 쿼리문은 알고는 있었는데 안드로이드에서 Select Sum을 조건별로 구하는 것이 잘 안돼서 며칠을 버렸다. 혼자 끙끙만 대고 있다가 파파고를 돌려서 Stack Overflow에서 질문하고 해결했다. 깔끔한 질문을 만드는 습관, 질문하는 습관 그리고 무엇보다 영어를 쓰려는 습관이 필요하다는 것을 깨달았다.

## 7. 개선할 점
* 초기 화면에 도움말? 같은 항목을 두어 처음 기회비용을 접하는 사용자에게 충분히 이해시킬 것.
![제목 없음dddddddddddddddddddddd](https://user-images.githubusercontent.com/107661799/188814693-f3e89520-1a7e-4e17-ab0e-ce467d5f54b5.png)

* 선택지가 2개가 아니라 더 많은 선택지끼리 비교해야할 수도 있는데 초기 화면에 아예 선택지 개수를 받아서 프래그먼트를 나눠서 입력을 받고 마지막에 비교하는 식으로 할 것.

![제목 없음xzdzfz](https://user-images.githubusercontent.com/107661799/188814683-c1702441-acea-41b5-a0f8-6ab911a786b8.png)

* 뷰홀더를 두 개를 두어 왼쪽 오른쪽 대화하듯이 두 개의 선택지를 직관적으로 볼 수 있게할 것.

* 더하여 값을 그냥 비교하는 것이 아니라 저울 같은 것을 이용해서 시각적으로 판단이 쉽게 개선할 것.
* 전체적으로 직관적으로 디자인의 개선이 필요.

## 8. 참고자료
* https://youtube.com/playlist?list=PLuHgQVnccGMAIluRRVsC1e79ri-dwnBmR
* https://youtube.com/playlist?list=PLkiWrI-TY1CfkYWj9pvWOn26dP2PTkKNO
* https://www.youtube.com/playlist?list=PLC51MBz7PMyyyR2l4gGBMFMMUfYmBkZxm
* https://youtube.com/playlist?list=PL6vI-R26dX2UP1cXttu3p9OImQ3SGemBY

