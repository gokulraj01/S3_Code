/** @author Gokul Raj | 235 | R3A | CSE
 * AIM: Write a Java program that allows user to draw lines, rectangles, ovals
 * PROGRAM 15: Drawing in AWT
 */
import java.awt.*;
import java.awt.event.*;

class Tool extends Button{
    public char value;
    Tool(String name, char val, Panel root, ActionListener al){
        value = val;
        setLabel(name);
        addActionListener(al);
        root.add(this);
    }
}

class Toolkit extends Panel implements ActionListener{
    public static char value;
    Toolkit(){
        setSize(100,500);
        Tool c = new Tool("Oval", 'O', this, this);
        c.setBounds(20, 70, 60, 100);
        Tool l = new Tool("Line", 'L', this, this);
        l.setBounds(20, 180, 60, 100);
        Tool r = new Tool("Rect", 'R', this, this);
        r.setBounds(20, 290, 60, 100);
        setLayout(null);
        setVisible(true);
        setBackground(Color.decode("#1366bb"));
    }

    public void actionPerformed(ActionEvent e) {
        Tool src = (Tool)e.getSource();
        value = src.value;
    }
}


class Canvas extends Panel implements MouseListener{
    Point p1, p2;
    Canvas(){
        setSize(400,500);
        setLayout(null);
        addMouseListener(this);
        setVisible(true);
    }
    public void mousePressed(MouseEvent e) {
        p1 = e.getPoint();
    }
    public void mouseReleased(MouseEvent e) {
        p2 = e.getPoint();
        Graphics g = getGraphics();
        switch(Toolkit.value){
            case 'O':
                g.drawOval(p1.x, p1.y, Math.abs(p2.x-p1.x), Math.abs(p2.y-p1.y));
                break;
            case 'L':
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                break;
            case 'R':
                g.drawRect(p1.x, p1.y, Math.abs(p2.x-p1.x), Math.abs(p2.y-p1.y));
                break;
        }
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

class Painter extends Frame{
    Painter(){
        setTitle("Painter");
        Canvas can = new Canvas();
        can.setBounds(100,0,400,500);
        add(can);
        Toolkit tk = new Toolkit();
        tk.setBounds(0,0, 100, 500);
        add(tk);
        // WindowListener to close window on click exit
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){System.exit(0);}
        });
        setSize(500,500);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Painter();
    }
}