package cardgame.cards;

import cardgame.*;

import java.util.Scanner;


/**
 * Created by Kotono on 16/03/2016.
 */
public class Deflection implements Card {

    private class DeflectionEffect extends AbstractCardEffect {

        AbstractCardEffect target;
        AbstractCardEffect target_of_target;
        public boolean played = false;

        public DeflectionEffect(Player p, Card c){
            super(p,c);
        }


        @Override
        public boolean play() {
            /*int index = 0;
            System.out.println("Possibili effetti target nello stack");
            for (Effect e : CardGame.instance.get_stack()){
                if (e instanceof AbstractCardEffect && ((AbstractCardEffect) e).hasTarget())
                    System.out.println(index+ ". " + e.toString());
                    index++;
            }
            System.out.println("inserire l'indice del target");
            Scanner in = new Scanner(System.in);
            index = in.nextInt();
            target = (AbstractCardEffect) CardGame.instance.get_stack().get(index);*/

            setTarget();

            return super.play();
        }

        @Override
        public boolean hasTarget() {
            return true;
        }


        @Override
        public void resolve() {
            //TODO carta assai cancara

            if (target.getPlayed() == true) {
                    target_of_target = target.getTarget();
                    target_of_target.setTarget();
            }





        }
    }

    @Override
    public Effect get_effect(Player owner) {
        return new DeflectionEffect(owner,this);
    }

    @Override
    public String name() {
        return "Deflection";
    }

    @Override
    public String type() {
        return "Instant";
    }

    @Override
    public String rule_text() {
        return "Change the target of target spell with a single target";
    }

    @Override
    public boolean isInstant() {
        return true;
    }
}
