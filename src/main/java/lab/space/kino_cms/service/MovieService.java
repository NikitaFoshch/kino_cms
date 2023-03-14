package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {
    Movie getMovieById(Long movieId);
    List<Movie> getEightMovieByOrderById();
    List<Movie> getFourMovieByOrderById();
    void updateMovieById(Long movieId, Movie requestedMovie,
                              MultipartFile requestedMainImage, MultipartFile requestedGalleryImage1,
                              MultipartFile requestedGalleryImage2, MultipartFile requestedGalleryImage3,
                              MultipartFile requestedGalleryImage4, MultipartFile requestedGalleryImage5);
    void saveMovie(Movie movie, MultipartFile mainImage,
                        MultipartFile galleryImage1, MultipartFile galleryImage2,
                        MultipartFile galleryImage3, MultipartFile galleryImage4,
                        MultipartFile galleryImage5);
    void deleteMovieById(Long movieId);
}
