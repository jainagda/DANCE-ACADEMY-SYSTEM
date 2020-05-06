import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame 
{
	 public JFrame frame1=new JFrame();
	 public JPanel top,lower;
	
	JLabel leli;	

	JMenuBar mbr=new JMenuBar();

	JMenu A_form=new JMenu("Admission");
	
	JMenu tea=new JMenu("Faculty");

		 JMenu cour=new JMenu("Course");
	 
	 JMenu stu=new JMenu("Student");
	 
	 JMenu batch=new JMenu("Batches");
         JMenu exam=new JMenu("Exam");

	
		  JMenu bill=new JMenu("Receipt");
 JMenu rpt=new JMenu("Report");
	 
	JMenu exit=new JMenu("Logout");
	 String temp;
	 
	

 	
//student
        JMenuItem addts=new JMenuItem(" add ");
		JMenuItem search=new JMenuItem(" Search ");
		JMenuItem delete=new JMenuItem(" Delete ");
		JMenuItem modify=new JMenuItem(" Update ");

//teacher 
	 
    	JMenuItem opent=new JMenuItem(" Open ");
		JMenuItem modifyt=new JMenuItem("Update ");
		JMenuItem addt=new JMenuItem(" add ");
		JMenuItem deletet=new JMenuItem(" Delete ");
		  
	 
//Courses
    	JMenuItem addc=new JMenuItem(" Add");
		JMenuItem modc=new JMenuItem(" Update ");
		JMenuItem deletec=new JMenuItem(" Delete ");
		JMenuItem searchc=new JMenuItem(" Search ");
	 
//Courses
    	JMenuItem addb=new JMenuItem(" Add");
		




//bill

		JMenuItem openbl=new JMenuItem(" Open ");
		JMenuItem delbl=new JMenuItem(" Delete");
		JMenuItem printbl=new JMenuItem(" Add ");
 


//report
JMenuItem rptstd=new JMenuItem("Admission");
 JMenuItem rptenq=new JMenuItem("Enquiry");
 JMenuItem rptstud=new JMenuItem("Student");
 JMenuItem rpttea=new JMenuItem("Teacher");
 JMenuItem rptcourse=new JMenuItem("Course");


	    
//admission form
		
JMenuItem fresh=new JMenuItem("New Admission");
        JMenuItem fresh1=new JMenuItem("Enquiry");
//Exam
      //  JMenuItem exam1=new JMenuItem("Exam Details");
       // JMenuItem exam2=new JMenuItem("Result");


//exit
		JMenuItem exit1=new JMenuItem("Exit");
		//show();

 public void LaunchFrame()	
 {
	 	frame1.setSize(2000,1100);
	 	frame1.setLayout(null);
	 	frame1.setTitle("DAnce Academy System");
	    	
	 	frame1.add(mbr);


		leli=new JLabel(new ImageIcon("login1.png"));
	    	leli.setBounds(0,-90,1500,1100);
	    frame1.add(leli);
               /*Font fo=new Font("Monotype Corsiva" ,Font.BOLD,70);
	    	leli.setFont(fo);
	    	leli.setForeground(Color.red);
	
		top=new JPanel();
		top.setLayout(null);
		top.setBorder(BorderFactory.createEtchedBorder(1));
	     top.setBackground(Color.pink);     
		top.setBounds(0,10,1023,100);
	    	frame1.add(top);
		top.add(leli);

		
		lower=new JPanel();
		lower.setLayout(null);
		lower.setBorder(BorderFactory.createEtchedBorder(1));
	     lower.setBackground(Color.gray);     
		lower.setBounds(0,105,1023,800);
	    	frame1.add(lower);*/

//admission form
		 mbr.add(A_form);
		A_form.add(fresh);
A_form.add(fresh1);
//teacher	 	 	
		mbr.add(tea);
		tea.add(opent);
		tea.add(modifyt);
		tea.add(addt);
		tea.add(deletet);

	 
//faculty
   		 mbr.add(cour);
		cour.add(modc);
		cour.add(addc);
		cour.add(deletec);
		cour.add(searchc);
	mbr.add(batch);
		
		batch.add(addb);
		//student
       		 mbr.add(stu);
		stu.add(search);
		stu.add(delete);
		stu.add(modify);
        

//bill
		   mbr.add(bill);
		   bill.add(printbl);
		bill.add(openbl);
		bill.add(delbl);
		
//report

		   mbr.add(rpt);
		  rpt.add(rptstd);
		rpt.add(rptenq);
		rpt.add(rptstud);
		rpt.add(rpttea);
		rpt.add(rptcourse);

       mbr.add(exit);
		exit.add(exit1);

           
        	 	
	 	frame1.setJMenuBar(mbr);
	 	frame1.setVisible(true);
	// }
	 
}
 public void Check_Event()
 {
//faculty
     addc.addActionListener(new ActionListener()
		{
	   
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==addc)
	   	  	{
	   	  	   courec cr=new courec();
	   	  	}
	   	  }	   	  
	   });
	   

	 deletec.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==deletec)
			{
	   	         courecd crd=new courecd();
             
             		}
	   	  	
	   	  }   	  
	   });
	   
	   modc.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==modc)
	   	  	{
	   	  	 
	   	  	   courecm crm=new courecm();
             	   	}
            		   	  	
	   	  }   	  
	   });

		 searchc.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==searchc)
	   	  	{
	   	  	 
	   	  	   coureca crm=new coureca();
             	   	}
            		   	  	
	   	  }   	  
	   });	
//admission form 	 

		 fresh.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==fresh)
	   	  	{
	   	  	 
	   	  	   admfrm afm=new admfrm();
             
             	
            	
            	
	   	  	}
	   	  }   	  
	   });
           
              fresh1.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==fresh1)
	   	  	{
	   	  	 
	   	  	   enqfrm afm=new enqfrm();
             
             	
            	
            	
	   	  	}
	   	  }   	  
	   });
//exit
 addb.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==addb)
	   	  	{
	   	  	 
	   	  	   batrec abt=new batrec();
             
             	
            	
            	
	   	  	}
	   	  }   	  
	   });

		exit1.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==exit1)
	   	  	{
	   	  	 
	   	  	   System.exit(0);
                                   	
	   	  	}
	   	  }   	  
	   });
//student
		modify.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==modify)
	   	  	{
	   	  	 
	   	  	   sturecm srm=new sturecm();
	   	  	}
	   	  }   	  
	   });

		delete.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==delete)
	   	  	{
	   	  	 
	   	  	    sturec srm=new sturec();
                                   	
	   	  	}
	   	  }   	  
	   });

	search.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==search)
	   	  	{
	   	  	 
	   	  	   sturecs srm=new sturecs();
	   	  	}
	   	  }   	  
	   });
//TEACHER

		addt.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==addt)
	   	  	{
	   	  	 
	   	  	   teareca tadd=new teareca();
	   	  	}
	   	  }   	  
	   });


	deletet.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==deletet)
	   	  	{
	   	  	 
	   	  	   tearecd tdel=new tearecd();
	   	  	}
	   	  }   	  
	   });

	modifyt.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==modifyt)
	   	  	{
	   	  	 
	   	  	   tearecm tmod=new tearecm();
	   	  	}
	   	  }   	  
	   });


	     opent.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==opent)
	   	  	{
	   	  	 
	   	  	   teareco topen=new teareco();
	   	  	}
	   	  }   	  
	   });


		/*deleteb.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==deleteb)
	   	  	{
	   	  	 
	   	  	   batrec op=new batrec();
	   	  	}
	   	  }   	  
	   });

	
		addb.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==addb)
	   	  	{
	   	  	 
	   	  	   batrec op=new batrec();
	   	  	}
	   	  }   	  
	   });*/



//bill

		printbl.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==printbl)
	   	  	{
	   	  	 
	   	  	   stubill print=new stubill();
	   	  	}
	   	  }   	  
	   });

		openbl.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==openbl)
	   	  	{
	   	  	 
	   	  	   stubillo openbill=new stubillo();
	   	  	}
	   	  }   	  
	   });

		delbl.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==delbl)
	   	  	{
	   	  	 
	   	  	   stubilld delbill=new stubilld();
	   	  	}
	   	  }   	  
	   });


//report

rptstd.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==rptstd)
	   	  	{
	   	  	 
	   	  	Reportstd afm=new  Reportstd();
             
             	
            	
            	
	   	  	}
	   	  }   	  
	   });

rptenq.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==rptenq)
	   	  	{
	   	  	 
	   	  	Reportenq afm=new  Reportenq();
             
             	
            	
            	
	   	  	}
	   	  }   	  
	   });

rptstud.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==rptstud)
	   	  	{
	   	  	 
	   	  	Reportstud afm=new  Reportstud();
             
             	
            	
            	
	   	  	}
	   	  }   	  
	   });
rpttea.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==rpttea)
	   	  	{
	   	  	 
	   	  	Reporttea afm=new  Reporttea();
             
             	
            	
            	
	   	  	}
	   	  }   	  
	   });
rptcourse.addActionListener(new ActionListener()
		{
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==rptcourse)
	   	  	{
	   	  	 
	   	  	Reportcourse afm=new  Reportcourse();
             
             	
            	
            	
	   	  	}
	   	  }   	  
	   });

//Exam

 
	 }
public static void main(String args[])
{
    MainMenu menu1=new MainMenu();
menu1.LaunchFrame();	
	menu1.Check_Event();	

}
	 
}
