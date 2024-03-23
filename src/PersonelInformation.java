public class PersonelInformation {
    private Personel personel;
    private double anaMaas;
    private double mesaiOdemesi;
    private int calismaSaati;
    private double toplamOdeme;
    public PersonelInformation() {
    }

    public PersonelInformation(Personel personel, double anaMaas, double mesaiOdemesi, int calismaSaati) {
        this.personel = personel;
        this.anaMaas = anaMaas;
        this.mesaiOdemesi = mesaiOdemesi;
        this.calismaSaati = calismaSaati;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public double getAnaMaas() {
        return anaMaas;
    }

    public void setAnaMaas(double anaMaas) {
        this.anaMaas = anaMaas;
    }

    public double getMesaiOdemesi() {
        return mesaiOdemesi;
    }

    public void setMesaiOdemesi(double mesaiOdemesi) {
        this.mesaiOdemesi = mesaiOdemesi;
    }

    public int getCalismaSaati() {
        return calismaSaati;
    }

    public void setCalismaSaati(int calismaSaati) {
        this.calismaSaati = calismaSaati;
    }

    public double getToplamOdeme() {
        return toplamOdeme;
    }

    public void setToplamOdeme(double toplamOdeme) {
        this.toplamOdeme = toplamOdeme;
    }

    @Override
    public String toString() {
        return "PersonelInformation{" +
                "personel=" + personel +
                ", anaMaas=" + anaMaas +
                ", mesaiOdemesi=" + mesaiOdemesi +
                ", calismaSaati=" + calismaSaati +
                '}';
    }
}
