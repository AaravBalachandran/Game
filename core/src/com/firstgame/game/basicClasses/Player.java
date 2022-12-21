package com.firstgame.game.basicClasses;
import com.badlogic.gdx.math.MathUtils;
import com.firstgame.game.sprites.Tank;

import java.lang.Math;

public class Player {
    private int health = 100;
    private int position = 0;
    private int fuel = 100;
    private Tank tanks;
    private boolean isWinner ;

    private float angle;

    private int power;

    public float getAngle(){
        return angle;
    }
    public void setAngle(float angle){this.angle =angle;}

    public int getHealth() {
        return health;
    }

    public int getPosition() {
        return position;
    }

    public int getFuel() {
        return fuel;
    }

    public void refuel(){
        fuel = 100;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public Tank getTanks() {
        return tanks;
    }

    public void setTanks(Tank tanks) {
        this.tanks = tanks;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public int getPower() {return power;}

    public void setPower(int power) {
        this.power = power;
    }

    public float getDottedLine(float x){
        return (float)((Math.tan(Math.toDegrees(this.angle))*x) + 350);
    }
}
