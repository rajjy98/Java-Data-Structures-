/**
 *
 * format of the contents of the file is
 * number of vertices (N)
 * vertex0 number-of-neighbors  space separated list of neighbors of vertex0
 * vertex1 number-of-neighbors  space separated list of neighbors of vertex1
 *
 * vertex(N-1) number-of-neighbors space separated list of neighbors of vertex(N-1)
 */
package csce210Graphs;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Graph
{
    // Map and array translate between integer and string representations
    // of a vertex
    final Map<String, Integer> vertexNameToNumberMap = new HashMap<>();
    final String[] vertexNames;

    private final LinkedList<Integer>[] adjList;
    
    public int getNumberOfVertices() { return adjList.length; }
    public  LinkedList<Integer>[] getAdjacencyList() { return adjList;}
    public String getVertexName(int v) { return vertexNames[v];}
    public int getVertexNumber(String name) { return vertexNameToNumberMap.get(name);}

    public Graph(Scanner sc)
    {
        
        
        int numVerts = sc.nextInt();
        adjList = (LinkedList<Integer>[]) new LinkedList[numVerts];
        int vertexNum = 0;
        vertexNames = new String[numVerts];
        
        for (int n = 0; n < numVerts; n++)
        {
           
            int count = 0;
            LinkedList <Integer> temp = new LinkedList<Integer>();
            int key;
            
            String primaryVert = sc.next();
            if((vertexNameToNumberMap.containsKey(primaryVert))==false)
            { 
                vertexNames[vertexNum] = primaryVert;
                vertexNameToNumberMap.put(primaryVert, vertexNum);
               
                vertexNum++;   
                key = vertexNameToNumberMap.get(primaryVert);
                count = key;
            }
            else
            {
                key = vertexNameToNumberMap.get(primaryVert);
                count = key;
            }
            int numNeighbors = sc.nextInt();
            
            for(int j = 0; j < numNeighbors; j++) 
            {
                String finalvert = sc.next();
                if((vertexNameToNumberMap.containsKey(finalvert))==false)
                {
                    vertexNames[vertexNum] = finalvert;
                    vertexNameToNumberMap.put(finalvert, vertexNum);
                    
                    
                    vertexNum ++;
                    key = vertexNameToNumberMap.get(finalvert);
                    temp.add(key);
                }
                else
                {
                    key = vertexNameToNumberMap.get(finalvert);
                    temp.add(key);
                }
            }
            adjList[count] = temp;
    }
    }
    
    // Translate list of integers that are number of vertices
    // to a list of names for those vertices.
    public List<String> translate(List<Integer> path)
    {        
       List<String> ret = new LinkedList<>();
       for(int p:path)
       {
           ret.add(vertexNames[p]);
           
       }
       return ret;
    }

    // Output the internal, number representation of the graph
    public void outputInt(PrintStream out)
    {        
        for (int k = 0; k < adjList.length; k++)
        {
            out.printf("%d : %s\n", k, adjList[k]);
        }
    }
    
    // Output the representation of the graphs using string names 
    // of verices instead of number.
    public void outputString(PrintStream out)
    {       
        for (int k = 0; k < adjList.length; k++)
        {
           // out.printf? Hint: use translate method
            String translated = vertexNames[k];
            List<String> translatedList = translate(adjList[k]);
            out.printf("%s : %s\n", translated, translatedList);
        }
    }
}
