
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class EmployeeForm extends JFrame implements ActionListener
{
    JLabel lbl_emp_Name , lbl_emp_age,lbl_salary, lbl_Address;
    JButton btn_Submit,btn_Show;
    JTextField txt_emp_Name, txt_emp_age, txt_salary,txt_Address;
    EmployeeForm(String s)
    {
        super(s);
        setSize(300,250);
        setLocation(100,200);
        setLayout(null);



        lbl_emp_Name=new JLabel("emp_Name");

        lbl_emp_age=new JLabel("emp_age");
        lbl_salary=new JLabel("salary");
        lbl_Address=new JLabel("Address");


        lbl_emp_Name.setBounds(30,50,80,20);
        lbl_emp_age.setBounds(30,80,80,20);
        lbl_salary.setBounds(30,110,80,20);
        lbl_Address.setBounds(30,140,80,20);

        txt_emp_Name=new JTextField();
        txt_emp_age=new JTextField();
        txt_salary=new JTextField();
        txt_Address=new JTextField();

        txt_emp_Name.setBounds(120,50,130,25);
        txt_emp_age.setBounds(120,80,130,25);
        txt_salary.setBounds(120,110,130,25);
        txt_Address.setBounds(120,140,130,25);


        btn_Submit=new JButton("submit");
        btn_Show=new JButton("Show");

        btn_Submit.setBounds(40,180,100,30);
        btn_Show.setBounds(150,180,70,30);

        add(lbl_emp_Name);
        add(lbl_emp_age);
        add(lbl_salary);
        add(lbl_Address);
        add(txt_emp_Name);
        add(txt_emp_age);
        add(txt_salary);
        add(txt_Address);
        add(btn_Submit);
        add(btn_Show);



        btn_Submit.addActionListener(this);
        setVisible(true);
    }

    Connection con;
    public void actionPerformed(ActionEvent ee)
    {
        String name=txt_emp_Name.getText();
        int age=Integer.parseInt(txt_emp_age.getText());
        int marks=Integer.parseInt(txt_salary.getText());
        String add=txt_Address.getText();

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","SCAM_1992bhai");

            Statement s=con.createStatement();

//s.executeUpdate("insert into Records values('"+name+"',"+age+","+marks+",'"+add+"')");
            s.executeUpdate("update Records set address=?  where name='Rahul'");


        }catch(Exception e){System.out.println(" "+e);}
        finally{try{con.close();}catch (Exception e){}}




    }
    public static void main(String...a1)
    {
        EmployeeForm s1=new EmployeeForm("Employee form");

    }
}