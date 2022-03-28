package Creatures;
import HugLife.*;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static HugLife.HugLifeUtils.randomEntry;
public class Plip extends Creature {
    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;
    /**
     * creates plip with energy equal to E.
     */

    public Plip() {
        this(1);
    }
    public Plip(double e) {
        super("plip");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    public String name(){
        return super.name();
    }


    @Override
    public void move() {
        energy -= 0.15;
        if(energy < 0){
            energy = 0;
        }
    }

    @Override
    public void attack(Creature c) {

    }

    @Override
    public Creature replicate() {
        this.energy = 0.5*energy;
        double babyEnergy = 0.5*energy;
        return new Plip(babyEnergy);
    }

    @Override
    public void stay() {
        energy += 0.2;
        if(energy > 2){
            energy = 2;
        }

    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyNeighbors = new ArrayDeque<Direction>();
        boolean anyClorus = false;
        double moveProbability = 0.5;
        for(Direction key : neighbors.keySet()){
            if(neighbors.get(key).name().equals("empty")){
               emptyNeighbors.add(key);
            }else if(neighbors.get(key).name().equals("clorus")){
                anyClorus = true;
            }
        }
        if(emptyNeighbors.size() == 0){
            return new Action(Action.ActionType.STAY);
        }else if(energy >= 1){
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        }else if(anyClorus == true && Math.random() > moveProbability){
            return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
        }else{
            return new Action(Action.ActionType.STAY);
        }
    }

    @Override
    public Color color() {
        r = 99;
        b = 76;
        g = (int)(96*energy+63);
        return color(r,g,b);
    }


}
