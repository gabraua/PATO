package com.quack.pato.model;

import java.util.ArrayList;
import java.util.List;

public class UrlManager {
    private List<String> urls;

    public UrlManager() {
        this.urls = new ArrayList<>();
    }

    public void addUrl(String url) {
        urls.add(url);
    }

    public void removeUrl(String url) {
        urls.remove(url);
    }

    public List<String> getUrls() {
        return urls;
    }

    public void clearUrls() {
        urls.clear();
    }
}
