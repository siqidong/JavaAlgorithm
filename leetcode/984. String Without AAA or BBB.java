/*
Just a lot of if conditions...

TC: O(n)
SC: O(n)
*/
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        if(A>=2*B) {
            int count = 0;
            while(count<B) {
                sb.append("aab");
                count++;
            }
            while(A-2*count>0) {
                sb.append("a");
                A--;
            }
        } else if (B>=2*A) {
            int count = 0;
            while(count<A) {
                sb.append("bba");
                count++;
            }
            while(B-2*count>0) {
                sb.append("b");
                B--;
            }
        } else {
            if(A>B) {
                int count = 0;
                int diff = A-B;
                while(count<diff){
                    sb.append("aab");
                    count++;
                }
                while(count<B) {
                    sb.append("ab");
                    count++;
                }
            } else {
                int count = 0;
                int diff = B-A;
                while(count<diff) {
                    sb.append("bba");
                    count++;
                }
                while(count<A) {
                    sb.append("ba");
                    count++;
                }
            }
        }
        return sb.toString();
    }
}
