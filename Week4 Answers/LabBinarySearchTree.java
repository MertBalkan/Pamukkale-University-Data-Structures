import java.util.ArrayList;

public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	private ArrayList<BTNode<T>> _myList;
    public LabBinarySearchTree(){
        //Bu metodu deðiþtirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu deðiþtirmeyin
        super(root);
        _myList = new ArrayList<BTNode<T>>();
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

    public BTNode<T> myFindParent(BTNode<T> nodeWay, BTNode<T> search){
    	_myList.add(nodeWay);
    	 
    	 //nodeway -> current value, search->item that we're looking for
         if(search.value.compareTo(getRoot().value) == 0) return null;
         //if node that we're looking for one of the child; return nodeWay!!!
         if(search.value.compareTo(nodeWay.value) < 0)
         {
        	 return myFindParent(nodeWay.left, search);
             
         }else if(search.value.compareTo(nodeWay.value) > 0)
         {
             
        	 return myFindParent(nodeWay.right, search);
         }

         return _myList.get(_myList.size() - 2);
         
         
    }
    @Override
    public BTNode<T> findParent(BTNode<T> node) {
        //WORK IN PROGRESS**************************	
        if(node == null) return null;

        return myFindParent(getRoot(), node);
       
    }

}