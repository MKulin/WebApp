package webApp.model;

import org.springframework.stereotype.Component;

@Component
public class Human {

    private long id;
    private String name;

    public Human(){

    }

    public Human(String name){
        this.name = name;
    }

    public Human(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
