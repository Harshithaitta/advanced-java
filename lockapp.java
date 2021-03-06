Create a Java Swing GUI application for an electronic lock as shown below. The display shall show the state of either "CLOSE" or "OPEN". In
the ";CLOSE" state, the user types his PIN followed by the "Enter" key to unlock the system. The display shall show an asterisk (*) for each
number entered. The display shall show "WRONG PIN" if the PIN is incorrect. The "Clear" button clears the number entered (if any), locks the
system and sets the display to "CLOSE".

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LockApp extends JFrame
{
JButton[] btn;
JButton btncl,btnen;
JTextField tf;
JPanel pg,pb;
String nums="",msg="",pin="123";

public LockApp()
{
pg=new JPanel(new FlowLayout());
tf=new JTextField(30);

pg.add(tf);
pb=new JPanel(new GridLayout(4,3));
btn=new JButton[10];

for(int i=1;i<=9;i++)
{
btn[i]=new JButton(Integer.toString(i));
pb.add(btn[i]);
}
btncl=new JButton("Clear");
pb.add(btncl);
btn[0]=new JButton(Integer.toString(0));
pb.add(btn[0]);
btnen=new JButton("Enter");
pb.add(btnen);
for(int n=1;n<=9;n++)
{
btn[n].addActionListener(new BtnListener1());
}
btncl.addActionListener(new BtnListener2());
btnen.addActionListener(new BtnListener2());

setLayout(new BorderLayout());
add(pg, BorderLayout.NORTH);
add(pb, BorderLayout.CENTER);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("BorderLayout Demo");
setSize(450,400);
setVisible(true);
}
public static void main(String[] args)
{
new LockApp();
}
private class BtnListener1 implements ActionListener
{
public void actionPerformed(ActionEvent evt)
{
nums+=evt.getActionCommand();
msg+="*";
tf.setText(msg);
}
}
private class BtnListener2 implements ActionListener
{
public void actionPerformed(ActionEvent evt)
{
if(evt.getSource()==btncl)
{
tf.setText("CLOSE");
nums="";
msg="";
}
else if(evt.getSource()==btnen)
{
if(checkPIN(nums))
unlock();
else
lock();
}
}
public boolean checkPIN(String p)
{
if(p.equals(pin))
return true;
else
return false;
}
public void unlock()
{
tf.setText("OPEN");
}
public void lock()
{
tf.setText("WRONG PIN");
}
}
}
/*
<applet code="LockApp.class" width=300 height=300>
</applet>
*/ 
