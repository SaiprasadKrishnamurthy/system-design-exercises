public class DFSinMatrix {
    //Check whether there is path from src(x,y) to dest (x, y)
    //DFS wraper, Time O(m*n), Space O(m*n)
    public static boolean hasPathDfs(int[][] adj, int sx, int sy, int dx, int dy) {
        int m = adj.length;
        int n = adj[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(adj, sx, sy, visited);
        if (!visited[dx][dy]) {
            return false;
        }
        return true;
    }

    //DFS + memoization, Time O(m*n), Space O(m*n)
    private static void dfs(int[][] adj, int i, int j, boolean[][] visited) {
        int m = adj.length;
        int n = adj[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || adj[i][j] == 1 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(adj, i, j - 1, visited); //Move top
        dfs(adj, i + 1, j, visited); // Move Right
        dfs(adj, i - 1, j, visited); // Move left
        dfs(adj, i, j + 1, visited); //Move bottom
    }

    public static void main(String[] args) {
        //2D matrix with 1's as blocked  and 0's as path.
        int[][] matrix = {{0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        //find path
        int sx = 1, sy = 3, dx = 3, dy = 1;
        System.out.println("Find path from (" + sx + "," + sy + ") to (" + dx + "," + dy + "): ");
        System.out.println("DFS: " + hasPathDfs(matrix, sx, sy, dx, dy));
    }
}