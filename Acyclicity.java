// find cycle in the graph

import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity 
{
    private static int acyclic(ArrayList<Integer>[] adj) 
    {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        boolean[] recursArr = new boolean[n];
        for(int v = 0; v < n; v++)
        {
            if(!visited[v])
                if(acyclicUtil(adj, v, visited, recursArr))
                    return 1;
        }
        return 0;
    }

    private static boolean acyclicUtil(ArrayList<Integer>[] adjList, int src, boolean[] visited, boolean[] recursArr)
    {
        visited[src] = true;
        recursArr[src] = true;

        for(int v : adjList[src])
        {
            if(!visited[v])
                if(acyclicUtil(adjList, v, visited, recursArr))
                    return true;
            
            if(recursArr[v])
                return true;
        }
        recursArr[src] = false;
        return false;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
    
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
    
        for (int i = 0; i < m; i++) 
        {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
        scanner.close();
    }
}

