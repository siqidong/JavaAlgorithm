/*
Using two stack to interate a nexted list.

TC: O(n)
SC: O(n)
*/
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack1;
    Stack<NestedInteger> stack2;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        for(int i = nestedList.size()-1; i >= 0; i--) {
            stack1.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack1.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack1.empty() && !stack1.peek().isInteger()) {
            List<NestedInteger> list = stack1.pop().getList();
            for(NestedInteger element : list) {
                stack2.push(element);
            }
            while(!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return !stack1.empty();
    }
}