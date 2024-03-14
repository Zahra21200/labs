import Shapes.*;

import java.util.ArrayList;
import java.util.List;

public class TestShapes {
    static void drawShapes(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());

        System.out.println("Drawing Rectangles:");
        drawShapes(rectangles);

        System.out.println("\nDrawing Circles:");
        drawShapes(circles);
    }
}
