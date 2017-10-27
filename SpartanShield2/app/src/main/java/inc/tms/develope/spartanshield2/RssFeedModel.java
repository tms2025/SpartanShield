package inc.tms.develope.spartanshield2;

/**
 * Created by obaro on 27/11/2016.
 */

public class RssFeedModel {

    public String title;
    public String link;
    public String description;
    public String time;
    public String publisher;

    public RssFeedModel(String title, String link, String description, String time, String publisher) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.time = time;
        this.publisher = publisher;
    }
}
