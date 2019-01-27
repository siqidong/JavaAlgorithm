/*
A classical solution to this type of problems.

Monotonous Stack
Using stack to calculate how many numbers are continuously smaller/bigger than current number.

To calculate how many values are continuously smaller than current value, maintain a decreasing stack.
A trick is to store an array int[2] arr: with arr[0]==value, arr[1]==count
ex: 
     arr = [100, 80, 60, 70, 60, 75, 85]

   stack =  [(100, 1)]
            [(100, 1), (80, 1)]
            [(100, 1), (80, 1), (60, 1)]
            [(100, 1), (80, 1), (70, 2)]
            [(100, 1), (80, 1), (70, 2), (60, 1)]
            [(100, 1), (80, 1), (75, 4)]
            [(100, 1), (85, 6)]


TC: O(n)
SC: O(n)
*/
class StockSpanner {
    
    Stack<int[]> stack;
    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!stack.empty() && stack.peek()[0]<=price) {
            count += stack.pop()[1];
        }
        stack.push(new int[]{price, count});
        return count;
    }
}
