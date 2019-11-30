package GraphSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecursiveDFS
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
        RecursiveDFS.adjList = adjList;        
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
    
    public static void search(int  v)
    {
       visit(v);
       predecessorMap.put(v,null);
       for (int w: adjList[v])
       {
           if (!(visited.contains(w)))
           {
               search(w);
               predecessorMap.put(w,v);
           }
       }
    }
}
