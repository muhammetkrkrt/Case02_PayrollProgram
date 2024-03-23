import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MaasBordro {
    public void bordroOlustur(PersonelInformation personelInformation) {
        JSONObject personelJson = new JSONObject();
        personelJson.put("ismi", personelInformation.getPersonel().getAd());
        personelJson.put("calismaSaati", personelInformation.getCalismaSaati());

        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("tr", "TR"));
        format.setMaximumFractionDigits(2);

        JSONObject odemeDetaylari = new JSONObject();
        if (!personelInformation.getPersonel().getRol().equals("Yönetici")) {
            odemeDetaylari.put("anaOdeme", format.format(personelInformation.getAnaMaas()));
            odemeDetaylari.put("mesai", format.format(personelInformation.getMesaiOdemesi()));
            odemeDetaylari.put("toplamOdeme", format.format(personelInformation.getToplamOdeme()));
        } else {
            odemeDetaylari.put("anaOdeme", format.format(personelInformation.getAnaMaas()));
            odemeDetaylari.put("bonus", format.format(personelInformation.getMesaiOdemesi()));
            odemeDetaylari.put("toplamOdeme", format.format(personelInformation.getToplamOdeme()));
        }

        personelJson.put("odemeDetaylari", odemeDetaylari);

        JSONObject bordroJson = new JSONObject();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("tr", "TR"));
        String formattedDate = LocalDate.now().format(formatter);

        bordroJson.put("bordro", formattedDate);
        bordroJson.put("personel", personelJson);

        File personelKlasoru = new File(personelInformation.getPersonel().getAd().trim());
        if (!personelKlasoru.exists()) {
            personelKlasoru.mkdirs();
        }

        String dosyaAdi = personelInformation.getPersonel().getAd().trim() + "_" + formattedDate + ".json";
        File file = new File(personelInformation.getPersonel().getAd().trim(), dosyaAdi);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(bordroJson.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(personelInformation.getPersonel().getAd() + " için " + formattedDate + " maaş bilgileri başarıyla kaydedildi.");
    }
}
