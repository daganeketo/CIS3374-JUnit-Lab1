
package krishna_lab1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Krishna_Lab1 {
static String note = "";
   public static void main(String[] args) {
   String size = args[0];
   int N = Integer.parseInt(size);
    
    
    double[][] matrix_A = new double[N][N];
    double[][] matrix_B = new double[N][N];
   // double[][] matrix_C;// = new double[N][N];
    
    fill_matrix(matrix_A, N);
    fill_matrix(matrix_B, N);
   // matrix_multiplication(matrix_A, matrix_B, matrix_C, N);
    switched_ijk(matrix_A, matrix_B, N);
    
    }
    
    public static void fill_matrix(double [][] x, double N){
        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                //x[i][j] = i*j+3;
                x[i][j]= (int)(Math.random()*10);
            }
        }
    }
    
    /*public static void matrix_multiplication(double[][]A, double[][]B, double[][]C, int N){
       long start1 = System.nanoTime();
        for(int i= 0; i<A.length; i++){
            for(int j= 0; j<A.length; j++){
                for(int k = 0; k<A.length; k++){
                    C[i][j] = C[i][j]+ (A[i][k]*B[k][j]);
                }
            }
        }
        long end1 = System.nanoTime();
        
        long time1 = (end1 - start1)/1000 ;
        
         file_writer(time1, N, "ijk");
    }*/
    
    public static void file_writer(long time, int q, String s){
        
        double N = (double)q;
        
        File file = new File("Lab1.log");
        if (!file.exists()){
            try{
            file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } 
        try{
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        double W = (((N*N)/time)*N);
        pw.printf("%s", s);
        pw.printf("%5.0f", N);
        pw.printf("%20d", time);
        pw.printf("%10.2f%n", W);

        pw.close();
        } catch(IOException e) {
            System.out.println("Something went wrong!!");
            e.printStackTrace();  
        }
        
    }
    
    public static void switched_ijk(double [][]a,double [][]b, int N){
        double[][] C = new double[N][N];
        double[][] D = new double[N][N];
        double[][] E = new double[N][N];
        double[][] F = new double[N][N];
        double[][] G = new double[N][N];
        double[][] H = new double[N][N];
        
        init(C);
        init(D);
        init(E);
        init(F);
        init(G);
        init(H);
   multiplyMatrix(a, b, C,D, E, F, G, H, N);
   checkmatrices(C,D,E,F,G,H,N);
    }      
    
    public static void init (double [][] c){
        for (double[] c1 : c) {
            for (int j = 0; j< c.length; j++) {
                c1[j] = 0;
            }
        }
    }
    
     public static void multiplyMatrix(double[][] a, double [][] b, double C[][],
            double [][] D, double [][] E, double [][] F, double [][] G, double [][] H,int N){
         
         long start1 = System.nanoTime();
        for(int i= 0; i<N; i++){
            for(int j= 0; j<N; j++){
                for(int k = 0; k<N; k++){
                    C[i][j] = C[i][j]+ (a[i][k]*b[k][j]);
                }
            }
        }
  
        long end1 = System.nanoTime();
        long time1 = (end1 - start1)/1000 ;
        file_writer(time1, N, "ijk");
//------------------------------------------------------------------------------------------------------- 
        long start2 = System.nanoTime();
        for(int j= 0; j<N; j++){
            for(int i= 0; i<N; i++){
                for(int k = 0; k<N; k++){
                    D[i][j] = D[i][j]+ (a[i][k]*b[k][j]);
                }
            }
        }
  
        long end2 = System.nanoTime();
        long time2 = (end2 - start2)/1000 ;
        file_writer(time2, N, "jik");

 //-------------------------------------------------------------------------------------------------------    
 
        long start3 = System.nanoTime();
        for(int k= 0; k<N; k++){
            for(int j= 0; j<N; j++){
                for(int i = 0; i<N; i++){
                    E[i][j] = E[i][j]+ (a[i][k]*b[k][j]);
                }
            }
        }

        long end3 = System.nanoTime();
        long time3 = (end3 - start3)/1000 ;
        file_writer(time3, N, "kji");

 //------------------------------------------------------------------------------------------------------- 
 
        long start4 = System.nanoTime();
        for(int i= 0; i<N; i++){
            for(int k= 0; k<N; k++){
                for(int j = 0; j<N; j++){
                    F[i][j] = F[i][j]+ (a[i][k]*b[k][j]);
                }
            }
        }
     
        long end4 = System.nanoTime();
        long time4 = (end4 - start4)/1000 ;
        file_writer(time4, N, "ikj");
        
 //-------------------------------------------------------------------------------------------------------        
        long start5 = System.nanoTime();
        for(int j= 0; j<N; j++){
            for(int k= 0; k<N; k++){
                for(int i = 0; i<N; i++){
                    G[i][j] = G[i][j]+ (a[i][k]*b[k][j]);
                }
            }
        }
      
        long end5 = System.nanoTime();
        long time5 = (end5 - start5)/1000 ;
        file_writer(time5, N, "jki");

 //------------------------------------------------------------------------------------------------------- 
 
        long start6 = System.nanoTime();
        for(int k= 0; k<N; k++){
            for(int i= 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    H[i][j] = H[i][j]+ (a[i][k]*b[k][j]);
                }
            }
        }
        
        long end6 = System.nanoTime();
        long time6 = (end6 - start6)/1000 ;
        file_writer(time6, N, "kij");
 //------------------------------------------------------------------------------------------------------- 
 
   long min_time = calculate_mintime(time1, time2, time3, time4, time5, time6);
   //file_writer(min_time, N, "Minimum Time");
        
    }
     
     public static void checkmatrices(double [][]C, double [][]D, double [][]E, double [][]F, double [][]G, double [][]H, double N){
        for(int i = 0; i< N; i++){
            for(int j = 0; j<N; j++){
                if((C[i][j]==D[i][j])&&(D[i][j]== E[i][j])&&(E[i][j]==F[i][j])&&(F[i][j]== G[i][j])&&(G[i][j]==H[i][j])){
                } else {
                    System.out.println("These matrices are not equal");
                    break;
                }    
            }
        }
        System.out.println("All permutations of Products produced the same result");
    }
     
     public static long calculate_mintime(long t1, long t2, long t3, long t4, long t5, long t6){
         long [] time = new long [] {t1, t2, t3, t4, t5, t6};
         
            long min_time = time[0];
         for(int i = 0; i<time.length; i++){
             if(time[i]<= min_time){
                 min_time = time[i];
             } 
         }
         return min_time;
         }
     
    
}
    
    

