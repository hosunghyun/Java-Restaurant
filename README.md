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
손님의 좌석 예약 기능

```
public void reserdel() {
        int c = 0;
        System.out.print("예약하신 분의 성함을 적어주세요 : ");
        name = sc.nextLine();
        for (Menu menu : table) {
            if (menu.getName().equals(name)) {
                System.out.println("예약이 취소되었습니다.");
                menu.setName("null");
                c++;
                break;
            }
        }
        if (c == 0) {
            System.out.println("예약하신 기록이 없습니다.");
        }
```
손님의 예약 취소 기능

```
    public void go() {
        int c = 0;

        System.out.print("예약하신 분의 좌석과 성함을 적어주세요(ex 1번,김철수) : ");
        name = sc.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(name, ",");
        String[] arr = new String[tokenizer.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tokenizer.nextToken();
        }
        for (Menu menu : table) {
            if (menu.getTable().equals(arr[0]) && menu.getName().equals(arr[1])) {
                System.out.println("즐거운 하루 되세요.");
                c++;
                break;
            }
        }
        if (c == 0) {
            System.out.println("예약하신 기록이 없습니다.");
        }
```
손님의 예약 좌석 입장 기능

```
        public void save() {
            File file = new File("seat.txt");
            try {
                FileWriter writer = new FileWriter(file);
                BufferedWriter buf = new BufferedWriter(writer);
                for (Menu menu : table) {
                    buf.write(menu.getTable() + ",");
                    buf.write(menu.getName() + ",");
                    buf.newLine();
                }
                buf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
```
예약 목록 seat.txt파일에 저장하는 기능

```
    public void load(){
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buf = new BufferedReader(reader);
            String line;

            while((line = buf.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line,",");
                String table = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                add(new Menu(table,name));
            }
            buf.close();
        } catch (FileNotFoundException e) {
            System.out.println(file + " 파일을 찾을 수 없습니다.\n");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```
예약 목록이 저장된 seat.txt 파일 호출


**MenuManager.java**

```
    public void add(){
        String food,price;
        System.out.print("추가하고 싶은 음식 : ");
        food = sc.nextLine();
        System.out.print("가격 : ");
        price =sc.nextLine();
        if(menu.containsKey(food) == false) {
            menu.put(food,price);
            System.out.println("메뉴가 추가되었습니다.");
        }
    }

    public void remove(){
        String food;
        System.out.print("메뉴 삭제 : ");
        food = sc.next();
        if(menu.containsKey(food) == true) {
            menu.remove(food);
            System.out.println("[ " + food + " ] 메뉴를 삭제했습니다.\n");
        }
        else {
            System.out.println("해당 메뉴는 레스토랑에 없어 메인으로 돌아갑니다");
            return;
        }
    }
```
관리자의 메뉴 추가와 삭제 기능 구현

```
public void save(){
        File file = new File("Menu.txt");
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter buf = new BufferedWriter(writer);
            for(Map.Entry<String, String> menu : menu.entrySet()) {
                buf.write(menu.getKey() + ",");
                buf.write(menu.getValue());
                buf.newLine();
            }
            buf.close();
        } catch (IOException e) {
            System.out.println(file + " 파일에 접근 오류입니다.\n");
            e.printStackTrace();
        }
    }
    public void load(){
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buf = new BufferedReader(reader);
            String line;

            while((line = buf.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line,",");
                String[] arr = new String[tokenizer.countTokens()];
                for (int i=0;i<arr.length;i++){
                    arr[i] = tokenizer.nextToken();
                }

                menu.put(arr[0], arr[1]);
            }
            buf.close();
        } catch (FileNotFoundException e) {
            System.out.println(file + " 파일을 찾을 수 없습니다.\n");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```
관리자가 추가 삭제한 메뉴를 Menu.txt에 반영하기 위해 저장하는 기능과 저장된 메뉴를 불러오는 기능

```
    public void show(){
        int cnt=1;
        System.out.println("================[메뉴판]=================");
        Iterator<String> menus = menu.keySet().iterator();
        while(menus.hasNext()){
            String key = menus.next();
            System.out.println("[메뉴 "+cnt+"번]" + key + " [가격]" +  menu.get(key) + "원");
            cnt++;
        }
        System.out.println("========================================");
    }
```
손님에게 메뉴판을 보여주는 기능

```
    public void order(){
        String food;
        String total;
        String s;
        while(true) {
            int cnt=0;
            System.out.print("주문할 음식 : ");
            food = sc.nextLine();
            ord.add(cnt++,"음식 : "+food+" 가격 : "+menu.get(food));
            System.out.print("주문그만두기(o/x) :");

            s = sc.nextLine();
            if(s.equals("o")){break;}
        }
    }
    public void showord(){
        for (int i=0;i< ord.size();i++){
            System.out.println(ord.get(i));
        }
    }

    public void cancel(){
        String food;
        int c;
        int to=0;
        String price="";
            System.out.print(ord);
            System.out.println();
        System.out.print("취소할 음식 : ");
        food = sc.nextLine();
        for(int i=0;i< ord.size();i++) {
            StringTokenizer tokenizer = new StringTokenizer(ord.get(i)," ");
            String[] arr = new String[tokenizer.countTokens()];
            for(int j=0;j< arr.length;j++){
                arr[j] = tokenizer.nextToken();
                if(arr[j].equals(food)){
                    ord.remove(i);
                    System.out.println("음식을 취소하였습니다");
                    break;
                }

            }
        }
    }
```
손님이 메뉴를 주문하고 주문한 메뉴를 취소하는 기능 구현









