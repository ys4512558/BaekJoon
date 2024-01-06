import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int visit[];
    static boolean visited[];
    static boolean isVisit[][];
    static int cnt = 1;
    static int count = 0;
    static Queue<Integer> queue;
    static Queue<Integer[]> points;
    static int cost[][];
    final static int dx[] = {-1, 1, 0, 0};
    final static int dy[] = {0, 0, -1, 1};
    static int moveX[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int moveY[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int isVisited[][];
    static int max = 0;

    static int moveH[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int moveW[] = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {

    }

    private static void prob11725() throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int parent[] = new int[N];

        for (int i = 1; i <= N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map.get(A).add(B);
            map.get(B).add(A);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parent[0] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            ArrayList<Integer> childs = map.get(cur);

            for (int i = 0; i < childs.size(); i++) {
                int child = childs.get(i);
                if (parent[child - 1] == 0) {
                    parent[child - 1] = cur;
                    queue.add(child);
                }
            }
        }

        for (int i = 1; i < N; i++) {
            sb.append(parent[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11403() throws IOException {
        int N = Integer.parseInt(br.readLine());

        int map[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob4963() throws IOException {
        int cnt = 0;
        while (true) {
            int map[][] = new int[50][50];
            isVisit = new boolean[50][50];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            for (int i = 0; i < h; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!isVisit[i][j] && map[i][j] == 1){
                        dfs4963(map, i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
            cnt = 0;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs4963(int map[][], int h, int w){
        isVisit[h][w] = true;
        for (int i = 0; i < moveH.length; i++) {
            int y = moveH[i] + h;
            int x = moveW[i] + w;
            if (y < 0 || x < 0 || y >= map.length || x >= map[y].length) {
                continue;
            }
            if (!isVisit[y][x] && map[y][x] == 1) {
                dfs4963(map, y, x);
            }
        }
    }

    private static void prob2468() throws IOException {
        int N = Integer.parseInt(br.readLine());

        int map[][] = new int[N][N];
        boolean isImmersed[][] = new boolean[N][N];
        boolean visited[][] = new boolean[N][N];
        int max = 0;
        int height = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, map[i][j]);
            }
        }

        for (int i = 0; i <= height; i++) {
            max = Math.max(max, bfs2468(map, i));
        }

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs2468(int[][] map, int height) {
        Queue<Integer[]> queue = new LinkedList<>();
        int count = 0;

        boolean[][] visited = new boolean[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] > height && !visited[i][j]) {
                    queue.add(new Integer[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Integer point[] = queue.poll();
                        int y = point[0];
                        int x = point[1];

                        for (int k = 0; k < 4; k++) {
                            int curY = y + dy[k];
                            int curX = x + dx[k];

                            if (curX < 0 || curY < 0 || curY >= map.length || curX >= map[curY].length) {
                                continue;
                            }
                            if (visited[curY][curX] || map[curY][curX] <= height) {
                                continue;
                            }

                            queue.add(new Integer[]{curY, curX});
                            visited[curY][curX] = true;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private static void prob14502() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs14502(map, 0);

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs14502(int[][] map, int wall) {
        if (wall == 3) {
            bfs14502(map, map.length, map[0].length);
            max = Math.max(max, count);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs14502(map, wall+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs14502(int[][] map, int N, int M) {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        points = new LinkedList<>();
        boolean visit[][] = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2) {
                    points.add(new Integer[]{i, j});
                }
            }
        }

        while (!points.isEmpty()) {
            Integer point[] = points.poll();
            int y = point[0];
            int x = point[1];

            for (int i = 0; i < 4; i++) {
                int curX = x + dx[i];
                int curY = y + dy[i];

                if (curY < 0 || curX < 0 || curY >= copyMap.length || curX >= copyMap[curY].length) {
                    continue;
                }
                if (copyMap[curY][curX] == 0 && !visit[curY][curX]) {
                    visit[curY][curX] = true;
                    copyMap[curY][curX] = 2;
                    points.add(new Integer[]{curY, curX});
                }
            }
        }
        calcCount(copyMap);
    }

    private static void calcCount(int[][] copyMap) {
        count = 0;
        for (int i = 0; i < copyMap.length; i++) {
            for (int j = 0; j < copyMap[i].length; j++) {
                if (copyMap[i][j] == 0) {
                   count++;
                }
            }
        }
    }

    private static void prob2206() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        int visit[][][] = new int[2][N][M];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        visit[0][0][0] = 1;
        visit[1][0][0] = 1;

        queue.add(new int[]{0, 0, 0});
        bfs2206(map, visit, queue, N, M);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs2206(int[][] map, int[][][] visit, Queue<int[]> queue, int N, int M) {
        while (!queue.isEmpty()) {
            int point[] = queue.poll();
            int crash = point[0];
            int y = point[1];
            int x = point[2];

            if (y == N - 1 && x == M - 1) {
                sb.append(visit[crash][y][x]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int curX = x + dx[i];
                int curY = y + dy[i];

                if (curX < 0 || curY < 0 || curY >= map.length || curX >= map[curY].length) {
                    continue;
                }
                if (map[curY][curX] == 1) {
                    if(crash == 0 && visit[1][curY][curX] == 0){
                        queue.add(new int[]{1, curY, curX});
                        visit[1][curY][curX] = visit[0][y][x] + 1;
                    }
                } else {
                    if (visit[crash][curY][curX] == 0) {
                        visit[crash][curY][curX] = visit[crash][y][x] + 1;
                        queue.add(new int[]{crash, curY, curX});
                    }
                }
                if (curY == N - 1 && curX == M - 1) {
                    sb.append(visit[crash][curY][curX]);
                    return;
                }
            }
        }
        sb.append(-1);
    }


    private static void prob2206_timeOut() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        isVisited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        int res = 1000000;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                points = new LinkedList<>();
                points.add(new Integer[]{0, 0});
                isVisited = new int[N][M];
                isVisited[0][0] = 1;
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    res = Math.min(res, bfs2206(map, N, M));
                    map[i][j] = 1;
                } else {
                    res = Math.min(res, bfs2206(map, N, M));
                }
            }
        }
        res = res == 1000000 ? -1 : res;
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs2206(int[][] map, int N, int M) {
        while (!points.isEmpty()) {
            Integer[] point = points.poll();
            int y = point[0];
            int x = point[1];

            for (int i = 0; i < 4; i++) {
                int curX = x + dx[i];
                int curY = y + dy[i];

                if (curX >= 0 && curY >= 0 && curY < N && curX < M) {
                    if (isVisited[curY][curX] == 0 && map[curY][curX] == 0) {
                        points.add(new Integer[]{curY, curX});
                        isVisited[curY][curX] = isVisited[y][x] + 1;
                    }
                }
            }
        }
        return isVisited[N - 1][M - 1] == 0 ? 1000000 : isVisited[N - 1][M - 1];
    }


    private static void prob16928() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ladderAndSnake[] = new int[101];
        int visit[] = new int[101];
        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladderAndSnake[start] = end;
        }
        queue = new LinkedList<>();

        bfs16928(ladderAndSnake, visit);

        sb.append(visit[100]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs16928(int[] ladderAndSnake, int[] visit) {
        queue.add(1);

        while (!queue.isEmpty()) {
            int q = queue.poll();
            if (q == 100) {
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int cur = q + i;
                if (cur > 100) {
                    continue;
                }
                if (visit[cur] != 0) {
                    continue;
                }
                visit[cur] = visit[q] + 1;
                if (ladderAndSnake[cur] != 0) {
                    if (visit[ladderAndSnake[cur]] == 0) {
                        queue.add(ladderAndSnake[cur]);
                        visit[ladderAndSnake[cur]] = visit[q] + 1;
                    }
                } else {
                    queue.add(cur);
                    visit[cur] = visit[q] + 1;
                }
            }
        }
    }

    private static void bfs169281(int[][] ladder, int[][] snake, int[] visit) {
        for (int i = 2; i <= 7; i++) {
            visit[i] = visit[1]+1;
            queue.add(i);
            for (int j = 0; j < ladder.length; j++) {
                if (i == ladder[j][0]) {
                    queue.add(ladder[j][1]);
                    visit[ladder[j][1]] = visit[i];
                }
            }
            for (int j = 0; j < snake.length; j++) {
                if (i == snake[j][0]) {
                    queue.add(snake[j][1]);
                    visit[snake[j][1]] = visit[i];
                }
            }
        }

        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int i = 1; i <= 6; i++) {
                if ((q + i) <= 100 && visit[q + i] == 0) {
                    visit[q + i] = visit[q] + 1;
                    queue.add(q + i);
                    for (int j = 0; j < ladder.length; j++) {
                        if ((q + i) == ladder[j][0]) {
                            queue.add(ladder[j][1]);
                            visit[ladder[j][1]] = visit[q + i];
                        }
                    }
                    for (int j = 0; j < snake.length; j++) {
                        if ((q + i) == snake[j][0] && visit[snake[j][1]] == 0) {
                            queue.add(snake[j][1]);
                            visit[snake[j][0]] = 0;
                        }
                    }
                }
            }
        }
    }


    private static void prob7569() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int tomato[][][] = new int[H][N][M];
        int visit[][][] = new int[H][N][M];
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    visit[i][j][k] = -1;
                    if(tomato[i][j][k] == 1) {
                        queue.add(new Integer[]{i, j, k});
                        visit[i][j][k] = 0;
                    }
                }
            }
        }
        visit = bfs7569(tomato, visit, queue);
        int res = 0;
        boolean isAvalilable = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(visit[i][j][k] == -1 && tomato[i][j][k] != -1){
                        isAvalilable = false;
                        break;
                    }
                    res = Math.max(res, visit[i][j][k]);
                }
            }
        }
        if(!isAvalilable)
            sb.append("-1");
        else {
            sb.append(res);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int[][][] bfs7569(int[][][] tomato, int[][][] visit, Queue<Integer[]> queue) {
        int dx[] = {-1, 1, 0, 0, 0, 0};
        int dy[] = {0, 0, -1, 1, 0, 0};
        int dz[] = {0, 0, 0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Integer point[] = queue.poll();
            int X = point[2];
            int Y = point[1];
            int Z = point[0];

            for (int i = 0; i < 6; i++) {
                int curX = X + dx[i];
                int curY = Y + dy[i];
                int curZ = Z + dz[i];

                if(curZ >= 0 && curY >= 0 && curX >= 0
                        && curZ < tomato.length
                        && curY < tomato[curZ].length
                        && curX < tomato[curZ][curY].length){
                    if(tomato[curZ][curY][curX] == 0 && visit[curZ][curY][curX] == -1){
                        visit[curZ][curY][curX] = visit[Z][Y][X]+1;
                        queue.add(new Integer[]{curZ, curY, curX});
                    }
                }
            }
        }
        return visit;
    }

    private static void prob7576() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        points = new LinkedList<>();

        int tomato[][] = new int[N][M];
        isVisited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1) {
                    points.add(new Integer[]{i, j});
                    isVisited[i][j] = 0;
                }
                else {
                    isVisited[i][j] = -1;
                }
            }
        }
        bfs7576(tomato, points);
        boolean check = false;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(isVisited[i][j] == -1 && tomato[i][j] != -1) {
                    check = true;
                    break;
                }
                else {
                    res = Math.max(res, isVisited[i][j]);
                }
            }
        }
        if(check)
            sb.append("-1");
        else {
            sb.append(res);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs7576(int[][] tomato, Queue<Integer[]> points) {
        while (!points.isEmpty()) {
            Integer[] curPoint = points.poll();
            int curX  = curPoint[1];
            int curY  = curPoint[0];
            for (int i = 0; i < 4; i++) {
                int X = curX + dx[i];
                int Y = curY + dy[i];
                if (X >= 0 && Y >= 0 && Y < tomato.length && X < tomato[Y].length){
                    if (isVisited[Y][X] == -1 && tomato[Y][X] != -1) {
                        points.add(new Integer[]{Y, X});
                        tomato[Y][X] = 1;
                        isVisited[Y][X] = isVisited[curY][curX] + 1;
                    }
                }
            }
        }
    }


    private static void prob7562_bfs() throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            int visited[][] = new int[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer cur[] = new Integer[2];
            cur[0] = Integer.valueOf(st.nextToken());
            cur[1] = Integer.valueOf(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Integer goal[] = new Integer[2];
            goal[0] = Integer.valueOf(st.nextToken());
            goal[1] = Integer.valueOf(st.nextToken());
            if (cur[0].equals(goal[0]) && cur[1].equals(goal[1])) {
                sb.append(0).append("\n");
            } else {
                sb.append(bfs7562(visited, cur, goal)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs7562(int visited[][], Integer[] cur, Integer[] goal) {
        points = new LinkedList<>();
        points.add(cur);
        while (!points.isEmpty()) {
            Integer point[] = points.poll();
            for (int i = 0; i < moveX.length; i++) {
                int curY = point[0] + moveY[i];
                int curX = point[1] + moveX[i];
                if (curX >= 0 && curY >= 0 && curY < visited.length && curX < visited[curY].length) {
                    if (visited[curY][curX] == 0) {
                        visited[curY][curX] = visited[point[0]][point[1]]+1;
                        points.add(new Integer[]{curY, curX});
                    }
                    if(curY == goal[0] && curX == goal[1])
                        return visited[curY][curX];
                }
            }
        }
        return 0;
    }


    private static void prob2178() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N][M];
        cost = new int[N][M];
        isVisit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        points = new LinkedList<>();
        bfs2178(map, 0, 0);
        sb.append(cost[N - 1][M - 1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs2178(int[][] map, int i, int j) {
        points.add(new Integer[]{i,j});
        isVisit[i][j] = true;
        cost[i][j] = 1;
        while (!points.isEmpty()) {
            Integer[] point = points.poll();
            int Y = point[0];
            int X = point[1];
            if(Y == map.length-1 && X == map[Y].length-1){
                break;
            }
            for (int k = 0; k < 4; k++) {
                int curY = Y + dy[k];
                int curX = X + dx[k];
                if(curY >= 0 && curX >= 0 && curY < map.length && curX < map[curY].length){
                    if(!isVisit[curY][curX] && map[curY][curX] == 1){
                        isVisit[curY][curX] = true;
                        points.add(new Integer[]{curY, curX});
                        cost[curY][curX] = cost[Y][X]+1;
                    }
                }
            }
        }
    }


    private static void prob1012_dfs() throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int map[][] = new int[N][M];
            isVisit = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(!isVisit[j][k] && map[j][k] == 1) {
                        dfs1012(map, j, k);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs1012(int[][] map, int j, int k) {
        isVisit[j][k] = true;
        for (int i = 0; i < 4; i++) {
            int curX = k + dx[i];
            int curY = j + dy[i];
            if (curX >= 0 && curY >= 0 && curY < map.length && curX < map[curY].length ) {
                if(!isVisit[curY][curX] && map[curY][curX] == 1)
                    dfs1012(map, curY, curX);
            }
        }
    }


    private static void prob2667_bfs() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[N][N];
        isVisit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp.toCharArray()[j]));
            }
        }
        int total = 0;
        ArrayList<Integer> house = new ArrayList<>();

        points = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!isVisit[i][j] && map[i][j] == 1)
                    bfs2667(map, i, j);
                if(count != 0) {
                    house.add(count);
                    total++;
                }
                count = 0;
            }
        }
        Collections.sort(house);
        sb.append(total).append("\n");
        for (int i = 0; i < house.size(); i++) {
            sb.append(house.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs2667(int[][] map, int i, int j) {
        Integer point[] = new Integer[]{i, j};
        points.add(point);
        isVisit[i][j] = true;

        while (!points.isEmpty()) {
            point = points.poll();
            int y = point[0];
            int x = point[1];

            count++;
            if (x - 1 >= 0 && !isVisit[y][x-1] && map[y][x-1] == 1) {
                points.add(new Integer[]{y, x - 1});
                isVisit[y][x-1] = true;
            }
            if (x + 1 < map[i].length && !isVisit[y][x+1] && map[y][x+1] == 1) {
                points.add(new Integer[]{y, x + 1});
                isVisit[y][x+1] = true;
            }
            if (y - 1 >= 0 && !isVisit[y-1][x] && map[y-1][x] == 1) {
                points.add(new Integer[]{y - 1, x});
                isVisit[y-1][x] = true;
            }
            if (y + 1 < map.length && !isVisit[y+1][x] && map[y+1][x] == 1) {
                points.add(new Integer[]{y + 1, x});
                isVisit[y+1][x] = true;
            }
        }
    }

    private static void prob2667_dfs() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[N][N];
        isVisit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp.toCharArray()[j]));
            }
        }
        int total = 0;
        ArrayList<Integer> house = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs2667(map, i, j);
                if(count != 0) {
                    house.add(count);
                    total++;
                }
                count = 0;
            }
        }
        Collections.sort(house);
        sb.append(total).append("\n");
        for (int i = 0; i < house.size(); i++) {
            sb.append(house.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs2667(int[][] map, int i, int j) {
        if(!isVisit[i][j] && map[i][j] == 1){
            isVisit[i][j] = true;
            count++;
            if(j-1 >= 0)
                dfs2667(map, i, j-1);
            if(j+1 < map[i].length)
                dfs2667(map, i, j+1);
            if(i-1 >= 0)
                dfs2667(map, i-1, j);
            if(i+1 < map.length)
                dfs2667(map, i+1, j);
        }
    }


    private static void prob1697() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visit = new int[100001];
        queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int q = queue.poll();
            if(q == K){
                break;
            }
            if(q-1 >= 0  && visit[q-1] == 0){
                queue.add(q - 1);
                visit[q-1] = visit[q]+1;
            }
            if(q+1 <= 100000 && visit[q+1] == 0 ){
                queue.add(q + 1);
                visit[q+1] = visit[q]+1;
            }
            if((q * 2) <= 100000 && visit[q*2] == 0){
                queue.add(q * 2);
                visit[q*2] = visit[q]+1;
            }
        }
        sb.append(visit[K]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1260() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edge.get(node1).add(node2);
            edge.get(node2).add(node1);
        }
        sb.append(V).append(" ");
        dfs1260(edge, V);
        sb.append("\n");

        queue = new LinkedList<>();
        visited = new boolean[N+1];
        bfs1260(edge, V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs1260(Map<Integer, ArrayList<Integer>> edge, int v) {
        visited[v] = true;
        Collections.sort(edge.get(v));
        for (int i = 0; i < edge.get(v).size(); i++) {
            if(!visited[edge.get(v).get(i)]) {
                sb.append(edge.get(v).get(i)).append(" ");
                dfs1260(edge, edge.get(v).get(i));
            }
        }
    }
    private static void bfs1260(Map<Integer, ArrayList<Integer>> edge, int v) {
        queue.add(v);
        visited[v] = true;
        sb.append(v).append(" ");
        while (!queue.isEmpty()) {
            int q = queue.poll();
            Collections.sort(edge.get(q));
            for (int i = 0; i < edge.get(q).size(); i++) {
                if(!visited[edge.get(q).get(i)]){
                    visited[edge.get(q).get(i)] = true;
                    queue.add(edge.get(q).get(i));
                    sb.append(edge.get(q).get(i)).append(" ");
                }
            }
        }
    }

    private static void prob2606_bfs() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edge.get(node1).add(node2);
            edge.get(node2).add(node1);
        }
        bfs2606(edge, 1);

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if(visited[i])
                count++;
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs2606(Map<Integer, ArrayList<Integer>> edge, int start) {
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()){
            int q = queue.poll();
            for (int i = 0; i < edge.get(q).size(); i++) {
                if(!visited[edge.get(q).get(i)]){
                    visited[edge.get(q).get(i)] = true;
                    queue.add(edge.get(q).get(i));
                }
            }
        }
    }

    private static void prob2606_dfs() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edge.get(node1).add(node2);
            edge.get(node2).add(node1);
        }
        dfs2606(edge, 1);
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if(visited[i])
                count++;
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs2606(Map<Integer, ArrayList<Integer>> edge, int start) {
        visited[start] = true;
        for (int i = 0; i < edge.get(start).size(); i++) {
            if(!visited[edge.get(start).get(i)]){
                dfs2606(edge, edge.get(start).get(i));
            }
        }
    }

    private static void prob24445() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i + 1), new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge.get(e1).add(e2);
            edge.get(e2).add(e1);
        }
        bfs24445(edge, R);
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs24445(Map<Integer, ArrayList<Integer>> edge, int r){
        visit[r] = cnt++;
        queue.add(r);
        while (!queue.isEmpty()) {
            int q = queue.remove();
            Collections.sort(edge.get(q), Collections.reverseOrder());
            for (int i = 0; i < edge.get(q).size(); i++) {
                if (visit[edge.get(q).get(i)] == 0) {
                    visit[edge.get(q).get(i)] = cnt++;
                    queue.add(edge.get(q).get(i));
                }
            }
        }
    }

    private static void prob24444() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge.get(e1).add(e2);
            edge.get(e2).add(e1);
        }
        bfs24444(edge, R);
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void bfs24444(Map<Integer, ArrayList<Integer>> edge, int r) {
        visit[r] = cnt++;
        queue.add(r);
        int q;
        while (!queue.isEmpty()){
            q = queue.remove();
            Collections.sort(edge.get(q));
            for (int i = 0; i < edge.get(q).size(); i++) {
                if(visit[edge.get(q).get(i)] == 0) {
                    visit[edge.get(q).get(i)] = cnt++;
                    queue.add(edge.get(q).get(i));
                }
            }
        }
    }

    private static void prob24480() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge.get(e1).add(e2);
            edge.get(e2).add(e1);
        }
        dfs24480(edge, R);
        for (int i = 1; i < visit.length; i++) {
            sb.append(visit[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void dfs24480(Map<Integer, ArrayList<Integer>> edge, int r) {
        visit[r] = cnt++;
        Collections.sort(edge.get(r), Collections.reverseOrder());
        for (int i = 0; i < edge.get(r).size(); i++) {
            if(visit[edge.get(r).get(i)] == 0)
                dfs24480(edge, edge.get(r).get(i));
        }
    }
    private static void prob24479() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visit = new int[N+1];
        Map<Integer, ArrayList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < N; i++) {
            edge.put((i+1), new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            edge.get(e1).add(e2);
            edge.get(e2).add(e1);
        }
        dfs24479(edge, R);
        for (int i = 1; i < visit.length; i++) {
            sb.append(visit[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void dfs24479(Map<Integer, ArrayList<Integer>> edge, int r) {
        visit[r] = cnt++;
        Collections.sort(edge.get(r));
        for (int i = 0; i < edge.get(r).size(); i++) {
            if(visit[edge.get(r).get(i)] == 0)
                dfs24479(edge, edge.get(r).get(i));
        }
    }
}