/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 */

package leetcode.editor.cn;

import java.util.*;

public class CalculateWaterArea {

    // 附近点移动，按照上右下左的顺序
    private int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0 || land[0].length == 0) {
            return new int[0];
        }
        int[][] mark = new int[land.length][land[0].length];
        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0 && mark[i][j] == 0) {
                    int waterArea = getWaterArea(land, i, j, mark);
                    areas.add(waterArea);
                }
            }
        }
        Collections.sort(areas);
        int[] resAreas = new int[areas.size()];
        for (int i =0; i<areas.size();i++) {
            resAreas[i]=areas.get(i);
        }
        return resAreas;
    }

    private int getWaterArea(int[][] land, int row, int col, int[][] mark) {
        int waterArea = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(land[row][col]);
        while (!queue.isEmpty()) {
            queue.poll();
            mark[row][col]=1;
            waterArea += 1;
            for (int i = 0; i < move.length; i++) {
                int nextRow = move[i][0] + row;
                int nextCol = move[i][1] + col;
                if (isNotBoundary(land, nextRow, nextCol) && land[nextRow][nextCol] == 0 && mark[nextRow][nextCol] == 0) {
                    queue.add(land[nextRow][nextCol]);
                }
            }
        }
        return waterArea;
    }

    private boolean isNotBoundary(int[][] land, int row, int col) {
        int rowBoundary = land.length - 1;
        int rolBoundary = land[0].length - 1;
        return row >= 0 && row <= rowBoundary && col >= 0 && col <= rolBoundary;
    }
}
