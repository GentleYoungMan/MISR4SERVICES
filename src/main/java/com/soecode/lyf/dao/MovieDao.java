package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/22.
 */
public interface MovieDao extends SuperBasicDao<Movie> {
    List<Movie> queryDao();

    int insertDao(Movie movie);

    int deleteDao(@Param("moviesId") int moviesId);

    int updateDao(Movie movie);

    List<Movie> queryMovieById();

    List<Movie> getMoviesWithTabs(@Param("offset") Integer offset, @Param("size") Integer size);

    List<Movie> fuzzyMoviesByNane(@Param("movieTitles") String movieTitles);

}
