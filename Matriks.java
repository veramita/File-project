import java.util.*;
import java.lang.*;
public class Matriks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ukuran = input.nextInt();
        input.nextLine();
        double[][] matriks1 = hitungMatriks(input, ukuran);
        double[][] matriks2 = hitungMatriks(input, ukuran);
        double[][] hasil = hadamard(matriks1, matriks2, ukuran);

        for (int i = 0; i < hasil.length; i++){
            for (int j = 0; j < hasil[i].length; j++){
                System.out.printf("%.2f%c", hasil[i][j], ' ');
            }
            System.out.println("");
        }
    }
    public static double[][] hitungMatriks(Scanner input, int size){
        List<double[]> matrixKolom = new ArrayList<>();

        for(int i = 0; i < size; i++){
            String string = input.nextLine();
            String[] isi = string.split(" ");
            double[] baris = new double[isi.length];
            for(int j = 0; j < isi.length; j++){
                baris[j] = Double.parseDouble(isi[j]);
            }
            matrixKolom.add(baris);
        }
        double[][] matrix = new double[matrixKolom.size()][];
        for(int i = 0; i < matrixKolom.size(); i++){
            matrix[i] = matrixKolom.get(i);
        }
        return matrix;
    }
    public static double[][] hadamard(double[][] matrix1, double[][] matrix2, int size){
        int kolom = Math.min(matrix1[0].length, matrix2[0].length);
        double[][] hasil = new double[size][kolom];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }
        return hasil;
    }
}