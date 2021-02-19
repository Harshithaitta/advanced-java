import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class task extends JFrame
{
	JTextField tname,tage,tocc,tsal,tany;
	JPanel c;
	JLabel name,age,occ,sal,any;
	JButton submit;
	String n,s,a,o,an,st;
	public task()
	{
		c = new JPanel(new GridLayout(5,2));
		name=new JLabel("Name");
		c.add(name);
		tname=new JTextField();
		c.add(tname);
		age=new JLabel("Age");
		c.add(age);
		tage=new JTextField();
		c.add(tage);
		occ=new JLabel("Occupation");
		c.add(occ);
		tocc=new JTextField();
		c.add(tocc);
		sal=new JLabel("Salary");
		c.add(sal);
		tsal=new JTextField();
		c.add(tsal);
		any=new JLabel("Anything");
		c.add(any);
		tany=new JTextField();
		c.add(tany);
		submit=new JButton("Submit"); 
		submit.addActionListener(new sub());
		setLayout(new BorderLayout());
		add(c,BorderLayout.NORTH);
		add(submit,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,200);
		setVisible(true);
		
	}
	public static void main(String args[])
	{
		new task();
	}
	private class sub implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			if(evt.getSource()==submit)
			{
			n=tname.getText();
			st=tage.getText();
			o=tocc.getText();
			s=tsal.getText();
			an=tany.getText();
			try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
					Statement stmt=con.createStatement();
					stmt.executeUpdate("INSERT INTO empp1 values(n,a,o,s,an)");
					stmt.close();
					con.close();
				}
				catch(ClassNotFoundException e){
					System.out.println("Exception:"+"oracle driver not available"+e.getMessage());
				}	
				catch(SQLException e){
					System.out.println("Exception:"+"improper syntax in statement  "+e.getMessage());
				}
			}
		}
	}
		
}
