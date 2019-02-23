import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) 
    {
        boolean[] visited = new boolean[adj.length];
        return explore(adj, x, y, visited);
    }

    private static int explore(ArrayList<Integer>[] adj, int src, int dest, boolean[] visited)
    {
        if(src == dest)
            return 1;
        visited[src] = true;
        for(int child : adj[src])
        {
            if(!visited[child])
            {
                if(explore(adj, child, dest, visited) == 1)
                    return 1; 
            }
        }
        return 0;
    }


    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) 
        {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
       // System.out.println("Please enter \"start\" and \"end\" node");
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
        scanner.close();
    }
}

