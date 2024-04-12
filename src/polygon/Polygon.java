package polygon;

public class Polygon implements Shape {
    private Vec2[] vec2;
    private Style style;
    public Polygon(Vec2[] vec2, Style style) {
        this.style = style;
        this.vec2 = vec2;
    }
    public Polygon(Vec2[] points) {
        this.style = new Style("none","black", 1.0);
        this.vec2 = points;

    }
    public String toSvg(String parameters) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<polygon points=\"");
        for (Vec2 vec2 : vec2) {
            stringBuilder.append(vec2.x).append(",").append(vec2.y).append(" ");
        }
        stringBuilder.append("\" ").append(parameters).append("/>");
        return stringBuilder.toString();
    }
    public Polygon(Polygon src) {
        this.style = new Style(src.style.fillColor, src.style.strokeColor, src.style.strokeWidth);
        this.vec2 = new Vec2[src.vec2.length];
        for (int i = 0; i < vec2.length; ++i) {
            vec2[i] = new Vec2(src.vec2[i].x, src.vec2[i].y);
        }
    }

    public static Polygon square(Segment segment, Style style) {
        Vec2 pointH = new Vec2(((segment.getStartPoint().x+segment.getEndPoint().x)/2),((segment.getStartPoint().y+segment.getEndPoint().y)/2));
        Segment segmentH = new Segment(segment.getStartPoint(),pointH);
        Segment[] secR = Segment.perpendicularSegments(segmentH,pointH);
        Vec2[] pointsTab = {segment.getStartPoint(),secR[0].getEndPoint(),segment.getEndPoint(),secR[1].getEndPoint()};
        return new Polygon(pointsTab,style);
    }
}
