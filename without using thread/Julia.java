//E/17/159

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

    



    public void paintComponent(Graphics g) { 
      

        
        for (int col = 0; col < 800; col++) {
             
                for (int row = 0; row < 800; row++) { 
                    
            double x = Fractalgenerate.DEFAULT_MINRE+row*(Fractalgenerate.DEFAULT_MAXRE-Fractalgenerate.DEFAULT_MINRE)/(width-1);
            double y = Fractalgenerate.DEFAULT_MAXIM -col*(Fractalgenerate.DEFAULT_MAXIM-Fractalgenerate.DEFAULT_MINIM)/(height-1);
    
            
            
            int iteration = Fractalgenerate.FindMaxIter(x, y, c_re, c_im, max_iteration );
            Point point = new Point(row,col);
        
            
            Fractalgenerate.printPoint((Graphics2D)g,Fractalgenerate.SelectColor(max_iteration, iteration), point);
         
        }
    }
    
    }
}