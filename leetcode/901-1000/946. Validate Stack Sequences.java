/*
Simulating the push and pop procedure.
1. Keep adding element from pushed to the stack until stack.peek() is equal to the current element in popped
2. Keep removing element from stack while stack.peek() is equal to popped
3. Loop step 1 and 2
4. Until no element can be added into stack, check if stack is empty.

ex: 
          0 1 2 3 4             0 1 2 3 4
pushed = [1,2,3,4,5], popped = [4,3,5,1,2]

stack  = [1 2 3 4] 4 is equal to popped[0]
      => [1 2] remove 4, then remove 3
      => [1 2 5] 5 is equal to popped[2]
      => [1 2] remove 5
      => can no longer adding in more elements, but stack = [1,2] not null => false

TC: O(n)
SC: O(n)
*/
public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int n = pushed.length;
    int i = 0;
    int j = 0;
    while(i < n) {
        while(i < n && (stack.empty() || stack.peek()!=popped[j])) {
            stack.push(pushed[i++]);
        }
        while(!stack.empty() && stack.peek()==popped[j]) {
            stack.pop();
            j++;
        }
    }
    return stack.empty();
}