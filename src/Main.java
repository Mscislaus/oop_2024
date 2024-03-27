public class Main extends Segment {
    public Main(Point begin, Point end) {
        super(begin, end);
    }

    public static void main(String[] args) {
        Point begin = new Point(1, 2);
        Point end = new Point(2, 3);
        Segment segment = new Segment(begin, end);
        System.out.println(segment.toSvg());

        Point[] pointsArray = {new Point(50, 50), new Point(50, 20), new Point(100, 20),new Point(100, 50)};
        Polygon polygon = new Polygon(pointsArray);
        System.out.println(polygon.toSvg());
        Polygon polygon2 = new Polygon(polygon);
        System.out.println(polygon2.toSvg());

        Point[] pointsArray2 = { new  Point(100, 100), new Point(100, 40) };
        Polygon p2 = new Polygon(pointsArray2);
        SvgScene scene = new SvgScene();
        scene.add(p2);
        scene.add(polygon);
        scene.save("./out.html");
    }
}