package INFO6205.Assignment_8;

public class ShortestPath {
    static int num = 5;
    public static void minimumDistance(int[][] graph,int source){
        if(graph.length == 0 || source < 0){
            return;
        }
        int dist[] = new int[num];
        boolean b[] = new boolean[num];
        for(int i =0; i < num; i ++){
            dist[i] = Integer.MAX_VALUE;
            b[i]=false;
        }
        dist[source] =0;
        for(int i=0; i < num-1; i++){
            int minDist = miniDistance(dist,b);
            b[minDist] = true;
            for(int j = 0; j<num; j++){
                if(!b[j] && graph[minDist][j] != 0 && dist[minDist] != Integer.MAX_VALUE && dist[minDist]+graph[minDist][j] < dist[j]){
                    dist[j] = dist[minDist] + graph[minDist][j];
                }
            }
        }
        printGraph(dist);
    }
    public static int miniDistance(int dist[],boolean[] b){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i =0; i < num; i++){
            if(!b[i] && dist[i] <= min){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
    private static void  printGraph(int[] dist){
        System.out.println("Distance from source to destination is :");
        for(int j =0; j < num; j++){
            System.out.println(j+"....."+dist[j]);
        }
    }
    public static void main(String[] args){
//        int graph[][] = new int[0][0];
        int graph[][] = new int[][] { { 0, 4, 0, 0, 8 },
                { 4, 0, 8, 0, 11 },
                { 0, 8, 0, 7, 2 },
                { 0, 0, 7, 0, 0 },
                { 0, 0, 0, 9, 0 },
                { 0, 0, 4, 14, 0 }};
        int src =0;
        minimumDistance(graph,src);
    }
}
