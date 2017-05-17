package hu.bme.aut.mobsoft.mobsoftlab.model;

/**
 * Created by rapgo on 2017. 05. 14..
 */

public class Event {
    private Long id = null;
    private int commentCount;
    private String description;
    private String duration;
    private String eventHosts;
    private String fee;
    private String name;
    private String time;
    private String venue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEventHosts() {
        return eventHosts;
    }

    public void setEventHosts(String eventHosts) {
        this.eventHosts = eventHosts;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getYesRsvpCount() {
        return yesRsvpCount;
    }

    public void setYesRsvpCount(int yesRsvpCount) {
        this.yesRsvpCount = yesRsvpCount;
    }

    private int yesRsvpCount;

    public  Event(){}

    public Event(Long id, int commentCount, String description, String duration, String eventHosts, String fee, String name, String time, String venue, int yesRsvpCount) {
        this.id = id;
        this.commentCount = commentCount;
        this.description = description;
        this.duration = duration;
        this.eventHosts = eventHosts;
        this.fee = fee;
        this.name = name;
        this.time = time;
        this.venue = venue;
        this.yesRsvpCount = yesRsvpCount;
    }
}
