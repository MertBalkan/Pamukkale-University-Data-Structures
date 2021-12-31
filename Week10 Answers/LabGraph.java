public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {
        Vertex<T> vertex = verticesMap.get(deger);
        if(vertex != null) return vertex.edges.size();
        return -1;
    }

    @Override
    public int inDegree(T deger) {
        if(deger == null) return -1;
        int inDegreeCount = 0;
        
        Vertex<T> vertex = verticesMap.get(deger);
        if(vertex == null) return -1;
        
        for(Vertex<T> vertices : vertices){
            for(Edge<T> edge : vertices.edges){
                if(edge.to.value.equals(deger)){
                    inDegreeCount++;
                }
            }
        }
        return inDegreeCount;
    }
}
