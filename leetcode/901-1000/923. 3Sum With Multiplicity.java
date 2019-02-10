/*
My Brute Force
要计算tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target
先把每个元素的个数存起来，再遍历i j k，可能的情况是：
1). i==j==k: count[i] choose 3
2). i==j!=k: count[i] choose 2 * count[k]
3). i==k!=j: count[i] choose 2 * count[j]
4). j==k!=i: count[j] choose 2 * count[i]
5). i!=j!=k: count[i] * count[j] * count[k]

要注意的强制类型转换的stack overflow：
1). int型相乘时要把每个int转换成long
2). long转int取模后再转换

TC: O(n)
SC: O(1)
*/

    
int base = 1000000007;
public int threeSumMulti(int[] A, int target) {
    if(A==null || A.length<=2) {
        return 0;
    }
    long[] count = new long[101];
    for(int num : A) {
        count[num]++;
    }
    System.out.println(count[0]);
    int res = 0;
    for(int i = 0; i <= 100; i++) {
        for(int j = i; j <= 100; j++) {
            for(int k = j; k <= 100; k++) {
                if((i+j+k)==target) {
                    res += getCount(i, j, k, count);
                    res %= base;
                }
            }
        }
    }
    return res;
}

public int getCount(int i, int j, int k, long[] count) {
    long longtemp = 0;
    int temp = 0;
    if(i==j && j==k) {
        if(count[i]>=3) {
            longtemp = count[i]*(count[i]-1)*(count[i]-2)/6;
        }
    } else if (i==j) {
        if(count[i]>=2) {
            longtemp = count[i]*(count[i]-1)*count[k]/2;
        }
    } else if (i==k) {
        if(count[i]>=2) {
            longtemp = count[i]*(count[i]-1)*count[j]/2;
        }
    } else if (j==k) {
        if(count[j]>=2) {
            longtemp = count[j]*(count[j]-1)*(count[i])/2;
        }
    } else {
        longtemp = count[i]*count[j]*count[k];
    }
    temp = (int)(longtemp%base);
    return temp;
}


/*
Think outside of box!
A brilliant solution here...
*/

public int threeSumMulti(int[] A, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    
    int res = 0;
    int mod = 1000000007;
    for (int i = 0; i < A.length; i++) {
        res = (res + map.getOrDefault(target - A[i], 0)) % mod;
        
        for (int j = 0; j < i; j++) {
            int temp = A[i] + A[j];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
    }
    return res;
}