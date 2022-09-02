import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BinaryTree
 */
public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        // BFS(root ,"In");
        // System.out.println();
        // BFS(root,"Pr");
        // System.out.println();
        // BFS(root,"Po");
        // System.out.println();
        // // DFS(root);
        // allTraversal(root);
        //System.out.println(maxHeight(root));
        //System.out.println(isBalanced(root) != -1 ? true : false);
        int[] max = new int[1];
        // int temp = diameter(root,max);
        // System.out.println(max[0]);
        int t = maxPathSum(root,max);
        System.out.println(max[0]);
    }
    //#region MaxPathSun
    private static int maxPathSum(Node root, int[] max) {
        if(root == null)
            return 0;
        int ls = maxPathSum(root.left, max);
        int rs = maxPathSum(root.right, max);

        max[0] = Math.max(max[0], ls + rs + root.val);

        return root.val + Math.max(ls,rs);
    }
    //#endregion
    
    //#region diameter

    private static int diameter(Node root,int[] max) {
        if(root == null)
        {
            return 0;
        }
        int ld = diameter(root.left,max);
        int rd = diameter(root.right,max);
        max[0] = Math.max(max[0],ld+rd);
        return 1 + Math.max(ld,rd);
    }
    //#endregion
    
    //#region IsBalanced
    private static int isBalanced(Node root) {
        if(root == null) 
            return 0;

        int lh = isBalanced(root.left);
        int rh = isBalanced(root.right);
        if(lh != rh || lh == -1 || rh == -1)
        {
            return -1;
        }
        else{
            return Math.max(lh,rh) + 1;
        }
    }
    //#endregion

    //#region Max Depth/Height
    private static int maxHeight(Node root) 
    {
        if(root == null) 
            return 0;

        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        return Math.max(lh,rh) + 1; 

    }
    //#endregion

    //#region All Traversal
    private static void allTraversal(Node root)
    {
        Node temp = root;
        Stack<Pair> s = new Stack<>();
        s.add(new Pair(temp,1));
        ArrayList<Integer> in = new ArrayList<>(),pre = new ArrayList<>(),pos = new ArrayList<>();
        while(!s.isEmpty())
        {
            Pair t = s.pop();
            if(t.val == 1)
            {
                pre.add(t.node.val);
                t.val++;
                s.push(t);
                if(t.node.left != null)
                {
                    s.push(new Pair(t.node.left, 1));
                }
            }
            else if (t.val == 2)
            {
                in.add(t.node.val);
                t.val++;
                s.push(t);
                if(t.node.right != null)
                {
                    s.push(new Pair(t.node.right, 1));
                }
            }
            else
            {
                pos.add(t.node.val);
            }
        }

        System.out.println(pre.toString());
        System.out.println(in.toString());
        System.out.println(pos.toString());


    }
    //#endregion

    //#region DFS
    private static void DFS(Node root)
    {
        Node temp = root;
        Queue<Node> d = new LinkedList<Node>();
        d.add(temp);
        while(!d.isEmpty())
        {
            Node cur = d.remove();
            System.out.println(cur.val);
            if(cur.left!= null)
            {
                d.add(cur.left);
            }
            if(cur.right!= null)
            {
                d.add(cur.right);
            }
        }
    }
//#endregion

    //region BFS
    private static void BFS(Node root,String s)
    {
        Node temp = root;
        if(s.compareTo("In") == 0)
            ioT(temp);
        else if (s.compareTo("Pr") == 0)
            proT(temp);
        else
            poT(temp);
    }

    private static void poT(Node temp)
    {
        if(temp.left != null)
        {
            poT(temp.left);
        }
        if(temp.right != null)
        {
            poT(temp.right);
        }
        System.out.print(temp.val + " ");    
    }

    private static void proT(Node temp) 
    {
        System.out.print(temp.val + " ");
        if(temp.left != null)
        {
            proT(temp.left);
        }
        if(temp.right != null)
        {
            proT(temp.right);
        }
    }

    private static void ioT(Node temp)
    {
        if(temp.left != null)
        {
            ioT(temp.left);
        }
        System.out.print(temp.val + " ");
        if(temp.right != null)
        {
            ioT(temp.right);
        }

    }
//endregion;
    
}
 
class Node{
    public int val;
    public Node left;
    public Node right;
    public Node(int data){
        this.val = data;
        this.right = null;
        this.left = null;
    }
}
class Pair{
    public int val;
    public Node node;
    public Pair(Node n,int v)
    {
        this.node = n;
        this.val = v;
    }
}