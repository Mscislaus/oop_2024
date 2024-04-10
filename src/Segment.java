import java.util.Locale;

public class Segment {
    private final Vec2  first, second;

    Segment(Vec2 first, Vec2 second) {
        this.first = first;
        this.second = second;
    }

    public double returnLength() {
        return Math.sqrt(Math.pow((second.x - first.x) + (second.y) - first.y, 2));
    }

    public String toSvg() {
        //return "<line x1 ='" +first.x  +"' y1 = '" + first.y+ "' x2 = '" + second.x+ "' y2= '"+ second.y +"stroke=\"black\"/>";
        return String.format(Locale.ENGLISH, "<line x1 = '%f' y1 = '%f' x2 = '%f' y2 = '%f' stroke = 'black'/>", first.x, first.y, second.x, second.y);
    }

    public static Segment[] perpendicularSegments(Segment segment, Vec2 point) {
        double dX = segment.second.x - segment.first.x;
        double dY = segment.second.y - segment.first.y;

        double perpDx1 = -dY;
        double perpDy1 = dX;

        double perpDx2 = dY;
        double perpDy2 = -dX;

        Vec2 endPoint = new Vec2(point.x + perpDx1, point.y + perpDy1);
        Vec2 endPoint2 = new Vec2(point.x + perpDx2, point.y + perpDy2);

        Segment segment1 = new Segment(point, endPoint);
        Segment segment2 = new Segment(point, endPoint2);

        return new Segment[]{segment1, segment2};
    }
    public static Segment[] perpendicularSegments(Segment segment) {
        double half = segment.returnLength() / 2;
        double px = (segment.second.x + segment.first.x) / 2;
        double py = (segment.second.y + segment.first.y) / 2;
        double dX = segment.second.x - segment.first.x;
        double dY = segment.second.y - segment.first.y;
        Vec2 center = new Vec2(px, py);
        double newDX = dX / segment.returnLength();
        double newDY = dY / segment.returnLength();

        double perpDx1 = -newDY;
        double perpDy1 = newDX;
        double perpDx2 = newDY;
        double perpDy2 = -newDX;

        double perpDX1 = half * (-newDY);
        double perpDY1 =  half * newDX;
        double perpDX2 = half * newDY;
        double perpDY2 = -newDX * half;

        Vec2 endPoint = new Vec2(center.x + perpDx1, center.y + perpDy1);
        Vec2 endPoint2 = new Vec2(center.x + perpDx2, center.y + perpDy2);

        Segment segment1 = new Segment(center, endPoint);
        Segment segment2 = new Segment(center, endPoint2);


        return new Segment[]{segment1,segment2};
    }

}
