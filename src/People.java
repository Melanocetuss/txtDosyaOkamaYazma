public class People {
    private String isim;
    private String soyIsim;

    public People(String s , String sy ){
        isim = s.trim();
        soyIsim = sy.trim();
    }

    public String getInfo(){
        String s = isim + " " + soyIsim;
        return s;
    }
}
