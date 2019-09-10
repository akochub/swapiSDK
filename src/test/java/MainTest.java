import model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainTest {
    static Swapi api;

    @BeforeClass
    public static void init() {
        api = new Swapi();
    }

    @Test
    public void retrieveSingleFail() {
        Assert.assertNull(api.getCharacter(9654));
    }

    @Test
    public void retrieveAllFull() {
        List<Film> films = api.getFilms();
        List<Specie> species = api.getSpecies();
        List<model.Character> characters = api.getCharacters();
        List<Starship> starships = api.getStarships();
        List<Vehicle> vehicles = api.getVehicles();
        List<Planet> planets = api.getPlanets();

        Assert.assertEquals(7, films.size());
        Assert.assertEquals(37, species.size());
        Assert.assertEquals(87, characters.size());
        Assert.assertEquals(37, starships.size());
        Assert.assertEquals(39, vehicles.size());
        Assert.assertEquals(61, planets.size());
    }

    @Test
    public void retrieveAllFilter() {
        List<Film> films = api.getFilms();
        Assert.assertEquals(7, films.size());
        films.removeIf(film -> !film.getTitle().contains("Menace"));
        Assert.assertEquals(1, films.size());
        Assert.assertEquals(1, films.get(0).getEpisodeId());
    }

    @Test
    public void retrieveSingle() {
        Planet actual = api.getPlanet(3);
        Planet expected = new Planet();
        expected.setName("Yavin IV");
        expected.setRotationPeriod("24");
        expected.setOrbitalPeriod("4818");
        expected.setDiameter("10200");
        expected.setClimate("temperate, tropical");
        expected.setGravity("1 standard");
        expected.setTerrain("jungle, rainforests");
        expected.setSurfaceWater("8");
        expected.setPopulation("1000");
        expected.setResidents(new ArrayList<>());
        expected.setFilms(new ArrayList<>(Arrays.asList("https://swapi.co/api/films/1/")));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkLazyInit() {
        // During the first call the lazy initialization happens
        // which should take far more time than 2 consequtive calls after
        Planet planet = api.getPlanet(3);
        long start = System.currentTimeMillis();
        Assert.assertEquals(1, planet.getFilmList().size());
        long initDuration = System.currentTimeMillis() - start;
        start = System.currentTimeMillis();
        Assert.assertEquals("A New Hope", planet.getFilmList().get(0).getTitle());
        Assert.assertEquals(4, planet.getFilmList().get(0).getEpisodeId());
        Assert.assertTrue(initDuration > 2 * (System.currentTimeMillis() - start));
    }

    @Test
    public void retrieveWithFilter() {
        List<Predicate> filters = new ArrayList<>();
        filters.add(item -> ((Film) item).getEpisodeId() <= 5);
        filters.add(item -> ((Film) item).getTitle().contains("Menace"));
        List<Film> films = api.getFilms(filters);
        Assert.assertEquals(1, films.size());
        Assert.assertEquals("The Phantom Menace", films.get(0).getTitle());
    }
}
