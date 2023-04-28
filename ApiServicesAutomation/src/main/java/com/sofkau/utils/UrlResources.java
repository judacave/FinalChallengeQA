package com.sofkau.utils;

public enum UrlResources {
    PHOTO_POST_RESOURCE("/photos"),
    JSONPLACEHOLDER_BASE_URL("https://jsonplaceholder.typicode.com"),
    APPRENTICE_RADAR_BASE_URL("https://c1-2023-ca-apprenticeradar-production.up.railway.app"),
    RADAR_POST_URL("/api/v1/radars");

    private final String value;

    UrlResources(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
