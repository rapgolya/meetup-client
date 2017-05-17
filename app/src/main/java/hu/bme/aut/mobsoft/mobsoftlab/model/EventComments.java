package hu.bme.aut.mobsoft.mobsoftlab.model;

/**
 * Created by rapgo on 2017. 05. 14..
 */

public class EventComments {
    public EventComments(Long id, String comment, String created, Long inReplyTo, int likeCount, String member, String title) {
        this.id = id;
        this.comment = comment;
        this.created = created;
        this.inReplyTo = inReplyTo;
        this.likeCount = likeCount;
        this.member = member;
        this.title = title;
    }

    private Long id = null;

    public EventComments() {
    }

    private String comment;
    private String created;
    private Long inReplyTo;
    private int likeCount;
    private String member;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Long getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(Long inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
