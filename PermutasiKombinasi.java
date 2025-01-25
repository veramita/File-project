import java.util.*;
public class PermutasiKombinasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = 3;
        do{
            System.out.println("");
            System.out.println("Program Penghitung Kombinasi dan Pemutasi");
            System.out.println("1. Menghitung Permutasi");
            System.out.println("2. Menghitung Kombinasi");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan anda : ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    permutasi(input);
                    break;
            
                case 2:
                    Kombinasi(input);
                    break;
            }
        } while (pilihan != 3);
    }

    public static void permutasi(Scanner input){
        System.out.print("Masukkan nilai n : ");
        int n = input.nextInt();
        System.out.print("Masukkan nilai r : ");
        int r = input.nextInt();

        if (n < 0 || r < 0 || r > n) {
            System.out.println("Nilai n dan r tidak boleh negatif, serta" + "r tidak boleh lebih dari n.\n");
            return;
        }

        int hasil = faktorial(n) / faktorial(n - r); 

        System.out.printf("%-10c %-5s\n", ' ', "n");
        System.out.println("nPr = ----------- = " + hasil );
        System.out.printf("%-8c %-5s\n", ' ', "(n-r)!");
    }

    public static void Kombinasi(Scanner input){
        System.out.print("Masukkan nilai n : ");
        int n = input.nextInt();
        System.out.print("Masukkan nilai r : ");
        int r = input.nextInt();

        if (n < 0 || r < 0 || r > n) {
            System.out.println("Nilai n dan r tidak boleh negatif, serta" + "r tidak boleh lebih dari n.\n");
            return;
        }

        int hasil = faktorial(n) / (faktorial(r)*faktorial(n - r)); 

        System.out.printf("%-10c %-5s\n", ' ', "n");
        System.out.println("nCr = ----------- = " + hasil );
        System.out.printf("%-5c %-5s\n", ' ', "(n-r)! x r!");
    }

    private static int faktorial(int bil){ 
        if (bil==1)
        return 1; else
        return (bil * faktorial(bil-1));
    }
}
