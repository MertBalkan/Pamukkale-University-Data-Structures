
public class TestMain {

	public static void main(String[] args) {
		//here do your tests
		LinkedListTest();

	}
	
	//WEEK 3
	private static void LinkedListTest() {

        LabDoublyLinkedList<Integer> myLinkedList = new LabDoublyLinkedList<>();
        	
        //INSERT AT
        myLinkedList.insertAt(0, 6);
        myLinkedList.insertAt(0, 5);
        myLinkedList.insertAt(0, 4);
        myLinkedList.insertAt(0, 3);
        myLinkedList.insertAt(0, 2);
        myLinkedList.insertAt(0, 1);
        myLinkedList.print();

        //REMOVE AT
        myLinkedList.removeAt(0);
        myLinkedList.removeAt(4);
        myLinkedList.removeAt(2);
        myLinkedList.print();
	}

	//WEEK 4
	private static void TreeTest() {

		LabBinarySearchTree<Integer> binaryTree = new LabBinarySearchTree<Integer>();
		binaryTree.add(21);
		binaryTree.add(10);
		binaryTree.add(45);
		binaryTree.add(4);
		binaryTree.add(12);
		binaryTree.add(36);
		binaryTree.add(64);
		binaryTree.add(25);
		binaryTree.add(40);
		
		System.out.println(binaryTree.find(binaryTree.getRoot(), 36).value);
	}

}