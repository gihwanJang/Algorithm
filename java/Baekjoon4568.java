/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjun4568{
    public static class LinkedHashSet{
        int size;
        HashSet<Character> set;
        LinkedList<Character> order=new LinkedList<>();
        public LinkedHashSet(int N){
            this.size=N;
            this.set = new HashSet<>((int)(N*1.3));
        }
        public void put(char c){
            if(!set.contains(c)){
                if(set.size()==size){
                    set.remove(order.get(0));
                    order.remove(0);
                }
                set.add(c);
                order.add(c);
            }
            else
                order.add(order.remove(order.indexOf(c)));
        }
        public void get(){
            for(char c: order)
                System.out.print(c);
            System.out.println();
        }
    }
    public static void LRU(int count, int N, String[] data){
        System.out.println("Simulation "+count);
        LinkedHashSet cache = new LinkedHashSet(N);
        for(int i=0; i<data.length; ++i){
            for(int j=0; j<data[i].length(); ++j)
                cache.put(data[i].charAt(j));
            cache.get();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N==0) return;
            String[] data = st.nextToken().split("!");
            LRU(count++, N, data);
        }
    }
}
*/
import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon4568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        int num = 0;
        LRUCache cache = new LRUCache();
        while (true) {
            num++;
            line = scanner.nextLine();
            if (line.equals("0")) {
                break;
            }
            doLRU(cache, line, num);
        }
        scanner.close();
    }

    public static void doLRU(LRUCache cache, String line, int lineNum) {
        String[] fields = line.split("\\s+");
        int cacheSize = Integer.parseInt(fields[0]);
        String sequence = fields[1];
        cache.init(cacheSize);
        System.out.println("Simulation " + lineNum);
        sequence.chars().forEach(c -> {
            if (c == '!') {
                cache.print();
            } else {
                cache.access((char) c);
            }
        });
    }

    private static class LRUCache {

        MyLinkedList<Character> cache = new MyLinkedList<>();
        int size;

        public LRUCache() {
        }

        public void init(int size) {
            cache.clear();
            this.size = size;
        }

        public void access(char c) {
            if (cache.contains(c)) {
                cache.findAndMoveToLast(c);
            } else {
                if (cache.size() == size) {
                    cache.removeHead();
                }
                cache.addTail(c);
            }
        }

        public void print() {
            cache.print();
        }
    }

    private static class MyLinkedList<E> {

        private static class Node<E> {
            Node<E> prev = null;
            Node<E> next = null;
            E data = null;

            public Node(E data) {
                this.data = data;
            }
        }

        private Node<E> head = null;
        private Node<E> tail = null;
        private HashMap<E, Node<E>> map = new HashMap<>();
        int count = 0;

        public void clear() {
            head = null;
            tail = null;
            map.clear();
            count = 0;
        }

        public void addTail(E data) {
            Node<E> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            map.put(data, newNode);
            count++;
        }

        public void removeHead() {
            if (head != null) {
                map.remove(head.data);
                if (head.next != null) {
                    head.next.prev = null;
                }
                head = head.next;
                count--;
            }
        }

        public boolean contains(E data) {
            return map.containsKey(data);
        }

        public void findAndMoveToLast(E data) {
            if (map.containsKey(data)) {
                Node<E> node = map.get(data);
                removeFromLink(node);

                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
            }
        }

        public int size() {
            return count;
        }

        private void removeFromLink(Node<E> n) {
            if (n == null)
                return;

            if (n == head) {
                head = n.next;
            }

            if (n == tail) {
                tail = n.prev;
            }

            if (n.prev != null) {
                n.prev.next = n.next;
            }
            if (n.next != null) {
                n.next.prev = n.prev;
            }
            n.prev = null;
            n.next = null;
        }

        public void print() {
            Node<E> cur = head;
            while (cur != null) {
                System.out.print(cur.data);
                cur = cur.next;
            }
            System.out.println();
        }
    }
}