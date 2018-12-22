//return the length of a string
//implemented same as Java JDK source code
//link: https://zgrepcode.com/java/oracle/jdk-8u181/java/lang/string.java#L-621

//TC: O(1)
public int strlen(String str) {
    char[] chars = str.toCharArray();
    return chars.length;
}