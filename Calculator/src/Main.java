import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Font buttonFont = new Font(Font.MONOSPACED,Font.BOLD,35);
        Font screenFont = new Font(Font.MONOSPACED,Font.BOLD,45);
        JTextField screen = new JTextField();
        screen.setFont(screenFont);
        ScreenManager sm = new ScreenManager(screen);
        JFrame f=new JFrame();

        JButton addBtn=new JButton("+");
        JButton subBtn=new JButton("-");
        JButton mulBtn=new JButton("X");
        JButton divBtn=new JButton("/");
        JButton oneBtn=new JButton("1");
        JButton twoBtn=new JButton("2");
        JButton threeBtn=new JButton("3");
        JButton fourBtn=new JButton("4");
        JButton fiveBtn=new JButton("5");
        JButton sixBtn=new JButton("6");
        JButton sevenBtn=new JButton("7");
        JButton eightBtn=new JButton("8");
        JButton nineBtn=new JButton("9");
        JButton zeroBtn=new JButton("0");
        JButton clearBtn=new JButton("C");
        JButton equalBtn=new JButton("=");

        addBtn.setFont(buttonFont);
        subBtn.setFont(buttonFont);
        mulBtn.setFont(buttonFont);
        divBtn.setFont(buttonFont);
        oneBtn.setFont(buttonFont);
        twoBtn.setFont(buttonFont);
        threeBtn.setFont(buttonFont);
        fourBtn.setFont(buttonFont);
        fiveBtn.setFont(buttonFont);
        sixBtn.setFont(buttonFont);
        sevenBtn.setFont(buttonFont);
        eightBtn.setFont(buttonFont);
        nineBtn.setFont(buttonFont);
        zeroBtn.setFont(buttonFont);
        clearBtn.setFont(buttonFont);
        equalBtn.setFont(buttonFont);


        oneBtn.setBounds(5,400,100, 40);//x-axis, y-axis, width, height
        twoBtn.setBounds(110,400,100,40);
        threeBtn.setBounds(215,400,100,40);
        addBtn.setBounds(320,400,100,40);
        fourBtn.setBounds(5,355,100,40);
        fiveBtn.setBounds(110,355,100,40);
        sixBtn.setBounds(215,355,100,40);
        subBtn.setBounds(320,355,100,40);
        sevenBtn.setBounds(5,310,100,40);
        eightBtn.setBounds(110,310,100,40);
        nineBtn.setBounds(215,310,100,40);
        mulBtn.setBounds(320,310,100,40);
        divBtn.setBounds(320,265,100,40);
        zeroBtn.setBounds(110,265,100,40);
        clearBtn.setBounds(5,265,100,40);
        equalBtn.setBounds(215,265,100,40);

        screen.setBounds(0,0,440,100);

        addBtn.addActionListener(e -> sm.addTextToScreen("+"));
        subBtn.addActionListener(e -> sm.addTextToScreen("-"));
        divBtn.addActionListener(e -> sm.addTextToScreen("/"));
        mulBtn.addActionListener(e -> sm.addTextToScreen("*"));
        oneBtn.addActionListener(e -> sm.addTextToScreen("1"));
        twoBtn.addActionListener(e -> sm.addTextToScreen("2"));
        threeBtn.addActionListener(e -> sm.addTextToScreen("3"));
        fourBtn.addActionListener(e -> sm.addTextToScreen("4"));
        fiveBtn.addActionListener(e -> sm.addTextToScreen("5"));
        sixBtn.addActionListener(e -> sm.addTextToScreen("6"));
        sevenBtn.addActionListener(e -> sm.addTextToScreen("7"));
        eightBtn.addActionListener(e -> sm.addTextToScreen("8"));
        nineBtn.addActionListener(e -> sm.addTextToScreen("9"));
        zeroBtn.addActionListener(e -> sm.addTextToScreen("0"));
        clearBtn.addActionListener(e -> screen.setText(""));
        equalBtn.addActionListener(e -> sm.calculate());

        f.add(addBtn);
        f.add(subBtn);
        f.add(mulBtn);
        f.add(divBtn);
        f.add(oneBtn);
        f.add(twoBtn);
        f.add(threeBtn);
        f.add(fourBtn);
        f.add(fiveBtn);
        f.add(sixBtn);
        f.add(sevenBtn);
        f.add(eightBtn);
        f.add(nineBtn);
        f.add(zeroBtn);
        f.add(clearBtn);
        f.add(equalBtn);
        f.add(screen);

        f.setSize(440,500);//400 width and 500 height
        f.setResizable(false);
        f.setTitle("Calculator");
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }



}

class ScreenManager{
    boolean error = false;
    JTextField screen;
    float operand1,operand2,result;
    String operator;
    ScreenManager(JTextField screen){
        this.screen = screen;
    }

    public void addTextToScreen(String text){
        String currentText = screen.getText();
        if(text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/") && !currentText.isBlank()){
            operand1 = Float.parseFloat(currentText);
            screen.setText("");
            operator = text;
        }else{
            currentText += text;
            screen.setText(currentText);
        }
    }

    public void calculate(){
        String currentText = screen.getText();
        if(!currentText.isBlank()){
            operand2 = Float.parseFloat(currentText);
            switch (operator){
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    try{
                        result = operand1 / operand2;
                    }catch (Exception e){
                        error = true;
                    }
                    break;
                default:
                    error = true;
            }
            if(error){
                screen.setText("ERROR");
            }else{
                screen.setText(String.valueOf(result));
            }
        }
    }
}