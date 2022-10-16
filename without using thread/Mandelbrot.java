//E/17/159

import java.awt.*; 
import javax.swing.*;
   

class Mandelbrot extends JPanel { // inherit JPanel 

    private static final int width=800, height=800;   	//set width & height 
	private double minre;                             	//minimum real no
	private double maxre;								//maximum real no
	private double minim;								//minimum imaginary no
	private double maxim;								//maximum imaginary no
	
	private int max_iteration;                		//maximum iterations

	public int iteration_matrix[][];					//matrix to save iterations for each point


	public Mandelbrot(double minre, double maxre, double minim, double maxim, int max_iteration ) {   //constructors
	
	this.minre = minre;
	this.maxre = maxre;
	this.minim = minim;
	this.maxim = maxim;
	this.max_iteration = max_iteration;
	this.iteration_matrix =  new int[width][height];  
	setPreferredSize(new Dimension(width, height));
	
    }

	public Mandelbrot(){
		
		this(Fractalgenerate.DEFAULT_MINRE, Fractalgenerate.DEFAULT_MAXRE, Fractalgenerate.DEFAULT_MINIM, Fractalgenerate.DEFAULT_MAXIM, Fractalgenerate.DEFAULT_ITER );
		
	}

	public Mandelbrot(double minre,double maxre,double minim, double maxim) {
		
		this(minre, maxre, minim, maxim, Fractalgenerate.DEFAULT_ITER);
	}


	


    public void paintComponent(Graphics g) {    //method to find each point, its iterstion vale and print that point with its color
	
		for (int col = 0; col < 800; col++) {
         
			for (int row = 0; row < 800; row++) { 
				
		double c_re = minre+row*(maxre-minre)/(width-1);
		double c_im = maxim-col*(maxim-minim)/(height-1);

		double x = c_re, y = c_im;
		
		int iteration = Fractalgenerate.FindMaxIter(x, y, c_re, c_im, max_iteration );   //method call to find the maximum iteration of a point
		Point point = new Point(row,col);
	
		
		Fractalgenerate.printPoint((Graphics2D)g,Fractalgenerate.SelectColor(max_iteration, iteration), point);    //call method print point
	 
	}
}


}
	



}