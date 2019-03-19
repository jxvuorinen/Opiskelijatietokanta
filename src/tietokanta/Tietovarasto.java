package tietokanta;

import java.sql.*;

import data.Opiskelija;
import java.util.ArrayList;

public class Tietovarasto {

    private String ajuri = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/koulu";
    private String kayttajatunnus = "root";
    private String salasana = "";

    private String sqlLisaaOpiskelija = "INSERT INTO Opiskelija(opiskelijaID, etunimi, sukunimi, "
            + "opintoviikot, paaAine) VALUES (?,?,?,?,?)";

    private String sqlHaeOpiskelija = "SELECT * FROM opiskelija WHERE opiskelijaID = ?";

    private String sqlPoistaOpiskelija = "DELETE FROM opiskelija WHERE opiskelija.opiskelijaID = ?";
    
    private String sqlHaeKaikki = "SELECT * FROM opiskelija";
    
    private String sqlMuutaTiedot = "UPDATE opiskelija SET etunimi = ?, sukunimi = ?, opintoviikot = ?, paaAine = ? WHERE opiskelijaID = ?";

    public Opiskelija haeOpiskelija(int opiskelijaID) throws Exception {
        Connection yhteys = null;
        try {
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
        } catch (Exception e) {
            throw new Exception("Tietovarasto ei ole auki.", e);
        }

        PreparedStatement haeOpiskelija = null;
        ResultSet tulos = null;
        try {
            haeOpiskelija = yhteys.prepareStatement(sqlHaeOpiskelija);
            haeOpiskelija.setInt(1, opiskelijaID);
            tulos = haeOpiskelija.executeQuery();
            if (tulos.next()) {
                return new Opiskelija(tulos.getInt(1), tulos.getString(2), tulos.getString(3), tulos.getInt(4), tulos.getString(5));
            } else {
                throw new Exception("Opiskelijaa ei löydy");
            }

        } catch (SQLException sqle) {
            throw new Exception("Hakuvirhe", sqle);
        } finally {
            YhteydenHallinta.suljeYhteys(yhteys);
        }

    }

    public void lisaaOpiskelija(Opiskelija uusiOpiskelija) throws Exception {
        int opiskelijaID = uusiOpiskelija.getOpiskelijaID();

        Connection yhteys = null;
        try {
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
        } catch (Exception e) {
            throw new Exception("Tietovarasto ei ole auki.", e);
        }
        PreparedStatement opiskelijanLisays = null;
        try {
            opiskelijanLisays = yhteys.prepareStatement(sqlLisaaOpiskelija);
            opiskelijanLisays.setInt(1, uusiOpiskelija.getOpiskelijaID());// ensimmäinen kysymysmerkki
            opiskelijanLisays.setString(2, uusiOpiskelija.getEtunimi());// toinen kysymysmerkki
            opiskelijanLisays.setString(3, uusiOpiskelija.getSukunimi());// jne
            opiskelijanLisays.setInt(4, uusiOpiskelija.getOpintoviikot());// jne
            opiskelijanLisays.setString(5, uusiOpiskelija.getPaaAine());
            opiskelijanLisays.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new Exception("Opiskelijan lisäys ei onnistu.", sqle);
        }
    }

    public void poistaOpiskelija(Opiskelija poistettava) throws Exception {
        int opiskelijaID = poistettava.getOpiskelijaID();
        Connection yhteys = null;
        try {
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
        } catch (Exception e) {
            throw new Exception("Tietovarasto ei ole auki.", e);
        }
        PreparedStatement poistaOpiskelija = null;
        try {
            poistaOpiskelija = yhteys.prepareStatement(sqlPoistaOpiskelija);
            poistaOpiskelija.setInt(1, opiskelijaID);
            poistaOpiskelija.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new Exception("Opiskelijan poisto ei onnistu.", sqle);
        }

    }
    public ArrayList<Opiskelija> haeKaikki() throws Exception {
        Connection yhteys = null;
        ArrayList<Opiskelija> listaus = new ArrayList<>();
        try {
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
        } catch (Exception e) {
            throw new Exception("Tietovarasto ei ole auki.", e);
        }

        PreparedStatement haeKaikki = null;
        ResultSet tulos = null;
        try {
            haeKaikki = yhteys.prepareStatement(sqlHaeKaikki);
            tulos = haeKaikki.executeQuery();
            while (tulos.next()) {
                listaus.add(new Opiskelija(tulos.getInt(1), tulos.getString(2), tulos.getString(3), tulos.getInt(4), tulos.getString(5)));
            }

        } catch (SQLException sqle) {
            throw new Exception("Hakuvirhe", sqle);
        } finally {
            YhteydenHallinta.suljeYhteys(yhteys);
        }
        return listaus;
    }
    public void teeMuutos(Opiskelija muutettava) throws Exception {
        int opiskelijaID = muutettava.getOpiskelijaID();
        Connection yhteys = null;
        try {
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
        } catch (Exception e) {
            throw new Exception("Tietovarasto ei ole auki.", e);
        }
        PreparedStatement muutaTiedot = null;
        try {
            muutaTiedot = yhteys.prepareStatement(sqlMuutaTiedot);
            muutaTiedot.setString(1,muutettava.getEtunimi());
            muutaTiedot.setString(2, muutettava.getSukunimi());
            muutaTiedot.setInt(3, muutettava.getOpintoviikot());
            muutaTiedot.setString(4, muutettava.getPaaAine());
            muutaTiedot.setInt(5, opiskelijaID);
            muutaTiedot.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new Exception("Opiskelijan tietojen muuttaminen ei onnistu.", sqle);
        }

    }

}
