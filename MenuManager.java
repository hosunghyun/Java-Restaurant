import java.io.*;
import java.util.*;

public class MenuManager {
    private HashMap<String, String> menu = new HashMap<String, String>();
    private String file;
    private Scanner sc = new Scanner(System.in);
    public MenuManager(String name) { file = name;}
    private ArrayList<String> ord = new ArrayList<>();
    //관리자부분
    // 메뉴추가
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
    //메뉴 삭제
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
    //메뉴 리스트로 뽑기
    public void list(){
        System.out.println(menu);
    }

    //손님용 구문
    //주문하기
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
    //주문 취소하기
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
    //메뉴판 보여주기
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

    //파일처리구간
    //저장하기
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
    //불러오기
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
}
