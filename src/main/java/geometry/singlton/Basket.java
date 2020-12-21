package geometry.singlton;

import geometry.entity.Ball;

import java.util.ArrayList;
import java.util.List;

public class Basket{
    private static Basket INSTANCE = new Basket();
    private List<Ball> basket = new ArrayList<Ball>();

    private Basket(){}

    public static Basket getInstance(){
        return INSTANCE;
    }

    public void addBall(Ball ball){
        basket.add(ball);
    }

    public void removeBall(Ball Ball){
        basket.remove(Ball.getBallId());
    }

    public int getBasketSize(){
        return basket.size();
    }

    public Ball getBallFromBasket(int i){
        return basket.get(i);
    }
}
