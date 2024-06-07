class Solution {
    public int trapRainWater(int[][] heightMap) {
     // Write your solution here
    int rows = heightMap.length;
    int cols = heightMap[0].length;
    if (rows <= 2 || cols <= 2) {
      return 0;
    }
    PriorityQueue<Pair> minHeap = new PriorityQueue<>();
    boolean[][] visited = new boolean[rows][cols];
    processBorder(heightMap, visited, minHeap, rows, cols);
    int res = 0;
    Pair cur;
    List<Pair> neis;
    while (!minHeap.isEmpty()) {
      cur = minHeap.poll();
      neis = getNeighbors(cur, heightMap);
      for (Pair nei: neis) {
        if (visited[nei.x][nei.y]) {
          continue;
        }
        visited[nei.x][nei.y] = true;
        res += Math.max(cur.height - nei.height, 0);
        nei.height = Math.max(cur.height, nei.height);
        minHeap.offer(nei);
      }
    }
    return res;
  }

  private List<Pair> getNeighbors(Pair cur, int[][] matrix) {
    List<Pair> neis = new ArrayList<>();
    if (cur.x + 1 < matrix.length) {
      neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
    }

    if (cur.x - 1 >= 0) {
      neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
    }

    if (cur.y + 1 < matrix[0].length) {
      neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
    }

    if (cur.y - 1 >= 0) {
      neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x ][cur.y - 1]));
    }

    return neis;
  }

  private void processBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minHeap, int rows, int cols) {
    for (int j = 0; j < cols; j++) {
      minHeap.offer(new Pair(0, j, matrix[0][j]));
      minHeap.offer(new Pair(rows - 1, j, matrix[rows - 1][j]));
      visited[0][j] = true;
      visited[rows - 1][j] = true;
    }

    for (int i = 0; i < rows; i++) {
      minHeap.offer(new Pair(i, 0, matrix[i][0]));
      minHeap.offer(new Pair(i, cols - 1, matrix[i][cols - 1]));
      visited[i][0] = true;
      visited[i][cols - 1] = true;
    }
  }

  class Pair implements Comparable<Pair> {
    int x, y, height;

    Pair(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }

    @Override
    public int compareTo(Pair another) {
      if (this.height == another.height) {
        return 0;
      }
      return this.height < another.height? -1 : 1;
    }
  }
}