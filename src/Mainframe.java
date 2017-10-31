import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Mainframe extends JFrame{

    private int ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 500,frmH=400 ;
    private JMenuBar jmb = new JMenuBar();
    private  JMenu jmF = new JMenu("File");
    private  JMenu jmSet = new JMenu("Set");
    private  JMenu jmGame = new JMenu("Game");
    private  JMenu jmAbout = new JMenu("About");
    private  JMenuItem jmItemExit = new JMenuItem("Exit");
    private  JMenuItem jmItemLoto = new JMenuItem("Loto");
    private  JMenuItem jmItemStyle = new JMenuItem("Style");
    private  JLabel Jlb[] = new JLabel[6];
    private  JDesktopPane jdp = new JDesktopPane();
    private JInternalFrame jif = new JInternalFrame();
    private JPanel Jp= new JPanel(new GridLayout(1,6,3,3));
    private JPanel Jp1= new JPanel(new GridLayout(1,2,3,3));
    private JButton Jbtn1 = new JButton("Close");
    private JButton Jbtn2 = new JButton("General");
    private Random rnd = new Random(System.currentTimeMillis());
    private  int data[] = new int[6];
    private Container cp;

    private JPanel jPanel1 = new JPanel(new GridLayout(2,3,3,3));
    String[]    Option = {"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    JComboBox jcb = new JComboBox(Option);
    private JTextField jtfF = new JTextField("");
    private JTextField jtfFont = new JTextField("24");


    private boolean b;

    public Mainframe(){

        init();
    }
    private void init(){
            this.setContentPane(jdp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Mainframe.this.setVisible(false);
              //  log.setVisible(true);
            }
        });
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        this.setJMenuBar(jmb);

        jmb.add(jmF);
        jmb.add(jmSet);
        jmb.add(jmGame);
        jmb.add(jmAbout);

        jmF.add(jmItemExit);
        jmGame.add(jmItemLoto);
        jmSet.add(jmItemStyle);
        jmItemExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmItemLoto.setAccelerator(KeyStroke.getKeyStroke('C',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmItemStyle.setAccelerator(KeyStroke.getKeyStroke('f',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        cp = jif.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(Jp,BorderLayout.CENTER);
        cp.add(Jp1,BorderLayout.SOUTH);
     Jp1.add(Jbtn1);
        Jp1.add(Jbtn2);
        jif.setBounds(0,0,300,120);

        jPanel1.add(jtfF);
        jPanel1.add(jcb);
        jPanel1.add(jtfFont);



Jbtn1.addActionListener(new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        jif.dispose();
    }
});


         jmItemLoto.addActionListener(new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 jdp.add(jif);
                 jif.setVisible(true);
             }
         });

        jmItemExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

Jbtn2.addActionListener(new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
Jp.removeAll();
        Loto();
    }
});


        jmItemStyle.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
JOptionPane.showInputDialog(Mainframe.this.jPanel1,jcb,"font Setting",JOptionPane.OK_CANCEL_OPTION);
int Style=0;


            }
        });



    }








    public void Loto(){
         int  n;

        for(int i=0;i<6;i++)
        {
            b = true;
            while(b) {
                b = false;
                n = rnd.nextInt(42)+1;
                for(int j=0;j<data.length;j++) {
                    if(n==data[j]){
                        b = true;
                    }
                }
                data[i]=n;

            }

            Jlb[i]=new JLabel(Integer.toString(data[i]));
            Jp.add(Jlb[i]);
            Jlb[i].setOpaque(true);
            Jlb[i].setBackground(new Color (100,100,255));
            Jlb[i].setFont(new Font("Source Sans pro ", Font.PLAIN, 22));
            Jlb[i].setHorizontalAlignment(SwingConstants.CENTER);
        }

    }

}
