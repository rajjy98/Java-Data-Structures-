package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Suraj Patel
 */
class BinaryTree
{
    public JPanel getView()
    {
        return new BinaryTreeView(root);
    }
    static class Node
    {
        int value;
        Node left, right;
        Node(int value)
        {
           this(value, null, null);
        }
        Node(int value, Node left, Node right)
        {
           this.value = value;
           this.left = left; 
           this.right = right;
        }
    }   

    private Node root;
    /**
     * clears all values and empties the binary tree
     */
    public void clear()
    {
        root = null;
    }
    
    /**
     * Return size of this binary tree object
     * @return 
     */
    public int size()
    {
        return size(root);
    } 
    
     /**
     * Return number of nodes in a binary tree
     * @param r : root of the binary tree
     * @return 
     */
    private static int size(Node tree)
    {
        if (tree == null) return 0;
        else 
            return size(tree.left) + size(tree.right) + 1;
    }
    /**
     * Adds a value to this binary tree object
     * @param value 
     */
    public void add(int value)
    {
        root = add(root, value);
    }
    
       /**
     * Adds a value to the binary tree with the given tree
     * @param tree
     * @param value
     * @return a pointer to the tree of the augmented binary tree
     */
    private static Node add(Node tree, int value)
    {
         if (tree == null) 
         {
             return new Node(value);
         }
         if (value == tree.value) {return tree;}
         if (value < tree.value)
             tree.left = add(tree.left, value);
         else
             tree.right = add(tree.right, value);
         return tree;
    } 
    
    /**
     * 
     * @return a preorder list of the values in the binary tree
     */
    public List<Integer> preorder()
    {
        // Create empty list to be filled in by the recursive method
        List<Integer> preorderList = new ArrayList<>();
        preorder(root, preorderList);
        return  preorderList;
    }
    /**
     * Adds all values in the tree to the preorderList
     * @param root
     * @param preorderList 
     */
   private static void preorder(Node tree, List<Integer> preorderList)
   {
      if (tree != null) 
      {
        preorderList.add(tree.value);   
        preorder(tree.left, preorderList);
        preorder(tree.right, preorderList);  
      }
    
     
   }
   
      /**
     * 
     * @return a postorder list of the values in the binary tree
     */
    public List<Integer> postorder()
    {
        // Create empty list to be filled in by the recursive method
        List<Integer> postorderList = new ArrayList<>();
        postorder(root, postorderList);
        return  postorderList;
    }
    /**
     * Adds all values in tree to the postorderList
     * @param root
     * @param postorderList 
     */
   private static void postorder(Node tree, List<Integer> postorderList)
   {
      if (tree != null)
      {
        postorder(tree.left, postorderList);
        postorder(tree.right, postorderList);
        postorderList.add(tree.value);
      }
   }
 
    /**
     * 
     * @return a inorder list of the values in the binary tree
     */
    public List<Integer> inorder()
    {
        // Create empty list to be filled in by the recursive method
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return  inorderList;
    }
    /**
     * Adds all values in the binary tree to the inorderList
     * @param root
     * @param inorderList 
     */
   private static void inorder(Node tree, List<Integer> inorderList)
   {
       if (tree != null)
       {
           inorder(tree.left, inorderList);
           inorderList.add(tree.value);
           inorder(tree.right, inorderList);
       }
   }
   /**
    * 
    * @return height of the binary tree
    */
   public int treeHeight()
   {
       return treeHeight(root);
   }
   /**
    * 
    * @param root
    * @return height of the binary tree with the given root
    */
   private static int treeHeight(Node tree)
   {
       if (tree == null)
       {
           return -1;
       }
      
      
        int heightLeft = treeHeight(tree.left); // largest height of left side of tree
        int heightRight = treeHeight(tree.right); // largest height of right side of tree
        if (heightLeft > heightRight) // finding largest overall height
        {
            return heightLeft + 1;  // add one for root
        }
        else
        {
            return heightRight + 1; // add one for root
        }
      
   }
            
   
   
   /**
    * 
    * @return the list of all leaves of the binary tree.
    */
   public List<Integer> leaves()
   {      
      List<Integer> listOfLeaves = new ArrayList<>();
      leaves(root, listOfLeaves); 
      return listOfLeaves;
   }
   /**
    * Add all leaves in the binary tree  into a list  listOfLeaves
    * @param tree
    * @param listOfLeaves 
    */
   private static void leaves(Node tree, List<Integer> listOfLeaves)
   {
       if (tree != null)
       {
        if (tree.right == null && tree.left == null) // leaf by definition 
        {
             listOfLeaves.add(tree.value); // if true add to list 
         }
       
        leaves(tree.left, listOfLeaves); // recursively iterate through the tree.
        leaves(tree.right, listOfLeaves); 
       }
   }
       
   /**
    * 
    * @param level
    * @return list of all values in the binary tree at the given level
    */
   public List<Integer> atLevel(int level)
   {
       List<Integer> valuesAtLevel = new ArrayList<>();
       atLevel(root, valuesAtLevel, level);
       return valuesAtLevel;
   }
   /**
    * Adds all values at the given level in the binary tree rooted at root to 
    * the list valuesAtLevel
    * @param root
    * @param valuesAtLevel
    * @param level 
    */
   private static void atLevel(Node root, List<Integer> valuesAtLevel, int level)  //////////////////////////////////////////////////////////////////
   {
      if (root != null)
      {
          if (level == 1) // level one only contains the root.
          {
              valuesAtLevel.add(root.value);
          }
          
          else 
          {
              atLevel(root.left, valuesAtLevel, level -1);  //recursively move left
              atLevel(root.right, valuesAtLevel, level -1); // or right decrementing level until it equals one.
              
          }
      }  
   }
   /**
    * remove a value from the binary tree
    * @param value
    * @return true if the value was removed, false otherwise
    */
   public  boolean remove(int value)
   {
      Node[] res = remove(root, value);   
      root = res[1];
      return res[0] != null;    
   }
   
   /**
    * removes the specified value from the binary tree
    * @param tree
    * @param value
    * @return an array of Node where the detached node 
    * containing the removed value is at index 0 and the 
    * reduced remaining tree is at index 1
    */
   
   private static Node[] remove(Node tree, int value)
   {
       if (tree == null)   {return new Node[]{null, null};}
       
       // is value at the root of the tree?
       if (value == tree.value)
       {
           // detach the root node from its subtrees
           Node root = tree;
           Node leftSubtree = tree.left;
           Node rightSubtree = tree.right;
           
           if (leftSubtree == null)  
           {
              return new Node[]{root, rightSubtree}; 
           }
           if (rightSubtree == null)
           {
               return new Node[]{root, leftSubtree};
           }
           // both subtrees are non empty, so form 
           // the reduced subtree by removing the largest
           // node in the left subtree and making it the
           // root of the reduced subtree
           
            Node [] tempResult = removeLargest(leftSubtree);
            Node reducedSubtree = tempResult[0];
            reducedSubtree.left = tempResult[1];
            reducedSubtree.right = rightSubtree;
            
            return new Node[] { root, reducedSubtree};
       }
       
       // Not at root, so remove from either left or right subtree
       if (value < tree.value)
       {
           Node [] tempResult = remove(tree.left, value);
           tree.left = tempResult[1];
           return new Node[]{tempResult[0], tree};
       }
       else
       {
           // value > tree.value
           Node [] tempResult = remove(tree.right, value);
           tree.right = tempResult[1];
           return new Node[]{tempResult[0], tree};
       }      
   }
   /**
    * remove and return the value in the right most node
    * @return 
    */
   public int removeLargest() 
   {
      if (root == null) throw new IllegalStateException("The binary tree is empty!");
      Node [] result = removeLargest(root);
      root = result[1];
      
      return result[0].value;
   }
   /**
    * Remove the largest node in the tree rooted at the given root, assuming
    * the tree is empty.
    * @param root
    * @return an array consisting of the detached removed node
    *         at index 0 and the reduced tree at index 1
    */
   
   private static Node[] removeLargest(Node tree)
   {
       if (tree == null) throw new IllegalStateException("The binary tree is empty!");
       
       if (tree.right == null)
       {   // root node is the largest
           Node leftSubtree = tree.left;
           Node rootNode = tree;
           rootNode.left = null;
           return new Node[]{rootNode, leftSubtree};
       }
       //  Remove the largest node from the right subtree
       Node[] result = removeLargest(tree.right);
       //  replace right subtree by the reduced tree from the recursive call
       tree.right = result[1];
       // return the array of the largest node and the reduced tree from this 
       // call
       return new Node[]{result[0], tree};       
   }
  
   /**
    *  
    * @param value
    * @return level at which a value is found, or -1 if the value is not in the tree
    */
   public int levelOf(int value)
   {
      return levelOf(root, value); 
   }
   /**
    * 
    * @param root
    * @param value
    * @return level of the value in the binary tree rooted at the given root.
    */
   private static int levelOf(Node root, int value) ////////
   {
    if (root != null)
    {
        if (root.value == value)
           {
                return 0;
           }
        if(value > root.value)
            {
                return 1 + levelOf(root.right, value);
            }
        else if (value < root.value)
            {
                return 1 + levelOf(root.left, value);
            }
    }
        return -1;
   }
   
    /**
    * remove and return the value in the left most node
    * @return 
    */
   public int removeSmallest() 
   {
      if (root == null) throw new IllegalStateException("The binary tree is empty!");
      Node [] result = removeSmallest(root);
      root = result[1];
      
      return result[0].value;
   }
   /**
    * Remove the smallest node in the tree rooted at the given root
    * @param root
    * @return 
    */
   private static Node[] removeSmallest(Node root) 
   {
        if (root == null) throw new IllegalStateException("The binary tree is empty!"); 
       
       if (root.left == null)               // very similar to the remove largest code
       {                                    // Because removing smallest, we switch the right with left
           Node leftSubtree = root.right;   // left subtree will always contain the smallest  value if existent. 
           Node rootNode = root;
           rootNode.right = null;
           return new Node[]{rootNode, leftSubtree};
       }
       Node[] result = removeSmallest(root.left);
       root.left = result[1];
       return new Node[]{result[0], root}; 
   }
   /**
    * Does not have to be recursive
    * @return the smallest value  in the binary tree
    */
   public int getSmallest()
   {
      if (root == null) throw new IllegalStateException("Binary tree is empty.");
      Node newNode = root;
      while (newNode.left != null) // while loop keeps excecuting until newNode = leftmost position
      {                             //by definition the leftmost position will always be the smallest
          newNode = newNode.left;
      }
      return newNode.value;
   }
   
   
   /**
    * Does not have to recursive
    * @return the largest value  in the binary tree
    */
   public int getLargest()                                                              
   {
      {
      if (root == null) throw new IllegalStateException("Binary tree is empty.");
      Node newNode = root;          //while loop keeps excecuting until newNode = rightmost position
      while (newNode.right != null) //by definition the rightmost position will always be the largest
      {
          newNode = newNode.right;
      }
      return newNode.value;
   }
   } 
}


