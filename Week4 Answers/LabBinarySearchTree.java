import com.sun.org.apache.bcel.internal.classfile.Node;

public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
        //Bu metodu deðiþtirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu deðiþtirmeyin
        super(root);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new LabBinarySearchTree(kopyala(getRoot()));
    }
    
    public BTNode<T> kopyala(BTNode<T> node){
        if(node == null){
            return null;
        }
        BTNode<T> newNode = new BTNode<>(node.value, null, null);
        newNode.left = kopyala(node.left);
        newNode.right = kopyala(node.right);
        return newNode;
        
    }
    
    @Override
    public BTNode<T> successor(T value) {
        BTNode<T> node = find(getRoot(), value);
        if(node == null || node.right == null)
            return null;
        node = node.right;
        while(node.left != null)
            node = node.left;
        return node;
    }

    @Override
    public BTNode<T> predecessor(T value) {
        BTNode<T> node = find(getRoot(), value);
        if(node == null || node.left == null)
            return null;
        node = node.left;
        while(node.right != null)
            node = node.right;
        return node;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {
        //WORK IN PROGRESS**************************
        if(node == null) return null;
        

        BTNode<T> nodeWay = getRoot();
        
        if(node.value.compareTo(getRoot().value) == 0) return null;
        
        if(node.value.compareTo(nodeWay.value) < 0)
        {
            nodeWay = nodeWay.left;
            findParent(node.left);
        }else if(node.value.compareTo(nodeWay.value) > 0)
        {
            nodeWay = nodeWay.right;
            findParent(node.right);
        }
        
        return nodeWay;
        
    }

}
