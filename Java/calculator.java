import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;

import javax.swing.plaf.LabelUI;

class ButtonLayoutHandler {
    public final int padding = 10;
    private Dimension btnDim, frameDim;
    private int margin, x, y, col, row, ci = 0;
    ButtonLayoutHandler(int frameW, int frameH, int rowCount, int colCount, int margin){
        x = y = this.margin = margin;
        btnDim = new Dimension();
        frameDim = new Dimension();
        col = colCount;
        row = rowCount;
        int dw = (frameW-2*margin-padding*(col-1))/col;
        int dh = (frameW-margin-margin/2-padding*(row-1))/row;
        btnDim.setSize(dw, dh);
        frameDim.setSize(frameW, frameH);
    }

    Rectangle getNextButtonDim(){
        Rectangle r = new Rectangle();
        r.setBounds(x, y, btnDim.width, btnDim.height);
        x = x + btnDim.width + padding;
        ci++;
        if(ci >= col){
            y = y + btnDim.height + padding;
            x = margin;
            ci = 0;
        }
        return r;
    }

    Dimension getFrameDim(){
        return frameDim;
    }
}

class DisplayHandler{
    static Label display;
    DisplayHandler(){}
    DisplayHandler(Label disp){
        display = disp;
    }
    void show(String s){
        display.setText(s);
    }
}

class Evaluate {
    static double n1 = 0;
    static double n2 = 0;
    static char op = '\0';
    DisplayHandler disp = new DisplayHandler();
    
    void clear(){
        n1 = 0;
        n2 = 0;
        op = '\0';
        disp.show("0");
    }

    void setOp(char o){
        if(o == 'C')
            clear();
        else if(o == '=')
            eval();
        else if(op != '\0'){
            eval();
            op = o;
        }
        else
            op = o;
    }
    
    void putNum(double digit){
        if(op != '\0'){
            n2 = n2*10+digit;
            disp.show(Integer.toString((int)n1)+" "+op+" "+Integer.toString((int)n2));
        }
        else{
            n1 = n1*10+digit;
            disp.show(Integer.toString((int)n1));
        }
    }
    
    void eval(){
        try{
            switch(op){
                case '+':
                    n1 = n1+n2;
                    break;
                case '-':
                    n1 = n1-n2;
                    break;
                case '*':
                    n1 = n1*n2;
                    break;
                case '/':
                    n1 = n1/n2;
                    break;
            }
        }catch(Exception e){
            clear();
            disp.show(e.getClass().toString());
        }
        n2 = 0;
        op = '\0';
        disp.show(Double.toString(n1));
    }
}

class NumBtn extends Button {
    public double val;
    NumBtn(double value, ButtonLayoutHandler layout, NumClickHandler handler, Panel f){
        val = value;
        setBounds(layout.getNextButtonDim());
        setLabel(Integer.toString((int)val));
        addActionListener(handler);
        setBackground(Color.decode("#2b2b2b"));
        setForeground(Color.white);
        f.add(this);
    }
}

class OperatorBtn extends Button {
    public char val;
    OperatorBtn(char value, OperatorClickHandler handler, Panel f){
        setLabel(""+value);
        val = value;
        addActionListener(handler);
        setForeground(Color.WHITE);
        setBackground(Color.decode("#dc8c00"));
        f.add(this);
    }
    OperatorBtn(char value, ButtonLayoutHandler layout, OperatorClickHandler handler, Panel f){
        val = value;
        setBounds(layout.getNextButtonDim());
        setLabel(""+value);
        addActionListener(handler);
        setForeground(Color.WHITE);
        setBackground(Color.decode("#dc8c00"));
        f.add(this);
    }
}

class NumClickHandler implements ActionListener {
    Evaluate eval = new Evaluate();
    @Override
    public void actionPerformed(ActionEvent e) {
        NumBtn src = (NumBtn) e.getSource();
        eval.putNum(src.val);
    }
}

class OperatorClickHandler implements ActionListener {
    Evaluate eval = new Evaluate();
    @Override
    public void actionPerformed(ActionEvent e) {
        OperatorBtn src = (OperatorBtn) e.getSource();
        eval.setOp(src.val);
    }
}

class Calculator extends Frame{
    final int windowW = 500,
              windowH = 360,
              dispPad = 20,
              padding = 10,
              dispH = 50,
              numPadW = windowW/2,
              numpadH = windowH - dispH - 2*dispPad,
              panelOffset = dispH+2*dispPad+10;

    Calculator(){
        setFont(new Font("monospaced", Font.BOLD, 30));

        // Initialize Display
        Label display = new Label("BASIC CALCULATOR");
        display.setBounds(dispPad, dispPad*2, windowW-2*dispPad, dispH);
        display.setBackground(Color.white);
        display.setAlignment(Label.RIGHT);
        add(display);

        // Initialize DisplayHandler
        new DisplayHandler(display);

        // Initialize Number Pad
        NumClickHandler numH = new NumClickHandler();
        ButtonLayoutHandler numpadLt = new ButtonLayoutHandler(numPadW, numpadH, 4, 3, padding);
        Panel numpad = new Panel();
        numpad.setBackground(Color.BLACK);
        numpad.setBounds(0, panelOffset, numPadW, numpadH);
        numpad.setLayout(null);
        for(int i=1; i<10; i++)
            new NumBtn(i, numpadLt, numH, numpad);
        new NumBtn(0, numpadLt, numH, numpad);

        // Initialize Operations Pad
        OperatorClickHandler opH = new OperatorClickHandler();
        ButtonLayoutHandler fnLt = new ButtonLayoutHandler(numPadW, numpadH, 5, 1, padding);
        Panel opList = new Panel();
        opList.setBackground(Color.BLACK);
        opList.setBounds(numPadW, panelOffset, numPadW, numpadH);
        opList.setLayout(null);

        OperatorBtn eq = new OperatorBtn('=', opH, numpad);
        Rectangle eqr = numpadLt.getNextButtonDim();
        eqr.width = eqr.width*2 + numpadLt.padding;
        eq.setBounds(eqr);
        OperatorBtn cls = new OperatorBtn('C', fnLt, opH, opList);
        cls.setBackground(Color.red);
        new OperatorBtn('+', fnLt, opH, opList);
        new OperatorBtn('-', fnLt, opH, opList);
        new OperatorBtn('*', fnLt, opH, opList);
        new OperatorBtn('/', fnLt, opH, opList);

        add(numpad);
        add(opList);

        setSize(windowW, windowH);
        setTitle("Calculator");
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
