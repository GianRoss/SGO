package com.example.yehia.studentsgo;

public class Passaggio {

    private String ritrovo;
    private String orario;
    private String posti;
    private String citta;
    private boolean genitore;

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getPosti() {
        return posti;
    }

    public void setPosti(String posti) {
        this.posti = posti;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getRitrovo() {
        return ritrovo;
    }

    public void setRitrovo(String ritrovo) {
        this.ritrovo = ritrovo;
    }

    public boolean isGenitore() {
        return genitore;
    }

    public void setGenitore(boolean genitore) {
        this.genitore = genitore;
    }
}
