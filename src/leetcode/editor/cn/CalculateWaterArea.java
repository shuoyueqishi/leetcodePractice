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

import javafx.geometry.Pos;

import java.util.*;

public class CalculateWaterArea {

    public static void main(String[] args) {
        int[][] maps = new int[][]{
                {0, 2, 1, 1},
                {0, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 0, 1}
        };
        int[] waterAreas = pondSizes(maps);
        for (int area : waterAreas) {
            System.out.printf("%5d", area);
        }
        System.out.println();
    }

    // 附近点移动，按照逆时针方向从左上角开始的顺序
    private static int[][] move = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    /**
     * 坐标点定义
     */
    private static class Position {
        private int row;
        private int col;

        public Position(int r, int c) {
            row = r;
            col = c;
        }
    }

    /**
     * 获取地图中水域的面积
     * @param land 地图
     * @return 水域面积从小到大排列
     */
    public static int[] pondSizes(int[][] land) {
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
        for (int i = 0; i < areas.size(); i++) {
            resAreas[i] = areas.get(i);
        }
        return resAreas;
    }

    /**
     * 使用宽度优先搜索求包含当前点的水域面积
     * @param land 地图
     * @param row 当前点的行坐标
     * @param col 当前点的列坐标
     * @param mark 记录该点是否被访问标记
     * @return 返回包含当前点的水域面积
     */
    private static int getWaterArea(int[][] land, int row, int col, int[][] mark) {
        int waterArea = 0;
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(row, col));
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            mark[row][col] = 1;
            waterArea += 1;
            for (int i = 0; i < move.length; i++) {
                int nextRow = move[i][0] + position.row;
                int nextCol = move[i][1] + position.col;
                if (isNotBoundary(land, nextRow, nextCol)) {
                    if (land[nextRow][nextCol] == 0 && mark[nextRow][nextCol] == 0) {
                        queue.add(new Position(nextRow, nextCol));
                    }
                    mark[nextRow][nextCol] = 1;
                }
            }
        }
        return waterArea;
    }

    /**
     * 边界检查
     * @param land 地图
     * @param row 当前行坐标
     * @param col 当前列坐标
     * @return 返回是否在地图内
     */
    private static boolean isNotBoundary(int[][] land, int row, int col) {
        int rowBoundary = land.length - 1;
        int rolBoundary = land[0].length - 1;
        return row >= 0 && row <= rowBoundary && col >= 0 && col <= rolBoundary;
    }
}
