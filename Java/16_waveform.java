/** @author Gokul Raj | 235 | R3A | CSE
 * AIM: Write a Java Swing program to print a waveform
 * PROGRAM 16: Waveform Viewer
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WaveViewer extends JFrame{
    WaveViewer(){
        setVisible(true);
        setTitle("Sine Wave");
        setSize(1000,250);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){System.exit(0);}
        });
    }
    
    public void paint(Graphics g){
        // Set graph resolution, amplitude and frequency factor
        int resolution = 5, amplitude = 100, freq = 5;
        int w = getWidth();
        int h = getHeight();
        // Start graph at middle of screen
        int yoffset = h/2;
        // Clear screen
        g.setColor(Color.white);
        g.fillRect(0,0,w,h);
        g.setColor(Color.red);
     
        int prevx = 0, prevy = yoffset;
        for(int x=0; x<=w; x+=resolution){
            int y = (int)(Math.sin(Math.toRadians(x)*freq)*amplitude)+yoffset;
            g.drawLine(prevx, prevy, x, y);
            prevx = x; prevy = y;
        }
    }
    // Driver Code
    public static void main(String args[]){
        new WaveViewer();
    }
}
