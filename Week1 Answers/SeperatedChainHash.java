import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        int h = hash(deger);
        
        if(dizi[h] == null) 
            dizi[h] = new LinkedList<>();
        
        dizi[h].add(deger);
    } 
    public boolean sil(int deger){
        int h = hash(deger);
        
        if(dizi[h] == null) 
            return false;
        
        int konum = dizi[h].indexOf(deger);
        
        if(konum == -1) 
            return false;
        dizi[h].remove(konum);
        
        return true;
    }
    public boolean asalMi(int deger){
        int kontrol = 0;
        for(int i = 2; i < kontrol; i++){
            if(deger % i == 0) {
                kontrol = 1;
                return false;
            }
        }
        if(kontrol == 0) return true;
        return false;
    }
    public int yeniAsalBoyut(int deger){
        int yeniDeger = deger;
        while(!asalMi(yeniDeger))
            yeniDeger++;
        return yeniDeger;
    }
    public void yenidenOzetle() {
        LinkedList<Integer>[] eskiDizi = dizi;
        dizi = new LinkedList[yeniAsalBoyut((dizi.length * 2) + 1)];
        
        for(LinkedList<Integer> linkedList : eskiDizi){
            if(linkedList!=null)
                for(Integer value : linkedList){
                    ekle(value);
                }
            }
        }
    
        
        //bir dizinin 2 katının 1 fazlasına bak. Eger asal sayi bulursan yeni bir tane dizi olustur
        //olusturulan diziyi yukardaki dizinin ustune yaz
        
        //yenidenOzetle metodunu yazınız //asal sayi
        //tablo boyutunu asal sayi ile belirle.
        //bir sayinin asal olup olmadigini hesapla
    }
