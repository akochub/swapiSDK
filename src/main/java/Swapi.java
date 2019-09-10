import com.google.gson.reflect.TypeToken;
import common.Endpoint;
import model.Character;
import model.*;
import util.GSONParser;
import util.RequestMaker;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public class Swapi {

    public List<Film> getFilms(List<Predicate> filters) {
        return (List<Film>) getBaseEndpoint(Endpoint.FILMS, new TypeToken<PagedResult<Film>>() {}.getType(), filters);
    }

    public List<Film> getFilms() {
        return (List<Film>) getBaseEndpoint(Endpoint.FILMS, new TypeToken<PagedResult<Film>>() {}.getType(), new ArrayList<>());
    }

    public List<Specie> getSpecies(List<Predicate> filters) {
        return (List<Specie>) getBaseEndpoint(Endpoint.SPECIES, new TypeToken<PagedResult<Specie>>() {}.getType(), filters);
    }

    public List<Specie> getSpecies() {
        return (List<Specie>) getBaseEndpoint(Endpoint.SPECIES, new TypeToken<PagedResult<Specie>>() {}.getType(), new ArrayList<>());
    }

    public List<model.Character> getCharacters(List<Predicate> filters) {
        return (List<Character>) getBaseEndpoint(Endpoint.CHARACTERS, new TypeToken<PagedResult<Character>>() {}.getType(), filters);
    }

    public List<model.Character> getCharacters() {
        return (List<Character>) getBaseEndpoint(Endpoint.CHARACTERS, new TypeToken<PagedResult<Character>>() {}.getType(), new ArrayList<>());
    }

    public List<Starship> getStarships(List<Predicate> filters) {
        return (List<Starship>) getBaseEndpoint(Endpoint.STARSHIPS, new TypeToken<PagedResult<Starship>>() {}.getType(), filters);
    }

    public List<Starship> getStarships() {
        return (List<Starship>) getBaseEndpoint(Endpoint.STARSHIPS, new TypeToken<PagedResult<Starship>>() {}.getType(), new ArrayList<>());
    }

    public List<Vehicle> getVehicles(List<Predicate> filters) {
        return (List<Vehicle>) getBaseEndpoint(Endpoint.VEHICLES, new TypeToken<PagedResult<Vehicle>>() {}.getType(), filters);
    }

    public List<Vehicle> getVehicles() {
        return (List<Vehicle>) getBaseEndpoint(Endpoint.VEHICLES, new TypeToken<PagedResult<Vehicle>>() {}.getType(), new ArrayList<>());
    }

    public List<Planet> getPlanets(List<Predicate> filters) {
        return (List<Planet>) getBaseEndpoint(Endpoint.PLANETS, new TypeToken<PagedResult<Planet>>() {}.getType(), filters);
    }

    public List<Planet> getPlanets() {
        return (List<Planet>) getBaseEndpoint(Endpoint.PLANETS, new TypeToken<PagedResult<Planet>>() {}.getType(), new ArrayList<>());
    }

    public Film getFilm(int id) {
        return (Film) getById(Endpoint.FILMS, id, new TypeToken<Film>() {}.getType());
    }

    public Specie getSpecie(int id) {
        return (Specie) getById(Endpoint.SPECIES, id, new TypeToken<Specie>() {}.getType());
    }

    public Character getCharacter(int id) {
        return (Character) getById(Endpoint.CHARACTERS, id, new TypeToken<Character>() {}.getType());
    }

    public Starship getStarship(int id) {
        return (Starship) getById(Endpoint.STARSHIPS, id, new TypeToken<Starship>() {}.getType());
    }

    public Vehicle getVehicle(int id) {
        return (Vehicle) getById(Endpoint.VEHICLES, id, new TypeToken<Vehicle>() {}.getType());
    }

    public Planet getPlanet(int id) {
        return (Planet) getById(Endpoint.PLANETS, id, new TypeToken<Planet>() {}.getType());
    }

    private List getBaseEndpoint(Endpoint endpoint, Type type, List<Predicate> filters) {
        List<Requestable> entries = new ArrayList<>();

        try {
            String json = RequestMaker.get(endpoint.getEndpoint());
            PagedResult page = GSONParser.getInstance().fromJson(json, type);
            while (page.getResults() != null) {
                entries.addAll(page.getResults());
                if (page.getNext() == null)
                    break;
                json = RequestMaker.get(page.getNext());
                page = GSONParser.getInstance().fromJson(json, type);
            }

            // Filter results
            for (Predicate filter : filters) {
                entries.removeIf(filter.negate());
            }
        } catch (IOException e) {
            System.out.println("API call to " + endpoint.getEndpoint() + " failed.\n"
                + "Reason: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        return entries;
    }

    private Requestable getById(Endpoint endpoint, int id, Type type) {
        try {
            String json = RequestMaker.get(endpoint.getEndpoint() + "/" + id + "/");
            return GSONParser.getInstance().fromJson(json, type);
        } catch (IOException e) {
            System.out.println("API call to " + endpoint.getEndpoint() + " failed.\n"
                    + "Reason: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
