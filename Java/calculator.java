import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;

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

class NumBtn extends Button {
    public int val;
    NumBtn(int value, ButtonLayoutHandler layout, NumClickHandler handler, Panel f){
        val = value;
        setBounds(layout.getNextButtonDim());
        setLabel(Integer.toString(val));
        addActionListener(handler);
        setBackground(Color.decode("#2b2b2b"));
        setForeground(Color.white);
        f.add(this);
    }
}

class NumClickHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        NumBtn src = (NumBtn) e.getSource();
        System.out.println("Clicked: "+src.val);
    }
}

class OperatorBtn extends Button {
    public char val;
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

class OperatorClickHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        OperatorBtn src = (OperatorBtn) e.getSource();
        System.out.println("Clicked Operator: "+src.val);
    }
}

class Calculator extends Frame{
    final int windowW = 500*2,
              windowH = 360*2,
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

        // Initialize Number Pad
        NumClickHandler numH = new NumClickHandler();
        ButtonLayoutHandler numpadLt = new ButtonLayoutHandler(numPadW, numpadH, 4, 3, padding);
        Panel numpad = new Panel();
        numpad.setBackground(Color.BLACK);
        numpad.setBounds(0, panelOffset, numPadW, numpadH);
        numpad.setLayout(null);
        new NumBtn(1, numpadLt, numH, numpad);
        new NumBtn(2, numpadLt, numH, numpad);
        new NumBtn(3, numpadLt, numH, numpad);
        new NumBtn(4, numpadLt, numH, numpad);
        new NumBtn(5, numpadLt, numH, numpad);
        new NumBtn(6, numpadLt, numH, numpad);
        new NumBtn(7, numpadLt, numH, numpad);
        new NumBtn(8, numpadLt, numH, numpad);
        new NumBtn(9, numpadLt, numH, numpad);
        new NumBtn(0, numpadLt, numH, numpad);
        Button eq = new Button("=");
        Rectangle eqr = numpadLt.getNextButtonDim();
        eqr.width = eqr.width*2 + numpadLt.padding;
        eq.setBounds(eqr);
        numpad.add(eq);
        add(numpad);

        // Initialize Operations Pad
        OperatorClickHandler opH = new OperatorClickHandler();
        ButtonLayoutHandler fnLt = new ButtonLayoutHandler(numPadW, numpadH, 4, 1, padding);
        Panel opList = new Panel();
        opList.setBackground(Color.BLACK);
        opList.setBounds(numPadW, panelOffset, numPadW, numpadH);
        opList.setLayout(null);
        new OperatorBtn('+', fnLt, opH, opList);
        new OperatorBtn('-', fnLt, opH, opList);
        new OperatorBtn('*', fnLt, opH, opList);
        new OperatorBtn('/', fnLt, opH, opList);
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