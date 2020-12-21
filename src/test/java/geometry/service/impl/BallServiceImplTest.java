package geometry.service.impl;

import geometry.entity.Ball;
import geometry.entity.PointOnPlane;
import geometry.singlton.Basket;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallServiceImplTest {
    private double[] ballsSurfaceAreaExpected;
    private double[] ballsSphereVolumeExpected;

    @BeforeClass
    public void setInfo(){
        Basket basket = Basket.getInstance();
        basket.addBall(new Ball(0, 100, 10, 10, 50));
        ballsSurfaceAreaExpected = new double[1];
        ballsSphereVolumeExpected = new double[1];
        ballsSurfaceAreaExpected[0] = 4 * Math.PI * Math.sqrt(50);
        ballsSphereVolumeExpected[0] = 4/3 * Math.PI * Math.pow(50,3);
    }

    @Test
    public void testCalculateBallSurfaceArea() {
        Basket basket = Basket.getInstance();
        double[] ballsSurfaceAreaActual = new double[basket.getBasketSize()];
        for(int i = 0; i < basket.getBasketSize(); i++){
            ballsSurfaceAreaActual[i] = 4 * Math.PI * Math.sqrt(basket.getBallFromBasket(i).getBallRadius());
        }
        assertEquals(ballsSurfaceAreaActual, ballsSurfaceAreaExpected);
    }

    @Test
    public void testCalculateSphereVolume() {
        Basket basket = Basket.getInstance();
        double[] ballsSphereVolumeActual = new double[basket.getBasketSize()];
        for(int i = 0; i < basket.getBasketSize(); i++){
            ballsSphereVolumeActual[i] = 4/3 * Math.PI * Math.pow(basket.getBallFromBasket(i).getBallRadius(),3);
        }
        assertEquals(ballsSphereVolumeActual[0], ballsSphereVolumeExpected[0]);
    }

    @Test
    public void testIsBallContactCoordinatePlanes() {
        Basket basket = Basket.getInstance();
        boolean[] ball = new boolean[basket.getBasketSize()];
        for(int i = 0; i < basket.getBasketSize(); i++){
            if(basket.getBallFromBasket(i).getBallRadius() >= basket.getBallFromBasket(i).getBallPositionX() ||
                    basket.getBallFromBasket(i).getBallRadius() >= basket.getBallFromBasket(i).getBallPositionY() ||
                    basket.getBallFromBasket(i).getBallRadius() >= basket.getBallFromBasket(i).getBallPositionZ()){
                ball[i] = true;
            }
        }
        assertFalse(ball[0]);
    }
}