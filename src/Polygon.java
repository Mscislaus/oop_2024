import java.io.StringReader;

public class Polygon {
    private Point[] points;
    private Style style;

    public Polygon(Point[] points, Style style) {
        this.points = points;
        this.style = style;
    }

    public Polygon(Point[] points) {
        this.points = points;
        this.style = new Style("none","black", 1.0);
    }

    public String toSvg() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<polygon points=\"");
        for (Point point : points) {
            stringBuilder.append(point.x).append(",").append(point.y).append(" ");
        }
        stringBuilder.append(style.toSvg()).append("/>");
        return stringBuilder.toString();
    }

    public Polygon(Polygon src) {
        this.points = new Point[src.points.length];
        for (int i = 0; i < points.length; ++i) {
            points[i] = new Point(src.points[i].x, src.points[i].y);
        }
        style = new Style(src.style.fillColor, src.style.strokeColor, src.style.strokeWidth);
    }
}
