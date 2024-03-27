import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private List<Polygon> polygons;

    public SvgScene() {
        this.polygons = new ArrayList<>();
    }

    public void add(Polygon polygon) {
        this.polygons.add(polygon);
    }

    public void save(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><svg width=\"1024\" height=\"768\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        sb.append(string);
        sb.append("</svg></body></html>");
    }
}
