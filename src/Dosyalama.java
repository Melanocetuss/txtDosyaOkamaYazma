import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Dosyalama {

    private File dosya = new File("kisiler.txt");
    private  int no = 0;
    private FileWriter yazici;
    private BufferedWriter bufY;

    public void dosyaYaz(){
        Scanner sc = new Scanner(System.in);
        ArrayList <String> liste = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Isim: ");
            String isim = sc.nextLine().trim();

            System.out.println("Soyisim: ");
            String soyIsim = sc.nextLine().trim();

            People kisi = new People(isim , soyIsim);
            no++;
            liste.add(no + ". " + kisi.getInfo());
        }
        doldur(liste);
    }

    private void doldur(ArrayList<String> liste){
        try {
            yazici = new FileWriter(dosya);
            bufY = new BufferedWriter(yazici);

            for (int i = 0; i <liste.size(); i++) {
                bufY.write(liste.get(i) + "\n");
            }
            bufY.close();
        }
        
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void  degistir(){
        Scanner sc = new Scanner(System.in);
        try {
            FileReader ok = new FileReader(dosya);
            BufferedReader bo = new BufferedReader(ok);
            ArrayList <String> liste = new ArrayList<>();
            String temp;

            while ((temp=bo.readLine()) != null){
                liste.add(temp);
            }
            System.out.println("Degistirmel istedginiz kisinin namarsinin giriniz");
            String no = sc.nextLine().trim();

            for (int i = 0; i < liste.size(); i++) {
                if(liste.get(i).contains(no)){

                    System.out.println("Isim: ");
                    String isim = sc.nextLine().trim();

                    System.out.println("Soyisim: ");
                    String soyIsim = sc.nextLine().trim();

                    People kisi = new People(isim,soyIsim);
                    String s = no + ". " + kisi.getInfo();
                    liste.set(i,s);
                }
            }
            doldur(liste);
        }
        catch (Exception e){
           e.printStackTrace();
        }

    }

}
