package com.cineabondo.Repositories;

import com.cineabondo.Models.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListRepository extends JpaRepository<MovieList, Long> {
}