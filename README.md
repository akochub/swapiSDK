## Simple Star Wars API SDK (https://swapi.co)

#### Includes access to all endpoints with additional support for filtering
To use just do something like:

```
    // All of the possible methods are defines in Swapi class
    // Those are just some of the examples 
    
    // View all 
    Swapi api = new Swapi();
    api.getFilms();
    
    // View specific item
    api.getFilm(1);
    
    // View child items 
    // For example, film contains info about characters
    api.getFilm(1).getCharacterList();
    
    // Depth of the query is not limited
    api.getFilm(1).getCharacterList().get(0).getPlanetList(); 
    
    // Filter results
    List<Predicate> filters = new ArrayList<>();
    filters.add(item -> ((Film) item).getEpisodeId() <= 5);
    filters.add(item -> ((Film) item).getTitle().contains("Menace"));
    api.getFilms(filters);
    
```
#### Questions & Answers

Assuming the Star Wars API was slow, what are some optimizations
that could be implemented to improve the user experience?

```
    After working a little bit with SW API I've noticed that requests tend
    to vary a lot in exectution time which is also random. So to improve
    user experience a good solution could be to memoize results of some
    requests since the API does not change. If changes are possible though,
    a cache with a set time to live could be created to support data updates. 
```

Any improvements you would make to your application?

```
    If the SDK performance was the issue, it is possible to manually do JSON parsing
    instead of relying on Gson, since we know schemas for all the data and it most
    likely won't change.  
```
