import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.*;

class Abc implements ActionListener
{
    public void actionPerformed(ActionEvent r)
    {
        System.exit(0);
    }
}
class MyWindowClosing extends WindowAdapter
{
    JMenu menu;
    MyWindowClosing(JMenu menu)
    {
        this .menu=menu;
    }
    public void windowClosing(WindowEvent e)
    {
        try{
            int a=JOptionPane.showConfirmDialog(menu,"Are you sure?","Exit Program",JOptionPane.YES_NO_OPTION);
            if(a==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
        }
        catch(Exception em){}
    }
}


 class JMenus extends JFrame
{

    JMenuBar menubar;
    JMenu file,edit,menu, view,submenu,format;
    JMenuItem
            new_item,open,save,menuitem,saveas,pagesetup,print,exit,newframe,newframes ,selectAll,close;
    JRadioButtonMenuItem red, green,blue,rbmenuitem;
    JCheckBoxMenuItem india,china,cbmenuitem;
 //JFrame jFrame;
    JTextArea jTextArea;

    public JMenus()
    {
        super("Text Editor");


        setTitle("Text Editor");
      // jFrame=new JFrame();
//setDedaultCloseOption(EXIT_ON_CLOSE);


        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screenSize=kit.getScreenSize();
        int screenHeight=screenSize.height;
        int screenWidth=screenSize.width;
        setLocation(screenWidth/4,screenHeight/4);



        menubar=new JMenuBar();

        file=new JMenu("file");
        edit=new JMenu("edit");
        view=new JMenu("View");
        format=new JMenu("Format");

           //intilize the textarea
        jTextArea=new JTextArea();

        menubar.add(file);
        menubar.add(edit);
        menubar.add(view);
        menubar.add(format);
        file.setMnemonic(KeyEvent.VK_F);
        edit.setMnemonic(KeyEvent.VK_E);
        view.setMnemonic(KeyEvent.VK_V);
        format.setMnemonic(KeyEvent.VK_R);





        new_item=new JMenuItem("New",KeyEvent.VK_N);
        open=new JMenuItem("open",KeyEvent.VK_O);
        save=new JMenuItem("save",KeyEvent.VK_S);
        saveas=new JMenuItem("saveas",KeyEvent.VK_K);
        pagesetup=new JMenuItem("Cut",KeyEvent.VK_P);
        selectAll=new JMenuItem("selectAll");
        close=new JMenuItem("close");
        print=new JMenuItem("copy",KeyEvent.VK_L);
        exit=new JMenuItem("paste",KeyEvent.VK_M);
        newframe=new JMenuItem("newframe",KeyEvent.VK_G);
        newframes=new JMenuItem("newframes",KeyEvent.VK_T);

        file.add(new_item);
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.add(saveas);

        edit.add(pagesetup);
        edit.add(print);
        edit.add(exit);
        edit.add(selectAll);
        edit.add(close);

        view.add(newframes);

        format.add(newframe);

        new_item.addActionListener(new ActionListener()
                                   {
                                       public void actionPerformed(ActionEvent e)
                                       {
                                           JMenus jMenu=new JMenus();
                                       }
                                   }
        );

        open.addActionListener(new ActionListener()
                                   {
                                       public void actionPerformed(ActionEvent e)
                                       {
                                           //open a file chooser
                                           JFileChooser fileChooser=new JFileChooser("c");
                                           int choseOption=fileChooser.showOpenDialog(null);
                                           //if we have click on open button
                                           if(choseOption==JFileChooser.APPROVE_OPTION){
                                               //get selected file
                                               File file=fileChooser.getSelectedFile();
                                               //get path from selected file
                                               String filePath=file.getPath();
                                               try{
                                                   FileReader fileReader=new FileReader(filePath);

                                                   BufferedReader bufferedReader=new BufferedReader(fileReader);
                                                   String intermediate="",output="";
                                                   while((intermediate=bufferedReader.readLine())!=null){
                                                       output+=intermediate+"\n";
                                                   }
                                                   jTextArea.setText(output);
                                               }catch (IOException fileNotFoundException){
                                                   fileNotFoundException.printStackTrace();
                                               }
                                           }
                                       }
                                   }
        );
        save.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            JFileChooser fileChooser=new JFileChooser("c");
                                            int choseOption=fileChooser.showSaveDialog(null);

                                            if(choseOption==JFileChooser.APPROVE_OPTION) {
                                                File file=new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                                           try{
                                               FileWriter fileWriter=new FileWriter(file);

                                               BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

                                               jTextArea.write(bufferedWriter);
                                               bufferedWriter.close();
                                            }catch (IOException ioException){
                                               ioException.printStackTrace();
                                           }

                                           }
                                            }
                                    }
        );

        pagesetup.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            jTextArea.cut();
                                        }
                                    }
        );
        print.addActionListener(new ActionListener()
                                   {
                                       public void actionPerformed(ActionEvent e)
                                       {
                                           jTextArea.copy();
                                       }
                                   }
        );

        close.addActionListener(new ActionListener()
                               {
                                   public void actionPerformed(ActionEvent e)
                                   {
                                      System.exit(0);
                                   }
                               }
        );
        selectAll.addActionListener(new ActionListener()
                               {
                                   public void actionPerformed(ActionEvent e)
                                   {
                                       jTextArea.selectAll();
                                   }
                               }
        );

        exit.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            jTextArea.paste();
                                        }
                                    }
        );





        ButtonGroup group=new ButtonGroup();

        red=new JRadioButtonMenuItem("red");
        green=new JRadioButtonMenuItem("green");
        blue=new JRadioButtonMenuItem("blue");

        group.add(red);
        group.add(green);
        group.add(blue);

        india=new JCheckBoxMenuItem("india");
        china=new JCheckBoxMenuItem("China");

        india.setSelected(true);
        view.add(india);
        view.add(china);

        submenu=new JMenu("Number");
        menuitem=new JMenuItem("1");
        submenu.add(menuitem);

        file.add(submenu);

//addwindowListener(this);
        JPanel jpanel=new JPanel();
        jpanel.setBorder(new EmptyBorder(5,5,5,5));
        jpanel.setLayout(new BorderLayout(0,0));

        jpanel.add(jTextArea,BorderLayout.CENTER);
//        JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 500);
//        JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
//        hbar.addAdjustmentListener(new JMenus());
//        vbar.addAdjustmentListener(new JMenus());


         JScrollPane jScrollPane=new JScrollPane(jTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//  JScrollBar jScrollBar=new JScrollBar();
//  //jScrollBar.setOrientation(0);
//  //jScrollBar.setSize(20,500);
//  jScrollBar.setBounds(480,0,20,20);
        jpanel.add(jScrollPane);

//        getContentPane().add(hbar, BorderLayout.SOUTH);
//        getContentPane().add(vbar, BorderLayout.EAST);

        add(jpanel);
       // add(h);
        setSize(500,500);
        setVisible(true);
        setJMenuBar(menubar);
        add(jTextArea);


    }
    public static void main(String...d1)
    {
        new JMenus();
    }


}



