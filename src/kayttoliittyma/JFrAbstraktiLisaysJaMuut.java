package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import tietokanta.Tietovarasto;


public abstract class JFrAbstraktiLisaysJaMuut extends JFrame{
	
	 //protected muuttujia voi käyttää samassa pakkauksessa olevat luokat
    private JPanel paPohja = new JPanel(new BorderLayout());
    private JPanel paNapit = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    private JPanel paYla = new JPanel(new GridLayout(5, 2));
    
    private JLabel lbId = new JLabel("OpiskelijaID");
    protected JTextField tfId = new JTextField();
    private JLabel lbEtunimi = new JLabel("Etunimi");
    protected JTextField tfEtunimi = new JTextField();
    private JLabel lbSukunimi = new JLabel("Sukunimi");
    protected JTextField tfSukunimi = new JTextField();
    private JLabel lbOpintoviikot = new JLabel("Opintoviikot");
    protected JTextField tfOpintoviikot = new JTextField();
    private JLabel lbPaaAine = new JLabel("Pääaine");
    protected JTextField tfPaaAine = new JTextField();
    protected JButton btNappi = new JButton();
    protected JButton btPeruuta = new JButton("Tyhjennä");
    protected JButton btPaivita = new JButton("Hae ID:llä");
    
    protected Tietovarasto rekisteri;
	
    //konstruktori
    public JFrAbstraktiLisaysJaMuut(Tietovarasto varasto){
    	this.rekisteri = varasto;
    	asetteleKomponentit();
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setLocation(100, 100);
    	this.setSize(300,180);
    }
    
    private void asetteleKomponentit(){
    	paYla.add(lbId);
    	paYla.add(tfId);
    	paYla.add(lbEtunimi);
    	paYla.add(tfEtunimi);
    	paYla.add(lbSukunimi);
    	paYla.add(tfSukunimi);
    	paYla.add(lbOpintoviikot);
    	paYla.add(tfOpintoviikot);
        paYla.add(lbPaaAine);
        paYla.add(tfPaaAine);
    	
    	paNapit.add(btNappi);
        paNapit.add(btPaivita);
    	paNapit.add(btPeruuta);
    	
    	paPohja.add(paYla, BorderLayout.PAGE_START);
    	paPohja.add(paNapit, BorderLayout.PAGE_END);
    	
    	this.add(paPohja);
    	
    	btNappi.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			kasitteleNappi();
    		}
    	});
    	
    	btPeruuta.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			tyhjenna();
    		}
    	});
        
        btPaivita.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			haeTiedot();
    		}
    	});
    }//asetteleKomponentit loppu
    
    protected abstract void kasitteleNappi();
    
    protected abstract void haeTiedot();
	
    private void tyhjenna(){
    	tfId.setText("");
    	tfSukunimi.setText("");
    	tfEtunimi.setText("");
    	tfOpintoviikot.setText("");
        tfPaaAine.setText("");
        
    }
	/**
	 * @param args
	 */
	

}
