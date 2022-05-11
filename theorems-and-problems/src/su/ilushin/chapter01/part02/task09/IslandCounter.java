package su.ilushin.chapter01.part02.task09;

public class IslandCounter {

  /**
   * Returns number of islands on map
   *
   * Islands are rectangles
   * Islands do not overlap
   *
   * @param map - array with 1 - if point belongs to island
   * @return number of islands on map
   */
  public static int getIslandCount(int[][] map) {
    int result = 0;


    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        //check if [i,j] is top-left island conner
        if (map[i][j] == 1) {
          if (
              ((i == 0) && (j == 0))
                  || ((i == 0) && (j > 0) && (map[i][j - 1] == 0))
                  || ((i > 0) && (j == 0) && (map[i - 1][j] == 0))
                  || ((i > 0) && (j > 0) && (map[i - 1][j] == 0) && (map[i][j - 1] == 0))
          ) {
            result++;
          }
        }
      }
    }

    return result;
  }

  public static void run() {

    int[][] arr = {
        {1, 0, 0, 0, 1, 1, 0, 0, 0},//2
        {0, 1, 1, 1, 0, 0, 0, 0, 0},//1
        {0, 1, 1, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0},//1
        {1, 0, 0, 0, 0, 0, 0, 0, 0},//1
        {1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 1, 0, 0},//2
        {0, 0, 0, 1, 1, 1, 0, 0, 0},//1
        {0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    System.out.println("Island count: "+getIslandCount(arr));
  }


}
