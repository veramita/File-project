import java.util.*;
import java.lang.*;

public class NilaiTertinggi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        String kelas = input.nextLine();

        String [] angkaData = data.split(" ");
        double[] angka = new double[angkaData.length];
        for(int i = 0; i < angkaData.length; i++){
            angka[i] = Double.parseDouble(angkaData[i]);
        }
        String [] kata = kelas.split(" ");

        System.out.println(argmax(angka, kata));
    }

    public static String argmax(double[] angka, String[] kata){
        double max = angka[0];
        int urutan = 0;

        for(int i = 1; i < angka.length; i++){
            if(angka[i] > max){
                max = angka[i];
                urutan = i;
            }
        }
        return kata[urutan];
    }
}