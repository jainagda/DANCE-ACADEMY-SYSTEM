import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
import java.sql.ResultSet;

class coNameException extends Exception{};
class courec extends JFrame implements ActionListener
{

	
        JLabel ladm,lcoid,lconm,lcopd,ltnm,lcof,lcof1; 
        JTextField tcoid,tconm,tcopd,ttnm,tcof,tcof1; 
        JButton bnew,bupdt,bdel,bcle,badd,bcan;
	Font fo=new Font("Verdana" ,Font.BOLD,20);	

	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pst;
	
	
//Table
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);	



	   courec()
	    {
                setSize(410,570);
	    	
	    	setLayout(null);
	    	setTitle("COURSE RECORD");
	    	setResizable(false);
               	setLocation(300,160);
	    	
                ladm=new JLabel("ADD RECORD");
	    	ladm.setBounds(145,30,270,30);
		ladm.setFont(fo);
		ladm.setForeground(Color.red);		    	


                lcoid=new JLabel("Course Id :");
	    	lcoid.setBounds(20,90,100,25);
                tcoid=new JTextField(5);
	    	tcoid.setBounds(150,90,90,25);
	    	
                lconm=new JLabel("Course Name :");
	    	lconm.setBounds(20,140,110,25);
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
	    	
              lcof1=new JLabel("Installment Fees :");
	    	lcof1.setBounds(20,290,140,25);
                tcof1=new JTextField(20);
	    	tcof1.setBounds(150,290,90,25);

	    	
                bnew=new JButton("New");
	    	bnew.setBounds(15,340,70,25);
		bnew.addActionListener(this);
		 badd=new JButton("Add");
		badd.addActionListener(this);
	    	badd.setBounds(113,340,70,25);
		bcle=new JButton("Clear");
	    	bcle.addActionListener(this);
	    	bcle.setBounds(210,340,80,25);
                              
                bcan=new JButton("ALL");
		bcan.addActionListener(this);
	    	bcan.setBounds(315,340,80,25);
	    	    	    	
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

	    	add(bnew);
	    	add(bcle);
	    	add(badd);
	    	add(bcan);

tcof.addKeyListener(new KeyAdapter()
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

tcof1.addKeyListener(new KeyAdapter()
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

tconm.addKeyListener(new KeyAdapter()
    {
        public void keyTyped(KeyEvent e) {
    	char c = e.getKeyChar();
      		if (((Character.isDigit(c))))
      	//if(!((c>=65 && c<=90) || (c>=97 && c<=122)))
      		{
        	 JOptionPane.showMessageDialog(null, "Please enter Alphabets");
           	 e.consume();
      		}
    		}
  		    });



// Table
    scrlPane.setBounds(0,390,410,200);
   add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));

    model.addColumn("C_ID");
    model.addColumn("C_NAME");
    model.addColumn("C_PERIOD");
    model.addColumn("O_FEE");
    model.addColumn("I_FEE");

					tcoid.setEnabled(false);
					tconm.setEnabled(true);
					tcopd.setEnabled(true);
				        tcof.setEnabled(true);
                                        tcof1.setEnabled(true);
			setVisible(true);		
					
	    }
	    public void actionPerformed(ActionEvent ae)
	    {
		if(ae.getSource()==badd)
			{
    	
    			
    			try
    				{
    					Class.forName("com.mysql.jdbc.Driver");
    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
    				
    		PreparedStatement pst = con.prepareStatement("INSERT INTO Course VALUES(?,?,?,?,?)");
     
			  
		                int tcoid1 =Integer.parseInt(tcoid.getText());
		                
	                    String tconm1=tconm.getText();
                               if(tconm.getText().equals(" "))
                                     throw new coNameException();
				
			 String tcopd1=tcopd.getText();
				 if(tcopd.getText().equals(" "))
                                     throw new coNameException();
				
			 String tcof11=tcof.getText();
				 if(tcof.getText().equals(" "))
                                     throw new coNameException();


 String tcof111=tcof1.getText();
				 if(tcof1.getText().equals(" "))
                                     throw new coNameException();
				
				
			
		   			
	                 	pst.setInt(1,tcoid1);
	                    pst.setString(2,tconm1);
	                    pst.setString(3,tcopd1);
				 pst.setString(4,tcof11);
			
pst.setString(5,tcof111);

   
                	    pst.executeUpdate();
                	    JOptionPane.showMessageDialog(null, "Your Record is Submitted");
                	        con.close();
				
				tcoid.setText("  ");
	    	tconm.setText(" ");
	    	tcopd.setText(" ");
	    	tcof.setText(" ");
tcof1.setText(" ");

		
		              }
                              catch(coNameException  e)
		              {
		                JOptionPane.showMessageDialog(null, "Please Enter Name !");
		              }                       
 
		              catch(NumberFormatException e)
		              {
		                JOptionPane.showMessageDialog(null, "Please Enter All Fields !");
		              }
		              
		             catch(Exception ex)
		             {
			            System.out.println("Error Occured");
			            System.out.println("Error:"+ex);
		              }
		}

	    	  if(ae.getSource()==bcle)
	    	  {
	    	  	  tcoid.setText(" ");
	    	  	  tconm.setText(" ");
	    	  	  tcopd.setText(" ");
	    	  	  tcof1.setText(" ");
	    	  	  tcof.setText(" "); 
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
                Connection cnDriver =DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
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

				if(ae.getSource()==bnew)
	      {
	                    try
    				{
    					Class.forName("com.mysql.jdbc.Driver");
    					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
    					
    					stmt=con.createStatement();
    					
    					rs=stmt.executeQuery("select co_id from Course");
    					int i=1;
    					
    					while(rs.next())
    					{
    						i=Integer.parseInt(rs.getString("co_id"));
    					}
    					i++;
    					tcoid.setText(""+i);
					 tconm.setText(" ");
	    	  	 		 tcopd.setText(" ");
	    	  	 		 tcof1.setText(" ");
	    	  	 	 	 tcof.setText(" "); 


					//tcoid.setEnabled(true);
					tconm.setEnabled(true);
					tcopd.setEnabled(true);
					tcof1.setEnabled(true);
					tcof.setEnabled(true);
										
    					
    					rs.close();
    				}
    				catch(Exception e)
	 	            {
	 		           System.out.println("error" +e);
	 	            }
			}


	    }
	    public static void main (String args[]) 
	    	{
					new courec();
						   }	
	    	
	    	
	    
}
