
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class CarDetails extends JFrame implements ActionListener
{
    JLabel lbl_CarName , lbl_company,lbl_price, lbl_model;
    JButton btn_Submit,btn_Show;
    JTextField txt_CarName, txt_company, txt_price,txt_model;
    CarDetails(String s)
    {
        super(s);
        setSize(300,250);
        setLocation(100,200);
        setLayout(null);



        lbl_CarName=new JLabel("CarName");

        lbl_company=new JLabel("company");
        lbl_price=new JLabel("price");
        lbl_model=new JLabel("model");


        lbl_CarName.setBounds(30,50,80,20);
        lbl_company.setBounds(30,80,80,20);
        lbl_price.setBounds(30,110,80,20);
        lbl_model.setBounds(30,140,80,20);

        txt_CarName=new JTextField();
        txt_company=new JTextField();
        txt_price=new JTextField();
        txt_model=new JTextField();

        txt_CarName.setBounds(120,50,130,25);
        txt_company.setBounds(120,80,130,25);
        txt_price.setBounds(120,110,130,25);
        txt_model.setBounds(120,140,130,25);


        btn_Submit=new JButton("Submit");
        btn_Show=new JButton("Show");

        btn_Submit.setBounds(40,180,100,30);
        btn_Show.setBounds(150,180,70,30);

        add(lbl_CarName);
        add(lbl_company);
        add(lbl_price);
        add(lbl_model);
        add(txt_CarName);
        add(txt_company);
        add(txt_price);
        add(txt_model);
        add(btn_Submit);
        add(btn_Show);
        btn_Submit.addActionListener(this);
        setVisible(true);
    }

    Connection con;
    public void actionPerformed(ActionEvent ee)
    {
        String cn=txt_CarName.getText();
        String com=txt_company.getText();
        int pr=Integer.parseInt(txt_price.getText());
        int m1=Integer.parseInt(txt_model.getText());

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","SCAM_1992bhai");

            Statement s=con.createStatement();

            s.executeUpdate("insert into Crs  values('"+cn+"','"+com+"',"+pr+","+m1+")");
        }catch(Exception e){System.out.println(e);}
        finally{try{con.close();}catch (Exception e){}}
    }



    public static void main(String...a1)
    {
        CarDetails s1=new CarDetails("car form");

    }
}