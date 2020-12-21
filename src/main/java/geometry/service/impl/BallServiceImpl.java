package geometry.service.impl;

import geometry.entity.PointOnPlane;
import geometry.service.BallService;
import geometry.singlton.Basket;

public class BallServiceImpl implements BallService {

    @Override
    public double[] calculateBallSurfaceArea() {
        Basket basket = Basket.getInstance();
        double[] ballsSurfaceArea = new double[basket.getBasketSize()];
        for(int i = 0; i < basket.getBasketSize(); i++){
            ballsSurfaceArea[i] = 4 * Math.PI * Math.sqrt(basket.getBallFromBasket(i).getBallRadius());
        }
        return ballsSurfaceArea;
    }

    @Override
    public double[] calculateSphereVolume() {
        Basket basket = Basket.getInstance();
        double[] ballsSphereVolume = new double[basket.getBasketSize()];
        for(int i = 0; i < basket.getBasketSize(); i++){
            ballsSphereVolume[i] = 4/3 * Math.PI * Math.pow(basket.getBallFromBasket(i).getBallRadius(),3);
        }
        return ballsSphereVolume;
    }

    @Override
    public double[] calculateBallVolumeRatio() {
        Basket basket = Basket.getInstance();
        final int X_MAX_SIZE = 200;
        final int Y_MAX_SIZE = 200;
        final int Z_MAX_SIZE = 200;

        PointOnPlane firstPoint = new PointOnPlane();
        PointOnPlane secondPoint = new PointOnPlane();
        firstPoint.setPointX((int)Math.random()*X_MAX_SIZE);
        firstPoint.setPointY((int)Math.random()*Y_MAX_SIZE);
        firstPoint.setPointZ((int)Math.random()*Z_MAX_SIZE);
        secondPoint.setPointX((int)Math.random()*X_MAX_SIZE);
        secondPoint.setPointY((int)Math.random()*Y_MAX_SIZE);
        secondPoint.setPointZ(firstPoint.getPointZ());

        double[] ballVolumeRatio = new double[basket.getBasketSize()];
        double firstBallPieceVolume;
        double secondBallPieceVolume;
        for(int i = 0; i < basket.getBasketSize(); i++){
            if(basket.getBallFromBasket(i).getBallPositionZ() + basket.getBallFromBasket(i).getBallRadius() > firstPoint.getPointZ() &&
                    basket.getBallFromBasket(i).getBallPositionZ() - basket.getBallFromBasket(i).getBallRadius() < firstPoint.getPointZ()){
                firstBallPieceVolume = 2/3 * Math.PI * Math.sqrt(basket.getBallFromBasket(i).getBallRadius()) *
                        (basket.getBallFromBasket(i).getBallRadius() - Math.abs(firstPoint.getPointZ() - basket.getBallFromBasket(i).getBallPositionZ()));
                secondBallPieceVolume = 4/3 * Math.PI * Math.pow(basket.getBallFromBasket(i).getBallRadius(),3) - firstBallPieceVolume;
                ballVolumeRatio[i] = secondBallPieceVolume/firstBallPieceVolume;
            }
        }
        return ballVolumeRatio;
    }

    @Override
    public boolean[] isBallContactCoordinatePlanes() {
        Basket basket = Basket.getInstance();
        boolean[] ball = new boolean[basket.getBasketSize()];
        for(int i = 0; i < basket.getBasketSize(); i++){
           if(basket.getBallFromBasket(i).getBallRadius() >= basket.getBallFromBasket(i).getBallPositionX() ||
                   basket.getBallFromBasket(i).getBallRadius() >= basket.getBallFromBasket(i).getBallPositionY() ||
                   basket.getBallFromBasket(i).getBallRadius() >= basket.getBallFromBasket(i).getBallPositionZ()){
               ball[i] = true;
           }
        }
        return ball;
    }
}
