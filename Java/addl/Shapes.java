import java.awt.*;
import java.applet.Applet;

/* 
<applet code="Shapes.class" width="360" height="350"></applet>
*/  

class Square{
    private int x, y, s; 
    Square(int x, int y, int s){
        this.x = x;
        this.y = y;
        this.s = s;
    }
    void draw(Graphics g){
        g.drawRect(x, y, s, s);
    }
}

class Oval{
    private int x, y, w, h; 
    Oval(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    void draw(Graphics g){
        g.setColor(Color.red);
        g.drawOval(x, y, w, h);
    }
}

class Line{
    private int x1, y1, x2, y2; 
    Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    void draw(Graphics g){
        g.setColor(Color.blue);
        g.drawLine(x1, y1, x2, y2);
    }
}



public class Shapes extends Applet{
    public void paint(Graphics g){
        Square s = new Square(10,10,100);
        Oval o = new Oval(110,110,100,100);
        Line l = new Line(230, 230, 330, 330);
        s.draw(g);
        o.draw(g);
        l.draw(g);
    }    
}
