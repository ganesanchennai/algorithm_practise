/**
 * Created by gmani on 2/7/16.
 */
public class BinTreeMaxDepth {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right  = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);

        TreeNode left = root.left;
        TreeNode right = root.right;

        left.right = new TreeNode(9);
        left.left = new TreeNode(8);

        //right.right = new TreeNode(9);
        //right.left = new TreeNode(8);
        //System.out.println((lowestCommonAncestor(root, left.left, left.right)).data);

        right.left = new TreeNode(10);
        TreeNode t1 = right.left;
        right.right = new TreeNode(11);


        TreeNode temp = right.left;

        for (int i = 0 ; i < 10 ; i++) {
            right = right.left;


            right.left = new TreeNode(10);
            right.right = new TreeNode(11);

        }

        TreeNode t2 = right.right;

        //System.out.println(depth(root.left, root.right));
        System.out.println(lowestCommonAncestor(root, t1, t2).data);

    }

    public static int depth(TreeNode left, TreeNode right) {
        if (left == null || right == null ) {
            return 0;
        }

        return Math.max(depth(left.left, left.right), depth(right.left, right.right)) + 1;
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if (root == node1 || root == node2 ) return root;

        if (!covers(root, node1) && !covers(root, node2)) return null;

        if (covers(root.left, node1) && covers(root.left, node2)) return lowestCommonAncestor(root.left, node1, node2);

        else if (covers(root.right, node1) && covers(root.right, node2)) return  lowestCommonAncestor(root.right, node1, node2);

        else return root;

    }

    public static boolean covers(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }

        if (root == node ) return true;

        return covers(root.left, node) || covers(root.right, node);
    }


}
