/*
My Algorithm:
       
             s1      e1          s2      e2      s3      e3
Given A = [0 1 0 1 1 1 0 0 0 0 0 1 0 1 1 1 0 0 0 1 0 1 1 1 0]

Step:
1: Count how many 1s in the array, if number of 1s is not a multiplier of 3, return false;
2: Divide into three parts, every part should have same pattern.
Find  s1, e1, s2, e2, s3, e3:
s1: starting 1 in first part
e1: ending 1 in first part
s2: starting 1 in second part
e2: ending 1 in second part
s3: starting 1 in third part
e4: ending 1 in third part

substring(s1, e1), substring(s1, e1), substring(s1, e1) should all be equal

3: Count the ending 0s in third part.
The 0s between part1 and part2 as well as the 0s between part2 and part3 should be equal to or more than that number.

ex: in the above example, 
substring1 = 10111, substring2 = 10111, substring2 = 10111;
Number of ending 0s in third substring is 1.
0s between substring1 and substring2 is (e1, s2) = 5>=1
0s between substring2 and substring3 is (e2, s3) = 3>=1

=> so we can find such three parts.


TC: O(n)
SC: O(n)
*/
class Solution {
    public int[] threeEqualParts(int[] A) {
        int count = 0;
        for(int num : A) {
            count += num==1?1:0;
        }
        if(count==0) {
            return new int[]{0, 2};
        }
        if(count%3!=0) {
            return new int[]{-1, -1};
        }
        count /= 3;
        int s1 = -1, e1 = -1, s2 = -1, e2 = -1, s3 = -1, e3 = -1;
        int n = A.length;
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(A[i]==1) {
                temp++;
            }
            if(temp==count+1) {
                temp = 1;
            }
            if(A[i]==1 && temp==1) {
                if(s1==-1) {
                    s1 = i;
                } else if (s2==-1) {
                    s2 = i;
                } else {
                    s3 = i;
                }
            }
            if(A[i]==1 && temp==count){
                if(e1==-1) {
                    e1 = i;
                } else if (e2==-1) {
                    e2 = i;
                } else {
                    e3 = i;
                }
            }
            sb.append(A[i]);
        }
        String str1 = sb.toString().substring(s1, e1+1);
        String str2 = sb.toString().substring(s2, e2+1);
        String str3 = sb.toString().substring(s3, e3+1);
        if(!str1.equals(str2) || !str2.equals(str3) || !str1.equals(str3)) {
            return new int[]{-1, -1};
        }
        int numZero = n-1-e3;
        int interval1 = s2-e1-1;
        int interval2 = s3-e2-1;
        if(interval1<numZero || interval2<numZero) {
            return new int[]{-1, -1};
        }
        return new int[]{e1+numZero, e2+numZero+1};
    }
}