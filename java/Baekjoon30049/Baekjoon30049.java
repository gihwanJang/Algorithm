import java.io.*;
import java.util.*;

class Store {
    int idx;
    List<Employee> employees;

    public Store(int idx) {
        this.idx = idx;
        employees = new ArrayList<>();
    }
}

class Employee {
    int idx;
    int[][] stores;

    public Employee(int idx, int k) {
        this.idx = idx;
        stores = new int[k][2];
    }

    public static 
}

class Problem {
    int n, m, k;
    Store[] stores;
    Employee[] employees;

    public Problem(String n, String m, String k) {
        this.n = Integer.parseInt(n);
        this.m = Integer.parseInt(m);
        this.k = Integer.parseInt(k);
        setStores();
        setEmployees();
    }

    private void setStores() {
        stores = new Store[m];
        for(int i = 0; i < m; ++i) {
            stores[i] = new Store(i);
        }
    }

    private void setEmployees() {
        employees = new Employee[n];
        for(int i = 0; i < n; ++i) {
            employees[i] = new Employee(i, k);
        }
    }
}

public class Baekjoon30049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(st.nextToken(), st.nextToken(), st.nextToken());

        for(int i = 0; i < problem.n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < problem.k; ++j) {
                int store = Integer.parseInt(st.nextToken())-1;
                int profit = Integer.parseInt(st.nextToken());
                problem.employees[i].stores[j][0] = store;
                problem.employees[i].stores[j][1] = profit;
                problem.stores[store].employees.add(problem.employees[i]);
            }
        }
    }
}
