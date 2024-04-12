package polygon;

public class StrokeShapeDecorator extends ShapeDecorator {
    private String color;
    private double width;

    public StrokeShapeDecorator(Shape decoratedShape, String color, double width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }

    public String toSvg(String parameters) {
        String strokeString = String.format("stroke='%s' stroke-width='%f' ", color, width);
        return decoratedShape.toSvg(strokeString + parameters);
    }
}