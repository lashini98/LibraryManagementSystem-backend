package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "w1698510_DVD")
public class DVD extends LibraryItem {

    private String w1698510_availLanguages;

    private String w1698510_availSubtitles;

    private String w1698510_dvdProducer;

    private String w1698510_dvdActors;

    public String getW1698510_availLanguages() {
        return w1698510_availLanguages;
    }

    public void setW1698510_availLanguages(String w1698510_availLanguages) {
        this.w1698510_availLanguages = w1698510_availLanguages;
    }

    public String getW1698510_availSubtitles() {
        return w1698510_availSubtitles;
    }

    public void setW1698510_availSubtitles(String w1698510_availSubtitles) {
        this.w1698510_availSubtitles = w1698510_availSubtitles;
    }

    public String getW1698510_dvdProducer() {
        return w1698510_dvdProducer;
    }

    public void setW1698510_dvdProducer(String w1698510_dvdProducer) {
        this.w1698510_dvdProducer = w1698510_dvdProducer;
    }

    public String getW1698510_dvdActors() {
        return w1698510_dvdActors;
    }

    public void setW1698510_dvdActors(String w1698510_dvdActors) {
        this.w1698510_dvdActors = w1698510_dvdActors;
    }
}
