package model;

import util.APIListUtil;

import java.util.ArrayList;
import java.util.List;

public class Specie implements Requestable {
    private String name;
    private String classification;
    private String designation;
    private String averageHeight;
    private String averageLifespan;
    private String hairColors;
    private String skinColors;
    private String eyeColors;
    private String homeworld;
    private String language;

    private String url;
    private String created;
    private String edited;

    private List<String> people;
    private List<String> films;

    private List<Character> characterList = new ArrayList<>();
    private List<Film> filmList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public String getHairColors() {
        return hairColors;
    }

    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public List<Film> getFilmList() {
        return APIListUtil.initFromUrls(filmList, films, Film.class);
    }

    public List<Character> getCharacterList() {
        return APIListUtil.initFromUrls(characterList, people, Character.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specie specie = (Specie) o;
        return name.equals(specie.name) &&
                classification.equals(specie.classification) &&
                designation.equals(specie.designation) &&
                averageHeight.equals(specie.averageHeight) &&
                averageLifespan.equals(specie.averageLifespan) &&
                hairColors.equals(specie.hairColors) &&
                skinColors.equals(specie.skinColors) &&
                eyeColors.equals(specie.eyeColors) &&
                homeworld.equals(specie.homeworld) &&
                language.equals(specie.language);
    }

    @Override
    public String toString() {
        return "Specie{" +
                "name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                ", designation='" + designation + '\'' +
                ", averageHeight='" + averageHeight + '\'' +
                ", averageLifespan='" + averageLifespan + '\'' +
                ", hairColors='" + hairColors + '\'' +
                ", skinColors='" + skinColors + '\'' +
                ", eyeColors='" + eyeColors + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", language='" + language + '\'' +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", people=" + people +
                ", films=" + films +
                ", characterList=" + characterList +
                ", filmList=" + filmList +
                '}';
    }
}
