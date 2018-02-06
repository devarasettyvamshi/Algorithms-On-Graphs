import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TopologicalSortOnDirectedGraph {
	static int used[];
	static ArrayList<Integer> order;
	static int NoOfNodes;
	static int NoOfEdges;
	static ArrayList<Integer>[] adj;
	
    private static void toposort() {
        used = new int[adj.length];
        order = new ArrayList<Integer>();
        for(int i=0;i<NoOfNodes;i++){
        	if(used[i]==0){
        		dfs(i);
            }
        	}
        //return order;
    }

    private static void dfs(int i) {
    		used[i]=1;
    		for(int j=0;j<adj[i].size();j++){
    			if(used[adj[i].get(j)]==0){
    				dfs(adj[i].get(j));
    			}
    		}
    		order.add(i);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoOfNodes = scanner.nextInt();
        NoOfEdges = scanner.nextInt();
        adj = (ArrayList<Integer>[])new ArrayList[NoOfNodes];
        for (int i = 0; i < NoOfNodes; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < NoOfEdges; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        toposort();
        for (int x=order.size()-1;x>=0;x--) {
            System.out.print((order.get(x))+1 + " ");
        }
    }
}