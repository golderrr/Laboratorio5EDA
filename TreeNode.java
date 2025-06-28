import java.util.*;

public class TreeNode {
    int victorias;
    String nombre;
    TreeNode left, right;

    TreeNode(int victorias, String nombre){
        this.victorias = victorias;
        this.nombre = nombre;
        this.left = this.right = null;
    }
}

class BST {

    TreeNode root = null;

    public void insert(int victorias, String nombre) {
        root = insertRec(root, victorias, nombre);
    }

    private TreeNode insertRec(TreeNode TreeNode, int victorias, String nombre) {

        if (TreeNode == null) return new TreeNode(victorias, nombre);

        if (victorias < TreeNode.victorias){
            TreeNode.left = insertRec(TreeNode.left, victorias, nombre);
        }
        else {
            TreeNode.right = insertRec(TreeNode.right, victorias, nombre);
        }

        return TreeNode;
    }

    public void range(TreeNode node, int lo, int hi, List<Map.Entry<Integer, String>> cumple) {
        if(node == null) return;

        if(node.victorias >= lo && node.victorias <= hi) cumple.add(new AbstractMap.SimpleImmutableEntry<>(node.victorias, node.nombre));

        if(node.victorias > lo) range(node.left, lo, hi, cumple);

        if(node.victorias < hi) range(node.right, lo, hi, cumple);

    }

    public TreeNode search(TreeNode root, int victorias) {
        if(root == null) return null;

        TreeNode node = null;
        if(root.victorias > victorias){
            node = root;
            root = root.left;
        }
        else {
            root = root.right;
        }
        return node;
    }

    public void addList(TreeNode node, TreeNode wins, List<Map.Entry<Integer, String>> cumple) {
        if(node == null) return;

        addList(node.left, wins, cumple);
        addList(node.right, wins, cumple);

        if(node.victorias == wins.victorias) cumple.add(new AbstractMap.SimpleImmutableEntry<>(node.victorias, node.nombre));
    }


}
