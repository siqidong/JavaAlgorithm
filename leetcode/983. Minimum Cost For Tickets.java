/*
Dynamic Programming

TC: O(n^2)
SC: O(n)
*/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] min = new int[n];
        int day1 = Math.min(costs[0], Math.min(costs[1], costs[2]));
        int day7 = Math.min(costs[1], costs[2]);
        min[0] = day1;
        for(int i = 1; i < n; i++) {
            //1 day pass
            min[i] = min[i-1]+day1; 
            //7 days pass
            int index = i;
            while(index>=0 && (days[i]-days[index])<7) {
                index--;
            }
            int temp = index<0?0:min[index];
            min[i] = Math.min(min[i], temp+day7);
            //30 days pass
            index = i;
            while(index>=0 && (days[i]-days[index])<30) {
                index--;
            }
            temp = index<0?0:min[index];
            min[i] = Math.min(min[i], temp+costs[2]);
        }
        return min[n-1];
    }
}