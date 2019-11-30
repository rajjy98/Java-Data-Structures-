
package GraphSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFS
{
    public static Map<Integer, Integer> predecessorMap;
    public static Set<Integer> visited; // vertices already visited
    
    private static Iterator<Integer> [ ] iter;
    private static List<Integer> [ ] adjList;   
    
   
    private static void visit(int v){ visited.add(v);}
    
    static public void init(List<Integer> [] adjList)
    {        
        predecessorMap = new HashMap<>();
        visited = new HashSet<>();
        iter = new Iterator[adjList.length];
        DFS.adjList = adjList;        
        reset();
    }
    
    /**
     * Start a completely new search
     */
    public static void reset()
    {
        predecessorMap.clear();
        visited.clear();
        for (int k = 0; k < iter.length; k++)
        {
            iter[k] = adjList[k].iterator();            
        }
    }  
    /**
     * Perform a BFS search from a start vertex v
     * @param v 
     */
    public static void search(int  v)
    {
        Stack<Integer> newStack = new Stack<Integer>();
        visit(v);
        newStack.push(v);
        predecessorMap.put(v,null);
        while (!newStack.empty())
        {
            int x = newStack.peek();
            
            if (iter[x].hasNext())
            {
                int j = iter[x].next();
                if (!(visited.contains(j)))
                {
                    visit (j);
                    newStack.push(j);
                    predecessorMap.put(j,x);
                }
            }
            else
            {
                newStack.pop();
            }
        }
    }
}
