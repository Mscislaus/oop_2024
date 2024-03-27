import java.lang.Math;
public class Segment {
    private Point begin;
    private Point end;

    public Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public void length() {
        System.out.println(Math.sqrt(Math.pow((end.x - begin.x), 2) + Math.pow((end.y - begin.y), 2)));
    }


    public String toSvg() {
        return "<line x1='" + begin.x + "' y1='" + begin.y + "' x2='" + end.x + "' y2='" + end.y + "' stroke=\"black\"/>";
    }


    public static Segment[] perpendicularSegments(Segment segment, Point point) {
        double dx = (segment.end.x - segment.begin.x);
        double dy = (segment.end.y - segment.begin.y);

        double perpDx1 = -dy;
        double perpDy1 = dx;

        double perpDx2 = dy;
        double perpDy2 = -dx;

        Point endPoint1 = new Point(point.x + perpDx1, point.y + perpDy1);
        Point endPoint2 = new Point(point.x + perpDx2, point.y + perpDy2);

        Segment segment1 = new Segment(point, endPoint1);
        Segment segment2 = new Segment(point, endPoint2);

        return new Segment[]{segment1, segment2};
    }

    public static Segment[] perpendicularSegments(Segment segment) {
        double half = segment.returnLenght() / 2;
        double px = (segment.end.x - segment.begin.x) / 2;
        double py = (segment.end.y - segment.begin.y) / 2;
        double dx = (segment.end.x - segment.begin.x);
        double dy = (segment.end.y - segment.begin.y);
        Point center = new Point(px, py);
    }
}
