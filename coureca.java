import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
import java.sql.ResultSet;



class coureca extends JFrame implements ActionListener
{

	
        JLabel ladm,lcoid,lconm,lcopd,ltnm,lcof,lcof1; 
        JTextField tcoid,tconm,tcopd,ttnm,tcof,tcof1; 
        JButton bopen,bdel,bcle,bcan;
	Font fo=new Font("Verdana" ,Font.BOLD,20);	

	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pst;
	

	
//Table
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);	


	   coureca()
	    {
                setSize(420,520);
	    	
	    	setLayout(null);
	    	setTitle(" COURSE RECORD");
	    	setResizable(false);
               	setLocation(400,160);
	    	
                ladm=new JLabel("SEARCH COURSE");
	    	ladm.setBounds(140,30,270,30);
		ladm.setFont(fo);
		ladm.setForeground(Color.red);		    	


                lcoid=new JLabel("Course Id :");
	    	lcoid.setBounds(20,90,100,30);
                tcoid=new JTextField(5);
	    	tcoid.setBounds(150,90,90,25);
	    	
                lconm=new JLabel("Course Name :");
	    	lconm.setBounds(20,140,110,30);
                tconm=new JTextField(25);
	    	tconm.setBounds(150,140,90,25);
	    	
	    		
                lcopd=new JLabel("Course Period :");
	    	lcopd.setBounds(20,190,120,25);
                tcopd=new JTextField(30);
	    	tcopd.setBounds(150,190,90,25);
	    		    	
                 lcof=new JLabel("Onetime Fees :");
	    	lcof.setBounds(20,240,110,25);
                tcof=new JTextField(20);
	    	tcof.setBounds(150,240,90,25);
	    	
                lcof1=new JLabel("Installment Fees:");
	    	lcof1.setBounds(20,290,140,25);
                tcof1=new JTextField(20);
	    	tcof1.setBounds(150,290,90,25);

             
	    	
                bopen=new JButton("Search");
	    	bopen.setBounds(40,340,90,25);
		bopen.addActionListener(this);
		
		bcle=new JButton("Clear");
	    	bcle.addActionListener(this);
	    	bcle.setBounds(175,340,80,25);
                              
                bcan=new JButton("ALL");
		bcan.addActionListener(this);
	    	bcan.setBounds(300,340,80,25);
	    	    	    	
	         add(ladm);
	        add(lcoid);
	        add(tcoid);
	        add(lconm);
	        add(tconm);
	        add(lcopd);
	        add(tcopd);
	        
	        
	        add(lcof);
	        add(tcof);
    
                 add(lcof1);
                 add(tcof1);
	        
	    	add(bopen);
	    	add(bcle);
	    	add(bcan);
tcoid.addKeyListener(new KeyAdapter()
    {
        public void keyTyped(KeyEvent e) {
    	char c = e.getKeyChar();
      		if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))))
      		{
        	 JOptionPane.showMessageDialog(null, "Please enter a numerical value");
           	 e.consume();
      		}
    		}
  		    });

// Table
    scrlPane.setBounds(0,390,416,200);
   add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));

  model.addColumn("C_ID");
    model.addColumn("C_NAME");
    model.addColumn("C_PERIOD");
    model.addColumn("O_FEE");
    model.addColumn("I_FEE");


		setVisible(true);					
					tconm.setEnabled(false);
					tcopd.setEnabled(false);
					tcof.setEnabled(false);
                                        tcof1.setEnabled(false);
	    }
	    public void actionPerformed(ActionEvent ae)
	    {
		if(ae.getSource()==bopen)
			{
    	
    			 try
	               	{
	               	     Class.forName("com.mysql.jdbc.Driver");
	                     con= DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	                     stmt= con.createStatement();
	                     String id=tcoid.getText();
	                     
                         String qry= "select * from Course where co_id="+id+"";
	                     rs = stmt.executeQuery(qry);
	                     while(rs.next())
                         {
                           tconm.setText(rs.getString(2));
                           tcopd.setText(rs.getString(3));
                           tcof.setText(rs.getString(4));  
                           tcof1.setText(rs.getString(5));

				tconm.setEnabled(true);
				tcopd.setEnabled(true);
				tcof.setEnabled(true);
                                tcof1.setEnabled(true);
                                                      
                         }
       
                        con.close();
	               			
	               	}
	               	catch(Exception ex)
            {
                    JOptionPane.showMessageDialog(null,"Error Occured : " + ex);
            }
		  			 
	    
                         }

	    	  if(ae.getSource()==bcle)
	    	  {
	    	  	  tcoid.setText(" ");
	    	  	  tconm.setText(" ");
	    	  	  tcopd.setText(" ");
	    	  	  tcof1.setText(" ");
	    	  	  tcof.setText(" "); 
                           tconm.setEnabled(false);
					tcopd.setEnabled(false);
					tcof.setEnabled(false);
                                        tcof1.setEnabled(false);
	    	  }


			if(ae.getSource()==bcan)
 			{
		  int r = 0;
while(model.getRowCount() > 0)
{
    model.removeRow(0);
}
        
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cnDriver = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
                Statement stmt = cnDriver.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * from Course" );
				
                while(rs.next())
                {
                	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5) });
                }
            }

            catch(Exception ex)
            {
                    JOptionPane.showMessageDialog(null,"Error Occured : " + ex);
            }
			}

				
				


	    }
	    public static void main (String args[]) 
	    	{
					new coureca();
						   }	
	    	
	    	
	    
}
