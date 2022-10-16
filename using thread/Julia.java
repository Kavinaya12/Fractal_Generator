//E/17/159

import javax.swing.*;
import java.awt.*; 

public class Julia extends Mandelbrot{

    private static final int width=800, height=800;     //set the height and the width
	private double c_im;                                //imaginary part of c 
    private double c_re;                                //real part of the c
    private int max_iteration;                          //maximum iterations 
    
    public Julia(double c_re, double c_im, int max_iteration){     //constructor
        this.c_im = c_im;
        this.c_re = c_re;
        this.max_iteration = max_iteration;
        this.iteration_matrix =  new int[width][height];
        setPreferredSize(new Dimension(width, height));
	
    }

    public Julia(){

        this(Fractalgenerate.DEFAULT_C_RE_JULIA, Fractalgenerate.DEFAULT_C_IM_JULIA, Fractalgenerate.DEFAULT_ITER);
    }

    


        @Override
        public void CreatePointLoop(int Xstart, int Xend, int Ystart, int Yend){    
            //method to find every points and its max iteration and save it to a array
            for (int col = Ystart; col <= Yend; col++) {
                for (int row = Xstart; row <= Xend; row++) { 

                    double x = Fractalgenerate.DEFAULT_MINRE+row*(Fractalgenerate.DEFAULT_MAXRE-Fractalgenerate.DEFAULT_MINRE)/(width-1);
                    double y = Fractalgenerate.DEFAULT_MAXIM -col*(Fractalgenerate.DEFAULT_MAXIM-Fractalgenerate.DEFAULT_MINIM)/(height-1);
            
                    
                    
                    int iteration = Fractalgenerate.FindMaxIter(x, y, c_re, c_im, max_iteration );  //finds max iterations of the point
                    Point point = new Point(row,col);
                   
	                iteration_matrix[row][col]=iteration;       //save max itarations of the point to the array
                }
            }
        }
}

