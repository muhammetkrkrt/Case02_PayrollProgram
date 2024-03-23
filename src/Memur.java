import java.time.LocalDate;

public class Memur extends Personel {
    private Derece derece;
    private double mesai;
    public Memur(String ad, String soyad, String rol, double saatlikUcret, Derece derece) {
        super(ad, soyad, rol, saatlikUcret);
        this.derece = derece;
    }

    public Memur(String ad, String soyad, String rol) {
        super(ad, soyad, rol);
    }

    @Override
    public double anaOdemeHesapla(int calismaSaati) {
        return getSaatlikUcret() * calismaSaati;
    }

    @Override
    public double mesaiOdemesi(int mesaiSaati) {
        return (getSaatlikUcret()* 1.5) * mesaiSaati ;
    }

    public Derece getDerece() {
        return derece;
    }

    public void setDerece(Derece derece) {
        this.derece = derece;
    }

    public double getMesai() {
        return mesai;
    }

    public void setMesai(double mesai) {
        this.mesai = mesai;
    }
}
