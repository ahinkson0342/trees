package trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T>
{
    private Node root;
    private int size;


    @Override
    public boolean add(T element)
    {
        root = add(root, element);
        return false;
    }

    private Node add(Node current, T element)
    {
        //base case
        if(current==null)
        {
            Node node = new Node(element);
            size++;
            return node;
        }

        int compare = element.compareTo(current.data);
        if (compare <0)
        {
            //search to the left
            current.left = add(current.left, element);
        }
        else if (compare >0)
        {
            //search to the right
            current.right = add(current.right, element);
        }
        return current;
    }

    @Override
    public boolean contains(T element)
    {
        return contains(root, element);
    }

    private boolean contains(Node current, T element)
    {
        //base case
        if(current==null)
        {
            return false;
        }

        int compare = element.compareTo(current.data);
        if (compare <0)
        {
            //search to the left
            return contains(current.left, element);
        }
        else if (compare >0)
        {
            //search to the right
            return contains(current.right, element);
        }
        else
        {
            return true;
        }
    }

    @Override
    public boolean remove(T element)
    {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size==0;
    }

    @Override
    public void clear()
    {
        root = null;
        size = 0;
    }

    @Override
    public List<T> inOrder() //LNR
    {
        List<T> traversal = new ArrayList<>();
        inOrder(root, traversal);
        return traversal;
    }

    private void inOrder(Node current, List<T> traversal)
    {
        inOrder(current.left, traversal); //L
        traversal.add(current.data); //N
        inOrder(current.right, traversal); //R
    }

    @Override
    public List<T> preOrder() //NLR
    {
        return null;
    }

    @Override
    public List<T> postOrder()  //LRN
    {
        return null;
    }

    @Override
    public String toString() {
        return root == null ? "null" : root.toString();
    }

    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node(T data)
        {
            this.data=data;
        }

        private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder builder)
        {
            if(right!=null)
            {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, builder);
            }

            builder.append(prefix).append(isTail ? "└── " : "┌── ").append(data).append("\n");

            if(left!=null)
            {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, builder);
            }

            return builder;
        }

        /**
         * Builds a visualization of the tree on the Java console.
         *
         * @see <a href="https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java/8948691#8948691">...</a>
         * @return a diagram of the tree
         */
        @Override
        public String toString()
        {
            return toString(new StringBuilder(), true, new StringBuilder()).toString();
        }


    }
}
