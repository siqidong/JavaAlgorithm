/*
Use Map to realize TimeMap

Set:
TC: O(1)
SC: O(1)

Get:
TC: O(n)
SC: O(n)
*/
class TimeMap {
    class Value {
        String value;
        int time;
        public Value(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    /** Initialize your data structure here. */
    Map<String, List<Value>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Value(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Value> values = map.get(key);
        int index = 0;
        while(index<values.size() && values.get(index).time<= timestamp) {
            index++;
        }
        index--;
        return index==-1?"":values.get(index).value;
    }
}