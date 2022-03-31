import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int vert[]=new int[v];
        int parent[]=new int[v];
        for(int i=0;i<v;i++){
            vert[i]=sc.nextInt();
            parent[i]=-1;
        }
        Edge edge[]=new Edge[e*2];
        Edge result[]=new Edge[v-1];
        for(int i=0;i<e*2;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int w=sc.nextInt();
            edge[i]=new Edge();
            edge[i].src=v1;
            edge[i].dest=v2;
            edge[i].w=w;
            i++;
            edge[i]=new Edge();
            edge[i].src=v2;
            edge[i].dest=v1;
            edge[i].w=w;
        }
        Arrays.sort(edge);
        int inc_e = 0;
        int edge_count=0;
        while(inc_e<v-1){
          int x = find(parent,edge[edge_count].src);
          int y= find(parent,edge[edge_count].dest);
          if(x!=y){
              result[inc_e]=edge[edge_count];
              inc_e++;
              union(parent,x,y);
            }
        edge_count++;
        }
        int tot_weight = 0;
       for(int i=0;i<v-1;i++){
           System.out.println((i+1)+"  "+result[i].src+"-->"+result[i].dest+" = "+result[i].w);
           tot_weight+=result[i].w;
       }
       System.out.println("Total weight : "+tot_weight);
    }
    public static int find(int parent[],int ele){
        if(parent[ele]==-1){
            return ele;
        }
        return find(parent,parent[ele]);
    }
    public static void union(int parent[],int x,int y){
        parent[x]=y;
    }
}
class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int w;
    public int compareTo(Edge comp){
        return this.w-comp.w;
    }}