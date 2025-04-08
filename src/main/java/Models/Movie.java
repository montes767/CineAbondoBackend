package Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    private Long id; // Usamos el ID de TMDb como clave primaria

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String overview; // Descripción de la película

    private String posterPath; // URL del póster

    private Double rating; // Valoración de TMDb

    private String releaseDate; // Fecha de estreno

    @ManyToMany(mappedBy = "movies")
    private List<MovieList> lists; // Listas en las que está incluida
}