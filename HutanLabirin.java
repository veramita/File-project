import java.util.Scanner;

public class HutanLabirin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int X = input.nextInt();
        int N = input.nextInt();
        int langkah = 0;
        boolean berhasil = false;
        
        while(langkah < N){
            langkah++;
            if((X%2) == 0){
                X /= 2;
            } else {
                X *= 10;
            }
            
            if(X > 1000){
                berhasil = true;
                break;
            }
        }
        if(berhasil) {
            System.out.println("Berhasil keluar pada langkah ke-" + langkah);
        } else {
            System.out.println("Terjebak setelah " + N + "langkah");
        }
    }
}