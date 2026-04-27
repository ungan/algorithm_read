
import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int index;
        int size;
        Node previous;
        Node next;

        Node(int index, int size) {
            this.index = index;
            this.size = size;
        }
    }

    static class Linkedlist {
        Node head;
        Node tail;

        public void insertHead(Node node) {
            node.next = head;
            if (head != null) head.previous = node;
            head = node;
            if (tail == null) tail = node;
        }

        public void insertTail(Node preNode, Node node) {
            node.previous = preNode;
            node.next = null;
            preNode.next = node;
            tail = node;
        }

        public void insertNode(Node preNode, Node node) {
            node.next = preNode.next;
            node.previous = preNode;
            if (preNode.next != null) preNode.next.previous = node;
            preNode.next = node;
            if (preNode == tail) tail = node;
        }

        public void deleteNode(Node node) {
            if (node == null) return;
            if (node == head) {
                head = head.next;
                if (head != null) head.previous = null;
                if (node == tail) tail = head;
            } else if (node.next == null) { // tail
                if (node.previous != null) node.previous.next = null;
                tail = node.previous;
            } else { // 중간
                if (node.previous != null) node.previous.next = node.next;
                if (node.next != null) node.next.previous = node.previous;
            }
            node.next = node.previous = null;
        }
    }

    static Linkedlist list = new Linkedlist();
    static HashMap<String, Node> hash = new HashMap<>();
    static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.charAt(4) == '=') malloc(s);
            else if (s.startsWith("print")) print(s);
            else if (s.startsWith("free(")) free(s);
        }
    }

    static void malloc(String s) {
        String name = s.substring(0, 4);
        int val = Integer.parseInt(s.substring(s.indexOf('(') + 1, s.indexOf(')')));
        Node node = new Node(1, val);

        if (list.head == null) { // 리스트 비었으면
            list.insertHead(node);
            hash.put(name, node);
            return;
        }

        // head 앞 공간 확인
        if (list.head.index - 1 >= val) {
            node.index = 1;
            list.insertHead(node);
            hash.put(name, node);
            return;
        }

        Node temp = list.head;
        while (temp != null) {
            if (temp.next == null) { // tail 뒤 공간
                if (INF - (temp.index + temp.size - 1) >= val) {
                    node.index = temp.index + temp.size;
                    list.insertTail(temp, node);
                } else {
                    node.index = 0; // 할당 실패 표시
                }
                hash.put(name, node);
                break;
            } else { // 중간 공간 확인
                if (temp.next.index - (temp.index + temp.size) >= val) {
                    node.index = temp.index + temp.size;
                    list.insertNode(temp, node);
                    hash.put(name, node);
                    break;
                }
            }
            temp = temp.next;
        }
    }

    static void free(String s) {
        String name = s.substring(s.indexOf('(') + 1, s.indexOf(')'));
        if (!hash.containsKey(name)) return;

        Node node = hash.get(name);
        list.deleteNode(node);
        hash.remove(name);
    }

    static void print(String s) {
        String name = s.substring(s.indexOf('(') + 1, s.indexOf(')'));
        Node node = hash.get(name);
        System.out.println(node != null ? node.index : 0);
    }
}
