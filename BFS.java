package GraphSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS
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
        BFS.adjList = adjList;        
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
       
       Queue<Integer> Q = new LinkedList<>(); 
       visit(v);
       predecessorMap.put(v,null);
       Q.add(v);
       while (!(Q.isEmpty()))
       {
           int f = Q.remove();
           for (Integer neighbor:adjList[f])
           {
               
               if(!(visited.contains(neighbor)))
               {
                   Q.add(neighbor);
                   predecessorMap.put(neighbor, f);
                   visit(neighbor);
               }
           }
       }
    }
}



