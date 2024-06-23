import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Table {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Menu> table;
    private String file;
    private String name;
    private String st;
    public Table(String file) {
        this.file = file;
        table = new ArrayList<>();
    }

    public void show() {
        for (int i = 0; i < table.size(); i++) {
            System.out.println(table.get(i));
        }
    }

    public void add(Menu menu) {
        table.add(menu);
    }

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
    }

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
    }

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
}