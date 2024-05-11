package trees;

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
        return false;
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

    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node(T data)
        {
            this.data=data;
        }

        public String toString()
        {
            return data.toString();
        }
    }
}
