public class SolidFieldPolygon extends Polygon {

    private  String color;
    public SolidFieldPolygon(Vec2[] vec2, String color) {
        super(vec2);
        this.color = color;
    }

    public String toSvg(String parameters) {
        return super.toSvg("\"fill:\"" + color + "\" " + parameters);
    }
}
