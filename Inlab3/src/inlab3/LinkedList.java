package inlab3;

/**
 *
 * @author yaw
 */
public class LinkedList {

    private Node head, current, temp;
    private int size;

    public LinkedList() {

    }

    public void addInOrder(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            size++;
        } else if (value >= head.getElement()) {
            newNode.setNextNode(head);
            head = newNode;
            size++;
        } else {
            boolean placed = false;
            current = head;
            while (!placed) {
                if (current != null && value < current.getElement()) {
                    temp = current;
                    current = current.getNextNode();
                } else {
                    temp.setNextNode(newNode);
                    newNode.setNextNode(current);
                    placed = true;
                    size++;
                }
            }
        }
    }

    public void removeAtIndex(int index) {
        if (index == 1) {
            head = head.getNextNode();
            size--;
        } else if(index > size) {
            System.out.println("There arent that many elements in this list.");
        } else {
            int currIndex = 1;
            current = head;
            while (currIndex <= index) {
                if (currIndex == index) {
                    temp.setNextNode(current.getNextNode());
                    current = null;
                    currIndex++;
                    size--;
                } else {
                    temp = current;
                    current = current.getNextNode();
                    currIndex++;
                }
            }
        }
    }

    public void printList() {
        if (head != null) {
            Node currentNode = head;
            int i = 1;
            do {
                System.out.println(i + ") " + currentNode.getElement());
                i++;
                currentNode = currentNode.getNextNode();
            } while (currentNode != null);
        }
        System.out.println();
    }
}
