package com.cineabondo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {



        private final TMDbService tmDbConnectionService;

        @Autowired
        public MovieService(TMDbService tmDbConnectionService) {
            this.tmDbConnectionService = tmDbConnectionService;
        }

        // Método para obtener una lista de películas por nombre
        public String buscarPeliculasPorNombre(String nombrePelicula) {
            String queryParams = "query=" + nombrePelicula;
            // Usamos la clase TMDbConnectionService para hacer la solicitud
            return tmDbConnectionService.realizarSolicitud("/search/movie", queryParams);
        }
    }
