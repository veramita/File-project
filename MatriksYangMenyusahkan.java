import java.io.*;
import java.util.*;
import java.util.Scanner;

public class MatriksYangMenyusahkan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int baris = input.nextInt();
        int kolom = input.nextInt();
        
        int[][] matriks = new int[baris][kolom];
        
        for (int i = 0; i<baris; i++){
            for (int j = 0; j<kolom; j++){
                matriks[i][j] = input.nextInt();
            }
        }
        
        int[][] matriksRotasi = new int[kolom][baris];
        
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                matriksRotasi[j][baris - i - 1] = matriks[i][j];
            }
        }
        for (int i = 0; i < kolom; i++) {
            for (int j = 0; j < baris; j++) {
                System.out.print(matriksRotasi[i][j] + " ");
            }
            System.out.println();
        }
    }
}