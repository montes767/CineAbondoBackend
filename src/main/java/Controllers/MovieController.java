package Controllers;

import Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "http://localhost:4200")

public class MovieController {


    private final MovieService peliculaService;

    @Autowired
    public MovieController(MovieService peliculaService) {
        this.peliculaService = peliculaService;
    }

    // Endpoint para buscar películas por nombre
    @GetMapping("/buscar/{nombre}")
    public String buscarPeliculas(@PathVariable String nombre) {
        return peliculaService.buscarPeliculasPorNombre(nombre);
    }
}

