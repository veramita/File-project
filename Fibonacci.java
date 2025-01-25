import java.util.*;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Fibonacci ke-");
        int bilangan = input.nextInt();
        for(int i = 0; i <= bilangan; i++){
            System.out.print(fibonacci(i) + "; ");
        }
    }

    private static int fibonacci(int bil){
        if (bil <= 0) {
            return 0;
        } else if (bil == 1) {
            return 1;
        } else {
            return fibonacci(bil - 1) + fibonacci(bil - 2);
        }
    }
}
