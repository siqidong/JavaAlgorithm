/*
练习写排序的Comparator

TC: O(nlogn)
SC: O(n)
*/

class LogComparator implements Comparator<String> {
    public int compare(String a, String b) {
        String[] splitA = a.split(" ");
        String[] splitB = b.split(" ");
        int index = 1;
        while(index<splitA.length && index<splitB.length && splitA[index].equals(splitB[index])) {
            index++;
        }
        if(index>=splitA.length) {
            return -1;
        }
        if(index>=splitB.length) {
            return 1;
        }
        return splitA[index].compareTo(splitB[index]);
    }
}
public String[] reorderLogFiles(String[] logs) {
    if(logs==null || logs.length<=1) {
        return logs;
    }
    List<String> listStr = new ArrayList<>();
    List<String> listNum = new ArrayList<>();
    for(String log : logs) {
        String[] words = log.split(" ");
        if(Character.isLetter(words[1].charAt(0))) {
            listStr.add(log);
        } else {
            listNum.add(log);
        }
    }
    listStr.sort(new LogComparator());
    String[] res = new String[logs.length];
    int index = 0;
    for(String s : listStr) {
        res[index++] = s;
    }
    for(String s : listNum) {
        res[index++] = s;
    }
    return res;
}