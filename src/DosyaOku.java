import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class DosyaOku {
    private List<Personel> personelList ;

    public DosyaOku() {
        this.personelList = new ArrayList<>();
    }

    public List<Personel> dosyaOku() {
        try {

            FileReader fileReader = new FileReader("personel.json");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonBuilder.append(line).append("\n");
            }
            bufferedReader.close();

            JSONArray jsonArray = new JSONArray(jsonBuilder.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String surname = obj.getString("surname");
                String role = obj.getString("role");
                if(role.equals("Yonetici")){
                    Personel personel=new Yonetici(name,surname,role);
                    getPersonelList().add(personel);
                }else{
                    Personel personel=new Memur(name,surname,role);
                    getPersonelList().add(personel);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getPersonelList();
    }


    public List<Personel> getPersonelList() {
        return personelList;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }
}
