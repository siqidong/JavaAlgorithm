/*
Using map to map direction to actual index change delta
Queue to store the sequence of the tail of snake
Set to store all the points of the snake

TC: O(n)
SC: O(n)
*/

class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    int n;
    int m;
    Map<String, int[]> map;
    int[][] food;
    int index;
    Set<Integer> set;
    Queue<Integer> queue;
    int current;
    public SnakeGame(int width, int height, int[][] food) {
        this.n = height;
        this.m = width;
        this.map = new HashMap<>();
        map.put("U", new int[]{-1, 0});
        map.put("L", new int[]{0, -1});
        map.put("R", new int[]{0, 1});
        map.put("D", new int[]{1, 0});
        this.food = food;
        this.index = 0;
        this.set = new HashSet<>();
        this.queue = new LinkedList<>();
        set.add(0);
        queue.add(0);
        this.current = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int currentX = current/m;
        int currentY = current%m;
        int nextX = currentX+map.get(direction)[0];
        int nextY = currentY+map.get(direction)[1];

        if(nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
            return -1;
        }
        if(index<food.length && nextX==food[index][0] && nextY==food[index][1]) {
            index++;
        } else {
            if(!queue.isEmpty()) {
                int number = queue.poll();
                set.remove(number);
            }
            if(set.contains(nextX*m+nextY)) {
                return -1;
            }
        }
        current = nextX*m+nextY;
        queue.offer(current);
        set.add(current);

        return set.size()-1;
    }
}
