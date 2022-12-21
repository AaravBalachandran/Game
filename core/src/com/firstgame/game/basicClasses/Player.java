package com.firstgame.game.basicClasses;

public class Player {
    private int health = 100;
    private int position = 0;
    private int fuel = 0;
    private Tank tanks = new Tank();
    private boolean isWinner ;

    private float angle;

    public float getAngle(){
        return angle;
    }
    public float setAngle(float angle){
        this.angle =angle;
        return angle;
    }

    public int getHealth() {
        return health;
    }

    public int getPosition() {
        return position;
    }

    public int getFuel() {
        return fuel;
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

}
