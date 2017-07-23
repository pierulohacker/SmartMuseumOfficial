package uniba.pierpaolomasella.myapplication;


/**
 * Created by pierpaolo on 22/07/2017.
 */

public class Details {

    String opera;
    String autore;
    String periodo;
    String tecnica;
    String cultura;
    String dimensione;
    String valore;
    String peso;
    String trovato_da;
    String descrizione;



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
//    private String getOpera() {
//        return opera;
//    }

    private void setOpera(String opera) {
        this.opera = opera;
    }

//    private String getAutore() {
//        return autore;
//    }

    private void setAutore(String autore) {
        this.autore = autore;
    }

//    private String getPeriodo() {
//        return periodo;
//    }

    private void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

//    private String getCultura() {
//        return cultura;
//    }

    private void setCultura(String cultura) {
        this.cultura = cultura;
    }

//    private String getDimensione() {
//        return dimensione;
//    }

    private void setDimensione(String dimensione) {
        this.dimensione = dimensione;
    }

//    private String getTecnica() {
//        return tecnica;
//    }

    private void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

//    private String getValore() {
//        return valore;
//    }

    private void setValore(String valore) {
        this.valore = valore;
    }

//    private String getPeso() {
//        return peso;
//    }

    private void setPeso(String peso) {
        this.peso = peso;
    }

//    private String getTrovato_da() {
//        return trovato_da;
//    }

    private void setTrovato_da(String trovato_da) {
        this.trovato_da = trovato_da;
    }

//    private String getDescrizione() {
//        return descrizione;
//    }

    private void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
