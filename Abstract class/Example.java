
abstract class Shape {
    abstract void draw();
    
    void describe() {
        System.out.println("This is a shape.");
    }
}


class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle.");
    }
}

public class Example {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.describe(); // Output: This is a shape.
        circle.draw();     // Output: Drawing a circle.
    }
}

//🔁 Execution Flow

//main() starts.
//Creates a Circle object.
//Calls describe() from Shape (inherited).
//Calls draw() from Circle (overridden).
