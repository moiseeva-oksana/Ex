package SomeTasks.triangle;

/**
 * Created by Оксана on 17.12.2016.
 */
public class Triangle {
    public Point apex1;
    public Point apex2;
    public Point apex3;

    private Line line1;
    private Line line2;
    private Line line3;

    public Triangle(Point apex1, Point apex2, Point apex3) {
        this.apex1 = apex1;
        this.apex2 = apex2;
        this.apex3 = apex3;
        line1 = new Line(apex1, apex2);
        line2 = new Line(apex2, apex3);
        line3 = new Line(apex1, apex3);
    }

    private double getHalfPerimeter(){
        return (line1.getLength()+line2.getLength()+line3.getLength())/2;
    }

    public double getSquare(){
        return Math.sqrt(getHalfPerimeter()*(getHalfPerimeter()-line1.getLength())*(getHalfPerimeter()-line2.getLength())*(getHalfPerimeter()-line3.getLength()));
    }

    public static void main(String[] args) {
        Point point = new Point(1,1);
        Point point2 = new Point(-2,4);
        Point point3 = new Point(-2,-2);
        System.out.println(new Triangle(point, point2, point3).getSquare());
    }
}
