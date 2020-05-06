import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
import java.sql.ResultSet;


class tearecd extends JFrame implements ActionListener
{

	
	JLabel lidno,ltname,ltadd,ltpno,lfno,lbat,ldate,ladm,ltgen,lconm,lcopd,lemail;
	JTextField tid,tdate,ttname,ttpno,ttadd,tcopd,tbat,tcou,tgen,temail;
	JButton bopen,bdel,bcancel,bcle;
	JPanel top;
	//JComboBox tgen,b_id,co_id;
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
										
	  tearecd()
	    {
                setSize(580,570);
	    	
               setLayout(null);
	    	setTitle("TEACHER  RECORD");
	    	setResizable(false);
	      	setLocation(300,160);	


		ladm=new JLabel("DELETE RECORD");
                ladm.setBounds(220,30,280,30);
		ladm.setFont(fo);
		ladm.setForeground(Color.red);	
		add(ladm);
		
    	

               lidno=new JLabel("Teacher id :");
	    	lidno.setBounds(30,100,100,30);
	    	tid=new JTextField();
	    	tid.setBounds(140,100,115,25);
	    	

		
	    	
	    	ltname=new JLabel("Teacher Name:");
	    	ltname.setBounds(30,140,120,25);
	    	ttname=new JTextField(150);
	    	ttname.setBounds(140,140,370,25);
	    	
	    	lemail=new JLabel("Email Id:");
	    	lemail.setBounds(30,177,120,25);
	    	temail=new JTextField(150);
	    	temail.setBounds(140,177,370,25);

                
	    	ltadd=new JLabel("Teacher Add:");
	    	ltadd.setBounds(30,215,120,25);
	    	ttadd=new JTextField(150);
	    	ttadd.setBounds(140,215,370,25);
	    	
	    	
	    	ltgen=new JLabel("Gender :");
	    	ltgen.setBounds(340,255,80,25);
	    	 tgen=new JTextField();
                 tgen.setBounds(410,255,100,25);
                         
	    	ltpno=new JLabel("Contact No :");
	    	ltpno.setBounds(30,255,90,25);
	    	ttpno=new JTextField(20);
	    	ttpno.setBounds(140,255,115,25);
	    	
	    		          	
                lconm=new JLabel("Course Id :");
	    	lconm.setBounds(30,300,90,25);
                tcou=new JTextField();
                tcou.setBounds(140,300,115,25);
                    
                lbat=new JLabel("Faculty :");
	    	lbat.setBounds(340,300,90,25);
                tbat=new JTextField ();
                tbat.setBounds(410,300,100,25);
	    	

		bopen=new JButton("Open");
	    	bopen.setBounds(45,370,90,25);
		bopen.addActionListener(this);
	    	bdel=new JButton("Delete");
	    	bdel.setBounds(185,370,90,25);
                bdel.addActionListener(this) ;
	    	bcle=new JButton("Clear");
	    	bcle.setBounds(318,370,90,25);
	    	bcle.addActionListener(this);
	    	bcancel=new JButton("ALL");
                bcancel.addActionListener(this);
	    	bcancel.setBounds(450,370,90,25);
	       	
		
		
                add(lidno);
                add(tid);
	    	add(ladm);
	    	add(ltname);
	    	add(ttname);
	    	add(ltadd);
	    	add(ttadd);
	    	add(ltgen);
                add(tgen);
                add(ltpno);
                add(ttpno);
		add(lconm);
		add(tcou);
		
                add(tbat);
                add(lbat);
                 add(bdel);
                 add(bcle);
	    	add(bcancel);
		add(bopen);
                add(lemail);
                add(temail);

tid.addKeyListener(new KeyAdapter()
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
    scrlPane.setBounds(0,410,577,200);
   add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));

  model.addColumn("T_ID");
    model.addColumn("T_NAME");
    model.addColumn("T_ADD");
    model.addColumn("E_ID");
    model.addColumn("T_PHONE");
    model.addColumn("T_GENDER");
    model.addColumn("C_ID");
    model.addColumn("T_FACULTY");
		
		
		setVisible(true);

					
					
					ttname.setEnabled(false);
					ttadd.setEnabled(false);
					ttpno.setEnabled(false);
					tbat.setEnabled(false);
					tgen.setEnabled(false);
					tcou.setEnabled(false);
                                        temail.setEnabled(false);
                                        

								
   			           

	    }

	  public void actionPerformed(ActionEvent ae)
	    {
	    	if(ae.getSource()==bcle)
	    	{
	    	tid.setText("  ");
	    	tcou.setText("  ");
	    	ttname.setText(" ");
	    	ttpno.setText(" ");
	    	ttadd.setText(" ");
	    	tgen.setText(" ");
	    	tbat.setText("  ");
                temail.setText("  ");
		

		ttname.setEnabled(false);
		ttadd.setEnabled(false);
		ttpno.setEnabled(false);
		tbat.setEnabled(false);
		tgen.setEnabled(false);
		tcou.setEnabled(false);
                temail.setEnabled(false);
		
	    		
	    	}
                if(ae.getSource()==bcancel)
                {
                   int r = 0;
        
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cnDriver =DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
                Statement stmt = cnDriver.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * from Teacher" );
				
                while(rs.next())
                {
                	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8) });
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
    		      pst=con.prepareStatement("Delete from Teacher where t_id=?");
    	
    		      String tid1=tid.getText();
      	          pst.setString(1,tid1);
      
                  JOptionPane.showMessageDialog(null,"Record Is Deleted ");
                  pst.executeUpdate();
                  tid.setText("");
           	     ttname.setText("");
           	     ttadd.setText("");
                     temail.setText("");
           	     ttpno.setText("");
		    tgen.setText("");
           	    tcou.setText("");
           	     tbat.setText("");
           	     
                   con.close();
		
					tid.setEnabled(true);
					ttname.setEnabled(false);
					ttadd.setEnabled(false);
					ttpno.setEnabled(false);
					tbat.setEnabled(false);
					tgen.setEnabled(false);
					tcou.setEnabled(false);
                                        temail.setEnabled(false);
		           		
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
	                     con= DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	                     st= con.createStatement();
	                     String id=tid.getText();
	                     
                         String qry= "select * from Teacher where t_id="+id+"";
	                     rs = st.executeQuery(qry);
	                     while(rs.next())
                         {
                           ttname.setText(rs.getString(2));
                           ttadd.setText(rs.getString(3));
                           temail.setText(rs.getString(4));
                           ttpno.setText(rs.getString(5));
			    tgen.setText(rs.getString(6));
			tcou.setText(rs.getString(7));
			tbat.setText(rs.getString(8));
                        
			
				ttname.setEnabled(false);
				ttadd.setEnabled(false);
                                temail.setEnabled(false);
				ttpno.setEnabled(false);
				tbat.setEnabled(false);
				tgen.setEnabled(false);
				tcou.setEnabled(false);
				
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
					new tearecd();
						   }	
	    	
	    	
	    
		}
	
