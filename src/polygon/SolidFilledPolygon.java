package polygon;

public class SolidFilledPolygon extends Polygon {
    private String color;

    public SolidFilledPolygon(Vec2[] vec2, String color) {
        super(vec2);
        this.color = color;
    }

    public String toSvg(String parameters) {
        return super.toSvg(String.format("fill=\"" + color + "\" " + parameters));
    }
}
