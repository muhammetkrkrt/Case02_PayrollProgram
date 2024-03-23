import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DosyaOku oku = new DosyaOku();
        List<Personel> okunanDosya = oku.dosyaOku();
        maasHesaplama(okunanDosya);
    }

    private static void maasHesaplama(List<Personel> personeller) {
        List<Personel> personelList = new ArrayList<>();
        List<PersonelInformation> personelInformations = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("------Maas Bordro Hesaplama--------");
        MaasBordro maasBordro = new MaasBordro();
        for (int i = 0; i < personeller.size(); i++) {
            PersonelInformation personelInformation = new PersonelInformation();
            System.out.println(personeller.get(i).getAd() + "  " + personeller.get(i).getRol() + "    un/in  calisma saatini giriniz");
            int calismaSaati = Integer.parseInt(scanner.nextLine());
            if (calismaSaati < 150) {
                personelList.add(personeller.get(i));
            }
            if (personeller.get(i).getRol().equals("Memur")) {
                if (calismaSaati <= 180) {
                    double anaMaas = personeller.get(i).anaOdemeHesapla(calismaSaati);
                    personelInformation.setPersonel(personeller.get(i));
                    personelInformation.setAnaMaas(anaMaas);
                    personelInformation.setCalismaSaati(calismaSaati);
                    personelInformation.setToplamOdeme(anaMaas);
                    personelInformation.setMesaiOdemesi(0);
                    maasBordro.bordroOlustur(personelInformation);
                    personelInformations.add(personelInformation);
                } else {
                    int mesaiSaati = calismaSaati - 180;
                    double mesaiOdemesi = personeller.get(i).mesaiOdemesi(mesaiSaati);
                    double anaMaas = personeller.get(i).anaOdemeHesapla(180);
                    double toplamMaas = mesaiOdemesi + anaMaas;
                    personelInformation.setPersonel(personeller.get(i));
                    personelInformation.setAnaMaas(anaMaas);
                    personelInformation.setCalismaSaati(calismaSaati);
                    personelInformation.setToplamOdeme(toplamMaas);
                    personelInformation.setMesaiOdemesi(mesaiOdemesi);
                    maasBordro.bordroOlustur(personelInformation);
                    personelInformations.add(personelInformation);
                }
            } else if (personeller.get(i).getRol().equals("Yonetici")) {
                double anaMaas = personeller.get(i).anaOdemeHesapla(calismaSaati);
                System.out.println("Bonus Ucreti giriniz");
                double bonus = Double.parseDouble(scanner.nextLine());
                personelInformation.setPersonel(personeller.get(i));
                personelInformation.setAnaMaas(anaMaas);
                personelInformation.setCalismaSaati(calismaSaati);
                personelInformation.setToplamOdeme(bonus + anaMaas);
                personelInformation.setMesaiOdemesi(bonus);
                maasBordro.bordroOlustur(personelInformation);
                personelInformations.add(personelInformation);
            }

        }
        System.out.println("------------------Personel Bordro bilgileri ---------------------");
        String baslik = String.format("%-20s %-20s %-15s %-15s %-15s",
                "Ad", "Soyad", "Rol", "Calisma Saati", "Toplam Odeme");
        System.out.println(baslik);
        personelInformations.stream().forEach(x -> {
            String formattedOutput = String.format("%-20s %-20s %-15s %-15s %-15s",
                    x.getPersonel().getAd(),
                    x.getPersonel().getSoyad(),
                    x.getPersonel().getRol(),
                    x.getCalismaSaati(),
                    x.getToplamOdeme());
            System.out.println(formattedOutput);
        });
        System.out.println("------------------Calisma Saati 150 nin Altinda Kalanlar ---------------------");
        personelList.stream().forEach(x -> {
            String formattedOutput = String.format("%-20s %-20s ",
                    x.getAd(),
                    x.getSoyad()
                    );
            System.out.println(formattedOutput);
        });
    }
}