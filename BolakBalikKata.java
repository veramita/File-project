import java.util.Scanner;

public class BolakBalikKata {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = input.nextInt();
        input.nextLine();
        String kata1 = input.nextLine();
        String kata2 = input.nextLine();

        switch (pilihan) {
            case 1:
                System.out.println(balikan(kata1));
                System.out.println(kata2);
                break;
        
            case 2:
                System.out.println(kata1);
                System.out.println(balikan(kata2));
                break;
        }
    }
    
    public static String balikan(String kata){ 
        String tambahan = "";
        for(int i = kata.length()-1; i>=0; i--){      
            tambahan += kata.charAt(i);
         }
        return tambahan;
    }
}