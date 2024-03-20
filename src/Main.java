public class Main extends Segment {
    public Main(Point begin, Point end) {
        super(begin, end);
    }

    public static void main(String[] args) {
        Point begin = new Point(1, 2);
        Point end = new Point(2, 3);
        Segment segment = new Segment(begin, end);
        System.out.println(segment.toSvg());
    }
}