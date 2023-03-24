
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class College extends JFrame implements ActionListener
{
    JLabel lbl_CName , lbl_Dept,lbl_fees, lbl_course;
    JButton btn_Submit,btn_Show;
    JTextField txt_CName, txt_Dept, txt_fees,txt_course;
    College(String s)
    {
        super(s);
        setSize(300,250);
        setLocation(100,200);
        setLayout(null);



        lbl_CName=new JLabel("CName");

        lbl_Dept=new JLabel("Dept");
        lbl_fees=new JLabel("fees");
        lbl_course=new JLabel("course");


        lbl_CName.setBounds(30,50,80,20);
        lbl_Dept.setBounds(30,80,80,20);
        lbl_fees.setBounds(30,110,80,20);
        lbl_course.setBounds(30,140,80,20);

        txt_CName=new JTextField();
        txt_Dept=new JTextField();
        txt_fees=new JTextField();
        txt_course=new JTextField();

        txt_CName.setBounds(120,50,130,25);
        txt_Dept.setBounds(120,80,130,25);
        txt_fees.setBounds(120,110,130,25);
        txt_course.setBounds(120,140,130,25);


        btn_Submit=new JButton("Submit");
        btn_Show=new JButton("Show");

        btn_Submit.setBounds(40,180,100,30);
        btn_Show.setBounds(150,180,70,30);

        add(lbl_CName);
        add(lbl_Dept);
        add(lbl_fees);
        add(lbl_course);
        add(txt_CName);
        add(txt_Dept);
        add(txt_fees);
        add(txt_course);
        add(btn_Submit);
        add(btn_Show);
        btn_Submit.addActionListener(this);
        setVisible(true);
    }

    Connection con;
    public void actionPerformed(ActionEvent ee)
    {
        String college=txt_CName.getText();
        String dept=txt_Dept.getText();
        int fee=Integer.parseInt(txt_fees.getText());
        String co=txt_course.getText();

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","SCAM_1992bhai");

            Statement s=con.createStatement();

            s.executeUpdate("insert into colleger  values('"+college+"','"+dept+"',"+fee+",'"+co+"')");
        }catch(Exception e){System.out.println(e);}
        finally{try{con.close();}catch (Exception e){}
        }



    }
    public static void main(String...a1)
    {
        College s1=new College("college form");

    }
}