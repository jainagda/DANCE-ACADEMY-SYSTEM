import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class  Reportenq extends JFrame implements ActionListener
{
	JTextArea ta;
        JScrollPane jsp;
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        Container c = getContentPane();
        JButton display,ok;
        JPanel p1,p2;
         Reportenq()
        {
                setLayout(null);
		setSize(800,800);
                display = new JButton("Display");
                display.setBounds(320,10,120,30);
                add(display);

                ok = new JButton("OK");
                ok.setBounds(320,460,120,30);
                add(ok);

                ta = new JTextArea();
                jsp = new JScrollPane(ta,v,h);
                jsp.setBounds(50,50,700,350);
                c.add(jsp);

                ta.setEditable(false);
                setVisible(true);

                display.addActionListener(this);
                ok.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae)
        {
                if(ae.getSource()==display)
                {
                        
                        try
                        {
                               Class.forName("com.mysql.jdbc.Driver");
  Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
    Statement stmt = c.createStatement();
                                ResultSet rs = stmt.executeQuery("select * from Enquiry");
                                ResultSetMetaData md = rs.getMetaData();
                                int n = md.getColumnCount();
				
                              
                                for(int i=1;i<=n;i++)
                                {
                                        ta.append(md.getColumnName(i)+"\t");
                                }
                                ta.append("\n\n");
                                while(rs.next())
                                {
                                        for(int i=1;i<=n;i++)
                                        {
                                                ta.append(rs.getString(i)+"\t");
						
                                        }
                                        ta.append("\n");
                                }
                        }
                        catch(Exception a)
                        {
                        }
                }
                if(ae.getSource()==ok)
                {
                        setVisible(false);
                }
        }
	public static void main(String a[])
	{
		new  Reportenq();
	}
}


