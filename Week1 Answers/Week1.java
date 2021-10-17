class Araba  implements Comparable{
    public int modelYili;
    public String plaka;
    public String marka;
    public double motorHacmi;
    
    public Araba(String marka, int modelYili,double motorHacmi, String plaka){
        this.marka = marka;
        this.modelYili = modelYili;
        this.motorHacmi = motorHacmi;
        this.plaka = plaka;
    }
    @Override
    public int compareTo(Object gecici){
        Araba diger = (Araba) gecici;
        
        if(this.modelYili > diger.modelYili)
            return 1;
        else if(this.modelYili < diger.modelYili)
            return -1;
        else
            return 0;
    }
}