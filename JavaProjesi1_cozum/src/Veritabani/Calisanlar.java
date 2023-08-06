package Veritabani;

import Modeller.Calisanlar.Calisan;
import Modeller.Departmanlar.Departman;

import java.util.ArrayList;

public class Calisanlar {

    private static ArrayList<Calisan> calisanList = new ArrayList<>();

    // Tüm çalışanları almak için
    public static ArrayList<Calisan> getCalisanList() {
        return calisanList;
    }

    // Bir çalışan eklemek için
    public static void addACalisan(Calisan calisan) {
        Calisanlar.calisanList.add(calisan);
    }


    // Bir çalışan silmek için
    public static void deleteACalisanWithId(String calisanId) {
        for (int i = 0; i < calisanList.size(); i++) {
            if (calisanList.get(i).getCalisanId().equals(calisanId)) {
                calisanList.remove(calisanList.get(i));
            }
        }
    }

    // Departman kodu verilerek, konsola o departmanda calisanlari yazdirmak için
    public static void printDepartmandakiCalisanlar(String departmanKodu) {

        Departman d = null;
        for (Departman departman : Departmanlar.getDepartmanList()) {
            if (departman.getDepartmanKodu().equals(departmanKodu)) {
                d = departman;
            }
        }
        for (Calisan calisan : calisanList) {
            if (calisan.getDepartman() == d) {
                System.out.println(calisan);
            }
        }
    }


    // Calisanlari konsola yazdirmak için
    public static void printCalisanlar() {
        for (Calisan calisan : calisanList) {
            System.out.println(calisan.toString());
        }
    }


}
