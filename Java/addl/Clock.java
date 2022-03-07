import java.awt.*;
import java.applet.Applet;
import java.util.Calendar;
/* 
<applet code="Clock.class" width="300" height="300"></applet>
*/  

class ClockFace{
    private int w, h;
    private Graphics g;
    private final int OFFSET = 30;
    private int center, radius;
    
    void clearScreen(){
        g.setColor(Color.white);
        g.fillRect(0,0,w,h); 
        g.setColor(Color.black);
    }
    
    void drawHand(int l, int ang){
        int dx = (int) (l*Math.cos(Math.toRadians(ang-90)));
        int dy = (int) (l*Math.sin(Math.toRadians(ang-90)));
        g.drawLine(center, center, center+dx, center+dy);
    }
    
    void drawMarkings(int len){
        for(int ang=0; ang<=360; ang+=30){
            int dx = (int) (radius*Math.cos(Math.toRadians(ang-90)));
            int dy = (int) (radius*Math.sin(Math.toRadians(ang-90)));
            
            int dx1 = (int) ((radius-len)*Math.cos(Math.toRadians(ang-90)));
            int dy1 = (int) ((radius-len)*Math.sin(Math.toRadians(ang-90)));
            g.drawLine(center+dx1, center+dy1, center+dx, center+dy);
        }
    }
    
    void showTime(int hr, int min, int sec){
        final int size = w-2*OFFSET;
        clearScreen();
        g.drawOval(OFFSET, OFFSET, size, size);
        drawMarkings(15);
        int hrAngle = (hr%12*30);
        int hrDelta = (int) Math.ceil(min/60.0*30.0);
        int minAngle = min%60*6;
        int minDelta = (int) Math.ceil(sec/60.0*6.0);
        int secAngle = sec%60*6;
        // draw Hour
        g.setColor(Color.blue);
        drawHand(radius-60, hrAngle+hrDelta);
        // draw Minute
        drawHand(radius-40, minAngle+minDelta);
        g.setColor(Color.red);
        drawHand(radius-20, secAngle);
    }
    
    ClockFace(Graphics g, int w, int h){
        this.w = w;
        this.h = h;
        this.g = g;
        // Draw Clock Circle
        final int size = w-2*OFFSET;
        this.center = size/2+OFFSET;
        this.radius = size/2;
    }
}

public class Clock extends Applet{
    ClockFace c;
    public void paint(Graphics g){
        final int WIDTH = getWidth();
        final int HEIGHT = getHeight();
        c = new ClockFace(g, WIDTH, HEIGHT);
        while(true){
            Calendar dt = Calendar.getInstance();
            c.showTime(dt.get(Calendar.HOUR), dt.get(Calendar.MINUTE), dt.get(Calendar.SECOND));
            System.out.printf("Time is: %d:%d:%d\n", dt.get(Calendar.HOUR), dt.get(Calendar.MINUTE), dt.get(Calendar.SECOND));
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                System.out.println("Interrupt Recieved!!");
            }
        }
    }
}
