import java.util.ArrayList;
import java.util.Scanner;

public class AcyclicityInDirectedGraph {
	static int n;
	static int m;
	static int[] visited;
	static int[] stack;
	static int a=0;
	static ArrayList<Integer>[] adj;
    static void acyclic() {
        //write your code here
    	int i;
    	for(i=0;i<n;i++){
    		if(visited[i]==0){
    			a=0;
    			explore(i);
    		}
    		if(a==1){
    			System.out.println("Cycle");
    			i=-1;
    			break;
    		}
    	}
    	if(i!=-1){
    		System.out.println("No Cycle");
    	}
    }
    
    static void explore(int j){
    	visited[j]=1;
    	stack[j]=1;
    	int k;
    	for(k=0;k<adj[j].size();k++){
    		if(a==1){
    			break;
    		}
    		if(visited[adj[j].get(k)]==0){
    			explore(adj[j].get(k));
    		}
    		else{
    			if(stack[adj[j].get(k)]==1){
    				a=1;
    				break;
    			}
    		}
    	}
    	if(k==0 || k==adj[j].size()){
    		stack[j]=0;
    	}
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        visited = new int[n];
        stack = new int[n];
        adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        acyclic();
    }
}