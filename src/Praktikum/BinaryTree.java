package Praktikum;

public class BinaryTree {
    private Node root;

    //KONSTRUKTOR
    public void NewData(char data) {
        root = NewData(root, new Node(data));
    }

    //PROSES PEMBUATAN TREE
    private Node NewData(Node root, Node addNew) {
        if (root == null) {
            root = addNew;
            return root;
        }
        if (addNew.data < root.data) {       //KONDISI KETIKA NILAI NODE LEBIH KECIL DARI ROOT,
            root.left = NewData(root.left, addNew); //MAKA AKAN BERADA DI CABANG SEBELAH KIRI
        } else {
            root.right = NewData(root.right, addNew); //KONDISI KETIKA NILAI NODE LEBIH BESAR DARI ROOT.
        }                                                 //MAKA AKAN BERADA DI CABANG SEBELAH KIRI
        return root;
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    private void PreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    private void PostOrder(Node node) {
        if (node != null) {
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void printInOrder() {
        System.out.println("InOrder : ");
        inOrder(root);
        System.out.println();
    }

    public void printPreOrder() {
        System.out.println("PreOrder : ");
        PreOrder(root);
        System.out.println();
    }

    public void printPostOrder() {
        System.out.println("PostOrder : ");
        PostOrder(root);
        System.out.println();
    }

    public void deleteKey(char data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, char data) {
        if (root == null)
            return root;
        if (data < root.data)
            root.left = deleteRec(root.left, data);
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, data);
        }
        return root;
    }

    private char minValue(Node node) {
        char minv = root.data;
        while (root.left!=null){
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
}
