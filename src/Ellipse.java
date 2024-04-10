public class Ellipse implements Shape {
    Vec2 center;
    Vec2 radius;
    double radiusx;
    double radiusy;
    Style style;

    public Ellipse(Style style, Vec2 center, double radius) {
        this.style = style;
        this.center = center;
        this.radiusx = radius;
        this.radiusy = radiusx;
    }

    public Ellipse(Style style, Vec2 center, double radiusx, double radiusy) {
        this.style = style;
        this.center = center;
        this.radiusx = radiusx;
        this.radiusy = radiusy;
    }

    public Ellipse(Style style, Vec2 center, Vec2 radius) {
        this.style = style;
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String toSvg(String parameters) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ellipse");
        stringBuilder.append(" cx=\"").append(center.x).append("\"");
        stringBuilder.append(" cy=\"").append(center.y).append("\"");
        stringBuilder.append(" rx=\"").append(radius.x).append("\"");
        stringBuilder.append(" ry=\"").append(radius.y);
        stringBuilder.append("\" ").append(parameters).append("/>");
        return stringBuilder.toString();
    }
}