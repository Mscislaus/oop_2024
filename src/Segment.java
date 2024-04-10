import java.lang.Math;
public class Segment {

    private Vec2 startPoint;
    private Vec2 endPoint;

    public Segment(Vec2 startPoint, Vec2 endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Vec2 getStartPoint() {
        return startPoint;
    }

    public Vec2 getEndPoint() {
        return endPoint;
    }

    public double length() {
        return Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2) + Math.pow(endPoint.y - startPoint.y, 2));

    }

    public String toSvg() {
        return "<line x1=\"" + startPoint.x + "\" y1=\"" + startPoint.y + "\" x2=\"" + endPoint.x + "\" y2=\"" + endPoint.y + "\" stroke=\"black\" />";
    }

    public static Segment[] perpendicularSegments(Segment segment, Vec2 point){
        double dx = segment.endPoint.x - segment.startPoint.x;
        double dy = segment.endPoint.y - segment.startPoint.y;

        Segment[] s_tab = new Segment[2];

        Vec2 p1 = new Vec2(point.x-dy,point.y+dx);
        s_tab[0] = new Segment(point,p1);

        Vec2 p2 = new Vec2(point.x+dy,point.y-dx);
        s_tab[1] = new Segment(point,p2);

        return s_tab;
    }
}