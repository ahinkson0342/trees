package trees;

// Type T will use the comparable interface
public interface ITree<T extends Comparable<T>>
{
    //primary methods
    boolean add(T element);
    boolean contains(T element);
    boolean remove(T element);

    //common methods
    int size();
    boolean isEmpty();
    void clear();

    //no concept of indices
    // no get(index) or set(index, element) methods
}
