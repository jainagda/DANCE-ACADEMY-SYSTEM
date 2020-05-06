import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
import java.sql.ResultSet;


class sturecs extends JFrame implements ActionListener
{

	
	JLabel lrno,lsname,lsadd,lspno,lfno,lbat,ldate,ladm,lsgen,lconm,lcopd,ldt,lemail;
	JTextField trno,tdate,tsname,tspno,tfno,tsem,tsadd,tcopd,tgen,tbat,tcou,tdt,temail;
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
					
	  sturecs()
	    {
                setSize(570,580);
	    	
               setLayout(null);
	    	setTitle("STUDENT  RECORD");
	    	setResizable(false);
	      	setLocation(300,160);	


		ladm=new JLabel("RECORDS");
        ladm.setBounds(240,30,350,30);
		ladm.setFont(fo);
		ladm.setForeground(Color.red);	
		add(ladm);
		
            lrno=new JLabel("Student Id :");
	    	lrno.setBounds(30,100,100,30);
	    	trno=new JTextField();
	    	trno.setBounds(130,100,120,25);
	    	
	    	ldt=new JLabel("Admission Date :");
	    	ldt.setBounds(280,100,130,30);
	    	tdt=new JTextField();
	    	tdt.setBounds(410,100,90,25);
	    			    		
	    	
	    	lsname=new JLabel("Stud Name:");
	    	lsname.setBounds(30,150,90,25);
	    	tsname=new JTextField(150);
	    	tsname.setBounds(130,150,370,25);
	    	
	    	lemail=new JLabel("Email_Id:");
	    	lemail.setBounds(30,190,90,25);
	    	temail=new JTextField(150);
	    	temail.setBounds(130,190,370,25);

                lsadd=new JLabel("Stu Add:");
	    	lsadd.setBounds(30,230,90,25);
	    	tsadd=new JTextField(150);
	    	tsadd.setBounds(130,230,370,25);
	    	
	    	lsgen=new JLabel("Gender :");
	    	lsgen.setBounds(330,275,80,25);
	    	tgen=new JTextField(150);
        	 tgen.setBounds(420,275,80,25);
                         
	    	lspno=new JLabel("Contact No :");
	    	lspno.setBounds(30,275,90,25);
	    	tspno=new JTextField(20);
	    	tspno.setBounds(130,275,115,25);
	    	
	    		          	
                lconm=new JLabel("Course Name:");
	    	lconm.setBounds(30,315,115,25);
                tcou=new JTextField();
                          tcou.setBounds(130,315,115,25);
	    	
                    
                lbat=new JLabel("Batch Time:");
	    	lbat.setBounds(330,315,120,25);
               tbat=new JTextField();
                           tbat.setBounds(420,315,80,25);
	    	

		bopen=new JButton("Open");
	    	bopen.setBounds(80,355,90,25);
		bopen.addActionListener(this);
	    	bcle=new JButton("Clear");
	    	bcle.setBounds(240,355,90,25);
	    	bcle.addActionListener(this);
	    	bcancel=new JButton("ALL");
                bcancel.addActionListener(this);
	    	bcancel.setBounds(400,355,90,25);
	       	
		
		
                add(lrno);
                add(trno);
               add(ldt);
                add(tdt); 
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
		add(tbat);
                add(lbat);
                add(bcle);
	    	add(bcancel);
		add(bopen);
                add(lemail);
                add(temail);

tsname.addKeyListener(new KeyAdapter()
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

tspno.addKeyListener(new KeyAdapter()
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
    scrlPane.setBounds(0,400,570,200);
   add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));
    
    
    model.addColumn("S_ID");
    model.addColumn("S_NAME");
    model.addColumn("S_ADD");
    model.addColumn("E_ID");
    model.addColumn("S_GENDER");
    model.addColumn("S_PHONE");
    model.addColumn("C_NAME");
    model.addColumn("B_TIME");
    model.addColumn("A_DATE");
		
		setVisible(true);

					
					trno.setEnabled(true);
					tsname.setEnabled(false);
					tsadd.setEnabled(false);
					tspno.setEnabled(false);
					tbat.setEnabled(false);
					tgen.setEnabled(false);
					tcou.setEnabled(false);
                                        temail.setEnabled(false);
                                        tdt.setEnabled(false);
					
                  
                  
	    }

	    public void actionPerformed(ActionEvent ae)
	    {
	    	if(ae.getSource()==bcle)
	    	{
	    	trno.setText("  ");
               tdt.setText("  ");
	    	tcou.setText("  ");
	    	tsname.setText(" ");
	    	tspno.setText(" ");
                temail.setText(" ");
	    	tsadd.setText(" ");
	    	tgen.setText(" ");
	    	tbat.setText("  ");
		

		/*tsname.setEnabled(false);
		tsadd.setEnabled(false);
		tspno.setEnabled(false);
		tbat.setEnabled(false);
		tgen.setEnabled(false);
		tcou.setEnabled(false);*/
		
	    		
	    	}
                if(ae.getSource()==bcancel)
                {
                    int r = 0;
        
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cnDriver = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
                Statement stmt = cnDriver.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * from Admission" );
				
                while(rs.next())
                {
                	model.insertRow(r++, new Object[]{rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5),rs.getString(8),rs.getString(7),rs.getString(9),rs.getString(10),rs.getString(2) });
                }
            }

            catch(Exception ex)
            {
                    JOptionPane.showMessageDialog(null,"Error Occured : " + ex);
            }
                }
		
		

		if(ae.getSource()==bopen)
	      {
	                     try
	               	{
	               	     Class.forName("com.mysql.jdbc.Driver");
	                     con= DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	                     st= con.createStatement();
	                     String id=trno.getText();
	                     
                         String qry= "select * from Admission where stu_id="+id+"";
	                     rs = st.executeQuery(qry);
	                     while(rs.next())
                         {
                           tsname.setText(rs.getString(4));
                           tsadd.setText(rs.getString(6));
                           temail.setText(rs.getString(5));
                           tspno.setText(rs.getString(7));
			    tgen.setText(rs.getString(8));
			tcou.setText(rs.getString(9));
			tbat.setText(rs.getString(10));
                        tdt.setText(rs.getString(2));
                        trno.setText(rs.getString(3));
			

				/*tsname.setEnabled(true);
				tsadd.setEnabled(true);
				tspno.setEnabled(true);
				tbat.setEnabled(true);
				tgen.setEnabled(true);
				tcou.setEnabled(true);*/
				
                         }
       
                        con.close();
	               			
	               	}
	               	 catch(Exception ex)
            {
                    JOptionPane.showMessageDialog(null,"Error Occured : " + ex);
            }
		  			 
	    
		}
	}

	    public static void main (String args[]) 
	    	{
					new sturecs();
						   }	
	    	
	    	
	    
		}
	
