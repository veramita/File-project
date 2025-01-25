import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HitungKode {
    public static void main(String[] args) {
        // Kode main tidak boleh dirubah
      Scanner scanner = new Scanner(System.in);

      String s1 = scanner.nextLine();
      String s2 = scanner.nextLine();

      char[] pesanKode = s1.toCharArray();
      char[] pesanEnkripsi = s2.toCharArray();

      System.out.println(hitungKemunculanPola(pesanKode, pesanEnkripsi));
  }
  public static int hitungKemunculanPola(char[] pesanKode, char[] pesanEnkripsi){
        int count = 0;
        int kode = pesanKode.length;
        int enkripsi = pesanEnkripsi.length;

        for (int i = 0; i <= enkripsi - kode; i++) {
            boolean hitung = true;
            for (int j = 0; j < kode; j++) {
                if (pesanEnkripsi[i + j] != pesanKode[j]) {
                    hitung = false;
                    break;
                }
            }
            if (hitung) {
                count++;
            }
        }
        return count;
    }
}
