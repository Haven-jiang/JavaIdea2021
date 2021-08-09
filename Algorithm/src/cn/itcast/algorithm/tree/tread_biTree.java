package cn.itcast.algorithm.tree;

public class tread_biTree<ElemType> {
    class tree_node<ElemType> {
        tree_node left;
        tree_node right;
        int left_tag = 0;
        int right_tag = 0;
        ElemType data;

        tree_node(ElemType data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "tree_node{\n" +
                    ", data=" + data +
                    "\n}";
        }
    }

    tree_node<ElemType> root;
    tree_node<ElemType> rear;
    String data_string;
    int temp = 0;
    boolean isThread = false;

    public tread_biTree(){
        rear = null;
    }

    public void insert(ElemType[] data) {
        this.root = insert(data, 0);
    }

    public tree_node insert(ElemType[] data, int index) {
        tree_node<ElemType> new_root = null;
        if (index < data.length) {
            temp++;
            new_root = new tree_node(data[index]);
            new_root.left = insert(data, 2 * index + 1);
            new_root.right = insert(data, 2 * index + 2);
        }
        return new_root;
    }

    public void inTread() {
        tree_node<ElemType> new_root = this.root;
        inThread(new_root);
        isThread = true;
    }

    private void inThread(tree_node<ElemType> root) {
        if (root == null) return;
            inThread(root.left);
            if (root.left == null) {
                root.left_tag = 1;
                root.left = rear;
            }
            if (rear != null && rear.right == null) {
                rear.right_tag = 1;
                rear.right = root;
            }
            rear = root;
            inThread(root.right);
    }

    public String preOrderTraverse() {
        tree_node<ElemType> GongJuren = root;
        String str;
        data_string = " [";
        preOrderTraverse(GongJuren);
        data_string += "] ";
        str = data_string;
        data_string = "";
        return str;
    }

    public void preOrderTraverse(tree_node<ElemType> root) {
        if (root == null) return;
        setData_string(root);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }


    public String inThreadList() {
        tree_node<ElemType> GongJuren = root;
        String str;
        data_string = " [";
        inThreadList(GongJuren);
        data_string += "] ";
        str = data_string;
        data_string = "";
        return str;
    }

    private void inThreadList(tree_node<ElemType> root) {
        while (root.left != null) root = root.left;

        while (root != null) {
            if (root.right_tag == 1) {
                setData_string(root);
                root = root.right;
            }else {
                setData_string(root);
                root = root.right;
                while (root != null && root.left_tag == 0) root = root.left;
            }
        }
    }

    public String inOrderTraverse() {
        tree_node<ElemType> GongJuren = root;
        String str;
        data_string = " [";
        inOrderTraverse(GongJuren);
        data_string += "] ";
        str = data_string;
        data_string = "";
        return str;
    }

    public void inOrderTraverse(tree_node<ElemType> root) {
        if (root == null) return;
        inOrderTraverse(root.left);
        setData_string(root);
        inOrderTraverse(root.right);
    }

    private void setData_string(tree_node<ElemType> root) {
        data_string += "\n\t{";
        data_string += "data: ";
        data_string += root.data;
        data_string += ", left_tag: ";
        data_string += root.left_tag;;
        data_string += ", right_tag: ";
        data_string += root.right_tag;
        data_string += '}';
    }

    @Override
    public String toString() {
        if (!isThread)
        return "clue_biTree{" +
                "\n\tpreOrderTraverse_data =" + preOrderTraverse() +
                "\n\tinOrderTraverse_data =" + inOrderTraverse() +
                "\n\ttemp=" + temp +
                "\n}";
        else return "clue_biTree{" +
                "\n\tinOrderTraverse_data =" + inThreadList() +
                "\n\ttemp=" + temp +
                "\n}";
    }
}
