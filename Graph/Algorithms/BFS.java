import java.util.*;

public class BFS{
    static int index;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        int numberOfEdges = sc.nextInt();
        int nodes[]=new int[numberOfNodes];
        for(int node = 0;node<numberOfNodes;node++){
            nodes[node]=sc.nextInt();
        }
        int adjacencyMatrix[][] = new int[numberOfNodes][numberOfNodes];
        for(int edge=0;edge<numberOfEdges;edge++){
            adjacencyMatrix[index(nodes,sc.nextInt(),numberOfNodes)][index(nodes,sc.nextInt(),numberOfNodes)]=1;
        }
        int bfsOut[]=new int[numberOfNodes];
        boolean visited[]=new boolean[numberOfNodes];
        index=0;
        for(int i=0;i<numberOfNodes;i++){
            if(!visited[i]){
                bfsOut=bfs(adjacencyMatrix,i,numberOfNodes,nodes,visited,bfsOut);
            }
        } 
        System.out.println("Printing BFS of given Graph");
        for(int element=0;element<numberOfNodes;element++){
            System.out.print(bfsOut[element]+" ");
        }
    }
    static int index(int array[],int key,int n){
        for(int i=0;i<n;i++){
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
    static int[] bfs(int[][] adjMat,int start,int n,int nodes[],boolean visited[],int bfsOut[]){
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int currNode = q.poll();
            //System.out.print(currNode+" ");
            bfsOut[index]=nodes[currNode];index++;
            for(int adj=0;adj<n;adj++){
                if(adjMat[currNode][adj]==1 && visited[adj]==false){
                    q.add(adj);
                    visited[adj]=true;
                }
            }
        }
        return bfsOut;
    }
}