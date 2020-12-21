package geometry.factory;

import geometry.entity.Ball;
import geometry.singlton.Basket;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BallFactoryTest {
    private Ball ballExpected;
    int[] ballData;

    @BeforeMethod
    public void setInfo(){
        ballExpected = new Ball(0, 10, 10, 10, 5);
        int[] data = {10, 10, 10, 5};
        ballData = data;
    }

    @Test
    public void testCreateFigure() {
        Basket basket = Basket.getInstance();
        int ballId = basket.getBasketSize();
        Ball ballActual = new Ball(ballId, ballData[0], ballData[1], ballData[2], ballData[3]);
        assertEquals(ballActual, ballExpected);
    }

    @AfterMethod
    public void deleteInfo(){
        ballData = null;
        ballExpected = null;
    }
}