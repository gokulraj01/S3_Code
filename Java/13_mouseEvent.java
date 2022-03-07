/** @author Gokul Raj | 235 | R3A | CSE
 * AIM: Write a Java program for handling Mouse Events
 * PROGRAM 13: Mouse Event Handling
 */
import java.awt.*;
import java.awt.event.*;

class MouseEventViewer extends Frame implements MouseListener{
    Font f = new Font("monospaced", Font.PLAIN, 24);
    Label l, ctr;
    int clicks = 0;
    // Constructor that assembles GUI
    MouseEventViewer(){
        l = new Label();
        l.setBounds(25, 25, 700, 50);
        l.setBackground(Color.WHITE);
        l.setText("Interact with Button for Status...");
        add(l);
        
        Button b = new Button("Click Me");
        b.addMouseListener(this);
        b.setBounds(25, 100, 700, 50);
        add(b);
        
        ctr = new Label();
        ctr.setBounds(25, 150, 700, 50);
        ctr.setText("0 clicks");
        add(ctr);
        
        setSize(750,250);
        setFont(f);
        setTitle("Mouse Event Viewer");
        // WindowListener to close window on click exit
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){System.exit(0);}
        });
        setLayout(null);
        setVisible(true);
    }
    
    public void mouseExited(MouseEvent e){
        l.setBackground(Color.WHITE);
        l.setText("You left!!");
    }
    
    public void mouseEntered(MouseEvent e){
        l.setBackground(Color.WHITE);
        l.setText("Welcome back!!");
    }
    
    public void mouseReleased(MouseEvent e){
        l.setBackground(Color.GREEN);
        l.setText("I am released!!");
    }
    
    public void mousePressed(MouseEvent e){
        l.setBackground(Color.RED);
        l.setText("You are pressing me!!");
    }
    
    public void mouseClicked(MouseEvent e){
        ctr.setText((++clicks)+" clicks");
    }
    
    public static void main(String args[]){
        new MouseEventViewer();
    } 
}
