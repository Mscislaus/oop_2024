import java.io.StringReader;

public class Polygon {
    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }

    public String toSvg() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<polygon points=\"");
        for(Point point : points) {
            stringBuilder.append(point.x).append(",").append(point.y).append(" ");
        }
        return "<line x1='" + begin.x + "' y1='" + begin.y + "' x2='" + end.x + "' y2='" + end.y + "' stroke=\"black\"/>";return
    }
}
