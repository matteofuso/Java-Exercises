public class LinkedList implements Container { // costruttore
    public LinkedList() {
        makeEmpty();
    }

    // metodi pubblici
    public void makeEmpty() {
        head = tail = new ListNode();
    }

    public boolean isEmpty() {
        return (head == tail);
    }

    public Object getFirst() // operazione O(1)
    {
        if (isEmpty())
            throw new EmptyLinkedListException();
        return head.getNext().getElement();
    }

    public Object getLast() // operazione O(1)
    {
        if (isEmpty())
            throw new EmptyLinkedListException();
        return tail.getElement();
    }

    // vanno scritti i metodi addFirst,addLast,removeFirst,removeLast
    public void addFirst(Object e) {
        head.setElement(e);
        head = new ListNode(null, head);
        // funziona perché prima head viene USATO
        // (a destra) e solo successivamente viene
        // MODIFICATO (a sinistra)
    }

    public Object removeFirst() {
        Object e = getFirst();// delega a getFirst il
        // controllo di lista vuota
        head = head.getNext();// aggiorno lo header
        head.setElement(null);
        return e;
    }

    public void addLast(Object e) {
        tail.setNext(new ListNode(e, null));
        tail = tail.getNext(); // aggiorno il tail
    }

    public Object removeLast() {
        Object e = getLast();
        // L’ultimo nodo non ha un riferimento al penultimo!
        // Bisogna cercare il penultimo nodo partendo dal primo
        // e andando avanti finche’ non si arriva alla fine
        ListNode temp = head;
        while (temp.getNext() != tail)
            temp = temp.getNext();
        // a questo punto temp si riferisce al penultimo nodo
        tail = temp;
        tail.setNext(null);
        return e;
    }

    private class ListNode { // costruttori
        public ListNode() {
            element = null;
            next = null;
        }

        public ListNode(Object e, ListNode n) {
            element = e;
            next = n;
        }

        // metodi pubblici
        public Object getElement() {
            return element;
        }

        public ListNode getNext() {
            return next;
        }

        public void setElement(Object e) {
            element = e;
        }

        public void setNext(ListNode n) {
            next = n;
        }

        // campi di esemplare
        private Object element;
        private ListNode next;
    }

    // campi di esemplare
    private ListNode head, tail;
}

class EmptyLinkedListException extends RuntimeException {
}