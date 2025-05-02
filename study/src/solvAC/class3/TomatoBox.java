package solvAC.class3;

import java.util.*;

//no.7576
public class TomatoBox {
    static int M, N; //가로 세로
    static int[][] box; //토마토 박스
    static int[][] dist; //날짜 저장
    static int[] dx = {1, -1, 0, 0}; //가로 이동
    static int[] dy = {0, 0, 1, -1}; //세로 이동
    static Queue<int[]> q = new LinkedList<>(); //익은 토마토 찾는 큐

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        box = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) { //익은 토마토 추가
                    q.add(new int[]{i, j});
                }
                if (box[i][j] == 0) { //안익은 토마토 저장
                    dist[i][j] = -1;
                }
            }
        }

        bfs(); //날짜 게산

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == -1) { //안악은 토마토 있음
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dist[i][j]); //날짜 최대값
            }
        }

        System.out.println(max);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] current = q.poll(); //익은 토마토 위치
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; //가로 이동
                int ny = y + dy[i]; //세로 이동

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) { //박스 내 조건
                    if (box[nx][ny] == 0 && dist[nx][ny] == -1) { //안익은 토마토
                        dist[nx][ny] = dist[x][y] + 1; //날짜 기록 익은 토마토 다음날
                        box[nx][ny] = 1; //익은 토마토
                        q.add(new int[]{nx, ny}); //익은 토마토 추가
                    }
                }
            }
        }
    }
}
