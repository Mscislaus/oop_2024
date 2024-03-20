import java.io.StringReader;

public class Polygon {
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }

    public String toSvg() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<polygon points=\"");
        for (Point point : points) {
            stringBuilder.append(point.x).append(",").append(point.y).append(" ");
        }
        stringBuilder.append("\" style=\"fill:none;stroke:black;stroke-width:1\"/>\n");
        return stringBuilder.toString();
    }

    public Polygon(Polygon src) {
        this.points = new Point[src.points.length];
        for(int i = 0; i < points.length; ++i) {
            points[i] = new Point(src.points[i].x, src.points[i].y);
        }
    }
}
