import java.util.Scanner;

/*author Meylisa Putri Veramita */

public class KalkulatorSederhana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[10];
        int jumlahData = 0;
        int pilihan;

        do {
            System.out.println("");
            System.out.println("Pilihan Menu:");
            System.out.println("1. Input Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Average");
            System.out.println("4. Sum");
            System.out.println("5. Max");
            System.out.println("6. Min");
            System.out.println("0. Keluar");
            System.out.print("Masukkan nilai: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch(pilihan){
            case 1 -> {
                System.out.print("Masukkan data (pisahkan dengan spasi): ");
                String input = scanner.nextLine();
                
                int indeks = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (input.charAt(i) == ' ') {
                        String angka = input.substring(indeks, i);
                        data[jumlahData] = Integer.parseInt(angka);
                        jumlahData++;
                        indeks = i + 1;
                    }
                }
                if (indeks < input.length()) {
                    data[jumlahData] = Integer.parseInt(input.substring(indeks));
                    jumlahData++;
                }

                System.out.println("Data berhasil ditambahkan.");
            } case 2 -> {
                if (jumlahData == 0) {
                    System.out.println("Data masih kosong.");
                } else {
                    System.out.print("Data: ");
                    for (int i = 0; i < jumlahData; i++) {
                        System.out.print(data[i] + " ");
                    }
                    System.out.println();
                }
            } case 3 -> {
                if (jumlahData == 0) {
                    System.out.println("Data masih kosong.");
                } else {
                    int sum = 0;
                    for (int i = 0; i < jumlahData; i++) {
                        sum += data[i];
                    }
                    double average = (double) sum / jumlahData;
                    System.out.println("Average(rata-rata): " + average);
                }
            } case 4 -> {
                if (jumlahData == 0) {
                    System.out.println("Data masih kosong.");
                } else {
                    int sum = 0;
                    for (int i = 0; i < jumlahData; i++) {
                        sum += data[i];
                    }
                    System.out.println("Jumlah total: " + sum);
                }
            } case 5 -> {
                if (jumlahData == 0) {
                    System.out.println("Data masih kosong.");
                } else {
                    int max = data[0];
                    for (int i = 1; i < jumlahData; i++) {
                        if (data[i] > max) {
                            max = data[i];
                        }
                    }
                    System.out.println("Nilai maksimum: " + max);
                }
            } case 6 -> {
                if (jumlahData == 0) {
                    System.out.println("Data masih kosong.");
                } else {
                    int min = data[0];
                    for (int i = 1; i < jumlahData; i++) {
                        if (data[i] < min) {
                            min = data[i];
                        }
                    }
                    System.out.println("Nilai minimum: " + min);
                }
            } case 0 -> {
                System.out.println("Keluar.");
            } default -> {
                System.out.println("Pilihan tidak valid, silahkan coba lagi.");
            }
        }
        } while (pilihan != 0);

        scanner.close();
    }
}
