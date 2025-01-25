import java.util.*;

public class RankingPemain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int banyakPemain = input.nextInt();
        int[] skillOfensif = new int[banyakPemain];
        int[] skillDefensif = new int[banyakPemain];
        for(int i = 0; i < banyakPemain; i++){
            skillOfensif[i] = input.nextInt();
        } for(int j = 0; j < banyakPemain; j++){
            skillDefensif[j] = input.nextInt();
        }
        int banyakPerintah = input.nextInt();
        while (true) {
            String[] perintah = new String[banyakPerintah];
            for(int i = 0; i < banyakPerintah; i++){
                perintah[i] = input.next();
            switch (perintah[i]) {
                case "tampil":
                    String tampil = input.next();
                    if (tampil.equals("skill")) {
                        
                    } else if(tampil.equals("rank")){
                        System.out.println("Rank ofensif: " + urutan(skillOfensif));
                        System.out.println("Rank ofensif: " + urutan(skillOfensif));
                        System.out.println("Rank overall: " + rankOverall(skillOfensif, skillDefensif, banyakPemain));
                    }
                    break;
                case "latih":
                    String latihSkill = input.next();
                    int latihPemain = input.nextInt();
                    int poinLatihan = input.nextInt();
                    break;
            }
            }
        }
    }  private static int urutan(int[] angka){
        int max = angka[0];
        int urutan = 0;
        for(int i = 1; i < angka.length; i++){
        if(angka[i] > max){
            max = angka[i];
            urutan = i;
        }
    }
        return angka[urutan];    
    } public static int rankOverall(int[] skillOfensif, int[] skillDefensif, int banyakPemain) {
        int[] sum = new int[banyakPemain];
        for(int i = 0; i < banyakPemain; i++) {
            sum[i] = skillOfensif[i] + skillDefensif[i];
        }
        return urutan(sum);
    }
}