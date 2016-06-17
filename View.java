/**
 * 
 * 
 * Die View, enthaelt nur das Layout sowie Get-Methoden
 * 
 */
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class View extends JFrame{
  
    private JPanel pnlLinks = new JPanel();
    private JPanel pnlA = new JPanel();
    private JPanel pnlB = new JPanel();
    private JPanel pnlC = new JPanel();
    private JPanel pnlPunkt = new JPanel();
    private JPanel pnlStart = new JPanel();
    private JPanel pnlStep = new JPanel();
    private JPanel pnlMitte = new JPanel();
    
    private JLabel lblA = new JLabel("A:");
    private JLabel lblB = new JLabel("B:");
    private JLabel lblC = new JLabel("C:");
    private JLabel lblPunkt = new JLabel("Punkt:");
    //hier kannste die anfangswerte in die Felder Eingeben
    private JTextField txtAX = new JTextField("150",3);
    private JTextField txtAY = new JTextField("80",3);
    private JTextField txtBX = new JTextField("130",3);
    private JTextField txtBY = new JTextField("120",3);
    private JTextField txtCX = new JTextField("170",3);
    private JTextField txtCY = new JTextField("120",3);
    private JTextField txtPunktX = new JTextField("150",3);
    private JTextField txtPunktY = new JTextField("100",3);
    private JTextField txtStep = new JTextField("10",3);
    
    private JButton cmdStart = new JButton("Start");
    private JButton cmdStep = new JButton("Step");
    private JButton cmdClear = new JButton("Clear");
    
    private JRadioButton rdbStandard = new JRadioButton("Gleichseitig, Mitte",true);
    private JRadioButton rdbEingeben = new JRadioButton("Eingeben, Eingeben");
    private JRadioButton rdbZufall = new JRadioButton("Zufall, Zufall");
    private ButtonGroup gruppe = new ButtonGroup();

    /**
     * Setzt den TitelNamen und baut die GUI
     */
    public View(){
        super("Fluch Des Pharao");
        initForm();
    }

    /**
     * 
     * Ordnet GUI-Elemente an
     * 
     * 
     */
    public void initForm(){
       this.setResizable(false);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(new BorderLayout());
       //hier die Größe des Fensters ändern
       //Je nach dem wieviel Platz zum Zeichnen da sein soll
       this.setSize(750,500);
       
       pnlLinks.setLayout(new BoxLayout(pnlLinks,BoxLayout.Y_AXIS));
       this.add(pnlLinks,BorderLayout.WEST);
       this.add(pnlMitte,BorderLayout.CENTER);
       
       pnlLinks.add(rdbStandard);
       pnlLinks.add(rdbEingeben);
       pnlLinks.add(rdbZufall);
       pnlLinks.add(pnlA);
       pnlLinks.add(pnlB);
       pnlLinks.add(pnlC);
       pnlLinks.add(pnlPunkt);
       pnlLinks.add(pnlStart);
       pnlLinks.add(pnlStep);
       
       pnlA.add(lblA);
       pnlA.add(txtAX);
       pnlA.add(txtAY);
       pnlB.add(lblB);
       pnlB.add(txtBX);
       pnlB.add(txtBY);
       pnlC.add(lblC);
       pnlC.add(txtCX);
       pnlC.add(txtCY);
       pnlPunkt.add(lblPunkt);
       pnlPunkt.add(txtPunktX);
       pnlPunkt.add(txtPunktY);
       pnlStart.add(cmdStart);
       pnlStart.add(txtStep);
       pnlStep.add(cmdStep);
       pnlStep.add(cmdClear);
       gruppe.add(rdbStandard);
       gruppe.add(rdbZufall);
       gruppe.add(rdbEingeben);
              
       this.pnlLinks.setVisible(true);
    }
    //Die Ganzen Getter
    public String getAX(){
        return this.txtAX.getText();
    }
    public String getAY(){
        return this.txtAY.getText();
    }
    public String getBX(){
        return this.txtBX.getText();
    }
    public String getBY(){
        return this.txtBY.getText();
    }
    public String getCX(){
        return this.txtCX.getText();
    }
    public String getCY(){
        return this.txtCY.getText();
    }
    public String getPunktX(){
        return this.txtPunktX.getText();
    }
    public String getPunktY(){
        return this.txtPunktY.getText();
    }
    public String getStep(){
        return this.txtStep.getText();
    }
    //Die 3 Aktionlistener für die Knöpfe
    public void setStartListener(ActionListener l){
        this.cmdStart.addActionListener(l);
    }
    public void setStepListener(ActionListener l){
        this.cmdStep.addActionListener(l);
    }
    public void setClearListener(ActionListener l){
        this.cmdClear.addActionListener(l);
    }
    //Die 3 RadioButtons
    public boolean getStandard(){
        return rdbStandard.isSelected();
    }
    public boolean getZufall(){
        return rdbZufall.isSelected();
    }
    public boolean getEingeben(){
        return rdbEingeben.isSelected();
    }
    /**
     * Faerbt die Startknoepfe Gruen oder Rot je nach dem ob die
     * Eingaben korrekt sind oder nicht
     * 
     * @param valid Ob die einstellungen erlaubt sind oder nicht
     */
    public void farbe(boolean valid){
        System.out.println(valid);
        if(valid){
            cmdStart.setBackground(Color.GREEN);
            cmdStep.setBackground(Color.GREEN);
        }else{
            cmdStart.setBackground(Color.RED);
            cmdStep.setBackground(Color.RED);
        }
         
    }
}
