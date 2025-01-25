import java.util.*;

public class RiffleShufflerString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String isi = input.nextLine();
        String hasil = riffleShuffle(isi);
        System.out.println(hasil);
    }
    public static String riffleShuffle(String hasil){
        if (hasil.length() <= 1) {
            return hasil;
        }
        int tengah = (hasil.length() + 1) / 2;

        String awal = hasil.substring(0, tengah);
        String akhir = hasil.substring(tengah);

        awal = riffleShuffle(awal);
        akhir = riffleShuffle(akhir);

        return acak(awal, akhir);
    }
    public static String acak(String awal, String akhir) {
        int totalPanjang = awal.length() + akhir.length();
        char[] shuffle = new char[totalPanjang];
        int i = 0, j = 0, k = 0;

        while (i < awal.length() || j < akhir.length()) {
            if (i < awal.length()) {
                shuffle[k++] = awal.charAt(i++);
            }
            if (j < akhir.length()) {
                shuffle[k++] = akhir.charAt(j++);
            }
        }
        return new String(shuffle);
    }
}