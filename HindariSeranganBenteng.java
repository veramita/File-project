import java.util.*;

public class HindariSeranganBenteng {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] papan = new String[8];
        for(int i = 0; i < papan.length; i++){
            papan[i] = input.nextLine();
        }
        char[] pisah = pisahan(papan);
        char[][] isi2D = ubahKe2D(pisah);
        int petakAman = kosong(isi2D);

        System.out.println(petakAman);
    }
    public static char[] pisahan(String[] papan){
        int length = 0;
        for(int i = 0; i < papan.length; i++){
                length += papan[i].length();
        }
        char[] pisah = new char[length];
        int k = 0;
        for(int i = 0; i < papan.length; i++){
            for(int j = 0; j < papan[i].length(); j++){
                pisah[k] = papan[i].charAt(j);
                k++;
            }
        }
        return pisah;
    }
    public static char[][] ubahKe2D (char[] pisah){
    char[][] array2D = new char[8][8];

        for(int i = 0; i < pisah.length; i++){
            int baris = i / 8;
            int kolom = i % 8;
            array2D[baris][kolom] = pisah[i];
        }
        return array2D;
    }
    public static int kosong (char[][] isi2D){
        boolean[] barisTerancam = new boolean[8];
        boolean[] kolomTerancam = new boolean[8];

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (isi2D[i][j] == '#') {
                    barisTerancam[i] = true;
                    kolomTerancam[j] = true;
                }
            }
        }
        int petakAman = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (isi2D[i][j] == '.' && !barisTerancam[i] && !kolomTerancam[j]) {
                    petakAman++;
                }
            }
        }
        return petakAman;
    }
}
