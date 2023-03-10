module TUMTriangle {
    requires javafx.controls;
    requires javafx.graphics;
    requires org.checkerframework.checker.qual;

    opens de.tum.in.ase to javafx.graphics, javafx.controls;

    exports de.tum.in.ase;
}
