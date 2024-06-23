# 자바프로그래밍 : 레스토랑
## 개요
-JAVA를 활용한 레스토랑 프로그램

일정
- 2021-05-03 ~ 2021-06-22

참여자
- 개인 프로젝트(100%)

## 사용 기술 및 개발환경
- OS : Windows 10
- Language : JAVA
- Tool : IntelliJ IDEA

## 내용

구현 결과는 

**Restaurant.java** 일부 코드
```
MenuManager manager = new MenuManager("Menu.txt");
Table seat = new Table("seat.txt");
Scanner sc = new Scanner(System.in);
int cnt = 0;

//좌석 생성하기
seat.load();

manager.load();
```

레스토랑의 메뉴와 좌석 정보를 .txt에서 호출

