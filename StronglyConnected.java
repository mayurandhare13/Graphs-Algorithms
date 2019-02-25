// find number of Strongly Connected Component in graph

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnected 
{
    private static void dfs(ArrayList<Integer>[] adjRev, int src, boolean[] visited, Stack<Integer> post)
    {
        visited[src] = true;
        for(int v : adjRev[src])
        {
            if(!visited[v])
                dfs(adjRev, v, visited, post);
        }

        if(post != null)
            post.push(src);
    }

    private static ArrayList<Integer>[] graphReverse(ArrayList<Integer>[] adj)
    {
        ArrayList<Integer>[] adjRev = new ArrayList[adj.length];
        for(int i = 0; i < adj.length; i++)
            adjRev[i] = new ArrayList<>();

        for(int v = 0; v < adj.length; v++)
        {
            for(int c : adj[v])
                adjRev[c].add(v);
        }
        return adjRev;
    }

    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) 
    {
        ArrayList<Integer>[] adjRev = graphReverse(adj);
        boolean[] visited = new boolean[adj.length];
        Stack<Integer> post = new Stack<>();

        for(int v = 0; v < adj.length; v++)
        {
            if(!visited[v])
                dfs(adjRev, v, visited, post);
        }

        int numSCC = 0;
        visited = new boolean[adj.length];
        while(!post.isEmpty())
        {
            int v = post.pop();
            if(visited[v])
                continue;
            dfs(adj, v, visited, null);
            numSCC += 1;
        }
        return numSCC;
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
        scanner.close();
    }
}

