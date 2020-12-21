package geometry.entity;

public abstract class GeometryFigure {
    private long figureId;

    public long getBallId() {
        return figureId;
    }

    public void setBallId(long ballId) {
        this.figureId = figureId;
    }
}
