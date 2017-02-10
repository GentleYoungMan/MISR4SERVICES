package com.soecode.osc.dao;

import com.alibaba.fastjson.JSON;
import com.soecode.osc.BaseTest;
import com.soecode.osc.entity.Movie;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/22.
 */
public class MovieDaoTest extends BaseTest {
    @Autowired
    private MovieDao movieDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void TestAddMovieDao() {
        boolean isFlag = false;
        if (isFlag) {
            for (int i = 0; i < 100; i++) {
                Movie movie = new Movie();
                movie.setTitle("影片标题" + i);
                movie.setCategory("影片类别" + i);
                movie.setChildProtectionDisplayName("影片保护等级显示" + i);
                movie.setChildProtectionId("影片儿童保护id" + i);
                movie.setCountries("影片国家" + i);
                movie.setCreationDate("影片创建时间" + i);
                movie.setLongDescription("影片描述" + i);
                movie.setMainGenre("影片主要类别" + i);
                movie.setRuntime("影片时长" + i);
                movie.setYear("影片年份" + i);
                movie.setOriginalTitle("影片原标题" + i);
                movie.setChildProtectionLevel("影片儿童保护等级" + i);
                Integer status = movieDao.insertDao(movie);
                System.out.println(status);
            }
        }
    }

    @Test
    public void TestUpdateDao() {
        Movie movie = new Movie();
        movie.setTitle("影片标题" + 23);
        movie.setCategory("影片类别" + 23);
        movie.setChildProtectionDisplayName("影片保护等级显示" + 23);
        movie.setChildProtectionId("影片儿童保护id" + 23);
        movie.setCountries("影片国家" + 23);
        movie.setCreationDate("影片创建时间" + 23);
        movie.setLongDescription("影片描述" + 23);
        movie.setMainGenre("影片主要类别" + 23);
        movie.setRuntime("影片时长" + 23);
        movie.setYear("影片年份" + 23);
        movie.setOriginalTitle("影片原标题" + 23);
        movie.setChildProtectionLevel("影片儿童保护等级" + 23);
        movie.setMovieId(23);
        Integer status = movieDao.updateDao(movie);
        System.out.println(status);
    }

    @Test
    public void TestDelDao() {
        int movieId = 23;
        Integer status = movieDao.deleteDao(movieId);
        System.out.println(status);
    }

    @Test
    public void TestGetMovieById() {
        int movieId = 24;
        Movie movie = movieDao.getMovieById(movieId);
        logger.debug(JSON.toJSONString(movie));
    }

    @Test
    public void TestGetMoviesWithTabs() {
        int offset = 0, size = 5;
        List<Movie> movies = movieDao.getMoviesWithTabs(offset, size);
        logger.debug(JSON.toJSONString(movies));
    }

    @Test
    public void TestFuzzyMoviesByName() {
        String filmName = "标题";
        List<Movie> movies = movieDao.fuzzyMoviesByName(filmName);
        logger.debug(JSON.toJSONString("" + movies.size()));
    }

}