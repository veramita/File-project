import java.util.*;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    
    public double getDiscriminant() {
        double diskriminan = Math.pow(b, 2) - (4 * a * c);
        return diskriminan;
    }
    public double getRoot1() {
        if(getDiscriminant() > -1) {
            double root = (-b + Math.sqrt(getDiscriminant())) / (2 * a);
            return root;
        } else {
            return 0;
        }
    }
    public double getRoot2() {
        if (getDiscriminant() > -1) {
            double root = (-b - Math.sqrt(getDiscriminant())) / (2 * a);
            return root;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        QuadraticEquation persamaan = new QuadraticEquation(a, b, c);
        double diskriminan = persamaan.getDiscriminant();
        
        if (diskriminan > 0) {
            System.out.printf("%s %.6f %s %.6f", "Enter a, b, c: The equation has two roots", persamaan.getRoot1(), "and", persamaan.getRoot2());
        } else if (diskriminan == 0) {
            System.out.printf("%s %.1f ", "Enter a, b, c: The equation has one root", persamaan.getRoot1());
        } else {
            System.out.println("Enter a, b, c: The equation has no real roots");
        }
    }
}
