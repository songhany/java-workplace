package CS570.hw3;

public class IDLListTest {
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
