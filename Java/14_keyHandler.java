/** @author Gokul Raj | 235 | R3A | CSE
 * AIM: Write a Java program for handling key events using Adapter Class
 * PROGRAM 14: Key Event Handling 
 */
import java.awt.*;
import java.awt.event.*;

class KeyHandler extends Frame{
    // Constructor for assembling GUI
    KeyHandler(){
        Font f = new Font("monospaced", Font.BOLD, 24);
        setSize(500,100);
        setTitle("Key Handler");
        Label disp = new Label("Press any key");
        disp.setBounds(50, 35, 400, 50);
        add(disp);
        // Create an instance of KeyAdapter to use as KeyListener
        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                disp.setText(String.format("You are pressing \'%c\'", e.getKeyChar()));
            }
            public void keyReleased(KeyEvent e){
                disp.setText("Key Released!!");
            }
        });
        // WindowListener to close window on click exit
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){System.exit(0);}
        });
        setLayout(null);
        setFont(f);
        setVisible(true);
    }
    public static void main(String[] args) {
        new KeyHandler();
    }
}