import java.util.ArrayList;
import java.util.Scanner;
public class NoOfComponentsInGraph {
    static int[] temp;
    static int NoOfNodes;
    static int NoOfEdges;
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        //write your code here
        for(int i=0;i<NoOfNodes;i++){
        	int a = Explore(adj,i);
        	if(a!=0)
        	{
        		result++;
        	}
        }
        return result;
    }
    private static int Explore(ArrayList<Integer>[] adj,int i){
    	if(temp[i]!=0){
    		return 0;
    	}
    	else{
    		temp[i]=1;
    		for(int j=0;j<adj[i].size();j++){
    			if(temp[adj[i].get(j)]==0){
    				Explore(adj,adj[i].get(j));
    			}
    		}
    		return 1;
    	}
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoOfNodes= scanner.nextInt();
        NoOfEdges= scanner.nextInt();
        temp = new int[NoOfNodes];
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
        System.out.println(numberOfComponents(adj));
    }
}