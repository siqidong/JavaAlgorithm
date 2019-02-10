/*
Use Set and Queue to implement a random number distributer

TC: get / check / release: O(1)
SC: O(n)
*/
class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    Set<Integer> assigned;
    Queue<Integer> unassigned;
    public PhoneDirectory(int maxNumbers) {
        this.assigned = new HashSet<>();
        this.unassigned = new LinkedList<>();
        for(int i = 0; i < maxNumbers; i++) {
            unassigned.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(unassigned.size()==0) {
            return -1;
        }
        int number = unassigned.poll();
        assigned.add(number);
        return number;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !assigned.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(assigned.contains(number)) {
            assigned.remove(number);
            unassigned.offer(number);
        }
    }
}
