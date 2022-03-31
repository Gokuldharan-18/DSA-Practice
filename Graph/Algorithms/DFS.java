import java.util.*;
public class DFS {
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
        // Recursive dfs
        index=0;
        int dfsOut[]=new int[numberOfNodes];
        boolean visited[]=new boolean[numberOfNodes];
        for(int i=0;i<numberOfNodes;i++){
            if(!visited[i]){
            dfsOut=dfs_rec(i,visited,dfsOut,nodes,adjacencyMatrix,numberOfNodes);}
        }
        System.out.println("Printing DFS of given Graph using recursive method");
        for(int element=0;element<numberOfNodes;element++){
            System.out.print(dfsOut[element]+" ");
        }
        // Iterative dfs
        index=0;
        dfsOut = new int[numberOfNodes];
        visited = new boolean[numberOfNodes];
        for(int i=0;i<numberOfNodes;i++){
            if(!visited[i]){
            dfsOut=dfs_iter(i,visited,dfsOut,nodes,adjacencyMatrix,numberOfNodes);
        }}
        System.out.println("\nPrinting DFS of given Graph using iterative method");
        for(int element=0;element<numberOfNodes;element++){
            System.out.print(dfsOut[element]+" ");
        }
    }
    static int[] dfs_rec(int start,boolean visited[],int dfsOut[],int nodes[],int adjMat[][],int n){

        visited[start]=true;
        dfsOut[index]=nodes[start];index++;
        for(int next=0;next<n;next++){
            if(visited[next]==false && adjMat[start][next]==1){
                dfs_rec(next,visited,dfsOut,nodes,adjMat,n);
            }
        }
        return dfsOut;
    }
    static int[] dfs_iter(int start,boolean visited[],int dfsOut[],int nodes[],int adjMat[][],int n){
        Stack<Integer> stk=new Stack<Integer>();
        stk.push(start);
        while(!stk.isEmpty()){
            int s = stk.peek();
            stk.pop();
            if(visited[s]==false){visited[s]=true;
            dfsOut[index]=nodes[s];index++;}
            for(int next=0;next<n;next++){
                if(visited[next]==false && adjMat[s][next]==1){
                    stk.push(next);
                }
            }
        }
        return dfsOut;
    }
    static int index(int array[],int key,int n){
        for(int i=0;i<n;i++){
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
}
