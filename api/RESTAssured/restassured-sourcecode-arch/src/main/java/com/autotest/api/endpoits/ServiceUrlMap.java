package com.autotest.api.endpoits;

import com.autotest.api.utils.readers.PropertiesReader;

public class ServiceUrlMap {

    static String POSTS_URL;
    static String COMMENTS_URL;
    static String ALBUMS_URL;
    static String PHOTOS_URL;
    static String TODOS_URL;
    static String USERS_URL;

    PropertiesReader props = new PropertiesReader();

    public String getPOSTS_URL() {;
        return POSTS_URL = props.getProperties("serviceUrls.properties", "posts");
    }

    public String getCOMMENTS_URL() {
        return COMMENTS_URL = props.getProperties("serviceUrls.properties", "comments");
    }

    public String getALBUMS_URL() {
        return ALBUMS_URL = props.getProperties("serviceUrls.properties", "albums");
    }

    public String getPHOTOS_URL() {
        return PHOTOS_URL = props.getProperties("serviceUrls.properties", "photos");
    }

    public String getTODOS_URL() {
        return TODOS_URL = props.getProperties("serviceUrls.properties", "todos");
    }

    public String getUSERS_URL() {
        return USERS_URL = props.getProperties("serviceUrls.properties", "users");
    }
}
