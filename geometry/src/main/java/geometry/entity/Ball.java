package geometry.entity;

import java.util.Objects;

public class Ball extends GeometryFigure {
    private long ballId;
    private int ballPositionX;
    private int ballPositionY;
    private int ballPositionZ;
    private int ballRadius;

    public Ball() {}

    public Ball(long ballId, int ballPositionX, int ballPositionY, int ballPositionZ, int ballRadius) {
        this.ballId = ballId;
        this.ballPositionX = ballPositionX;
        this.ballPositionY = ballPositionY;
        this.ballPositionZ = ballPositionZ;
        this.ballRadius = ballRadius;
    }

    public int getBallPositionZ() {
        return ballPositionZ;
    }

    public void setBallPositionZ(int ballPositionZ) {
        this.ballPositionZ = ballPositionZ;
    }

    public int getBallPositionX() {
        return ballPositionX;
    }

    public void setBallPositionX(int ballPositionX) {
        this.ballPositionX = ballPositionX;
    }

    public int getBallPositionY() {
        return ballPositionY;
    }

    public void setBallPositionY(int ballPositionY) {
        this.ballPositionY = ballPositionY;
    }

    public long getBallId() {
        return ballId;
    }

    public void setBallId(long ballId) {
        this.ballId = ballId;
    }

    public int getBallRadius() {
        return ballRadius;
    }

    public void setBallRadius(int ballRadius) {
        this.ballRadius = ballRadius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        if(ballPositionX != ball.getBallPositionX()){
            return false;
        }
        if(ballPositionY != ball.getBallPositionY()){
            return false;
        }
        if(ballPositionZ != ball.getBallPositionY()){
            return false;
        }
        if(ballRadius != ball.getBallRadius()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hCode = Long.hashCode(ballId);
        final int prime = 31;
        hCode = prime * hCode + Integer.hashCode(ballPositionX);
        hCode = prime * hCode + Integer.hashCode(ballPositionY);
        hCode = prime * hCode + Integer.hashCode(ballPositionZ);
        hCode = prime * hCode + Integer.hashCode(ballRadius);
        return hCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(ballId);
        builder.append(" ");
        builder.append(ballPositionX);
        builder.append(" ");
        builder.append(ballPositionY);
        builder.append(" ");
        builder.append(ballPositionZ);
        builder.append(" ");
        builder.append(ballRadius);
        builder.append(" ");
        builder.append(super.toString());
        return builder.toString();
    }
}
