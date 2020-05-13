package Ketidakpastian;

import java.util.Scanner;

public class Bayesian {

    public static double ketidakpastian(double populasi, double terkena, double akurasi, double data) {
        double p_b_a = 1 - (data / terkena);
        double p_a = terkena / populasi;
        double p_b_not_a = 1 - ((akurasi - data) / (populasi - terkena));
        return bayes(p_b_a, p_a , p_b_not_a) * 100;
    }
    
    public static double bayes(double p_b_a, double p_a, double p_b_not_a) {
        double atas = p_b_a * p_a;
        double p_not_a = 1 - p_a;
        double bawah = p_b_a * p_a + p_b_not_a * p_not_a;
        return atas/bawah;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan jumlah populasi: ");
        double populasi = in.nextDouble();
        
        System.out.print("Masukkan jumlah pengguna: ");
        double terkena = in.nextDouble();
        
        System.out.print("Masukkan akurasi hasil test: ");
        double akurasi = in.nextDouble();
        
        System.out.print("Masukkan hasil test sebenarnya: ");
        double data = in.nextDouble();

        System.out.print("Kemungkinan anda false positive: ");
        System.out.println(ketidakpastian(populasi, terkena, akurasi, data));
    }
}