import java.util.*;

public class DataPekerja {
    static final double GAJI_PER_JAM = 15000;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int banyakPekerja = input.nextInt();
        int banyakHari = input.nextInt();

        int[][] kerjaan = new int[banyakPekerja][banyakHari];
        for(int i = 0; i < banyakPekerja; i++){
            for(int j = 0; j < banyakHari; j++){
                kerjaan[i][j] = input.nextInt();
            }
        }

        int[] totalJamKerja = new int[banyakPekerja];
        double[] totalGaji = new double[banyakPekerja];

        for(int i = 0; i < banyakPekerja; i++){
            totalJamKerja[i] = jamKerja(kerjaan[i]);
            totalGaji[i] = gajiTotal(totalJamKerja[i], banyakHari);
        }
        for(int i = 0; i < banyakPekerja; i++){
            System.out.println("Tukang Bangunan " + (i+1) + ":");
            System.out.println("- Total jam kerja: " + totalJamKerja[i] + " jam");
            System.out.printf("%s Rp %.1f\n", "- Gaji:", totalGaji[i]);
        }
        int pekerjaTerbaik = urutan(totalJamKerja);
        double bonusPekerja = totalGaji[pekerjaTerbaik] * 0.1;
        double gajiTerbaik = totalGaji[pekerjaTerbaik] + bonusPekerja;
        System.out.println("");
        System.out.println("Pekerja terbaik: Tukang Bangunan " + (pekerjaTerbaik + 1));
        System.out.printf("%s Rp %.1f\n", "Bonus tambahan:", bonusPekerja);
        System.out.printf("%s%d: Rp %.1f\n", "Total Gaji yang diterima Tukang Bangunan ", (pekerjaTerbaik + 1), gajiTerbaik);
    }

    public static int jamKerja(int[] kerjaan){
        int total = 0;
        for(int i = 0; i < kerjaan.length; i++){
            total += kerjaan[i];
        }
        return total;
    }
    public static double gajiTotal(int totalJamKerja, int banyakHari){
        double gaji = totalJamKerja * GAJI_PER_JAM;

        if(totalJamKerja < (8*banyakHari)) {
            double denda = ((8*banyakHari) - totalJamKerja) *GAJI_PER_JAM * 0.5;
            gaji -= denda;
        } else if(totalJamKerja < (12*banyakHari)){
            return gaji;
        } else if(totalJamKerja > (12*banyakHari)){
            double bonus = (totalJamKerja - (12*banyakHari)) * GAJI_PER_JAM *0.5;
            gaji += bonus;
        }

        return gaji;
    }
    public static int urutan(int[] totalJamKerja){
        int max = totalJamKerja[0];
        int urutan = 0;
        for(int i = 1; i < totalJamKerja.length; i++){
            if (totalJamKerja[i] > max) {
                max = totalJamKerja[i];
                urutan = i;
            }
        }
        return urutan;
    }
}
