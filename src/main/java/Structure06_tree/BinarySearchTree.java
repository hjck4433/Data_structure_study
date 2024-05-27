package Structure06_tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T>  {

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public T min() {
        return this.minNode(this.root);
    }
    private T minNode(Node node) {
        T minData = node.data;
        while (node.left != null){
            minData = node.left.data;
            node = node.left;
        }
        return minData;
    }

    public T max() {
        return this.maxNode(this.root);
    }
    private T maxNode(Node node){
        T maxData = node.data;
        while(node.right != null){
            maxData = node.right.data;
            node = node.right;
        }
        return maxData;
    }

    @Override
    public void insert(T val) {
        this.root = this.insertNode(this.root, val);
        this.size++;
    }
    private Node insertNode(Node node, T val) {
        // leaf 가 될때까지 반복
        if (node == null) {
            return new Node(val);
        }
        // 이미 값이 있는 경우 다시 비교
        if (val.compareTo(node.data) < 0) {
            node.left = insertNode(node.left, val);
        }else if (val.compareTo(node.data) > 0) {
            node.right = insertNode(node.right, val);
        }

        // 최종적으로는 루드 노드가 다시 반환
        // 처음 값을 삽입 하는 경우에는 루트에 값이 들어가고
        // 그 이후에는 값 추가 후 다시 빠져나오는 것
        return node;
    }

    @Override
    public void delete(T val) {
        this.deleteNode(this.root, val);
    }

    private Node deleteNode(Node node, T val) {
        // 값이 없는 경우
        if (node == null) return null;
        // 삭제 할 값을 가진 노드를 찾아 감
        if (val.compareTo(node.data) < 0) {
            node.left = deleteNode(node.left, val);
        }else if (val.compareTo(node.data) > 0) {
            node.right = deleteNode(node.right, val);
        }else {
            //val == node.data 삭제할 노드 발견
            // 사이즈 감소
            this.size--;
            // 자식노드가 하나인 경우
            if (node.left == null) {
                // 자식노드가 오른쪽에만 있다면
                // 오른쪽 노드 반환
                return node.right;
            }else if (node.right == null) {
                // 자식노드가 왼쪽에만 있다면
                // 왼쪽 노드 반환
                return node.left;
            }
            // 자식 노드가 2인 경우
            // 오른쪽의 가장 작은 값으로 바꿔주고
            // 가장 작은 노드를 삭제하고 돌아옴
            node.data = this.minNode(node.right);
            node.right = deleteNode(node.right, node.data);
        }

        return node;
    }

    @Override
    public boolean contains(T val) {
        return containsNode(root, val);
    }

    private boolean containsNode(Node node, T val) {
        if (node == null) return false;
        // a.compareTo(b)
        // a < b -> -1
        // a == b -> 0
        // a > b -> 1
        if (val.compareTo(node.data) == 0) {
            return true;
        }

        if (val.compareTo(node.data) < 0) {
            return containsNode(node.left, val);
        }

        return containsNode(node.right, val);
    }

    @Override
    public int size() {
        return this.size;
    }

    public List<T> preOrder() {
        return this.preorderTree(root, new ArrayList<>());
    }
    private List<T> preorderTree(Node node, List<T> visited) {
        if (node == null) return visited;

        // 가운데 노드 추가
        visited.add(node.data);
        // 왼쪽 탐색
        preorderTree(node.left, visited);
        // 오른쪽 탐색
        // visited = 가운데 노드 추가 + 왼쪽 탐색의 결과
        preorderTree(node.right, visited);

        return visited;
    }

    public List<T> inOrder() {
        return this.inorderTree(root, new ArrayList<>());
    }
    private List<T> inorderTree(Node node, List<T> visited) {
        if (node == null) return visited;
        // 왼쪽 탐색
        inorderTree(node.left, visited);
        // 가운데 노드 추가
        // visited = 왼쪽 탐색의 결과
        visited.add(node.data);
        // 오른쪽 탐색
        //visited = 왼쪽 탐색의 결과 + 가운데 노드
        inorderTree(node.right, visited);

        return visited;
    }

    public List<T> postOrder() {
        return this.postorderTree(root, new ArrayList<>());
    }
    private List<T> postorderTree(Node node, List<T> visited){
        if (node == null) return visited;
        // 왼족 탐색
        postorderTree(node.left, visited);
        // 오른쪽 탐색
        // visited = 왼쪽 탐색의 결과
        postorderTree(node.right, visited);
        // 가운데 노드 추가
        // visited = 왼쪽 탐색의 결과 + 오른쪽 탐색 결과
        visited.add(node.data);

        return visited;
    }
    private class Node{
        T data;
        Node left;
        Node right;

        Node(T data){
            this.data = data;
        }

        Node(T data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
