public abstract class Shape {
    abstract double area();

    abstract double perimeter();
}
    class Circle extends Shape {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double area() {
            return 3.14 * radius * radius;
        }

        public double perimeter() {
            return 2 * 3.14 * radius;
        }
    }

    class Rectangle extends Shape {
        double len;
        double width;

        public Rectangle(double len, double width) {
            this.len = len;
            this.width = width;
        }

        public double area() {
            return len * width;
        }

        public double perimeter() {
            return 2 * (len + width);
        }

        public static void main(String[] args) {
            Circle circle = new Circle(12.9);
            System.out.println("Area of Circle= "+circle.area());
            System.out.println("Circumference of Circle = "+circle.perimeter());

            Rectangle rectangle = new Rectangle(4.23, 6);
            System.out.println("Area of Rectangle= "+rectangle.area());
            System.out.println("Perimeter of Rectangle= "+rectangle.perimeter());
        }
    }
