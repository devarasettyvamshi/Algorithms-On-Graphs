import java.util.ArrayList;
import java.util.Scanner;
public class PathBetweenNodesOfGraph {
	static int NoOfNodes;
	static int NoOfEdges;
	static int Visited[];
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
    	if(Visited[x]!=1){
    	Visited[x]=1;
    	int a = adj[x].size();
    	for(int i=0;i<a;i++){
    		if(adj[x].get(i)==y){
    			return 1;
    		}
    		else{
    		int temp = reach(adj,adj[x].get(i),y);
    		if(temp==1){
    			return 1;
    		}
    		}
    	}
    	}
    	return 0;
    }	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoOfNodes = scanner.nextInt();
        NoOfEdges = scanner.nextInt();
        Visited = new int[NoOfNodes];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[NoOfNodes];
        for (int i = 0; i < NoOfNodes; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < NoOfEdges; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}