package hu.bme.aut.mobsoft.mobsoftlab.model;

/**
 * Created by rapgo on 2017. 05. 14..
 */

public class Category {
    private Long id = null;
    private String name;
    private String shortName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Category() {}
    public Category(Long id, String name, String shortName){
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

}
