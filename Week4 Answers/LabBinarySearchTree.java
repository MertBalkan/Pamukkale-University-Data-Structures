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
        BTNode<T> kok = find(getRoot(), node.value);
        
                
        if(kok == null) return null;
        
        if(kok.value.compareTo(node.value) < 0){
            while(kok.right != null)
            {
                kok = kok.right;
                findParent(kok);    
            }
        }else if(kok.value.compareTo(node.value) > 0){
            while(kok.left != null){
        
                kok = kok.left;
                findParent(kok);
            }
        }
        return node;
        
    }

}
