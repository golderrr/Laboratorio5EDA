import java.util.*;

class TreeNode{
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
    private TreeNode root = null;

    public TreeNode getRoot() { return root; }

    public void insert(int victorias, String nombre) {
        root = insertar(root, victorias, nombre);
    }

    private TreeNode insertar(TreeNode root, int victorias, String nombre) {
        if (root == null) return new TreeNode(victorias, nombre);

        if (victorias < root.victorias) root.left = insertar(root.left, victorias, nombre);
        else root.right = insertar(root.right, victorias, nombre);

        return root;
    }

    public void borrarPorNombre(String nombre) {
        root = borrarPorNombre(root, nombre);
    }

    private TreeNode borrarPorNombre(TreeNode root, String nombre) {
        if (root == null) return null;

        if (root.nombre.equals(nombre)) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode temp = minimo(root.right);
            root.victorias = temp.victorias;
            root.nombre = temp.nombre;
            root.right = borrarPorNombre(root.right, temp.nombre);
            return root;
        }

        root.left = borrarPorNombre(root.left, nombre);
        root.right = borrarPorNombre(root.right, nombre);

        return root;
    }

    private TreeNode minimo(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public TreeNode buscarPorNombre(String nombre) {
        return buscarPorNombre(root, nombre);
    }

    private TreeNode buscarPorNombre(TreeNode root, String nombre) {
        if (root == null) return null;
        if (root.nombre.equals(nombre)) return root;

        TreeNode izquierda = buscarPorNombre(root.left, nombre);
        if (izquierda != null) return izquierda;

        else return buscarPorNombre(root.right, nombre);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.victorias + " : " + root.nombre);
            inOrderRec(root.right);
        }
    }
}
