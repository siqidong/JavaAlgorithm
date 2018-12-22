//Copy a string str
//TC: O(1)

public String strcpy(String str) {
    //newstr points to the same str instance
    //Since String is immutable in Java, hence newstr will not be modifies, so is safe
    String newstr = str;
    return newstr;
}