package DesignPatterns.strategy.duck;

public class SimpleQuack implements IQuackBehaviour{
    @Override
    public void quack(){
        System.out.println("Simple Quack!");
    }
}
