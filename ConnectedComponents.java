import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents 
{
    private static int numberOfComponents(ArrayList<Integer>[] adj) 
    {
        int result = 0;
        boolean[] visited = new boolean[adj.length];
        int[] nodes = new int[adj.length]; // used to see which Conneected component node belongs to

        for(int i = 0; i < adj.length; i++)
        {
            if(!visited[i])
            {
                explore(adj, i, visited, nodes, result);
                result += 1;
            }
        }
        
        for(int i : nodes)
            System.out.print(i+ " ");
        return result;
    }

    private static void explore(ArrayList<Integer>[] adj, int src, boolean[] visited, int[] nodes,int cc)
    {
        visited[src] = true;
        nodes[src] = cc;
        for(int child : adj[src])
        {
            if(!visited[child])
            {
                explore(adj, child, visited, nodes, cc);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
        scanner.close();
    }
}

