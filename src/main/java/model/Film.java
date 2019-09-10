package model;

import util.APIListUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Film implements Requestable {
    private String title;
    private int episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private Date releaseDate;

    private String url;
    private String created;
    private String edited;

    private List<String> species;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> characters;
    private List<String> planets;

    private List<Specie> specieList = new ArrayList<>();
    private List<Starship> starshipList= new ArrayList<>();
    private List<Vehicle> vehicleList= new ArrayList<>();
    private List<Character> characterList= new ArrayList<>();
    private List<Planet> planetList= new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<String> getPlanets() {
        return planets;
    }

    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

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

    public List<Specie> getSpecieList() {
        return APIListUtil.initFromUrls(specieList, species, Specie.class);
    }

    public List<Starship> getStarshipList() {
        return APIListUtil.initFromUrls(starshipList, starships, Starship.class);
    }

    public List<Vehicle> getVehicleList() {
        return APIListUtil.initFromUrls(vehicleList, vehicles, Vehicle.class);
    }

    public List<Character> getCharacterList() {
        return APIListUtil.initFromUrls(characterList, characters, Character.class);
    }

    public List<Planet> initFromUrls() {
        return APIListUtil.initFromUrls(planetList, planets, Planet.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return episodeId == film.episodeId &&
                title.equals(film.title) &&
                openingCrawl.equals(film.openingCrawl) &&
                director.equals(film.director) &&
                producer.equals(film.producer) &&
                releaseDate.equals(film.releaseDate);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", episodeId=" + episodeId +
                ", openingCrawl='" + openingCrawl + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", releaseDate=" + releaseDate +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", species=" + species +
                ", starships=" + starships +
                ", vehicles=" + vehicles +
                ", characters=" + characters +
                ", planets=" + planets +
                ", specieList=" + specieList +
                ", starshipList=" + starshipList +
                ", vehicleList=" + vehicleList +
                ", characterList=" + characterList +
                ", planetList=" + planetList +
                '}';
    }
}
