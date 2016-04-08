package cardgame;

import java.util.ArrayList;

/**
 * Created by mryolo on 31/03/16.
 */
public class AttackList {
    public static ArrayList<Attack> attacks = new ArrayList<>();

    public static void add(Attack a){
        attacks.add(a);
    }
    public static void remove(int i) {
        attacks.get(i).setDmg(0);
    }
    public boolean isEmpty() {
        return attacks.isEmpty();
    }
    public static void reset(){
        attacks = new ArrayList<>();
    }
}
