package de.tum.in.ase;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class TUMTriangle extends Application {

    private static final Color PAINT_BLUE = Color.valueOf("#316EB2");
    private static final Color PAINT_WHITE = Color.valueOf("#ffffff");

    private @NonNull List<Triangle> triangles = new ArrayList<>();

    /**
     * Creates the TUM triangle recursively by adding the generated triangles to the triangles
     * to the triangles attribute in the object.
     * @param top The offset from the top
     * @param left The offset from the left
     * @param height The height of the triangle
     * @param depth The recursion depth
     */
    public void createTUMTriangle(double top, double left, double height, int depth) {

        
       if (depth <= 0) {
           return;
       }

       double width = height * Math.sqrt(3) / 2;

       double x1 = left;
       double y1 = top;

       double x2 = width + left;
       double y2 = height / 2 + top;

       double x3 = left;
       double y3 = top + height;

       Point a = new Point(x1, y1);
       Point b = new Point(x2, y2);
       Point c = new Point(x3, y3);

       triangles.add(new Triangle(a, b, c, PAINT_BLUE));

       Point mab = new Point((x1 + x2) / 2, (y1 + y2) / 2);
       Point mac = new Point((x1 + x3) / 2, (y1 + y3) / 2);
       Point mbc = new Point((x2 + x3) / 2, (y2 + y3) / 2);

       triangles.add(new Triangle(mab, mac, mbc, PAINT_WHITE));

       createTUMTriangle(y1, x1, height / 2, depth - 1);
       createTUMTriangle((y1 + y2) / 2, (x1 + x2) / 2, height / 2, depth - 1);
       createTUMTriangle((y1 + y3) / 2, (x1 + x3) / 2, height / 2, depth - 1);



    }

    


    @Override
    public void start(Stage stage) {
        this.triangles = new ArrayList<>();

        SimplePad simplePad = new SimplePad(400 * Math.sqrt(3) / 2, 400);
        stage.setTitle("TUM triangle");
        stage.setScene(simplePad);
        stage.setResizable(false);
        stage.show();

        createTUMTriangle(100, 100, 200, 3);

        for (Triangle triangle : triangles) {
            simplePad.drawTriangle(triangle);
        }
    }
}
