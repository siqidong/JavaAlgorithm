/*
Obviously should belong to recursion...
example:
x:  
y: 
z:  1  2   3

ans: 
move 1 from x to z
move 2 from x to y
move 1 from z to y

move 3 from x to z

move 1 from y to x
move 2 from y to z
move 1 from x to z

*/

//TC: O(2^n)

class MyCode {
    static int minStep = 0;
	public static void main (String[] args) {
        hanoiTower(3, 'x', 'z', 'y');
        System.out.println("Minimum step is "+minStep);
	}

    public static void hanoiTower(int n, char from, char to, char aux) {
        minStep++;
        if(n==1) {
            System.out.println("Move disk 1 from " + from + " to " +to);
            return;
        }
        hanoiTower(n-1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " +to);
        hanoiTower(n-1, aux, to, from);
    }
}