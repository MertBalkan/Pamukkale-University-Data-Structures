import java.util.List;
import java.util.ArrayList;


public class LabGraph2<T> extends AbstractGraph2<T> {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LabGraph2<T> donecek = new LabGraph2<T>();
        for(Vertex<T> v : this.vertices){//ic ice for yazmamizin sebebi once vertexlerin, sonra edgelerin eklenmesinden dolayi. Aksi halde hata alabiliriz
            donecek.addVertex(v.value);
            /*for(Vertex<T> v : this.vertices){
                //alttaki for'u bunun icine alirsak garanti bir cozum yapariz
            }*/
            for(Edge<T> e : v.edges){
                donecek.addEdge(e.from.value, e.to.value);
                //donecek.addEdge(v.value, e.to.value);
            }
        }
        return donecek;
    }

    @Override
    public void removeVertex(T deger) {
        Vertex<T> silinecek = this.verticesMap.get(deger);
        if(silinecek == null) return;
        this.vertices.remove(silinecek);
        
         //Giren kenarlarin silinmesi
         for(Vertex<T> v : this.vertices){
             Edge<T> silinecekKenar = null;
             for(Edge<T> e : v.edges){
                 if(e.to.value.equals(deger)){
                    silinecekKenar = e;
                    break;
                 }
             }
             if(silinecekKenar != null){
                 v.edges.remove(silinecekKenar);
             }
         }
    }

    @Override
    public List<T> topologicalSort() {
        List<T> donecekListe = new ArrayList<T>();
        LabGraph2<T> cloneGraph = new LabGraph2<T>();
        
        try {cloneGraph = (LabGraph2<T>) this.clone();} 
        catch (Exception e){}
        
        for(Vertex<T> v : cloneGraph.vertices)
            if(inDegree(v.value) == 0)
                donecekListe.add(v.value);
        
        return donecekListe;
    }
}
