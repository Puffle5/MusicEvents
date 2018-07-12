package blog.bindingModels;

import javax.validation.constraints.NotNull;

public class EventSearch {
    @NotNull
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
