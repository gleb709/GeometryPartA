package geometry.factory;

import geometry.entity.GeometryFigure;

public abstract class FigureFactory {
    public abstract GeometryFigure createFigure(int[] data);
}
