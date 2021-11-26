public class Rotator {
    public static <T> BTNode<T> solaDondur(BTNode<T> k1){
        BTNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
    public static <T> BTNode<T> sagaDondur(BTNode<T> k2){
        BTNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    public static <T> BTNode<T> solaSagaDondur(BTNode<T> k3){
        k3.left = solaDondur(k3.left);
        return sagaDondur(k3);
    }
    public static <T> BTNode<T> sagaSolaDondur(BTNode<T> k1){
        k1.right = sagaDondur(k1.right);
        return solaDondur(k1);
    }
}