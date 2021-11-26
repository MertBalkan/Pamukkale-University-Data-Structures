/**
 * Minimum heap sınıfı
 * @param <T> Generic sınıf
 */
public class BinaryHeap<T extends Comparable<T>> {
    public T[]  dizi;//Yığını tutacak dizi(değiştirmeyin)
    public int es;//Eleman sayısı(değiştirmeyin)

    public BinaryHeap() {//değiştirmeyin
        dizi=(T[]) new Comparable[100];
    }
    public BinaryHeap(int boyut){//değiştirmeyin
        dizi=(T[])new Comparable[boyut];
    }
    public int ebeveyn(int konum){ return konum/2;}//değiştirmeyin, kullanın
    public int solCocuk(int konum){ return 2*konum;}//değiştirmeyin, kullanın
    public int sagCocuk(int konum){return 2*konum+1;}//değiştirmeyin, kullanın
    public int elemanSayisi(){return es;}

    public void ekle(T eleman){
        //Bu metodun gövdesini yazınız
        dizi[++es] = eleman;
        int konum = es;
        while(ebeveyn(konum) > 0 && dizi[ebeveyn(konum)].compareTo(dizi[konum]) > 0) //koke ulasmadigimizi gosteriyor. koke ulasmissak ebeveyn 0 olur
        {
            T gecici = dizi[konum];
            dizi[konum] = dizi[ebeveyn(konum)];
            dizi[ebeveyn(konum)] = gecici;
            konum = ebeveyn(konum);
        }
    }

    public T sil(){
        if(dizi == null) return null;
        return null;
    }
}
