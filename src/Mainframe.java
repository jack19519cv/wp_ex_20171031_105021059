import com.sun.deploy.uitoolkit.impl.fx.ui.FXMessageDialog;
import javafx.scene.control.*;
import sun.print.DialogOwner;

import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.*;

import java.awt.*;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.peer.DialogPeer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class Mainframe extends JFrame{

    private int ScreenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 800,frmH=600 ;
    private JMenuBar jmb = new JMenuBar();
    private  JMenu jmF = new JMenu("File");
    private  JMenu jmSet = new JMenu("Set");
    private  JMenu jmGame = new JMenu("Game");
    private  JMenu jmAbout = new JMenu("About");
    private  JMenuItem jmItemExit = new JMenuItem("Exit");
    private  JMenuItem jmItemLoto = new JMenuItem("Loto");

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
    private  Loginframe log;
//----------------------------------------------font-----style
    private  JMenuItem jmItemStyle = new JMenuItem("Style");
    private  JLabel Jlb1= new JLabel("family");
    private  JLabel Jlb2 = new JLabel("style");
    private  JLabel Jlb3 = new JLabel("font size");
    private JPanel jPanel1 = new JPanel(new GridLayout(2,3,3,3));
    String[]    Option = {"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    JComboBox jcb = new JComboBox(Option);
    private JTextField jtfF = new JTextField("Source Sans pro");
    private JTextField jtfFont = new JTextField("24");
//----------------------------------------------font-----style
    //------------------internal frame---add---gategory---------------------------
    private JLabel jlbge = new JLabel();
    private  JInternalFrame jifge = new JInternalFrame();
private Container  cpga = new Container();
    private JMenu jmdata = new JMenu("file");
    private JFileChooser jfc = new JFileChooser();
    private JTextArea Jta = new JTextArea();
    private  JScrollPane jsp = new JScrollPane();
    private  JMenuItem jmiload = new JMenuItem("Load");
    private  JMenuItem jmige = new JMenuItem("gategory");
    private JMenuItem jminew = new JMenuItem("New");
    private JMenuItem jmiclose = new JMenuItem("close");
    private JMenuBar jmbge = new JMenuBar();



    //------------------internal frame---add---gategory---------------------------
    private boolean b;

    public Mainframe(Loginframe loginframe){
        log= loginframe;
        init();
    }
    private void init(){
            this.setContentPane(jdp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Mainframe.this.setVisible(false);
                log.setVisible(true);
            }
        });
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        this.setJMenuBar(jmb);

        jifge.setJMenuBar(jmbge);

        jmbge.add(jmdata);

        jmb.add(jmF);
        jmb.add(jmSet);
        jmb.add(jmGame);
        jmb.add(jmAbout);


        jmdata.add(jminew);
        jmdata.add(jmiload);
        jmdata.add(jmiclose);

        jmF.add(jmItemExit);
        jmF.add(jmige);
        jmGame.add(jmItemLoto);
        jmSet.add(jmItemStyle);
        jmItemExit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmItemLoto.setAccelerator(KeyStroke.getKeyStroke('C',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmItemStyle.setAccelerator(KeyStroke.getKeyStroke('f',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmige.setAccelerator(KeyStroke.getKeyStroke('g',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        cp = jif.getContentPane();
        cpga = jifge.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cpga.setLayout(new BorderLayout(5,5));
        cpga.add(Jta);
        cp  .add(Jp,BorderLayout.CENTER);
        cp.add(Jp1,BorderLayout.SOUTH);
     Jp1.add(Jbtn1);
        Jp1.add(Jbtn2);
        jif.setBounds(0,0,300,120);
        jifge.setBounds(0,0,500,400);

        jPanel1.add(Jlb1);
        jPanel1.add(Jlb2);
        jPanel1.add(Jlb3);
        jPanel1.add(jtfF);
        jPanel1.add(jcb);
        jPanel1.add(jtfFont);
        jsp.add(jlbge);

        //------------------internal frame---add---gategory---------------------------
        jmige.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

              jdp.add(jifge);
                jifge.setVisible(true);
            }
        });
        jmiclose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jifge.dispose();
            }
        });
        jmiload.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    try{
                        File infile = jfc.getSelectedFile();
                        BufferedReader br = new BufferedReader(new FileReader(infile));
                        String str ="";
                        while((str =br.readLine())!=null){

                           Jta.append(str+"\n");
                        }
                    }catch (Exception ioe){
                        JOptionPane.showInputDialog(null,"openFail"+ioe.toString());
                    }
                }
            }
        });
        //------------------internal frame---add---gategory---------------------------
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
int result = JOptionPane.showConfirmDialog(Mainframe.this,jPanel1,"font Setting",JOptionPane.OK_CANCEL_OPTION);
int FontStyle=0;
switch(jcb.getSelectedIndex()){
    case 0:
        FontStyle=Font.PLAIN;
    case 1:
        FontStyle=Font.BOLD;
    case 2:
        FontStyle=Font.ITALIC;
    case 3:
        FontStyle=Font.BOLD+Font.ITALIC;
}
if(result==JOptionPane.OK_OPTION){
                    UIManager.put("Menu.font",new Font(jtfF.getText(),FontStyle,Integer.parseInt(jtfFont.getText())));
                }


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
