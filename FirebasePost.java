package edu.skku.map.pillalarm;

import java.util.HashMap;
import java.util.Map;
public class FirebasePost {
    public String medname;
    public String memo;
    public Long time;


    public FirebasePost() {
// Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
    }

    public FirebasePost(String medname, String memo, Long age) {
        this.medname = medname;
        this.memo = memo;
        this.time = age;

    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("medname", medname);
        result.put("memo", memo);
        result.put("time", time);
        return result;
    }
}