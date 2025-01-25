import java.util.*;

public class BilanganPrima {
    public static void main(String[] args) {
        System.out.println("Cek Bilangan Prima");
        System.out.println("==============================================");
        cekPrima();
        barisPrima();
    }

    private static void cekPrima(){
        Scanner input = new Scanner(System.in);

        int n, i;
        boolean angkaPrima = true;

        System.out.print("Masukkan angka pilihanmu! ");
        n = input.nextInt();

        if(n == 0 || n == 1){
            angkaPrima = false;
        } else {
            for (i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                  angkaPrima = false;
                  break;
                } 
            }
        }
        System.out.println("");
        if (angkaPrima) {
            System.out.println(n + " adalah angka prima");
        }else {
            System.out.println(n + " bukan angka prima");
        }
        System.out.println("==============================================");
    }

    private static void barisPrima(){
        int i = 0;
        int angka = 0;
        String angkaPrima = "";

        for(i = 1; i <= 100; i++){
            int hitung =0;
            for (angka = i; angka >= 1; angka--){
                if (i%angka == 0) {
                    hitung += 1;
                }
            } if (hitung == 2) {
                angkaPrima = angkaPrima + i + "; ";
            }
        }
        System.out.println("Angka prima dari 1 sampai 100");
        System.out.println(angkaPrima);
    }
}