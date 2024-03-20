public class Polygon {
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }

    public String toSvg() {
        return "<line x1='" + begin.x + "' y1='" + begin.y + "' x2='" + end.x + "' y2='" + end.y + "' stroke=\"black\"/>";return
    }
}
