/*
TC: O(n) - supppose there are n letters for name and typed
SC: O(1)
*/
public boolean isLongPressedName(String name, String typed) {
    if(name==null || typed==null || name.length()>typed.length()) {
        return false;
    }
    int indexN = 0;
    int indexT = 0;
    while(indexN<name.length() && indexT<typed.length()) {
        if(name.charAt(indexN)!=typed.charAt(indexT)) {
            return false;
        }
        int countN = 0;
        int countT = 0;
        while(indexN+1<name.length() && name.charAt(indexN)==name.charAt(indexN+1)) {
            countN++;
            indexN++;
        }
        while(indexT+1<typed.length() && typed.charAt(indexT)==typed.charAt(indexT+1)) {
            countT++;
            indexT++;
        }
        if(countN>countT) {
            return false;
        }
        indexN++;
        indexT++;
    }
    if(indexN>=name.length() && indexT>=typed.length()) {
        return true;
    }
    return false;
}