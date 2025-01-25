import java.util.Scanner;

class Angkot{
    int jamMulai;
    int jamSelesai;
    int durasiKerja;
    int jumlahPenumpang;
    int jumlahDewasa;
    int jumlahAnak;
    double totalPendapatan;
    double uangBensin;
    
    public Angkot(int jamMulai, int jamSelesai){
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.durasiKerja = jamSelesai - jamMulai;
        this.jumlahDewasa = 0;
        this.jumlahAnak = 0;
        this.totalPendapatan = 0;
        this.uangBensin = 0;
    }
}
public class AngkotDengklek {
    private static final double TIKET_DEWASA = 12000;
    private static final double TIKET_ANAK = 8000;
    private static final double BENSIN_PAGI = 10000;
    private static final double BENSIN_SIANG = 12000;
    private static final double BENSIN_MALAM = 11000;
    private static final double LITER_BENSIN_PERJAM = 2;
    
    public static void penumpang(Angkot angkot, String jenis){
        if(jenis.equalsIgnoreCase("dewasa")){
            angkot.jumlahDewasa++;
            angkot.totalPendapatan += TIKET_DEWASA;
        } else if(jenis.equalsIgnoreCase("anak kecil")){
            angkot.jumlahAnak++;
            angkot.totalPendapatan += TIKET_ANAK;
        }
    }
    public static void hitungUangBensin(Angkot angkot){
        int bensin = angkot.durasiKerja * (int)LITER_BENSIN_PERJAM;
        
        if(angkot.jamSelesai >= 0 && angkot.jamSelesai < 12){
            angkot.uangBensin = (double)bensin * BENSIN_PAGI + BENSIN_PAGI; 
        } else if(angkot.jamSelesai >= 12 && angkot.jamSelesai < 18){
            angkot.uangBensin = (double)bensin * BENSIN_SIANG ;
        } else{
            angkot.uangBensin = (double)bensin * BENSIN_MALAM;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int jamMulai = input.nextInt();
        int jamSelesai = input.nextInt();
        int jumlahPenumpang = input.nextInt();
        input.nextLine();
        
        Angkot angkot = new Angkot(jamMulai, jamSelesai);
        
        for(int i = 0; i < jumlahPenumpang; i++){
            String jenisPenumpang = input.nextLine();
            penumpang(angkot, jenisPenumpang);
        }
        
        hitungUangBensin(angkot);
        
        double keuntungan = angkot.totalPendapatan - angkot.uangBensin;
        
        System.out.printf("%-27s %c %d jam\n", "Durasi operasi", ':', angkot.durasiKerja);
        System.out.printf("%-27s %c %d orang\n", "Jumlah penumpang dewasa", ':', angkot.jumlahDewasa);
        System.out.printf("%-27s %c %d orang\n", "Jumlah penumpang anak kecil", ':', angkot.jumlahAnak);
        System.out.printf("%-27s %c Rp%.2f,-\n", "Total pendapatan", ':', angkot.totalPendapatan);
        System.out.printf("%-27s %c Rp%.2f,-\n", "Pengeluaran bensin", ':', angkot.uangBensin);
        
        if(keuntungan >= 0) {
            System.out.printf("Pak Dengklek mendapat keuntungan sebesar Rp%.2f,-\n", keuntungan);
        } else {
            System.out.printf("Pak Dengklek mengalami kerugian sebesar Rp%.2f,-\n", keuntungan);
        }
    }
}