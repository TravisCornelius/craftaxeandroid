package com.mybringback.traviscornelius.craftaxethrowing;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by traviscornelius on 10/13/17.
 */

public class Player {
    String name;
    String lane;

    public Player(String name, String lane){
        this.name = name;
        this.lane = lane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", this.name);
        result.put("lane", this.lane);

        return result;
    }

}
