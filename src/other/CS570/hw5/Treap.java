package other.CS570.hw5;
/*
 * other.CS570 Homework 5
 *
 * author: Songhan Yu
 * CWID: 10470449
 */

import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {

  private static class Node<E> {
    public E data;  // key for the search
    public int priority;  // random heap priority
    public Node<E> left;
    public Node<E> right;

    // constructor
    public Node(E data, int priority) {
      if (data == null) {  // Throw exceptions if data is null.
        throw new NullPointerException();
      }

      this.data = data;
      this.priority = priority;
      this.left = null;
      this.right = null;
    }

    Node<E> rotateRight() {
      Node<E> tmp = this.left;
      Node<E> left = tmp.right;
      tmp.right = this;
      this.left = left;
      return tmp;
    }

    Node<E> rotateLeft() {
      Node<E> tmp = this.right;
      Node<E> right = tmp.left;
      tmp.left = this;
      this.right = right;
      return tmp;
    }

    public String toString() {
      return this.data.toString();
    }
  }


  // "---------------------------------------------------"
  // Treap class field
  private Random priorityGenerator;
  private Node<E> root;

  public Treap() {
    this.root = null;  // Treap() creates an empty treap.
    this.priorityGenerator = new Random();
  }
  
  public Treap(long seed) {
    this.root = null;
    this.priorityGenerator = new Random(seed);
  }

  boolean add(E key) {
    // add(E key) call the add(E key, int priority) method once it has generated the ran-dom priority. Thus all the “work” is performed by the latter method.
    return add(key, this.priorityGenerator.nextInt());  // call function add(E key, int priority) with priority
  }

  boolean add(E key, int priority) {
    if (this.root == null) {
      this.root = new Node<E>(key, priority);
      return true;
    } else {
      Node<E> tmp = new Node<E>(key, priority);
      Stack<Node<E>> newStack = new Stack<Node<E>>();
      Node<E> curNode = this.root;

      while (curNode != null) {
        if (curNode.data.compareTo(key) == 0) {
          return false;
        } else {
          if (curNode.data.compareTo(key) < 0) {
            newStack.push(curNode);
            if (curNode.right == null) {
              curNode.right = tmp;
              reheap(tmp, newStack);
              return true;
            } else {
              curNode = curNode.right;
            }
          } else {
            newStack.push(curNode);
            if (curNode.left == null) {
              curNode.left = tmp;
              reheap(tmp, newStack);
              return true;
            } else {
              curNode = curNode.left;
            }
          }
        }
      }

      // If there is already a node containing the given key, the method returns false and does not modify the treap.
      return false;
    }
  }

  // Finds a node with the given key in the treap and returns true if it finds it and false otherwise.
  boolean delete(E key) {
    if (this.root == null || find(key) == false) {
      return false;
    } else {
      this.root = deleteHelper(key, this.root);
      return true;
    }
  }

  // Finds a node with the given key in the treap rooted at root and returns true if it finds it and false otherwise.
  private boolean find(Node<E> root, E key) {
    if (root == null) {
      return false;
    } else {
      if (root.data.compareTo(key) == 0) {
        return true;
      } else {
        return find(root.right, key) || find(root.left, key);
      }
    }
  }

  // Finds a node with the given key in the treap and returns true if it finds it and false otherwise.
  public boolean find(E key) {
    return find(this.root, key);
  }

  // Carries out a preorder traversal of the tree and returns a represen-tation of the nodes as a string.
  public String toString() {
    StringBuilder s = new StringBuilder();
    preOrderTraverse(root, 1, s);
    return s.toString();
  }

  void preOrderTraverse(Node<E> node, int depth, StringBuilder strbuilder) {
    for (int i = 1; i < depth; i++) {
      strbuilder.append("  ");
    }
    if (node == null) {
      strbuilder.append("null\n");
    }
    else {
      strbuilder.append("(key = " + node.toString() + ", ");
      strbuilder.append("priority = ");
      strbuilder.append(node.priority);
      strbuilder.append(")");
      strbuilder.append("\n");
      preOrderTraverse(node.left, depth + 1, strbuilder);
      preOrderTraverse(node.right, depth + 1, strbuilder);
    }
  }

  // helper function reheap() for Add operation
  void reheap(Node<E> newNode, Stack<Node<E>> stack) {
    while (!stack.isEmpty()) {
      Node<E> parNode = stack.pop();
      
      // If the priority of the parent node is less than the priority of the new node, 
      // bubble up the new node in the tree towards the root such that the treap is a heap according to the priorities of each node
      if (parNode.priority < newNode.priority) {
        if (parNode.data.compareTo(newNode.data) > 0) {
          newNode = parNode.rotateRight();
        } else {
          newNode = parNode.rotateLeft();
        }

        // stack is not Empty
        if (!stack.isEmpty()) {
          if (stack.peek().left == parNode) {
            stack.peek().left = newNode;
          }
          else {
            stack.peek().right = newNode;
          }
        } else {
          this.root = newNode;
        }
      } else {
        break;
      }
    }
  }

  Node<E> deleteHelper(E key, Node<E> rootNode) {
    if (rootNode == null) {
      return rootNode;
    } else {
      if (rootNode.data.compareTo(key) < 0) {
        rootNode.right = deleteHelper(key, rootNode.right);
      } else {
        if (rootNode.data.compareTo(key) > 0) {
          rootNode.left = deleteHelper(key, rootNode.left);
        } else {
          if (rootNode.right == null) {
            rootNode = rootNode.left;
          } else if (rootNode.left == null) {
            rootNode = rootNode.right;
          } else {
            if (rootNode.right.priority < rootNode.left.priority) {
              rootNode = rootNode.rotateRight();
              rootNode.right = deleteHelper(key, rootNode.right);
            } else {
              rootNode = rootNode.rotateLeft();
              rootNode.left = deleteHelper(key, rootNode.left);
            }
          }
        }

      }
    }
    return rootNode;
  }

  // PriorityQueueCompareLogic
  public static void main(String[] args) {
    Treap testTree = new Treap < Integer >();
    testTree.add (4 ,19);
    testTree.add (2 ,31);
    testTree.add (6 ,70);
    testTree.add (1 ,84);
    testTree.add (3 ,12);
    testTree.add (5 ,83);
    testTree.add (7 ,26);
    System.out.println(testTree.toString());
  }
}
