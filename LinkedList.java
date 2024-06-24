class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void addToHead(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addAfter(Node p, int x) {
        if (p == null) {
            throw new IllegalArgumentException("Node does not exist");
        }
        Node newNode = new Node(x);
        if (p.next == null) {
            p.next = newNode;
        } else {
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int deleteFromHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public int deleteFromTail() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head.next == null) {
            int data = head.data;
            head = null;
            return data;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = null;
        return data;
    }

    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            throw new IllegalArgumentException("Node does not exist or does not have a next node");
        }
        int data = p.next.data;
        p.next = p.next.next;
        return data;
    }

    public void dele(int x) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head.data == x) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == x) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void delete(int i) {
        if (i < 1 || i > count()) {
            throw new IllegalArgumentException("Index is out of range");
        }
        Node current = head;
        for (int j = 1; j < i; j++) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = current.next.next;
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current.next != null) {
            for (Node p = current.next; p != null; p = p.next) {
                if (p.data < current.data) {
                    int temp = current.data;
                    current.data = p.data;
                    p.data = temp;
                }
            }
            current = current.next;
        }
    }

    public void dele(Node p) {
        if (p == null) {
            throw new IllegalArgumentException("Node does not exist");
        }
        if (p.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next == p) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public int [] toArray() {
        int [] arr = new int[count()];
        int index = 0;
        Node current = head;
        while (current != null) {
            arr[index++] = current.data;
            current = current.next;
        }
        return arr;
    }



    public static LinkedList mergeSorted(LinkedList... lists) {
        if (lists.length == 0) {
            return new LinkedList();
        }
        LinkedList mergedList = new LinkedList();
        for (LinkedList list : lists) {
            if (list != null) {
                mergedList.addToTail(list.head.data);
                list.deleteFromHead();
            }
        }
        mergedList.sort();
        return mergedList;
    }

    public static int max(LinkedList list) {
        if (list == null || list.head == null) {
            return -1;
        }
        int max = list.head.data;
        Node current = list.head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    public static int min(LinkedList list) {
        if (list == null || list.head == null) {
            return -1;
        }
        int min = list.head.data;
        Node current = list.head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    public static int sum(LinkedList list) {
        if (list == null || list.head == null) {
            return 0;
        }
        int sum = 0;
        Node current = list.head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public static boolean sorted(LinkedList list) {
        if (list == null || list.head == null) {
            return true;
        }
        Node current = list.head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public static void insert(int x, LinkedList list) {
        if (list == null) {
            return;
        }
        Node newNode = new Node(x);
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node current = list.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}
