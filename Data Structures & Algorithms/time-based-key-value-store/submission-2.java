class TimeMap {

    private static class Entry{

        int time;

        String val;

        Entry(int time, String val){

            this.time = time;

            this.val = val;
        }
    }

    Map<List<Entry>> map;

    public TimeMap() {

        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.putIfAbsent(key,new ArrayList<>());

        map.get(key).add(new Entry(timestamp,value));
        
    }
    
    public String get(String key, int timestamp) {
        
        List<Entry> list = map.get(key);

        if(list == null) return "";

        int left = 0, right = list.size()-1, ans = -1;

        while(left <= right){

            int mid = left + (right-left)/2;

            if(map.get(mid).time <= timestamp){

                ans = mid;

                lef = mid + 1;
            }
            else{

                right = mid -1;
            }
        }

        return ans == -1 ? "" : map.get(ans).val;

    }
}
