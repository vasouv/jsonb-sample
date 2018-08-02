package com.airhacks;

import java.util.List;

/**
 *
 * @author vasouv
 */
public class Album {

    private String title;
    private String band;
    private String year;
    private List<Track> tracklist;

    public Album() {
    }

    public Album(String title, String band, String year, List<Track> tracklist) {
        this.title = title;
        this.band = band;
        this.year = year;
        this.tracklist = tracklist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Track> getTracklist() {
        return tracklist;
    }

    public void setTracklist(List<Track> tracklist) {
        this.tracklist = tracklist;
    }

}
