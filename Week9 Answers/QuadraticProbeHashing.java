public class QuadraticProbeHashing<T> {
    public HashEntry<T>[] dizi;
    public int elemanSayisi;

    public QuadraticProbeHashing() {
        dizi=new HashEntry[23];
    }
    public QuadraticProbeHashing(int boyut){
        dizi=new HashEntry[boyut];
    }
    public int hash(T deger) {
        return deger.hashCode()%dizi.length;
        //her farklı deger icin kendisine ozgu konum uretir
    }

    public void ekle(T eleman){
        //Karesel sondalama ekleme işlemini gerçekleştirin
        int konum = hash(eleman);
        int i = 0;
        while(true)
        {
            HashEntry<T> hucre = dizi[(konum + i * i)%dizi.length]; 
            if(hucre == null || !hucre.isActive){
                dizi[(konum + i * i)%dizi.length] = new HashEntry<>(eleman);
                break;
            }
            i++;
        }
        elemanSayisi++;
    }

    public boolean sil(T eleman){
        //karesel sondalama silme işlemini gerçekleştirin
        if(eleman == null) return false;
        int silinecekElemaninKonumu = hash(eleman);
        
        for(int i = 0; i < dizi.length || dizi[(silinecekElemaninKonumu + i * i) % dizi.length] != null; i++){
            if(dizi[(silinecekElemaninKonumu + i * i) % dizi.length].value == eleman || dizi[(silinecekElemaninKonumu + i * i) % dizi.length].isActive){
                dizi[(silinecekElemaninKonumu + i * i) % dizi.length].isActive = false;
                return true;
            }
        }
        return false;
    }

}
