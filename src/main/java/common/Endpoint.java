package common;

public enum Endpoint {
    FILMS("/films"),
    SPECIES("/species"),
    CHARACTERS("/people"),
    STARSHIPS("/starships"),
    VEHICLES("/vehicles"),
    PLANETS("/planets");

    private String endpoint;
    Endpoint(String endpoint){
        this.endpoint = Config.BASE_URL + endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
