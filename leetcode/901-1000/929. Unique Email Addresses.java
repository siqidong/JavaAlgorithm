/*
Use HashMap

TC: O(mn) - supppose there are m emails with n letters each
SC: O(mn)
*/
public int numUniqueEmails(String[] emails) {
    if(emails==null || emails.length<=0) {
        return 0;
    }
    Map<String, Set<String>> map = new HashMap<>();
    for(String email : emails) {
        int index = email.indexOf('@');
        String local = processLocal(email.substring(0, index));
        String domain = email.substring(index+1);
        if(!map.containsKey(domain)) {
            map.put(domain, new HashSet<>());
        }
        map.get(domain).add(local);
    }
    int res = 0;
    for(Map.Entry<String, Set<String>> entry : map.entrySet()) {
        res += entry.getValue().size();
    }
    return res;
}

public String processLocal(String str) {
    StringBuilder sb = new StringBuilder();
    for(char c : str.toCharArray()) {
        if(c=='+') {
            return sb.toString();
        }
        if(c=='.') {
            continue;
        }
        sb.append(c);
    }
    return sb.toString();
}