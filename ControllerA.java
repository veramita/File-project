import java.util.Scanner;

public class ControllerA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int barisKolom = scanner.nextInt();
        scanner.nextLine();
        
        char[][] area = new char[barisKolom][barisKolom];
        int X = 0, Y = 0;
        for (int i = 0; i < barisKolom; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < barisKolom; j++) {
                area[i][j] = line.charAt(j * 2);
                if (area[i][j] == 'A') {
                    X = i;
                    Y = j;
                }
            }
        }

        int jalan = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jalan; i++) {
            String perintah = scanner.nextLine();
            switch (perintah) {
                case "ATAS":
                    X = (X - 1 + barisKolom) % barisKolom;
                    break;
                case "BAWAH":
                    X = (X + 1) % barisKolom; 
                    break;
                case "KIRI":
                    Y = (Y - 1 + barisKolom) % barisKolom;
                    break;
                case "KANAN":
                    Y = (Y + 1) % barisKolom;
                    break;
            }
        }

        for (int i = 0; i < barisKolom; i++) {
            for (int j = 0; j < barisKolom; j++) {
                if (area[i][j] == 'A') {
                    area[i][j] = '_';
                }
            }
        }

        area[X][Y] = 'A';
        
        for (int i = 0; i < barisKolom; i++) {
            for (int j = 0; j < barisKolom; j++) {
                System.out.print(area[i][j]);
                if (j < barisKolom - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
