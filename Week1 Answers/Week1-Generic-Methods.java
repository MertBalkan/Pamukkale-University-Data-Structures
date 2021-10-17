public class H1GenericOgrenci {
    
    public static<T extends Comparable> void sirala(T[] dizi) {
        
        int diziUzunlugu = dizi.length;
        
        for(int i = 0; i < diziUzunlugu; i++){
            for(int j = 0; j < diziUzunlugu - 1; j++){
                if(dizi[j+1].compareTo(dizi[j]) < 0){
                    T geciciDeger = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = geciciDeger;
                }
            }
        }
    }
    public static<T extends Comparable> T enbuyuk(T deger1, T deger2, T deger3){
        T maxSayi = deger1;
        
        if(deger2.compareTo(maxSayi) > 0 && deger2.compareTo(deger3) > 0){
            maxSayi = deger2;
            return maxSayi;
        }
        else if(deger3.compareTo(maxSayi) > 0 && deger3.compareTo(deger2) > 0){
            maxSayi = deger3;
            return maxSayi;
        }
        else{
            return maxSayi;
        }
    }
}