import java.lang.Math;
public class Segment {
    private Point point1, point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void lenght() {
        System.out.println(Math.sqrt(Math.pow((point2.x-point1.x),2)+Math.pow((point2.y-point1.y),2)));
    }

    public  void toSvg() {
        System.out.println();
    }
}
