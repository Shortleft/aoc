import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private List<Node<T>> children = new ArrayList<Node<T>>();
    private List<Node<T>> parents = new ArrayList<Node<T>>();
    private T data = null;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> parents) {
        this.data = data;
        this.parents.add(parents);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParents(Node<T> parents) {
        if(this.parents.contains(parents)) {

        }
        parents.addChild(this);
        this.parents.add(parents);
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        child.setParents(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        child.setParents(this);
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parents == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent(Node<T> parent) {
        this.parents.remove(parent);
    }

    public void removeParent() {
        this.parents.clear();
    }



}
