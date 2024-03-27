import java.io.FileWriter;
import java.io.IOException;
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

    public void save(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><svg width=\"1024\" height=\"768\" xmlns=\"http://www.w3.org/2000/svg\">\n");

        for (Polygon polygon : polygons) {
            sb.append(polygon);
            sb.append("\n");
        }

        sb.append("</svg></body></html>");

        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
            writer.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try { writer.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}
