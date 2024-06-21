public class Menu {
    private String table,name;

    public Menu(String table, String name) {
        this.table = table;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return '['+
                "좌석='" + table + '\'' +
                ", 예약자='" + name + '\'' +
                ']';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

}
