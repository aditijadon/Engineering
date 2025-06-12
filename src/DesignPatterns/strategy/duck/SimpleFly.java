package DesignPatterns.strategy.duck;

public class SimpleFly implements IFlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Simple Fly!");
    }
}
