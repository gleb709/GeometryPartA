package geometry.entity;

import java.util.Objects;

public class  PointOnPlane {
    private int pointX;
    private int pointY;
    private int pointZ;

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public int getPointZ() {
        return pointZ;
    }

    public void setPointZ(int pointZ) {
        this.pointZ = pointZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOnPlane point = (PointOnPlane) o;
        if(pointX != point.pointX || pointY != point.pointY || pointZ != point.pointZ){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hCode = Integer.hashCode(pointX);
        final int prime = 31;
        hCode = prime * hCode + Integer.hashCode(pointY);
        hCode = prime * hCode + Integer.hashCode(pointZ);
        return hCode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pointX + " ");
        stringBuilder.append(pointY + " ");
        stringBuilder.append(pointZ);
        return stringBuilder.toString();
    }
}
