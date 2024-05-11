package tests;

import trees.BinarySearchTree;

public class TestTree
{
    public static void main(String[] args)
    {
        String[] words = {"was", "this", "and", "or", "but", "to"};

        BinarySearchTree<String> bst = new BinarySearchTree<>();

        for (String word : words)
        {
            bst.add(word);
        }

        System.out.println(bst);
    }
}
