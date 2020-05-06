import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
import java.sql.ResultSet;

class sturec extends JFrame implements ActionListener
{

	
	JLabel lrno,lsname,lsadd,lspno,lfno,lbat,ldate,ladm,lsgen,lconm,lcopd,lemail;
	JTextField trno,tdate,tsname,tspno,tfno,tsem,tsadd,tcopd,tgen,tbat,tcou,temail;
	JButton bopen,bdel,bcancel,bcle;
	JPanel top;

	Font fo=new Font("verdana" ,Font.BOLD,20);
	
	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	String test,test1;
       
//Table
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
					
					
	  sturec()
	    {
                setSize(580,550);
	    	
               setLayout(null);
	    	setTitle("STUDENT  RECORD");
	    	setResizable(false);
	      	setLocation(300,160);	


		ladm=new JLabel("DELETE RECORD");
                ladm.setBounds(220,30,280,30);
		ladm.setFont(fo);
		ladm.setForeground(Color.red);	
		add(ladm);
		/*top=new JPanel();
		top.setLayout(null);
		top.setBorder(BorderFactory.createEtchedBorder(1));
	        top.setBounds(60,20,320,50);
		add(top);*/
		
    	

               lrno=new JLabel("Student id :");
	    	lrno.setBounds(30,100,100,30);
	    	trno=new JTextField();
	    	trno.setBounds(130,100,120,25);
	    	

		/*ldate=new JLabel("Date :");
	    	ldate.setBounds(270,100,35,30);
	    	tdate=new JTextField();
	    	tdate.setBounds(320,100,140,25);*/
	    		
	    	
	    	lsname=new JLabel("Stud Name:");
	    	lsname.setBounds(30,150,90,25);
	    	tsname=new JTextField(150);
	    	tsname.setBounds(130,150,370,25);
	    	
	    	lemail=new JLabel("Email_Id:");
	    	lemail.setBounds(30,195,90,25);
	    	temail=new JTextField(150);
	    	temail.setBounds(130,195,370,25);

                lsadd=new JLabel("Stud Add:");
	    	lsadd.setBounds(30,240,90,25);
	    	tsadd=new JTextField(150);
	    	tsadd.setBounds(130,240,370,25);
	    	
	    	lsgen=new JLabel("Gender :");
	    	lsgen.setBounds(320,280,80,25);
	    	tgen=new JTextField(150);
        	 tgen.setBounds(410,280,90,25);
                         
	    	lspno=new JLabel("Contact No :");
	    	lspno.setBounds(30,280,90,25);
	    	tspno=new JTextField(20);
	    	tspno.setBounds(130,280,115,25);
	    	
	    		          	
                lconm=new JLabel("Course Name :");
	    	lconm.setBounds(30,320,110,25);
                tcou=new JTextField();
                          tcou.setBounds(130,320,115,25);
	    	
                    
                lbat=new JLabel("Batch Time :");
	    	lbat.setBounds(320,320,110,25);
               tbat=new JTextField();
                           tbat.setBounds(410,320,90,25);
	    	

		bopen=new JButton("Open");
	    	bopen.setBounds(50,365,90,25);
		bopen.addActionListener(this);
	    	bdel=new JButton("Delete");
	    	bdel.setBounds(180,365,90,25);
                bdel.addActionListener(this) ;
	    	bcle=new JButton("Clear");
	    	bcle.setBounds(320,365,90,25);
	    	bcle.addActionListener(this);
	    	bcancel=new JButton("ALL");
                bcancel.addActionListener(this);
	    	bcancel.setBounds(440,365,90,25);
	       	
		
		
                add(lrno);
                add(trno);
	    	add(ladm);
	    	add(lsname);
	    	add(tsname);
	    	add(lsadd);
	    	add(tsadd);
	    	add(lsgen);
                add(tgen);
                add(lspno);
                add(tspno);
		add(lconm);
		add(tcou);
		//add(ldate);
		//add(tdate);
                add(tbat);
                add(lbat);
                 add(bdel);
                 add(bcle);
	    	add(bcancel);
		add(bopen);
                add(lemail);
                add(temail);
 trno.addKeyListener(new KeyAdapter()
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
    scrlPane.setBounds(0,400,580,220);
   add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));

  model.addColumn("S_ID");
    model.addColumn("S_NAME");
    model.addColumn("E_ID");
    model.addColumn("S_ADD");
    model.addColumn("S_PHONE");
    model.addColumn("S_GENDER");
    model.addColumn("C_NAME");
		
		setVisible(true);

					
					trno.setEnabled(true);
					tsname.setEnabled(false);
					tsadd.setEnabled(false);
					tspno.setEnabled(false);
					tbat.setEnabled(false);
					tgen.setEnabled(false);
					tcou.setEnabled(false);
					//tdate.setEnabled(false);
                                        temail.setEnabled(false);		           

	    }

	    public void actionPerformed(ActionEvent ae)
	    {
	    	if(ae.getSource()==bcle)
	    	{
	    	trno.setText("  ");
	    	tcou.setText("  ");
	    	tsname.setText(" ");
	    	tspno.setText(" ");
	    	tsadd.setText(" ");
	    	tgen.setText(" ");
	    	tbat.setText("  ");
                temail.setText("  ");
		//tdate.setText(" ");

		/*tsname.setEnabled(false);
		tsadd.setEnabled(false);
		tspno.setEnabled(false);
		tbat.setEnabled(false);
		tgen.setEnabled(false);
		tcou.setEnabled(false);
		//tdate.setEnabled(false);*/
	    		
	    	}
                if(ae.getSource()==bcancel)
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
                ResultSet rs = stmt.executeQuery("SELECT * from Admission" );
				
                while(rs.next())
                {
                	model.insertRow(r++, new Object[]{rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9) });
                }
            }

            catch(Exception ex)
            {
                    JOptionPane.showMessageDialog(null,"Error Occured : " + ex);
            }
                }
		
		if(ae.getSource()==bdel)
			{

		 try
    	       	{
    		      Class.forName("com.mysql.jdbc.Driver");
    		      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
    		      pst=con.prepareStatement("Delete from Admission where stu_id=?");
    	
    		      String trno1=trno.getText();
      	          pst.setString(1,trno1);
      
                  JOptionPane.showMessageDialog(null,"Record Is Deleted ");
                  pst.executeUpdate();
                  trno.setText("");
           	     tsname.setText("");
           	     tsadd.setText("");
           	     tspno.setText("");
		    tgen.setText("");
           	    tcou.setText("");
           	     tbat.setText("");
                     temail.setText("");
           	     //tdate.setText(" ");
         
                   con.close();
		
					/*trno.setEnabled(true);
					tsname.setEnabled(false);
					tsadd.setEnabled(false);
					tspno.setEnabled(false);
					tbat.setEnabled(false);
					tgen.setEnabled(false);
					tcou.setEnabled(false);
		           		//tdate.setEnabled(false);*/

                  }
                  catch(Exception ex)
                  {
      	            System.out.println("Error occured :"+ex);
                  }
			

	    }

		if(ae.getSource()==bopen)
	      {
	                     try
	               	{
	               	     Class.forName("com.mysql.jdbc.Driver");
	                     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	                     st= con.createStatement();
	                     String id=trno.getText();

	                     
                         String qry= "Select * from Admission where stu_id="+id+"";
	                     rs = st.executeQuery(qry);
	                     while(rs.next())
                         {
                           tsname.setText(rs.getString(4));
                           tsadd.setText(rs.getString(6));
                           tspno.setText(rs.getString(7));
			    tgen.setText(rs.getString(8));
                            temail.setText(rs.getString(5));
			tcou.setText(rs.getString(9));
                        tbat.setText(rs.getString(10));
			//tdate.setText(rs.getString(2));	

				/*tsname.setEnabled(true);
				tsadd.setEnabled(true);
				tspno.setEnabled(true);
				tbat.setEnabled(true);
				tgen.setEnabled(true);
				tcou.setEnabled(true);
				//tdate.setEnabled(true);*/

                         }
       
                        con.close();
	               			
	               	}
	                catch(Exception ex)
                  {
      	            System.out.println("Error occured :"+ex);
                  }
		  			 
	    
		}
	}

	    public static void main (String args[]) 
	    	{
					new sturec();
						   }	
	    	
	    	
	    
		}
	
