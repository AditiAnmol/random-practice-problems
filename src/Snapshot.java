import java.util.ArrayList;

public class Snapshot {
    private ArrayList<Integer> data;

    public Snapshot(ArrayList<Integer> data) {
        this.data = data;
    }

    public ArrayList<Integer> restore() {
        return this.data;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        Snapshot snap = new Snapshot(new ArrayList(list));
        list.set(0, 3);
        ArrayList<Integer> listNew = snap.restore();
        System.out.println(listNew); //It should log "[1,2]"
        list.add(4);
        list = snap.restore();
        System.out.println(list); //It should log "[1,2]"
    }
}