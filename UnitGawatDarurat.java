import java.util.Scanner;

public class UnitGawatDarurat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] nama = new String[3];
        int[] umur = new int[3];
        int[] saturasi = new int[3];
        
        for(int i = 0; i < 3; i++){
            nama[i] = input.next();
            umur[i] = input.nextInt();
            saturasi[i] = input.nextInt();
        }
        
        for(int i = 0; i < 3; i++) {
            for(int j = i+1; j < 3; j++) {
                if(saturasi[i] > saturasi[j] || (saturasi[i] == saturasi[j] && umur[i]<umur[j])){
                    int tempSaturasi = saturasi[i];
                    saturasi[i] = saturasi[j];
                    saturasi[j] = tempSaturasi;
                    
                    int tempUmur = umur[i];
                    umur[i] = umur[j];
                    umur[j] = tempUmur;
                    
                    String tempNama = nama[i];
                    nama[i] = nama[j];
                    nama[j] = tempNama;
                }
            }
        }    
        for(int i = 0; i < 3; i++){
                System.out.println("Prioritas " + (i+1) + ": " + nama[i]);
        }
    }
}