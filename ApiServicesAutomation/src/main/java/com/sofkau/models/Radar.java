package com.sofkau.models;

import java.util.ArrayList;
import java.util.List;

public class Radar {
    private String radarId;
    private List<Descriptor> descriptorList = new ArrayList<>();

    public Radar() {
    }

    public String getRadarId() {
        return radarId;
    }

    public void setRadarId(String radarId) {
        this.radarId = radarId;
    }

    public List<Descriptor> getDescriptorList() {
        return descriptorList;
    }

    public void setDescriptorList(List<Descriptor> descriptorList) {
        this.descriptorList = descriptorList;
    }
}
