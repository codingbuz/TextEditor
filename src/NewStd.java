
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;


class NewStd extends JFrame implements ActionListener
{
    JLabel lbl_Name , lbl_age,lbl_marks, lbl_Address;
    JButton btn_Submit,btn_Show;
    JTextField txt_Name, txt_age, txt_marks,txt_Address;
    NewStd(String s)
    {
        super(s);
        setSize(300,250);
        setLocation(100,200);
        setLayout(null);



        lbl_Name=new JLabel("Name");

        lbl_age=new JLabel("age");
        lbl_marks=new JLabel("marks");
        lbl_Address=new JLabel("Address");


        lbl_Name.setBounds(30,50,80,20);
        lbl_age.setBounds(30,80,80,20);
        lbl_marks.setBounds(30,110,80,20);
        lbl_Address.setBounds(30,140,80,20);

        txt_Name=new JTextField();
        txt_age=new JTextField();
        txt_marks=new JTextField();
        txt_Address=new JTextField();

        txt_Name.setBounds(120,50,130,25);
        txt_age.setBounds(120,80,130,25);
        txt_marks.setBounds(120,110,130,25);
        txt_Address.setBounds(120,140,130,25);


        btn_Submit=new JButton("Submit");
        btn_Show=new JButton("Show");

        btn_Submit.setBounds(40,180,100,30);
        btn_Show.setBounds(150,180,70,30);

        add(lbl_Name);
        add(lbl_age);
        add(lbl_marks);
        add(lbl_Address);
        add(txt_Name);
        add(txt_age);
        add(txt_marks);
        add(txt_Address);
        add(btn_Submit);
        add(btn_Show);



        btn_Submit.addActionListener(this);
        setVisible(true);
    }

    Connection con;
    public void actionPerformed(ActionEvent ee)
    {
        String name=txt_Name.getText();
        int age=Integer.parseInt(txt_age.getText());
        int marks=Integer.parseInt(txt_marks.getText());
        String add=txt_Address.getText();

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","SCAM_1992bhai");

            Statement s=con.createStatement();

            s.executeUpdate("insert into Records values('"+name+"',"+age+","+marks+",'"+add+"')");
        }catch(Exception e){System.out.println(e);}
        finally{try{con.close();}catch (Exception e){}}
    }



    public static void main(String...a1)
    {
        NewStd s1=new NewStd("Database");

    }
}