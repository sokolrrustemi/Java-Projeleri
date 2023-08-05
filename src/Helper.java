import java.util.Scanner;

public class Helper {
    static Scanner scan = new Scanner(System.in);

    private static String loggedInUsername;
    private static UserRole loggedInUserRole;

    private static void login() {   //TODO LOGIN FONKSIYONUNU YAZIN

        if (loggedInUserRole != null) {
            System.out.println("Giriş yapılmış durumda.");
            return;
        }
        // login olunduğunda, "loggedInUserRole" ya ADMIN ya USER rolünü alacak, eğer null ise
        // login olunmamış demektir...

        //TODO loggedInUserRole null olup olmadığını kontrol ederek,
        //TODO kullanıcıdan, kullanıcı adı ve şifre isteyiniz...

        while (true) {
        System.out.print("Kullanıcı Adı: ");
        String username = scan.nextLine();
        System.out.print("Şifre: ");
        String password = scan.nextLine();

        //TODO username:password > admin:Admin123 ya da user:User123 şartının sağlanıp sağlanmadığına bakın...
        //TODO Geçerli giriş sağlanırsa kullanıcının rolünü belirleyin,
        //TODO "Admin olarak giris yapildi!" ya da "Standart kullanici olarak giris yapildi!" uygun olan mesajı verin..
        //TODO Yoksa "Gecersiz kullanici adi veya sifre!" mesajını döndürün.

        UserRole userRole = kullaniciDogrulama(username, password);
        if (userRole == null) {
            System.out.println("Geçersiz kullanıcı adı veya şifre!");
        } else {
            loggedInUsername = username;
            loggedInUserRole = userRole;
            if (userRole == UserRole.ADMIN) {
                System.out.println("Admin olarak giriş yapıldı!");
            } else {
                System.out.println("Standart User olarak giriş yapıldı!");
            }
            break;
        }
     }
    }
    private static UserRole kullaniciDogrulama(String kullaniciAdi, String sifre) {
        // Kullanıcı adı ve şifre doğrulama işlemini burada gerçekleştirin...
        // Örneğin:
        if (kullaniciAdi.equals("Admin") && sifre.equals("Admin123")) {
            return UserRole.ADMIN;
        } else if (kullaniciAdi.equals("User") && sifre.equals("User123")) {
            return UserRole.USER;
        } else {
            return null;
        }
    }

    public static void anaMenu() throws InterruptedException {
        login(); // Kullanıcı girişi yapılıyor
        //TODO User Role'e göre kullanıcının "showAdminMenu()" ya da "showUserMenu()" ye
        //TODO Yönlendirin...
        if (loggedInUserRole == UserRole.ADMIN) {
            showAdminMenu();
        } else if (loggedInUserRole == UserRole.USER) {
            showUserMenu();
        } else {
            System.out.println("Giris yapmaniz gerekmektedir!");
            return;
        }

        String tercih ="";
        while (true) {
         {//TODO Kullanıcıdan alacağınız tercihlere göre, gerekli menü metodlarına yönlendirme yapınız
             System.out.println(
                   "\n=========== TECHNO STUDY CONFLUENCE =============\n" +
                            "=================== ANA MENU ====================\n" +
                           "\n" +
                           "\t   1- Kutuphane Bilgileri Goruntule\n" +
                           "\t   2- Uyeler Menu\n" +
                            "\t   3- Kitaplar Menu\n" +
                            "\t   Q- CIKIS\n");
            System.out.print("Lutfen Menuden tercihinizi yapiniz:");

            tercih = scan.nextLine().toLowerCase();
             if (tercih.equals("1")) {
                 kutuphaneBilgileriniYazdir();
             } else if (tercih.equals("2")) {
                 loginAndShowUserMenu(UserRole.ADMIN);

             } else if (tercih.equals("3")) {
                 loginAndShowUserMenu(UserRole.ADMIN);
             } else if (tercih.equals("q")) {
                 System.out.println("Cikis yapiliyor...");
                 projeDurdur();
             } else {
                 System.out.println("Gecersiz bir tercih yaptiniz. Lutfen tekrar deneyin.");
             }
         }
         }
 }
    public static void kutuphaneBilgileriniYazdir() throws InterruptedException
    {//BU METODDA BİR DEĞİŞİKLİK YAPMANIZA GEREK YOK...

        System.out.print("Kutuphane bilgileri yazdiriliyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println("\n" +
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                "\t\t Kutuphane : " + Kutuphane.kutuphaneIsim +
                "\n\t\t Adres : " + Kutuphane.adres +
                "\n\t\t Telefon : " + Kutuphane.telefon);

    }

    private static void loginAndShowUserMenu(UserRole requiredRole) throws InterruptedException {
        System.out.print("Kullanici Adi: ");
        String username = scan.nextLine();
        System.out.print("Sifre: ");
        String password = scan.nextLine();

        //Kullanıcıdan aldığınız username ve password, authenticateUser(String username, String password)
        //metodunda doğrulamaya tabi tutuluyor...
        UserRole role = authenticateUser(username, password);

        //NOT : Doğrulamadan geçerse role ADMIN veya USER olur... Geçmezse "null" olur

        //TODO null ise "Gecersiz kullanici adi veya sifre." mesajı verin
        //TODO ADMIN ise showAdminMenu() metoduyla admin menüyü gösterin
        //TODO USER ise showUserMenu() metoduyla user menüyü gösterin...
        //TODO Aksi durumlarda "Bu sayfaya erisim izniniz yok." mesajını verin...
        //if-else bloklarıyla şartlar gerçeklenebilir...
    }

    private static UserRole authenticateUser(String username, String password) {

        //TODO Girilen Kullanıcı adı ve şifreyi kontrol edin,
        //TODO Geçerli kullanıcıadı ve şifreyse UserRole return edin... > ADMIN ya da USER
        return null;
    }

    private static void showAdminMenu() throws InterruptedException {

        System.out.println(
                "\n=========== TECHNO STUDY CONFLUENCE ==========\n" +
                        "================== ADMIN MENU ================\n" +
                        "\n" +
                        "\t   1- Uyeler Menu\n" +
                        "\t   2- Kitaplar Menu\n" +
                        "\t   A- ANAMENU\n" +
                        "\t   Q- CIKIS");

        //TODO Kullanıcıdan alacağınız tercihlere göre ilgili menüye (metoda) yönlendirme yapınız...

        System.out.print("Lutfen Menuden tercihinizi yapiniz:");
        String tercih = scan.nextLine().toLowerCase();

        if (tercih.equals("1")) {
        UyeManager.uyeMenu();
        } else if (tercih.equals("2")) {
        KitapManager.kitapMenu();
        } else if (tercih.equals("A")) {
         anaMenu();
        } else if (tercih.equals("Q")) {
        System.out.println("Cikis yapiliyor...");
         projeDurdur();
        } else {
         System.out.println("Lutfen gecerli bir tercih giriniz");
        }
    }
    private static void showUserMenu() throws InterruptedException {
        while (true) {

        //TODO Kullanıcı Çıkış Yapmadığı Sürece User Menüde Kalsın...

                 System.out.println(
                          "\n========== TECHNO STUDY CONFLUENCE ===========\n" +
                            "================== USER MENU =================\n" +
                            "\n" +
                            "\t   1- Uyeleri Listele\n" +
                            "\t   2- Soyisimden Uye Bulma\n" +
                            "\t   3- Sehire Gore Uye Bulma\n" +
                            "\t   4- Kitaplari Listele\n" +
                            "\t   5- Yazardan Kitap Bulma\n" +
                            "\t   6- Kitap Turu veya Yayin Tarihi Ile Kitap Bulma\n" +
                            "\t   7- Kitap Odunc Al\n" +
                            "\t   8- Kitap Iade Et\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");

            //TODO Kullanıcıdan alacağınız tercihlere göre ilgili menüye (metoda) yönlendirme yapınız...
            System.out.print("Lutfen Menuden tercihinizi yapiniz:");
            String tercih = scan.nextLine().toLowerCase();

            if (tercih.equals("1")) {
                UyeManager.uyeListesiYazdir();
            } else if (tercih.equals("2")) {
                UyeManager.soyisimdenUyeBulma();
            } else if (tercih.equals("3")) {
                UyeManager.sehreGoreUyeBulma();
            } else if (tercih.equals("4")) {
                KitapManager.kitapListesiYazdir();
            } else if (tercih.equals("5")) {
                KitapManager.yazardanKitapBulma();
            } else if (tercih.equals("6")) {
                KitapManager.turVeyaYayinTarihiIleKitapBulma();
            } else if (tercih.equals("7")) {
                KitapManager.kitapOduncAl();
            } else if (tercih.equals("8")) {
                KitapManager.kitapIadeEt();
            } else if (tercih.equals("A")) {
                anaMenu();
            } else if (tercih.equals("Q")) {
                System.out.println("Cikis yapiliyor...");
               projeDurdur();
            } else {
               System.out.println("Lutfen gecerli bir tercih giriniz");
            }
        }
    }

    public static void projeDurdur() {
        System.out.println("Kutuphane projesinden ciktiniz");
        System.exit(0);
    }
}

