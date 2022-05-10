package other.CS570.hw3;
/*
 * other.CS570 Homework 3
 *
 * author: Songhan Yu
 * CWID: 10470449
 */
import java.util.ArrayList;

public class IDLList<E> {

  public class Node<E> {
    // A node class for doubly linked list
    E data;
    Node<E> next;
    Node<E> prev;

    // Creates a node with no next or previous pointers.
    public Node(E elem) {
      try {
        this.data = elem;
        this.next = null;
        this.prev = null;
      } catch(Exception e) {
        throw e;
      }
    }

    // Creates a node with next and previous pointers.
    public Node(E elem, Node<E> prev, Node<E> next) {
      try {
        this.data = elem;
        this.prev = prev;
        this.next = next;
      } catch(Exception e) {
        throw e;
      }
    }
  }

  // class IDLList's Attributes
  private Node<E> head;
  private Node<E> tail;
  private int size;
  private ArrayList<Node<E>> indices;

  // creates an empty double-linked list
  public IDLList() {
    try {
      this.head = null;
      this.tail = null;
      this.size = 0;
      this.indices = new ArrayList<Node<E>>();  // index access
    } catch(Exception e) {
      throw e;
    }
  }

  // adds elem at position index
  public boolean add(int index, E elem) {
    try {
      if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
      } else if (index == 0) {
        add(elem);
      } else {
        // insert Node between head and tail
        Node<E> curNode = indices.get(index);  // find curNode with index from ArrayList
        Node<E> newCurNode = new Node<E>(elem, curNode.prev, curNode);
        curNode.prev.next = newCurNode;
        curNode.prev = newCurNode;
        size++;
        indices.add(index, newCurNode);
      }
      return true;
    } catch(Exception e) {
      throw e;
    }
  }

  // add elem at the head  ~  ListPrepend()
  public boolean add(E elem) {
    try {
      if (head == null) {  // list empty
        head = new Node<E>(elem, null, null);
        tail = head;
      }
      else {
        head = new Node<E>(elem, null, head);
        head.next.prev = head;  // second Node(that is previous head Node) should point to this new Node
      }
      size++;
      indices.add(0, head);  // this line just return void
      return true;
    } catch(Exception e) {
      throw e;
    }
  }

  // add elem as the last element  ~  ListAppend()
  public boolean append(E elem) {
    try {
      if (head == null) {  // list empty
        head = new Node<E>(elem, null, null);
        tail = head;
        size++;
        return indices.add(head);
      }
      else {
        tail.next = new Node<E>(elem, tail, null);
        tail = tail.next;
        size++;
        return indices.add(tail);
      }
    } catch (Exception e) {
      throw e;
    }
  }

  // returns the object at position index from the head. It uses the index for fast access.
  public E get(int index) {
    try {
      return indices.get(index).data;
    } catch(Exception e) {
      throw e;
    }
  }

  // returns the object at the head
  public E getHead() {
    try {
      if (head == null)
        throw new IllegalStateException();
      return head.data;
    } catch (Exception e) {
      throw e;
    }
  }

  // returns the object at the tail
  public E getLast() {
    try {
      if (tail == null)
        throw new IllegalStateException();
      return tail.data;
    } catch (Exception e) {
      throw e;
    }
  }

  // returns the list size
  public int size() {
    try {
      return size;
    } catch (Exception e) {
      throw e;
    }
  }

  // removes and returns the element at the head.
  public E remove() {
    try {
      if (head == null) {
        throw new IllegalStateException();
      }

      if (head == tail) {  // only one Node in DDl
        Node<E> tmpNode = head;
        head = null;
        tail = null;
        size--;
        indices.remove(0);
        return tmpNode.data;
      }

      Node<E> tmpNode = head;
      head = head.next;
      size--;
      indices.remove(0);
      return tmpNode.data;
    } catch (Exception e) {
      throw e;
    }
  }

  // removes and returns the element at the tail.
  public E removeLast() {
    try {
      if (tail == null) {
        throw new IllegalStateException();
      }

      if (head == tail) {
        Node<E> tmpNode = tail;
        head = null;
        tail = null;
        size --;
        indices.remove(size - 1);
        return tmpNode.data;
      }

      Node<E> tmpNode = tail;
      tail = tail.prev;
      tail.next = null;
      size --;
      indices.remove(size - 1);
      return tmpNode.data;
    } catch (Exception e) {
     throw e;
    }
  }

  // removes and returns the element at the index
  public E removeAt(int index) {
    try {
      if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
      }
      else if (index == 0) {
        return remove();
      }
      else if (index == size - 1) {
        return removeLast();
      }
      else {
        Node<E> curNode = indices.remove(index);
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        size --;
        return curNode.data;
      }
    } catch (Exception e) {
      throw e;
    }
  }

  // removes the first occurrence of elem in the list and returns true
  public boolean remove(E elem) {
    try {
      if (elem == head.data) {
        remove();
        return true;
      } else if (elem == tail.data) {
        removeLast();
        return true;
      } else {
        int idx = 0;
        Node<E> curNode = head;
        while (curNode != null) {
          if (curNode.data == elem) {
            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
            indices.remove(idx);
            size--;
            return true;
          }
          curNode = curNode.next;
          idx++;
        }
      }

      // don't find matching element
      return false;
    } catch (Exception e) {
      throw e;
    }
  }

  public String toString() {
    String res = "[";
    Node<E> curNode = head;
    while (curNode != null) {
      res += curNode.data.toString() + ",";
      curNode = curNode.next;
    }
    res = res.substring(0, res.length()-1);  // delete the last comma
    res += "]";
    return res;
  }

  public static void main(String[] args) {
    IDLList<Integer> dll = new IDLList<>();
    for (int i = 0; i < 6; i++) {
      dll.add(i);
    }
    System.out.println(dll);  // [5,4,3,2,1,0]

    dll.add(0, 0);
    dll.add(5, 10);
    System.out.println(dll);  // [0,5,4,3,2,10,1,0]

    dll.append(1);
    dll.append(2);
    System.out.println(dll);  // [0,5,4,3,2,10,1,0,1,2]

    System.out.println(dll.get(0));  // 0
    System.out.println(dll.get(1));  // 5
    System.out.println(dll.get(2));  // 4
    System.out.println(dll.get(3));  // 3

    System.out.println(dll);  // [0,5,4,3,2,10,1,0,1,2]
    System.out.println(dll.getHead());  // 0
    System.out.println(dll.getLast());  // 2
    System.out.println("IDLList size: " + dll.size());  // IDLList size: 10

    System.out.println("remove() remove Node: " + dll.remove() + " from head");  // 0
    System.out.println("remove() remove Node: " + dll.remove() + " from head");  // 5
    System.out.println("removeLast() remove Node: " + dll.removeLast() + " from tail");  // 2
    System.out.println("removeLast() remove Node: " + dll.removeLast() + " from tail");  // 1

    System.out.println(dll);  // [4,3,2,10,1,0]
    System.out.println("removeAt(0) remove Node: " + dll.removeAt(0) + "  at index 0");  // remove Node: 4
    System.out.println("removeAt(0) remove Node: " + dll.removeAt(1) + "  at index 1");  // remove Node: 2
//    System.out.println("removeAt(0) remove Node: " + dll.removeAt(3) + "  at index 5");

    System.out.println(dll);  // [3,10,1,0]
    System.out.println("remove(0): " + dll.remove(0));  // true
    System.out.println("remove(3): " + dll.remove(3));  // true
    System.out.println("remove(5): " + dll.remove(5));  // false
  }
}
