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

	

    public void paintComponent(Graphics g) { 
	 
	CreateThread();                                //call to create threads

		for (int i=0 ;i<width;i++){
			for (int j=0 ;j<width;j++){
				Point point = new Point(j,i);        //print the every point in the frame 
				Fractalgenerate.printPoint((Graphics2D)g,Fractalgenerate.SelectColor(max_iteration, iteration_matrix[j][i]), point);
		}

		}

	} 



	public void CreatePointLoop(int x_start, int x_end, int y_start, int y_end){   //method to find every points and its max iteration and save it to a array

		for (int col = y_start; col <=y_end; col++) {
         
			for (int row = x_start; row <= x_end; row++) { 
				
				double c_re = minre+row*(maxre-minre)/(width-1);   
				double c_im = maxim-col*(maxim-minim)/(height-1);

				double x = c_re, y = c_im;
				   
				int iteration = Fractalgenerate.FindMaxIter(x, y, c_re, c_im, max_iteration );    //finds max iterations of the point
				
				iteration_matrix[row][col]=iteration;     //save max itarations of the point to the array
		
	  
			}
		}
	}




	private void CreateThread(){    //create threads as 4 parts 
	
		Thread t1 = new Thread( 
			new Runnable() {
				@Override
				public void run() {
					CreatePointLoop(0, width/2 - 1, 0, height/2 - 1);
				}
			}
	);
	t1.start();

	Thread t2 = new Thread(
			new Runnable() {
				@Override
				public void run() {
					CreatePointLoop(width/2, width-1, 0, height/2 - 1);
				}
			}
	);
	t2.start();

	Thread t3 = new Thread(
			new Runnable() {
				@Override
				public void run() {
					CreatePointLoop(0, width/2 - 1, height/2, height -1);
				}
			}
	);
	t3.start();

	Thread t4 = new Thread(
			new Runnable() {
				@Override
				public void run() {
					CreatePointLoop(width/2, width-1, height/2, height-1);
				}
			}
	);
	t4.start();
              

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}
	
	

}