import java.awt.*;
import java.awt.event.*;

class LightBtn extends Button{
    public int state = 0;
    LightBtn(String lab, int s, Panel p, TrafficLight han){
        state = s;
        setLabel(lab);
        addActionListener(han);
        p.add(this);
    }
}

class LightView extends Panel{
    int xoffset = 20, yoffset = 20, state = 0;
    public Graphics g;
    
    void setState(int state){
        this.state = state;
        System.out.println("State: "+state);
        redraw();
    }
    
    void redraw(){
        System.out.println("Redraw "+state);
        g.setColor(Color.black);
        g.fillRect(xoffset+0,yoffset+0,110,300);
        g.setColor(Color.red);
        g.drawOval(xoffset+20, yoffset+20, 70, 70);
        if(state == 0)
            g.fillOval(xoffset+20, yoffset+20, 70, 70);
        g.setColor(Color.yellow);
        g.drawOval(xoffset+20, yoffset+110, 70, 70);
        if(state == 1)
            g.fillOval(xoffset+20, yoffset+110, 70, 70);
        g.setColor(Color.green);
        g.drawOval(xoffset+20, yoffset+200, 70, 70);
        if(state == 2)
            g.fillOval(xoffset+20, yoffset+200, 70, 70);
    }
    
    public void paint(Graphics g){
        this.g = g;
        redraw();
    }
}

class TrafficLight extends Frame implements ActionListener{
    LightView lp;
    TrafficLight(){
        lp = new LightView();
        lp.setSize(250,500);
        lp.setLayout(null);
        add(lp);
        
        Panel p = new Panel();
        p.setBounds(200, 0, 250, 500);
        LightBtn r = new LightBtn("Stop", 0, p, this);
        r.setBounds(100, 50, 50, 50);
        LightBtn y = new LightBtn("Wait", 1, p, this);
        y.setBounds(100, 120, 50, 50);
        LightBtn g = new LightBtn("Go", 2, p, this);
        g.setBounds(100, 190, 50, 50);
        p.setLayout(null);
        add(p);
        
        setSize(500,500);
        setLayout(null);
        setTitle("Traffic Signal");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        LightBtn btn = (LightBtn) e.getSource();
        lp.setState(btn.state);
    }
    
    public static void main(String args[]){
        new TrafficLight();
    }
}
