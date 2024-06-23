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

보고서 **레스토랑.docx**에 구현결과가 존재하므로 구현 결과를 보실 분은 해당 파일 참조  

**Restaurant.java**
---
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

```
while (cnt != -1) {
            int c = 0;
            int b=0;
            System.out.println("============================");
            System.out.println("Korea Traditional Restaurant");
            System.out.println("        1. 관리자");
            System.out.println("        2. 손님");
            System.out.println("        0. 종료");
            System.out.println("============================");
            System.out.print("선택하기 : ");
            c = sc.nextInt();
```
이후 기능을 위해 사용자의 정보를 받기

```
switch (c){
                case 1->{
                    while(true) {
                        System.out.println("===========");
                        System.out.println(" 1.메뉴 추가");
                        System.out.println(" 2.메뉴 삭제");
                        System.out.println(" 3.메뉴리스트");
                        System.out.println(" 0.종료");
                        System.out.println("===========");
                        System.out.print("선택하기 : ");
                        b = sc.nextInt();
                        if(b==1){manager.add();}
                        else if(b==2){manager.remove();}
                        else if(b==3){manager.list();}
                        else if(b==0){break;}
                        else{System.out.println("0~4의 숫자만 입력해주세요.");}
                    }
                }
```
관리자의 경우 메뉴판의 관리 기능 출력

```
                case 2-> {
                    while (true) {


                        System.out.println("=============");
                        System.out.println(" 1.자리목록");
                        System.out.println(" 2.자리예약");
                        System.out.println(" 3.예약취소");
                        System.out.println(" 4.자리앉기");
                        System.out.println(" 0.종료");
                        System.out.println("=============");
                        System.out.print("선택하기 : ");
                        b = sc.nextInt();

                        if (b == 1) {
                            seat.show();
                        } else if (b == 2) {
                            seat.reser();
                        } else if (b == 3) {
                            seat.reserdel();
                        } else if (b == 4) {
                            seat.go();
                            cnt = 1;
                        } else if (b == 0) {
                            cnt = 2;
                            break;
                        } else {
                            System.out.println("0~4의 숫자만 입력해주세요.");
                        }
                        if (cnt == 1) {
                            break;
                        }
                    }
                    if(cnt == 2){break;}
                        while (true) {
                            manager.show();
                            System.out.println("=============");
                            System.out.println(" 1.주문하기");
                            System.out.println(" 2.주문취소하기");
                            System.out.println(" 3.주문리스트");
                            System.out.println(" 0.종료");
                            System.out.println("=============");
                            System.out.print("선택하기 : ");
                            b = sc.nextInt();
                            if (b == 1) {
                                manager.order();
                            } else if (b == 2) {
                                manager.cancel();
                            } else if (b == 0) {
                                break;
                            } else if (b == 3) {
                                manager.showord();
                            } else {
                                System.out.println("0~2의 숫자만 입력해주세요.");
                            }
                        }

                }
```
손님의 경우 앉을 자리 선택 기능과 메뉴 주문 기능 출력

```
case 0->{
                    cnt = -1;
                    manager.save();
                    seat.save();
                }
                default -> System.out.println("0~2의 숫자만 입력해주세요.");
            }
```
프로그램 종료 기능


**Table.java**  



```
    public void reser() {

        int c = 0;
        System.out.print("예약하실 좌석을 적어주세요(1번,2번) : ");
        st = sc.nextLine();
        for (Menu menu : table) {
            if (menu.getTable().equals(st) && menu.getName().equals("null")) {
                System.out.print("예약자의 성함을 적어주세요 : ");
                name = sc.nextLine();
                menu.setName(name);
                System.out.println("예약되었습니다.");
                c++;
                break;
            }
        }
        if (c == 0) {
            System.out.println("좌석에 사람이 있습니다.");
        }
    }
```





















