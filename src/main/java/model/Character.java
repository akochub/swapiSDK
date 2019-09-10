package model;

import util.APIListUtil;

import java.util.ArrayList;
import java.util.List;

public class Character implements Requestable {
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;

    private String url;
    private String created;
    private String edited;

    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;

    private List<Film> filmList = new ArrayList<>();
    private List<Specie> specieList = new ArrayList<>();
    private List<Vehicle> vehicleList = new ArrayList<>();
    private List<Starship> starshipList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
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

    public List<Specie> getSpecieList() {
        return APIListUtil.initFromUrls(specieList, species, Specie.class);
    }

    public List<Starship> getStarshipList() {
        return APIListUtil.initFromUrls(starshipList, starships, Starship.class);
    }

    public List<Vehicle> getVehicleList() {
        return APIListUtil.initFromUrls(vehicleList, vehicles, Vehicle.class);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return name.equals(character.name) &&
                height.equals(character.height) &&
                mass.equals(character.mass) &&
                hairColor.equals(character.hairColor) &&
                skinColor.equals(character.skinColor) &&
                eyeColor.equals(character.eyeColor) &&
                birthYear.equals(character.birthYear) &&
                gender.equals(character.gender) &&
                homeworld.equals(character.homeworld);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", skinColor='" + skinColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", films=" + films +
                ", species=" + species +
                ", vehicles=" + vehicles +
                ", starships=" + starships +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", filmList=" + filmList +
                ", specieList=" + specieList +
                ", vehicleList=" + vehicleList +
                ", starshipList=" + starshipList +
                '}';
    }
}
