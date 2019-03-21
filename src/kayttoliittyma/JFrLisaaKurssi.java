package kayttoliittyma;

import data.Kurssi;
import javax.swing.JOptionPane;

import data.Opiskelija;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import tietokanta.Tietovarasto;

public class JFrLisaaKurssi extends JFrame {

    private JPanel paPohja = new JPanel(new BorderLayout());
    private JPanel paNapit = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    private JPanel paYla = new JPanel(new GridLayout(5, 2));

    private JLabel lbKurssitunnus = new JLabel("Kurssitunnus");
    private JTextField tfKurssitunnus = new JTextField();
    private JLabel lbKussinNimi = new JLabel("Kurssin nimi");
    private JTextField tfKurssinNimi = new JTextField();
    private JLabel lbOpintoviikot = new JLabel("Kurssin laajuus (ov)");
    private JTextField tfOpintoviikot = new JTextField();

    private JButton btNappi = new JButton("Tallenna");
    private JButton btPeruuta = new JButton("Tyhjennä");
    

    private Tietovarasto rekisteri;

    //konstruktori
    public JFrLisaaKurssi(Tietovarasto varasto) {
        this.rekisteri = varasto;
        asetteleKomponentit();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(100, 100);
        this.setSize(320, 170);
        this.setTitle("Lisää kurssi tietokantaan");
    }

    private void asetteleKomponentit() {
        paYla.add(lbKurssitunnus);
        paYla.add(tfKurssitunnus);
        paYla.add(lbKussinNimi);
        paYla.add(tfKurssinNimi);
        paYla.add(lbOpintoviikot);
        paYla.add(tfOpintoviikot);

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
                    String kurssitunnus = tfKurssitunnus.getText();
                    String kurssinNimi = tfKurssinNimi.getText();
                    int opintoviikot = Integer.parseInt(tfOpintoviikot.getText());
            
                    if (kurssitunnus.isEmpty() || kurssinNimi.isEmpty() || tfOpintoviikot.getText().isEmpty() ) {
                        JOptionPane.showMessageDialog(null, "Tiedoissa puutteita", "Tallennus", JOptionPane.INFORMATION_MESSAGE);
                } else {
                Kurssi kurssi = new Kurssi(kurssitunnus, kurssinNimi, opintoviikot);
                rekisteri.lisaaKurssi(kurssi);
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
        tfKurssitunnus.setText("");
        tfKurssinNimi.setText("");
        tfOpintoviikot.setText("");

    }
    /**
     * @param args
     */

}
