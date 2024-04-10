import java.util.Locale;

public class Ellipse implements Shape {
    Vec2 center;
    double radiusX;
    double radiusY;
    Style style;

    public Ellipse(Vec2 center, double radiusX, double radiusY, Style style) {
        this.style = style;
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Ellipse(Vec2 center, double radiusX, double radiusY) {
        this.style = new Style("none", "black", 1.0);
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public String toSvg(String parameters) {
        return String.format(
                Locale.ENGLISH,
                "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" %s/>",
                this.center.x,
                this.center.y,
                this.radiusX,
                this.radiusY,
                this.style.toSvg());
    }
}
