public class Traversal {
    public static<T> String inOrder(BTNode<T> node) {
        if(node == null) return "";
        String sol = inOrder(node.left);
        String sag = inOrder(node.right);
        
        
        return sol + (sol.equals("") ? "":" ") + node.value + (sag.equals("") ? "" : " ")+ sag;
    }

    public static<T> String preOrder(BTNode<T> node) {
        if(node == null) return "";
        String sol = preOrder(node.left);
        String sag = preOrder(node.right);
        
        return node.value + (sol.equals("") ? "": " ") + sol + (sag.equals("") ? "" : " ")+ sag;
   
    }

    public static<T> String postOrder(BTNode<T> node) {
        if(node == null) return "";
        String sol = postOrder(node.left);
        String sag = postOrder(node.right);
        
        return sol + (sol.equals("") ? "" : " ") + sag + (sag.equals("") ? "" : " ") + node.value;
        //return node.value + (sol.equals("") ? "": " ") + sol + (sag.equals("") ? "" : " ")+ sag;
   
    }
}