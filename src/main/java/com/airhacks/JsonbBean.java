package com.airhacks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

/**
 *
 * @author vasouv
 */
@Named("jsonbBean")
@SessionScoped
public class JsonbBean implements Serializable {
    
    private String title;
    private String band;
    private String year;
    private List<Track> tracklisting;
    private String trackToAdd;

    protected String jsonTextArea = "";

    private final Jsonb jsonb;

    public JsonbBean() {
        //JsonbConfig and Jsonb instance creation
        JsonbConfig config = new JsonbConfig().withFormatting(true);
        this.jsonb = JsonbBuilder.create(config);
    }
    
    @PostConstruct
    public void init(){
        tracklisting = new ArrayList();
        trackToAdd = "";
    }
    
    public void addTrack() {
        System.out.println("Adding " + trackToAdd);
        this.tracklisting.add(new Track(trackToAdd));
    }

    /*
     * Action method for the form in index.html.
     * Creates Person object and creates formatted JSON
     */
    public String createJson() {
        Album album = new Album(this.title, this.band, this.year, this.tracklisting);

        /* Serialize to JSON */
        this.jsonTextArea = jsonb.toJson(album);

        /* JSF navigation */
        return "jsongenerated";
    }

    /*
     * Action method for form in jsongenerated.xhtml.
     * Deserialize JSON from the textarea to Person object
     * and fills these data to form.
     */
    public String parseJson() {
        clearFields();

        /* Deserialization of JSON to Object */
        Album album = jsonb.fromJson(this.jsonTextArea, Album.class);
        this.title = album.getTitle();
        this.band = album.getBand();
        this.year = album.getYear();
        this.tracklisting = album.getTracklist();
        
        /* JSF navigation */
        return "index";
    }

    private void clearFields() {
        this.band = "";
        this.title = "";
        this.year = "";
        this.tracklisting.clear();
        this.trackToAdd = "";
    }

    //Getters and Setters
    public String getJsonTextArea() {
        return jsonTextArea;
    }

    public void setJsonTextArea(String jsonTextArea) {
        this.jsonTextArea = jsonTextArea;
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

    public List<Track> getTracklisting() {
        return tracklisting;
    }

    public void setTracklisting(List<Track> tracklisting) {
        this.tracklisting = tracklisting;
    }

    public String getTrackToAdd() {
        return trackToAdd;
    }

    public void setTrackToAdd(String trackToAdd) {
        this.trackToAdd = trackToAdd;
    }

}
