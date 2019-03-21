package kayttoliittyma;

import data.Kurssi;
import javax.swing.JOptionPane;

import data.Opiskelija;
import data.Suoritus;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import tietokanta.Tietovarasto;

public class JFrLisaaSuoritus extends JFrame {
    private JPanel paPohja = new JPanel(new BorderLayout());
    private JPanel paNapit = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    private JPanel paYla = new JPanel(new GridLayout(5, 2));

    private JLabel lbOpiskelijaID = new JLabel("OpiskelijaID: ");
    private JTextField tfOpiskelijaID = new JTextField();
    private JLabel lbKussitunnus = new JLabel("Suoritetun kurssin tunnus: ");
    private JTextField tfKurssitunnus = new JTextField();
    private JLabel lbSuorituspvm = new JLabel("Suorituspvm (vvvv-kk-pp)");
    private JTextField tfSuorituspvm = new JTextField();

    private JButton btNappi = new JButton("Tallenna");
    private JButton btPeruuta = new JButton("Tyhjennä");

    private Tietovarasto rekisteri;

    //konstruktori
    public JFrLisaaSuoritus(Tietovarasto varasto) {
        this.rekisteri = varasto;
        asetteleKomponentit();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(100, 100);
        this.setSize(330, 170);
        this.setTitle("Lisää suoritus");
    }

    private void asetteleKomponentit() {
        paYla.add(lbOpiskelijaID);
        paYla.add(tfOpiskelijaID);
        paYla.add(lbKussitunnus);
        paYla.add(tfKurssitunnus);
        paYla.add(lbSuorituspvm);
        paYla.add(tfSuorituspvm);

        paNapit.add(btNappi);
        paNapit.add(btPeruuta);

        paPohja.add(paYla, BorderLayout.PAGE_START);
        paPohja.add(paNapit, BorderLayout.PAGE_END);

        this.add(paPohja);

        btNappi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kasitteleNappi();
            }

               private void kasitteleNappi() {
                try {
                    int opiskelijaID = Integer.valueOf(tfOpiskelijaID.getText());
                    String kurssitunnus = tfKurssitunnus.getText();
                    Date suorituspvm = Date.valueOf(tfSuorituspvm.getText());
                    Opiskelija suorittaja = rekisteri.haeOpiskelija(opiskelijaID);
                    Kurssi suoritettu = rekisteri.haeKurssi(kurssitunnus);
            
                    if (tfOpiskelijaID.getText().isEmpty() || kurssitunnus.isEmpty() || tfSuorituspvm.getText().isEmpty() ) {
                        JOptionPane.showMessageDialog(null, "Tiedoissa puutteita", "Tallennus", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        
                Suoritus kurssiSuoritus = new Suoritus(opiskelijaID, kurssitunnus, suorituspvm);
                rekisteri.lisaaSuoritus(kurssiSuoritus);
                suorittaja.lisaaSuoritus(suoritettu.getLaajuus());
                rekisteri.lisaaOpintoviikot(suorittaja);
                
                JOptionPane.showMessageDialog(null, "Tiedot tallennettu", "Tallennus", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Virhe", JOptionPane.ERROR_MESSAGE);
        }      
    }   
        });

        btPeruuta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tyhjenna();
            }
        });

    }//asetteleKomponentit loppu
    
    private void tyhjenna() {
        tfOpiskelijaID.setText("");
        tfKurssitunnus.setText("");
        tfSuorituspvm.setText("");

    }
    /**
     * @param args
     */

}
