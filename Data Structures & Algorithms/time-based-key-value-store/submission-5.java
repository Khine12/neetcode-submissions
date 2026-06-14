class TimeMap {

    private static class Entry{

        int time;

        String val;

        Entry(int time, String val){

            this.time = time;

            this.val = val;
        }
    }

    Map<String,List<Entry>> map;

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

            if(list.get(mid).time <= timestamp){

                ans = mid;

                left = mid + 1;
            }
            else{

                right = mid -1;
            }
        }

        return ans == -1 ? "" : list.get(ans).val;

    }
}
