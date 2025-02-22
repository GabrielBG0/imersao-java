package GBG.linguagensapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mainLanguages")
public class Language {

    @Id
    private String id;
    private String title;
    private String image;
    private int rank;

    public Language(String title, String image, int rank) {
        this.title = title;
        this.image = image;
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRank() {
        return rank;
    }

    public String getId() {
        return id;
    }

}
