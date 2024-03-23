import java.time.LocalDate;

public class Yonetici extends Personel {
    private double bonus;

    public Yonetici(String ad, String soyad, String rol, double saatlikUcret, double bonus) {
        super(ad, soyad, rol, saatlikUcret);
        this.bonus = bonus;
    }

    public Yonetici(String ad, String soyad, String rol) {
        super(ad, soyad, rol);
    }

    @Override
    public double anaOdemeHesapla(int calismaSaati) {
        if(getSaatlikUcret()<=500){
           double saatlikUcret = 500 ;
           return  (saatlikUcret*calismaSaati);
        }else {
            return (getSaatlikUcret() * calismaSaati) ;
        }
    }

    @Override
    public double mesaiOdemesi(int mesaiSaati) {
        return bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}

