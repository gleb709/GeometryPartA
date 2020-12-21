package geometry.service;

public interface BallService {
    double[] calculateBallSurfaceArea();
    double[] calculateSphereVolume();
    double[] calculateBallVolumeRatio();
    boolean[] isBallContactCoordinatePlanes();
}
