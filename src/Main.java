public class Main {

    public static void main(String[] args) {

        /*
        Vec2[] pointsArray = {new Vec2(50, 50), new Vec2(50, 20), new Vec2(100, 20), new Vec2(100, 50)};
        Polygon polygon = new Polygon(pointsArray);
        System.out.println(polygon.toSvg(""));
        Polygon copyPol = new Polygon(polygon);
        System.out.println(copyPol.toSvg(""));
        Style s1 = new Style("red", "yellow", 3);
        Polygon polygon2 = new Polygon(pointsArray, s1);
        System.out.println(polygon2.toSvg(""));

        Vec2[] pointsArray2 = {new Vec2(100, 100), new Vec2(100, 40), new Vec2(200, 40), new Vec2(200, 100)};
        Polygon p2 = new Polygon(pointsArray2, s1);

        Ellipse ellipse = new Ellipse(new Vec2(200.00, 200.0), 50.00, 50.00, new Style("red", "yellow", 3));
         */

        Shape polygon = new Polygon(new Vec2[]{
                new Vec2(500, 100),
                new Vec2(220, 20),
                new Vec2(400, 25),
                new Vec2(70, 33),
        });

        //SolidFieldPolygon polygon2 = SolidFieldPolygon;

        SvgScene scene = new SvgScene();
        /*
        scene.add(p2);
        scene.add(ellipse);
         */
        scene.add(polygon);

        scene.save("./out.html");
    }
}