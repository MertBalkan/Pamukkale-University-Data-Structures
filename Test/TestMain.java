
public class TestMain {

	public static void main(String[] args) {
		//here do your tests
		//LinkedListTest();
		//TreeTest();
		TraversalTest();
	}
	
	//WEEK 3
	private static void LinkedListTest() {

        LabDoublyLinkedList<Integer> myLinkedList = new LabDoublyLinkedList<>();
        	
        //INSERT AT
        System.out.println("AFTER INSERT...");
        myLinkedList.insertAt(0, 6);
        myLinkedList.insertAt(0, 5);
        myLinkedList.insertAt(0, 4);
        myLinkedList.insertAt(0, 3);
        myLinkedList.insertAt(0, 2);
        myLinkedList.insertAt(0, 1);
        myLinkedList.print();

        //REMOVE AT
        System.out.println("AFTER REMOVE...");
        myLinkedList.removeAt(0);
        myLinkedList.removeAt(4);
        myLinkedList.removeAt(2);
        myLinkedList.print();
	}

	//WEEK 4
	private static void TreeTest() {


		BTNode<Integer> n7 = new BTNode<Integer>(25, null, null);
		BTNode<Integer> n8 = new BTNode<Integer>(40, null, null);
		BTNode<Integer> n4 = new BTNode<Integer>(12, null, null);
		BTNode<Integer> n3 = new BTNode<Integer>(4, null, null);
		BTNode<Integer> n5 = new BTNode<Integer>(36, n7, n8);
		BTNode<Integer> n6 = new BTNode<Integer>(64, null, null);
		BTNode<Integer> n1 = new BTNode<Integer>(10, n3, n4);
		BTNode<Integer> n2 = new BTNode<Integer>(45, n5, n6);
		
		BTNode<Integer> root = new BTNode<Integer>(21, n1, n2);
		LabBinarySearchTree<Integer> binaryTree = new LabBinarySearchTree<Integer>(root);

		//TREE BUILD... DONT CARE HERE JUST FOR THE SEE THE TREE THAT WE'RE WORKING
		System.out.println("                      " + binaryTree.find(root, root.value).value);
		System.out.println("\n");
		System.out.println("          " + n1.value + "                    " + n2.value);
		System.out.println("\n");
		System.out.println("     " + n3.value + "         " + n4.value + "          " + n5.value + "        " + n6.value);
		System.out.println("\n");
		System.out.println("                       " + n7.value + "      " + n8.value);

		System.out.println("****************************************************************");
		System.out.println(binaryTree.findParent(n8).value);
	}
	
	private static void TraversalTest() {
		
		BTNode<Integer> n7 = new BTNode<Integer>(25, null, null);
		BTNode<Integer> n8 = new BTNode<Integer>(40, null, null);
		BTNode<Integer> n4 = new BTNode<Integer>(12, null, null);
		BTNode<Integer> n3 = new BTNode<Integer>(4, null, null);
		BTNode<Integer> n5 = new BTNode<Integer>(36, n7, n8);
		BTNode<Integer> n6 = new BTNode<Integer>(64, null, null);
		BTNode<Integer> n1 = new BTNode<Integer>(10, n3, n4);
		BTNode<Integer> n2 = new BTNode<Integer>(45, n5, n6);
		
		BTNode<Integer> root = new BTNode<Integer>(21, n1, n2);
		LabBinarySearchTree<Integer> binaryTree = new LabBinarySearchTree<Integer>(root);
		
		Traversal traversal = new Traversal();
		
		//TREE BUILD... DONT CARE HERE JUST FOR THE SEE THE TREE THAT WE'RE WORKING
		System.out.println("                      " + binaryTree.find(root, root.value).value);
		System.out.println("\n");
		System.out.println("          " + n1.value + "                    " + n2.value);
		System.out.println("\n");
		System.out.println("     " + n3.value + "         " + n4.value + "          " + n5.value + "        " + n6.value);
		System.out.println("\n");
		System.out.println("                       " + n7.value + "      " + n8.value);

		System.out.println("****************************************************************");
		
		String preOrderedTreeNode = traversal.preOrder(root);
		String inOrderedTreeNode = traversal.inOrder(root);
		String postOrderedTreeNode = traversal.postOrder(root);
		
		System.out.println("PREORDER RESULT:" + preOrderedTreeNode);
		System.out.println("INORDER RESULT:" + inOrderedTreeNode);
		System.out.println("POSTORDER RESULT:" + postOrderedTreeNode);
		
	}
	
	private static void BinaryHeapTest() {
		
	}

}