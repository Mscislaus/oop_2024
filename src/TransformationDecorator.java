import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator {


    String transform;

    public TransformationDecorator(Shape shape, String transform) {
        super(shape);
        this.transform = transform;
    }

    @Override
    public String toSvg(String param) {
        return super.toSvg(String.format("%s transform=\"%s\"", param, this.transform));
    }
}