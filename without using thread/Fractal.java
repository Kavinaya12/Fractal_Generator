//E/17/159

import javax.swing.JPanel;
import javax.swing.*;

public class Fractal extends JPanel{

    public static JFrame frame; 
    public static void main(String[] args) {

         // If user did not give any Fractal set name
        if(args.length == 0){
            System.out.println("Fractal Set Is Missing\n");
            return;
        }
        
        else{
            frame = new JFrame("Fractals - "+args[0].toUpperCase());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    

            // If user calls mandelbrot set 
             if (args[0].equalsIgnoreCase("Mandelbrot")) {
               
                if (args.length == 1) {
                    frame.setContentPane(new Mandelbrot());

                } else if (args.length == 5) {
                    frame.setContentPane(new Mandelbrot(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4])));

                } else if (args.length == 6) {
                    frame.setContentPane(new Mandelbrot(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Integer.parseInt(args[5])));

                }else{
                    System.out.println("Wrong Number Of Arguments\n");    // If number of arguments are wrong
                    return;
                }

            }

            //If user calls Julia set 
            else if (args[0].equalsIgnoreCase("Julia")) {
                   
                if (args.length == 1) {
                    frame.setContentPane(new Julia());

                }
                else if (args.length == 4) {
                    frame.setContentPane(new Julia(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3])));

                }else{
                    System.out.println("Wrong Number Of Arguments\n");    // If number of arguments are wrong
                    return;
                }


            }else{
                System.out.println("Wrong Fractal Set\n");    // If the user calls wrong fractal set (java Fractal xyz)
                return;
            }
      
            frame.pack(); 
	frame.setLocationRelativeTo(null); 
	frame.setVisible(true);
    }
    }
}
