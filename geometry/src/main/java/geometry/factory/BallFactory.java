package geometry.factory;

import geometry.entity.Ball;
import geometry.singlton.Basket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallFactory extends FigureFactory{
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Ball createFigure(int[]ballData){
        Basket basket = Basket.getInstance();
        int ballId = basket.getBasketSize();
        Ball ball = new Ball();
        ball.setBallId(ballData[ballId]);
        ball.setBallPositionX(ballData[0]);
        ball.setBallPositionY(ballData[1]);
        ball.setBallPositionY(ballData[2]);
        ball.setBallRadius(ballData[3]);
        logger.info("Ball id: {} created. Data: {}", ballId, ball.toString());
        return ball;
    }


}
