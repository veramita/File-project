import java.util.Scanner;

/*author Meylisa Putri Veramita */

public class TiketKeretaApi {

    public static void main(String[] args) {
        String[][] keretaApi = {
            {"Ekonomi", "50000", "2%", "Tidak Ada", "Tidak Ada"},
            {"Bisnis", "100000", "5%", "Ada", "Tidak Ada"},
            {"Eksekutif", "200000", "7%", "Ada", "Tidak Ada"},
            {"Pariwisata", "300000", "10%", "Ada", "Ada"}
        };

        String[] pesananTiket = new String[10];
        int jumlahPesanan = 0;
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("");
            System.out.println("Pilihan Menu:");
            System.out.println("1. Melihat Daftar Kereta Api");
            System.out.println("2. Melihat Daftar Kereta Api yang ada AC");
            System.out.println("3. Melihat Daftar Kereta Api yang ada Colokan");
            System.out.println("4. Memesan Tiket Kereta Api");
            System.out.println("5. Melihat Pesanan Tiket");
            System.out.println("0. Keluar");
            System.out.print("Masukkan nilai: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            System.out.println("");

            switch (pilihan) {
                case 1 -> {
                    System.out.println("Daftar Kereta Api:");
                    System.out.printf("%-10s %-11s %-10s %-12s %-10s\n", "Jenis", "| Harga", "| Diskon", "| AC", "| Colokan");
                    System.out.println("-----------------------------------------------------------");
                    for (int i = 0; i < keretaApi.length; i++) {
                            System.out.printf("%-10s %c %-9s %c %-8s %c %-10s %c %-10s\n", keretaApi[i][0] 
                             , '|' , keretaApi[i][1]  
                             , '|' , keretaApi[i][2]  
                             , '|' , keretaApi[i][3]  
                             , '|' , keretaApi[i][4]);
                    }

                
                } case 2 -> {
                    System.out.println("Daftar Kereta Api dengan AC:");
                    System.out.printf("%-10s %-11s %-10s %-12s %-10s\n", "Jenis", "| Harga", "| Diskon", "| AC", "| Colokan");
                    System.out.println("-----------------------------------------------------------");
                    for (int i = 0; i < keretaApi.length; i++) {
                        if (keretaApi[i][3].equals("Ada")) {
                            System.out.printf("%-10s %c %-9s %c %-8s %c %-10s %c %-10s\n", keretaApi[i][0] 
                             , '|' , keretaApi[i][1]  
                             , '|' , keretaApi[i][2]  
                             , '|' , keretaApi[i][3]  
                             , '|' , keretaApi[i][4]);
                        }
                    }


                } case 3 -> {
                    System.out.println("Daftar Kereta Api dengan Colokan:");
                    System.out.printf("%-10s %-11s %-10s %-12s %-10s\n", "Jenis", "| Harga", "| Diskon", "| AC", "| Colokan");
                    System.out.println("-----------------------------------------------------------");
                    for (int i = 0; i < keretaApi.length; i++) {
                        if (keretaApi[i][4].equals("Ada")) {
                            System.out.printf("%-10s %c %-9s %c %-8s %c %-10s %c %-10s\n", keretaApi[i][0] 
                             , '|' , keretaApi[i][1]  
                             , '|' , keretaApi[i][2]  
                             , '|' , keretaApi[i][3]  
                             , '|' , keretaApi[i][4]);
                        }
                    }

                } case 4 -> {
                    if (jumlahPesanan < pesananTiket.length) {
                        System.out.println("Masukkan jenis kereta yang ingin dipesan:");
                        String jenis = scanner.nextLine();
                        boolean ditemukan = false;

                        for (String[] kereta : keretaApi) {
                            if (kereta[0].equalsIgnoreCase(jenis)) {
                                pesananTiket[jumlahPesanan] = jenis;
                                jumlahPesanan++;
                                System.out.println("Tiket untuk kereta " + jenis + " berhasil dipesan.");
                                ditemukan = true;
                                break;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Jenis kereta tidak ditemukan.");
                        }
                    } else {
                        System.out.println("Pesanan tiket penuh. Tidak dapat memesan lebih banyak tiket.");
                    }
                    break;

                } case 5 -> {
                    if (jumlahPesanan == 0) {
                        System.out.println("Belum ada tiket yang dipesan.");
                    } else {
                        System.out.println("Daftar Pesanan Tiket:");
                        for (int i = 0; i < jumlahPesanan; i++) {
                            System.out.println("Tiket Kereta: " + pesananTiket[i]);
                        }
                    }

                } case 0 -> {
                    System.out.println("Terima kasih telah menggunakan layanan kami.");

                } default -> {
                    System.out.println("Pilihan tidak valid, coba lagi.");
                }
            }

        } while (pilihan != 0);

        scanner.close();
    }
}
