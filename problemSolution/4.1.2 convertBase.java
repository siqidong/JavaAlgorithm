/*
进制转换
将m进制 的数字num 转换为n进制 （2 <= m,n <= 62) ？
思路是：先将m进制转换为10进制，再将10进制转为n进制。 
*/

/*
10进制转其他进制（m进制），
从最后一位算起，10进制的数字每次%m，取对应的m进制的string值，注意最后答案是reverse的。

link: https://www.binaryhexconverter.com/decimal-to-hex-converter
*/
//10进制转16进制
public String convertDecToHex(int num) {
    StringBuilder sb = new StringBuilder();
    String hex = "0123456789ABCDEF";
    while(num > 0) {
        sb.append(hex.charAt(num%16));
        num /= 16;
    }
    sb.reverse();
    return sb.toString();
}

//10进制转26进制
public String convertDecTo26(int num) {
    StringBuilder sb = new StringBuilder();
    String hex = "0123456789ABCDEFGHIJKLMNO";
    while(num > 0) {
        sb.append(hex.charAt(num%26));
        num /= 26;
    }
    sb.reverse();
    return sb.toString();
}

/*
m进制转10进制，
从第一位算起，m进制的数字取对应的m进制的index值，就是10进制中对应的数值

link: http://extraconversion.com/base-number/decimals/decimals-to-base-26.html
*/
//16进制转10进制
public int convertHexToDec(String num) {
    int res = 0;
    String hex = "0123456789ABCDEF";
    for(char c : num.toCharArray()) {
        int index = hex.indexOf(c);
        res = 16*res+index;
    }  
    return res;
}

//26进制转10进制
public int convert26ToDec(String num) {
    int res = 0;
    String hex = "0123456789ABCDEFGHIJKLMNO";
    for(char c : num.toCharArray()) {
        int index = hex.indexOf(c);
        res = 26*res+index;
    }  
    return res;
}