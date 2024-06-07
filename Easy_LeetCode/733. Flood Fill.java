class Solution {
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        queue.offer(new Pair(sr, sc));
        int target = image[sr][sc];
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            visited[cur.x][cur.y] = true;
            image[cur.x][cur.y] = newColor;
            add(cur, visited, target, image, queue);
        }
        return image;
    }
    
    private void add(Pair cur, boolean[][] visited, int target, int[][] image, Queue<Pair> queue) {
        if (cur.x > 0 && !visited[cur.x - 1][cur.y] && image[cur.x - 1][cur.y] == target) {
            queue.offer(new Pair(cur.x - 1, cur.y));
        }
        if (cur.y > 0 && !visited[cur.x][cur.y  - 1] && image[cur.x][cur.y - 1] == target) {
            queue.offer(new Pair(cur.x, cur.y - 1));
        }
        if (cur.x < image.length - 1 && !visited[cur.x + 1][cur.y] && image[cur.x + 1][cur.y] == target) {
            queue.offer(new Pair(cur.x + 1, cur.y));
        }
        if (cur.y < image[0].length - 1 && !visited[cur.x][cur.y + 1] && image[cur.x][cur.y + 1] == target) {
            queue.offer(new Pair(cur.x, cur.y + 1));
        }
    }
    
}