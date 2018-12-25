/*
暴力呗 还能咋整

TC: O(1)
SC: O(1) since A.length==4
*/

public String largestTimeFromDigits(int[] A) {
    int hour = Integer.MIN_VALUE;
    int min = Integer.MIN_VALUE;
    String hourStr = "";
    String minStr = "";
    for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 4; j++) {
            if(i==j) {
                continue;
            }
            for(int k = 0; k < 4; k++) {
                if(i==k || j==k) {
                    continue;
                }
                for(int l = 0; l < 4; l++) {
                    if(i==l || j==l || k==l) {
                        continue;
                    }
                    int tempHour = 10*A[i]+A[j];
                    int tempMin = 10*A[k]+A[l];
                    if(0<=tempHour && tempHour<=23 && 0<=tempMin && tempMin<=59) {
                        if(tempHour>hour || (tempHour==hour && tempMin>min)) {
                            hour = tempHour;
                            min = tempMin;
                            hourStr = A[i]+""+A[j];
                            minStr = A[k]+""+A[l];
                        }
                    }
                }
            }
        }
    }
    if(hour==Integer.MIN_VALUE || min==Integer.MIN_VALUE) {
        return "";
    }
    return hourStr+":"+minStr;
}