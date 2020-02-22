import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SimpleCalc1 extends JFrame implements ItemListener
{
   JLabel lnum1, lnum2;
   JTextField tnum1, tnum2, tres;
   JComboBox optr;
   String optrs[] = {"Add", "Subtract", "Multiply", "Divide"};
   Container c = getContentPane();
   
   SimpleCalc1() //constructor serves as 1. GUI Components
   {
      super("Simple Calculator v1");
      lnum1 = new JLabel("Input num1: ");
      lnum2 = new JLabel("Input num2: ");
      optr = new JComboBox(optrs);
      
      tnum1 = new JTextField(5);
      tnum2 = new JTextField(5);
      tres = new JTextField(5); tres.setEditable(false);
      
      optr.addItemListener(this);
      
      c.setLayout(new GridLayout(3,2));
      c.add(lnum1); c.add(tnum1);
      c.add(lnum2); c.add(tnum2);
      c.add(optr); c.add(tres);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(300, 200);
      setResizable(false);
      setVisible(true);
   }
   
   public void itemStateChanged(ItemEvent e)//2. Listener Method
   {
      double num1 =0, num2=0, res=0;

      try
      {
         num1 = Double.parseDouble(tnum1.getText());
         num2 = Double.parseDouble(tnum2.getText());
         
         if(optr.getSelectedIndex()==0)
         {
            res = add(num1, num2);
         }
         else
         if(optr.getSelectedItem().equals("Subtract"))
         {
            res = subtract(num1, num2);
         }
         else
         if(optr.getSelectedIndex()==2)
         {
            res = multiply(num1, num2);
         }
         else
         if(optr.getSelectedIndex()==3)
         {
            res = divide(num1, num2);
         }
         tres.setText(res+"");
      }

      catch(NumberFormatException nfe)
      {
         tres.setText("Boang ka!");
      }
      catch(Exception ex)
      {
      
      }
   }
   
   //3. Application Methods
   public double add(double num1, double num2)
   {
      return num1 + num2;
   }
   public double subtract(double num1, double num2)
   {
      return num1 - num2;
   }
   public double multiply(double num1, double num2)
   {
      return num1 * num2;
   }
   public double divide(double num1, double num2)
   {
      return num1 / num2;
   }
 
}

//--------------------------------------------
public class SimpleCalcDemo1
{
   public static void main(String args[])
   {
      new SimpleCalc1();
      
   }
}