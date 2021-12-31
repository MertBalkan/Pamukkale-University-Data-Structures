import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.Comparator;
import java.util.Collections;
import java.util.LinkedList;

class EdgeComparator<T extends Comparable<T>> implements Comparator<Edge<T>>{
    int _bfsOrDfsValue;
    EdgeComparator(int bfsOrDfsValue){ //if -1 then order as a dfs, otherwise order as a bfs
        _bfsOrDfsValue = bfsOrDfsValue;
    }
    @Override
    public int compare(Edge<T> e1, Edge<T> e2){

        return e1.to.value.compareTo(e2.to.value) * _bfsOrDfsValue;
    }
}

public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {
    @Override
    public List<T> dfs(T baslangic) {
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(verticesMap.get(baslangic));
        List<T> visited = new ArrayList<>();
        while(!stack.isEmpty()){
            Vertex<T> current = stack.pop();
            if(visited.contains(current.value)){
                continue;
            }
            visited.add(current.value);
            List<Edge<T>> kenarlar = new ArrayList<Edge<T>>(current.edges);
            Collections.sort(kenarlar, new EdgeComparator<>(-1));
            for(Edge<T> kenar : kenarlar)
                stack.push(kenar.to);
            
        }
        return visited;
    }
    
    @Override
    public List<T> bfs(T baslangic) {        
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(verticesMap.get(baslangic));
        List<T> visited = new ArrayList<>();
        while(!queue.isEmpty()){
            Vertex<T> current = queue.poll();
            if(visited.contains(current.value)){
                continue;
            }
            visited.add(current.value);
            List<Edge<T>> kenarlar = new ArrayList<Edge<T>>(current.edges);
            Collections.sort(kenarlar, new EdgeComparator<>(1));
            for(Edge<T> kenar : kenarlar)
                queue.add(kenar.to);
            
        }
        return visited;
    }
}
