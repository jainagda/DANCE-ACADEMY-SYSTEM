import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.table.*;
import java.sql.*;
import java.sql.ResultSet;




class stubillo extends JFrame implements ActionListener
{

	
        JLabel lrno,lsname,lsadd,lFeet,ldate,ladm,lbno,lPfee,lspno,lconm,lsgen,lfno,lcof,lemail;
        JTextField tdate,tsname,tFeet,tsadd,tconm,tbno,tPfee,trno,tspno,tfno,tgen,tcof,temail;
	JButton bcle,ball,bopen;
      // JComboBox gender;

	Font fo=new Font("vERDANA" ,Font.BOLD,20);	
	Connection con;
	Statement st;
	ResultSet rs;
	String test,test1;


	//Table
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
     

	
	   stubillo()
	    {
                setSize(590,580);
	    	
	    	setLayout(null);
	    	setTitle("STUDENT RECEIPT");
	    	setResizable(false);
	    	setLocation(300,160);
	    	
	    	ladm=new JLabel("OPEN RECEIPT");
		ladm.setFont(fo);
	    	ladm.setBounds(220,30,250,50);
		ladm.setForeground(Color.red);		    	

	        lbno=new JLabel("Receipt No :");
	    	lbno.setBounds(30,90,100,25);
	    	tbno=new JTextField(5);
	    	tbno.setBounds(130,90,100,25);
	    	    	
	    	 		
	    	lrno=new JLabel("Student Id :");
	    	lrno.setBounds(30,130,100,25);
	    	trno=new JTextField();
	    	trno.setBounds(130,130,100,25);
	    	
	    	lfno=new JLabel("Form No :");
	    	lfno.setBounds(300,130,70,25);
	    	tfno=new JTextField(15);
	    	tfno.setBounds(370,130,130,25);
	    	
	    	lsname=new JLabel("Stud Name:");
	    	lsname.setBounds(30,170,90,25);
	    	tsname=new JTextField(150);
	    	tsname.setBounds(130,170,370,25);
	    	
	    	lemail=new JLabel("Email_Id:");
	    	lemail.setBounds(30,210,90,25);
	    	temail=new JTextField(150);
	    	temail.setBounds(130,210,370,25);

                lsadd=new JLabel("Stud Add:");
	    	lsadd.setBounds(30,245,90,25);
	    	tsadd=new JTextField(150);
	    	tsadd.setBounds(130,245,370,25);


		
	    	lspno=new JLabel("Contact No :");
	    	lspno.setBounds(30,280,100,25);
	    	tspno=new JTextField(20);
	    	tspno.setBounds(130,280,100,25);
		
		lsgen=new JLabel("Gender :");
	    	lsgen.setBounds(340,280,90,25);
	    	tgen=new JTextField();
                 tgen.setBounds(420,280,80,25);
                         
	    	
	    		    	
	    	lconm=new JLabel("Course Name:");
	    	lconm.setBounds(30,320,100,25);
	    	tconm=new JTextField(30);
	        tconm.setBounds(130,320,100,25);
	    	    
               lFeet=new JLabel("Fee Type:");
               lFeet.setBounds(340,320,120,25);
	    	tFeet=new JTextField(30);
	    	tFeet.setBounds(420,320,80,25);

		lcof=new JLabel("Course Fees :");
	    	lcof.setBounds(30,360,100,25);
	    	tcof=new JTextField(15);
	    	tcof.setBounds(130,360,100,25);
	    	
		lPfee=new JLabel("Paid Fees:");
	    	lPfee.setBounds(340,360,115,25);
	    	tPfee=new JTextField(15);
	    	tPfee.setBounds(420,360,80,25);
	        
	    
	    	
		bopen=new  JButton("Open");
	    	bopen.setBounds(70,410,90,25);
		bopen.addActionListener(this);
	    	bcle=new  JButton("Clear");
	    	bcle.setBounds(250,410,90,25);
		bcle.addActionListener(this);
	    	ball=new  JButton("ALL");
	    	ball.setBounds(420,410,90,25);
		ball.addActionListener(this);
	    	
	    
	        add(lbno);
	        add(tbno);
	    	add(lrno);
	    	add(trno);
	    	add(ladm);
		add(lfno);
		add(tfno);
	    	
	    	add(lPfee);
	    	add(tPfee);
	    	add(lsname);
	    	add(tsname);
	    	add(lsadd);
	    	add(tsadd);
	      	add(lFeet);
	    	add(tFeet);
                add(lconm);
	    	add(tconm);
	    	add(lsgen);
		add(tspno);
	
		add(lspno);
		add(tgen);
		add(lcof);
		add(tcof);
	      	
		add(bopen);
	    	add(bcle);
		add(ball);

                add(lemail);
                add(temail);
	    	
 tbno.addKeyListener(new KeyAdapter()
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
    scrlPane.setBounds(0,450,590,200);
   add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));
    
    model.addColumn("R_NO");
    model.addColumn("A_NO");
    model.addColumn("S_ID");
    model.addColumn("S_NAME");
    model.addColumn("E_ID");
    model.addColumn("S_ADD");
    model.addColumn("S_GENDER");
    model.addColumn("S_PHONE");
    model.addColumn("C_NAME");
    model.addColumn("F_TYPE");
    model.addColumn("R_FEE");

		setVisible(true);

               
	    	trno.setEnabled(false);
		tfno.setEnabled(false);
	    	tPfee.setEnabled(false);
	    	tsname.setEnabled(false);
	    	tsadd.setEnabled(false);
	    	tFeet.setEnabled(false);
	    	tconm.setEnabled(false);
		tspno.setEnabled(false);
		tgen.setEnabled(false);
		tcof.setEnabled(false);
                temail.setEnabled(false);


	    }
	    public void actionPerformed(ActionEvent ae)
	    {
	    	 

		
		if(ae.getSource()==bopen)
	      {
	                     try
	               	{
	               	     Class.forName("com.mysql.jdbc.Driver");
	                     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	                     st= con.createStatement();
	                     String id=tbno.getText();
	                     
                         String qry= "Select * from bill where b_no="+id+"";
	                     rs = st.executeQuery(qry);
	                     while(rs.next())
                         {
			   tfno.setText(rs.getString(3));
				trno.setText(rs.getString(4));
                           tsname.setText(rs.getString(5));
                           temail.setText(rs.getString(6));
                           tsadd.setText(rs.getString(7));
				tgen.setText(rs.getString(8));
				tspno.setText(rs.getString(9));
                       	tconm.setText(rs.getString(10));
			
			tFeet.setText(rs.getString(11));
			tPfee.setText(rs.getString(12));
				
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

		   			
				trno.setText("  ");
	    		//tdate.setText("In Integer Only ");
	    		tsname.setText(" ");
	    		tspno.setText(" ");
	    		tfno.setText(" ");
	    		tsadd.setText(" ");
			tbno.setText(" ");
			tfno.setText(" ");
			tgen.setText(" ");
			tFeet.setText(" ");
			tPfee.setText(" ");
			tconm.setText("");
			tcof.setText("");
                        temail.setText("");


                  }
	              
          

			if(ae.getSource()==ball)
                {
                    int r = 0;
        
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cnDriver = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
                Statement stmt = cnDriver.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * from bill" );
				
                while(rs.next())
                {
                	model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(4),rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)  });
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
					new stubillo();
						   }	
	    	
	    	
	    
}
