package kayttoliittyma;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import tietokanta.Tietovarasto;

public class JFrPaaikkuna extends JFrame {

    private JPanel paPohja = new JPanel(new GridLayout(5, 1));

    private JButton btLisaa = new JButton("Lisää opiskelija");
    private JButton btHaeOpiskelija = new JButton("Hae opiskelijan tiedot");
    private JButton btPoista = new JButton("Poista opiskelija");
    private JButton btMuuta = new JButton("Muuta opiskelijan tiedot");
    private JButton btHaeKaikki = new JButton("Hae kaikki opiskelijat");

    private Tietovarasto rekisteri = new Tietovarasto();

    public JFrPaaikkuna() {
        this.setTitle("Pääikkuna");
        this.setLocation(100, 300);
        this.setSize(250, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        asetteleKomponentit();
        this.setVisible(true);
    }

    private void asetteleKomponentit() {
        paPohja.add(btLisaa);
        paPohja.add(btHaeOpiskelija);
        paPohja.add(btPoista);
        paPohja.add(btMuuta);
        paPohja.add(btHaeKaikki);

        this.add(paPohja);

        btLisaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lisaaOpiskelija();
            }
        });

        btHaeOpiskelija.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                haeOpiskelija();
            }
        });

        btPoista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                poistaOpiskelija();
            }
        });
        
        btHaeKaikki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                haeKaikkiOpiskelijat();
            }
        });
        
        btMuuta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                muutaTietoja();
            }
        });
        
    }//asetteleKomponentit lopetus

    private void lisaaOpiskelija() {
        new JFrLisays(rekisteri).setVisible(true);
    }

    private void haeOpiskelija() {
        new JFrHaku(rekisteri).setVisible(true);
    }

    private void poistaOpiskelija() {
        new JFrPoisto(rekisteri).setVisible(true);
    }
    
    private void haeKaikkiOpiskelijat() {
        new JFrHaeKaikki(rekisteri).setVisible(true);
    }
    
    private void muutaTietoja() {
        new JFrMuutos(rekisteri).setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrPaaikkuna ikkuna = new JFrPaaikkuna();

    }

}
