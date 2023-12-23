import java.io.*;
import java.util.*;

class Store {
    int idx, maxProfit;
    List<Employee> employees;

    public Store(int idx) {
        this.idx = idx;
        employees = new ArrayList<>();
    }

    public void setMaxProfit() {
        if(!employees.isEmpty()) {
            maxProfit = employees.get(0).stores.get(idx);
            for(Employee e : employees) {
                maxProfit = Math.max(maxProfit, e.stores.get(idx));
            }
        }
    }

    public boolean getMVP(int profit) {
        if(profit < maxProfit) {
            return false;
        }
        maxProfit = profit;
        return true;
    }
}

class Employee {
    int idx;
    HashSet<Integer> mvpSet;
    HashMap<Integer, Integer> stores;

    public Employee(int idx) {
        this.idx = idx;
        stores = new HashMap<>();
        mvpSet = new HashSet<>();
    }
}

class Problem {
    int n, m, k, cnt = 0;
    Store[] stores;
    Employee[] employees;
    boolean[] mvps;

    public Problem(String n, String m, String k) {
        this.n = Integer.parseInt(n);
        this.m = Integer.parseInt(m);
        this.k = Integer.parseInt(k);
        setStores();
        setEmployees();
    }

    public void setMVP() {
        mvps = new boolean[n];
        for(int i = 0; i < m; ++i) {
            stores[i].setMaxProfit();
        }
        for(int i = 0; i < n; ++i) {
            if(isMvp(i)) {
                mvps[i] = true;
                ++cnt;
            }
        }
    }

    public int getMVP(int e, int s, int p) {
        employees[e].stores.put(s, employees[e].stores.get(s)+p);

        if(stores[s].maxProfit < employees[e].stores.get(s)) { 
            stores[s].maxProfit = employees[e].stores.get(s);
            employees[e].mvpSet.add(s);

            for(int i = 0; i < n; ++i) {
                if(employees[i].mvpSet.contains(s) && employees[i].stores.containsKey(s) && !stores[s].getMVP(employees[i].stores.get(s))) {
                    employees[i].mvpSet.remove(s);
                    if(mvps[i]) {
                        mvps[i] = false;
                        --cnt;
                    }
                }
            }

            if(!mvps[e] && employees[e].mvpSet.size() == k) {
                mvps[e] = true;
                ++cnt;
            }
        }

        return cnt;
    }

    private boolean isMvp(int idx) {
        boolean flag = true;
        for(Integer store : employees[idx].stores.keySet()) {
            if(!stores[store].getMVP(employees[idx].stores.get(store))) {
                flag = false;
            } else {
                employees[idx].mvpSet.add(store);
            }
        }
        return flag;
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
            employees[i] = new Employee(i);
        }
    }
}

public class Baekjoon30049 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(st.nextToken(), st.nextToken(), st.nextToken());

        for(int i = 0; i < problem.n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < problem.k; ++j) {
                int store = Integer.parseInt(st.nextToken())-1;
                int profit = Integer.parseInt(st.nextToken());
                problem.employees[i].stores.put(store, profit);
                problem.stores[store].employees.add(problem.employees[i]);
            }
        }
        problem.setMVP();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;
            int p = Integer.parseInt(st.nextToken());
            sb.append(problem.getMVP(e, s, p)).append("\n");
        }

        System.out.print(sb.toString());
    }
}