import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Vec2[] pointsArray = {
                new Vec2(50, 50), new Vec2(50, 20),
                new Vec2(100, 20), new Vec2(100, 50)
        };
        Style style = new Style("purple", "blue", 2.0);

        //Ellipse ellipse = new Ellipse(style, new Vec2(200, 150), new Vec2(60, 35));
        Polygon polygon = new Polygon(pointsArray);

        SolidFillShapeDecorator solidFillShapeDecorator = new SolidFillShapeDecorator(polygon, "red");
        //SolidFillShapeDecorator solidFillShapeDecorator1 = new SolidFillShapeDecorator(ellipse, "blue");

        SvgScene svgScene = new SvgScene();
        svgScene.add(solidFillShapeDecorator);
        //svgScene.add(solidFillShapeDecorator1);
        svgScene.save("./test.html");
    }
}