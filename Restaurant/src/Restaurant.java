import java.util.Scanner;

public class Restaurant{
    public static void main(String[] args){
        MenuManager manager = new MenuManager("Menu.txt");
        Table seat = new Table("seat.txt");
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        //좌석 생성하기
        seat.load();

        manager.load();
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
                case 0->{
                    cnt = -1;
                    manager.save();
                    seat.save();
                }
                default -> System.out.println("0~2의 숫자만 입력해주세요.");
            }
        }
    }
}
