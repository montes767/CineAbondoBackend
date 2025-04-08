package Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;

@Service
public class TMDbService {

    // Aquí podemos configurar la URL base y la clave API
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public TMDbService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método para buscar una película por nombre
    public String realizarSolicitud(String endpoint, String queryParams) {

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + endpoint)
                .queryParam("api_key", apiKey)
                .queryParam("language", "es-ES")
                .queryParam(queryParams, "")
                .toUriString();


        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);


        return response.getBody();
    }
}