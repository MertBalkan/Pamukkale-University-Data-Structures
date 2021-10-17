public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {
    /**
     * Çift bağlı listenin istenilen konumuna eleman ekler
     * @param index konum
     * @param value eklenecek eleman
     */
    @Override
    public void insertAt(int index, T value) {
        if(index == 0) {
            addFirst(value);
        }
        else if(index == size()){
            addLast(value);
        }else {
            int i = 0;
            Node<T> current = getHead();
            while(i < index - 1 && current != null){
                i++;
                current = current.next;
            }
            Node<T> yeni = new Node<>(value, current.next, current);
            current.next.previous = yeni; // BURADA SIRA ONEMLİ
            current.next = yeni;
            setSize(size() + 1);
            
        }
    }

    /**
     * Verilen konumdaki elemanı siler
     * @param index silinecek elemanın konumu
     * @return silinen değer
     */
    @Override
    public T removeAt(int index) {
        int i = 0;
        
        if(size() == 0)
            return null;
        else{
            Node<T> current = getHead();
            
            while(i < index - 1 && current != null){
                i++;
                current = current.next;
            }
            current.next = null;
            current.next = current.next.next;
            setSize(size() - 1);
            return current.value;   
        }
        
    }
}
