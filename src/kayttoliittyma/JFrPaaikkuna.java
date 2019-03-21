package kayttoliittyma;

import data.Opiskelija;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tietokanta.Tietovarasto;

public class JFrPaaikkuna extends JFrame {

    private JPanel paPohja = new JPanel(new GridLayout(4, 2));

    private JButton btLisaa = new JButton("Lisää opiskelija");
    private JButton btHaeOpiskelija = new JButton("Hae opiskelijan tiedot");
    private JButton btPoista = new JButton("Poista opiskelija");
    private JButton btMuuta = new JButton("Muuta opiskelijan tiedot");
    private JButton btHaeKaikki = new JButton("Hae kaikki opiskelijat");

    private JButton btLisaaKurssi = new JButton("Lisää kurssi");
    private JButton btLisaaSuoritus = new JButton("Lisää kurssisuoritus");
    private JButton btHaeOpiskelijanSuoritukset = new JButton("Hae opiskelijan suoritukset");

    private Tietovarasto rekisteri = new Tietovarasto();

    public JFrPaaikkuna() {
        this.setTitle("Pääikkuna");
        this.setLocation(100, 300);
        this.setSize(550, 250);
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
        paPohja.add(btLisaaKurssi);
        paPohja.add(btLisaaSuoritus);
        paPohja.add(btHaeOpiskelijanSuoritukset);

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
        btLisaaKurssi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lisaaKurssi();
            }
        });
        btLisaaSuoritus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lisaaSuoritus();
            }
        });
        btHaeOpiskelijanSuoritukset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                haeSuoritukset();
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
        try {
            ArrayList<Opiskelija> listaus = rekisteri.haeKaikki();
            if (listaus == null) {
                JOptionPane.showMessageDialog(this, "Opiskelijoita ei löytynyt", "Virhe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JTextArea kaikkiOpiskelijat = new JTextArea(10, 50);
                for (Opiskelija opiskelija : listaus) {
                    kaikkiOpiskelijat.append(opiskelija.toString());
                    kaikkiOpiskelijat.append("\n");
                }
                JOptionPane.showMessageDialog(this, new JScrollPane(kaikkiOpiskelijat), "Kaikki opiskelijat",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Virhe", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void muutaTietoja() {
        new JFrMuutos(rekisteri).setVisible(true);
    }

    private void lisaaKurssi() {
        new JFrLisaaKurssi(rekisteri).setVisible(true);
    }

    private void lisaaSuoritus() {
        new JFrLisaaSuoritus(rekisteri).setVisible(true);
    }

    private void haeSuoritukset() {
        new JFrHaeSuoritukset(rekisteri).setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrPaaikkuna ikkuna = new JFrPaaikkuna();

    }

}
