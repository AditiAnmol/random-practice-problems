import java.util.LinkedList;
import java.util.Queue;

public class Veterinarian {
    //DS define
    Queue<String> petQueue = new LinkedList<>();

    public void accept(String petName) {
        if(petName.length() > 0){

        }
        this.petQueue.add(petName);
    }

    public String heal() {
        if(petQueue.isEmpty()){
            return null;
        }
        return petQueue.remove();
    }

    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        System.out.println(veterinarian.heal());
        System.out.println(veterinarian.heal());
    }
}