public class Main {

    public static void main(String[] args) {

        Point[] pointsArray = {new Point(50, 50), new Point(50, 20), new Point(100, 20), new Point(100, 50)};
        Polygon polygon = new Polygon(pointsArray);
        System.out.println(polygon.toSvg());
        Polygon copyPol = new Polygon(polygon);
        System.out.println(copyPol.toSvg());
        Style s1 = new Style("red", "yellow", 3);
        Polygon polygon2 = new Polygon(pointsArray, s1);
        System.out.println(polygon2.toSvg());

        Point[] pointsArray2 = {new Point(100, 100), new Point(100, 40), new Point(200, 40), new Point(200, 100)};
        Polygon p2 = new Polygon(pointsArray2, s1);

        Ellipse ellipse = new Ellipse(new Point(200.00, 200.0), 50.00, 50.00, new Style("red", "yellow", 3));

        SvgScene scene = new SvgScene();
        scene.add(p2);
        scene.add(ellipse);
        scene.add(polygon);

        scene.save("./out.html");
    }
}