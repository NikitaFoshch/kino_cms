package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.Movie;
import lab.space.kino_cms.repository.MovieRepository;
import lab.space.kino_cms.service.MovieService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Movie getMovieById(Long movieId) {
        log.info("---------------Get Movie By ID " + movieId + "---------------");
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie Not Found By ID " + movieId));
    }

    @Override
    public List<Movie> getAllMovieByOrderById() {
        log.info("---------------Get All Movies---------------");
        return movieRepository.findAll(Sort.by(Sort.Direction.ASC, "createAt"));
    }

    @Override
    public List<Movie> getAllMovieOngoingByOrderById() {
        log.info("---------------Get All Ongoing Movies---------------");
        List<Movie> movieList = getAllMovieByOrderById();
        List<Movie> movies = new ArrayList<>();
        LocalDate localDate = LocalDate.now().plusWeeks(1);
        for (Movie movie : movieList) {

            if (movie.getRelease().isBefore(localDate)) {
                movies.add(movie);
            }
        }
        return movies;
    }

    @Override
    public List<Movie> getAllMovieComingSoonByOrderById() {
        log.info("---------------Get All Coming Soon Movies---------------");
        List<Movie> movieList = getAllMovieByOrderById();
        List<Movie> movies = new ArrayList<>();
        LocalDate localDate = LocalDate.now().plusDays(1);
        for (Movie movie : movieList) {
            if (movie.getRelease().isAfter(localDate)) {
                movies.add(movie);
            }
        }
        return movies;
    }


    @Override
    public void updateMovieById(Long movieId, Movie requestedMovie,
                                MultipartFile requestedMainImage, MultipartFile requestedGalleryImage1,
                                MultipartFile requestedGalleryImage2, MultipartFile requestedGalleryImage3,
                                MultipartFile requestedGalleryImage4, MultipartFile requestedGalleryImage5) {
        log.info("---------------Update Movie By ID " + movieId + "---------------");
        Movie movie = getMovieById(movieId);

        movie.setName(requestedMovie.getName());
        movie.setRelease(requestedMovie.getRelease());
        movie.setDescription(requestedMovie.getDescription());
        movie.setTrailerUrl(requestedMovie.getTrailerUrl());
        movie.setDisabled(requestedMovie.isDisabled());
        movie.setType3D(requestedMovie.isType3D());
        movie.setType2D(requestedMovie.isType2D());
        movie.setPlus12(requestedMovie.isPlus12());
        movie.setPlus16(requestedMovie.isPlus16());
        movie.setPlus18(requestedMovie.isPlus18());
        movie.setImax(requestedMovie.isImax());
        movie.setDbox(requestedMovie.isDbox());

        if (FileUtil.saveFile(requestedMainImage.getOriginalFilename(), requestedMainImage)) {
            FileUtil.deleteFile(movie.getMainImage());
            movie.setMainImage(requestedMainImage.getOriginalFilename());
        }


        if (FileUtil.saveFile(requestedGalleryImage1.getOriginalFilename(), requestedGalleryImage1)) {
            FileUtil.deleteFile(movie.getGalleryImage1());
            movie.setGalleryImage1(requestedGalleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage2.getOriginalFilename(), requestedGalleryImage2)) {
            FileUtil.deleteFile(movie.getGalleryImage2());
            movie.setGalleryImage2(requestedGalleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage3.getOriginalFilename(), requestedGalleryImage3)) {
            FileUtil.deleteFile(movie.getGalleryImage3());
            movie.setGalleryImage3(requestedGalleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage4.getOriginalFilename(), requestedGalleryImage4)) {
            FileUtil.deleteFile(movie.getGalleryImage4());
            movie.setGalleryImage4(requestedGalleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage5.getOriginalFilename(), requestedGalleryImage5)) {
            FileUtil.deleteFile(movie.getGalleryImage5());
            movie.setGalleryImage5(requestedGalleryImage5.getOriginalFilename());
        }

        movie.setSeo(requestedMovie.getSeo());

        movieRepository.save(movie);
        log.info("---------------Success Update Movie By ID " + movieId + "---------------");
    }

    @Override
    public void saveMovie(Movie movie, MultipartFile mainImage,
                          MultipartFile galleryImage1, MultipartFile galleryImage2,
                          MultipartFile galleryImage3, MultipartFile galleryImage4,
                          MultipartFile galleryImage5) {
        log.info("---------------Save Movie---------------");
        if (movie.getRelease()==null){
            movie.setRelease(LocalDate.now());
        }
        if (FileUtil.saveFile(mainImage.getOriginalFilename(), mainImage))
            movie.setMainImage(mainImage.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage1.getOriginalFilename(), galleryImage1))
            movie.setGalleryImage1(galleryImage1.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage2.getOriginalFilename(), galleryImage2))
            movie.setGalleryImage2(galleryImage2.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage3.getOriginalFilename(), galleryImage3))
            movie.setGalleryImage3(galleryImage3.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage4.getOriginalFilename(), galleryImage4))
            movie.setGalleryImage4(galleryImage4.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage5.getOriginalFilename(), galleryImage5))
            movie.setGalleryImage5(galleryImage5.getOriginalFilename());

        movieRepository.save(movie);
        log.info("---------------Success Save Movie---------------");
    }

    @Override
    public void deleteMovieById(Long movieId) {
        log.info("---------------Delete Movie By ID " + movieId + "---------------");
        Movie movie = getMovieById(movieId);
        if (movie.getMainImage() != null) {
            FileUtil.deleteFile(movie.getMainImage());
        }
        if (movie.getGalleryImage1() != null) {
            FileUtil.deleteFile(movie.getGalleryImage1());
        }
        if (movie.getGalleryImage2() != null) {
            FileUtil.deleteFile(movie.getGalleryImage2());
        }
        if (movie.getGalleryImage3() != null) {
            FileUtil.deleteFile(movie.getGalleryImage3());
        }
        if (movie.getGalleryImage4() != null) {
            FileUtil.deleteFile(movie.getGalleryImage4());
        }
        if (movie.getGalleryImage5() != null) {
            FileUtil.deleteFile(movie.getGalleryImage5());
        }

        movieRepository.deleteById(movieId);
        log.info("---------------Success Delete Movie By ID " + movieId + "---------------");
    }

}
