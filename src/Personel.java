import java.time.LocalDate;

public abstract class Personel {
    private String ad;
    private String soyad;
    private String rol;
    private double saatlikUcret = 500.00;

    public Personel(String ad, String soyad, String rol, double saatlikUcret) {
        this.ad = ad;
        this.soyad = soyad;
        this.rol = rol;
        this.saatlikUcret = saatlikUcret;
    }

    public Personel(String ad, String soyad, String rol) {
        this.ad = ad;
        this.soyad = soyad;
        this.rol = rol;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    public double getSaatlikUcret() {
        return saatlikUcret;
    }

    public void setSaatlikUcret(double saatlikUcret) {
        this.saatlikUcret = saatlikUcret;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", rol='" + rol + '\'' +
                ", saatlikUcret=" + saatlikUcret +
                '}';
    }

    public abstract double anaOdemeHesapla(int calismaSaati);
    public abstract double mesaiOdemesi(int mesaiSaati);

}
