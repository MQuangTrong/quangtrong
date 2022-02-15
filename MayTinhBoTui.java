/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaNC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author LENOVO
 */
public class MayTinhBoTui extends JFrame implements ActionListener {
    private double b;
    private JPanel panelcalculator,mainPanel,panelOUTPUT;
    private JTextArea textarea;
    private String btnName[] = { "^_^", "C", "Del" , "+",
                                "7", "8", "9", "/",
                                "4", "5", "6", "*",
                                "1", "2", "3", "-",
                                "neg", "0", ".", "="};
    private JButton btn;
    private double a =0;
    private int casenumber = 0;
    private double result = 0;
    
    /*Hàm tạo panel chính*/
public JPanel createmainFrame()
{
     setTitle("May Tinh Bo tui");
 
     mainPanel = new JPanel(new BorderLayout(4,5));
     mainPanel.add(createButtonofCalculator(),BorderLayout.CENTER);
     mainPanel.add(createTextArea(),BorderLayout.NORTH);
     mainPanel.setBackground(Color.DARK_GRAY);
     return mainPanel;
}
/*Khởi tạo jbutton*/
private JButton myButton(String btnname)
{
     btn = new JButton(btnname);
     btn.setBackground(Color.DARK_GRAY);
     btn.setForeground(Color.WHITE);
     btn.addActionListener(this);
     return btn;
}    
/*Add các jbutton vào panel*/
public JPanel createButtonofCalculator()
{
     panelcalculator = new JPanel(new GridLayout(5, 4));
     for(int i=0;i<btnName.length;i++)
     {
          panelcalculator.add(myButton(btnName[i]));
     }
     panelcalculator.setBackground(Color.white);
     return panelcalculator;
 
}
/* Khởi tạo jtextarea */
     private JPanel createTextArea() {
     panelOUTPUT = new JPanel(new GridLayout(1, 1));
     textarea = new JTextArea(3, 3);
     textarea.setBackground(Color.GRAY);
     textarea.setForeground(Color.WHITE);
     panelOUTPUT.add(textarea);
     textarea.setEditable(false);
     return panelOUTPUT;
 
}
       @Override
public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand() == "1")
          textarea.append("1");
      if(e.getActionCommand()=="2")
          textarea.append("2");
      if(e.getActionCommand()=="3")
          textarea.append("3");
      if(e.getActionCommand()=="4")
          textarea.append("4");
      if(e.getActionCommand()=="5")
          textarea.append("5");
      if(e.getActionCommand()=="6")
           textarea.append("6");
      if(e.getActionCommand()=="7")
           textarea.append("7");
      if(e.getActionCommand()=="8")
          textarea.append("8");
      if(e.getActionCommand()=="9")
          textarea.append("9");
      if(e.getActionCommand()=="0")
           textarea.append("0");
      if(e.getActionCommand()==".")
           textarea.append(".");
      if(e.getActionCommand()=="neg")//Dấu âm (negative)
           textarea.append("-");
 
      if(e.getActionCommand()=="+")
      {
          a = Double.parseDouble(textarea.getText());
           casenumber= 1;
          textarea.setText("");
      }
      if(e.getActionCommand()=="-")
      {
          a = Double.parseDouble(textarea.getText());
          casenumber= 2;
          textarea.setText("");
      }
 
      if(e.getActionCommand()=="*")
      {
          a = Double.parseDouble(textarea.getText());
          casenumber= 3;
          textarea.setText("");
      }
 
      if(e.getActionCommand()=="/")
      {
          a = Double.parseDouble(textarea.getText());
           casenumber= 4;
           textarea.setText("");
      }
 
      if(e.getActionCommand()=="=")
      {
          b=Double.parseDouble(textarea.getText());
           switch(casenumber)
      {
          case 1: result = a+b;
          break;
 
          case 2: result=a-b;
          break;
 
          case 3: result=a*b;
           break;
 
          case 4: result=a/b;
          break;
 
          default: result=0;
      }
     textarea.setText(new Double(result).toString());
 }
 
 if(e.getActionCommand()=="Del")
 {
     String s=textarea.getText();
      textarea.setText("");
     for(int i=0;i<s.length()-1;i++){
          textarea.setText(textarea.getText()+s.charAt(i));
      }
 
 if(e.getActionCommand()=="C")
      textarea.setText("");
 }

}
public MayTinhBoTui(){
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setSize(240,330);
     setLocationRelativeTo(null);
     setResizable(false);
     Component add = add(createmainFrame());
}
public static void main(String[] args) {
    new MayTinhBoTui().setVisible(true);
}
}
