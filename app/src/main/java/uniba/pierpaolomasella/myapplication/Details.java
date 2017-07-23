package uniba.pierpaolomasella.myapplication;


/**
 * Created by pierpaolo on 22/07/2017.
 */

public class Details {

    private String opera, autore, periodo, tecnica, cultura, dimensione, valore, peso, trovato_da, descrizione;


    public Details(String opera, String autore, String periodo, String tecnica,String cultura,String dimensione,String valore, String peso, String trovato_da,String descrizione)
    {
        this.setOpera(opera);
        this.setAutore(autore);
        this.setPeriodo(periodo);
        this.setTecnica(tecnica);
        this.setCultura(cultura);
        this.setDimensione(dimensione);
        this.setValore(valore);
        this.setPeso(peso);
        this.setTrovato_da(trovato_da);
        this.setDescrizione(descrizione);

    }
    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public String getDimensione() {
        return dimensione;
    }

    public void setDimensione(String dimensione) {
        this.dimensione = dimensione;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTrovato_da() {
        return trovato_da;
    }

    public void setTrovato_da(String trovato_da) {
        this.trovato_da = trovato_da;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
