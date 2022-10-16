//E/17/159

import java.awt.Color;
import java.awt.*; 
import java.awt.geom.Line2D;

public class Fractalgenerate {
                                           //default parameters
    public static final Double DEFAULT_C_RE_JULIA = -0.4;
    public static final Double DEFAULT_C_IM_JULIA = 0.6;
    public static final Double DEFAULT_MINRE = -1.0;
    public static final Double DEFAULT_MAXRE = 1.0;
    public static final Double DEFAULT_MINIM = -1.0;
    public static final Double DEFAULT_MAXIM = 1.0;
    public static final int DEFAULT_ITER = 1000;
    



    //method to find maximum iteration for a point
    public static int FindMaxIter(double x, double y, double c_re, double c_im, int max_iteration ){
        int iteration = 0;
            while (x*x+y*y <= 4 && iteration <max_iteration) {
                double x_new = x*x - y*y +c_re;
                y = 2*x*y +c_im;
                x = x_new;
                    
                iteration++;
            }
        return iteration; 
    }



    public static Color SelectColor(int max_iteration, int iteration){
        //method to set color according to the iterations

      
      int color_no ;
      if(iteration == max_iteration)return Color.BLACK;
  
     else {color_no = Color.HSBtoRGB(iteration/256f,1,iteration/(iteration+8f));
        Color color =new Color(color_no);
        return color;}
    
    }



    public static void printPoint(Graphics2D frame, Color c, Point p) { 
	//method to print by point
        frame.setColor(c);                                        
        frame.draw(new Line2D.Double(p.getX(), p.getY(), p.getX(), p.getY())); 
    
        }

    
}
