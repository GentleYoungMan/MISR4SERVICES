package com.soecode.osc.web;

import com.soecode.osc.entity.Movie;
import com.soecode.osc.service.MovieService;
import com.soecode.osc.utils.GlobalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //配置KEY
    public static final String QUERY_VIDEO_KEY = "73b842fbcb87e0b6dd0a485b06d41f19";

    //1.影视搜索
    @ResponseBody
    @RequestMapping(value = "/video", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String movieVideo(String q) {
        String url = "http://op.juhe.cn/onebox/movie/video";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", QUERY_VIDEO_KEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "json");//返回数据的格式,xml或json，默认json
        params.put("q", q);//影视搜索名称
        return GlobalUtils.resultThrowException(url, params, "GET");
    }


    //2.最近影讯
    @ResponseBody
    @RequestMapping(value = "/pmovie", method = RequestMethod.GET, produces = {"text/html;charset=UTF-8;", "application/json;"})
    public String movieProduce(String city) {
        String url = "http://op.juhe.cn/onebox/movie/pmovie";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key", QUERY_VIDEO_KEY);//应用APPKEY(应用详细页查询)
        params.put("dtype", "");//返回数据的格式,xml或json，默认json
        params.put("city", city);//城市名称
        return GlobalUtils.resultThrowException(url, params, "GET");
    }

    /**
     * 分页查询影片
     *
     * @param model
     * @return {String}
     */
    @RequestMapping(value = "/ShowMovies/{isPagination}", method = RequestMethod.GET)
    public String getMoviesWithTabs(Model model, @PathVariable("isPagination") String isPagination) {
        logger.debug("isPagination" + isPagination);
        model.addAttribute("currentPages", isPagination);
        if (Integer.parseInt(isPagination) < 1) {
            isPagination = "1";
        }
        model.addAttribute("getMoviesWithTabs", movieService.getMoviesWithTabs(Integer.parseInt(isPagination), 10));
        model.addAttribute("code_msg", "查询成功");
        return "template/movies/movieList";
    }

    @RequestMapping(value = "/insertMovie", method = RequestMethod.POST)
    public String insertMovie(Movie movie, Model model) {
        int i = movieService.insertMovie(movie);
        if (i == 1) {
            model.addAttribute("code_msg", movie.getTitle() + "添加成功");
        } else {
            model.addAttribute("code_msg", movie.getTitle() + "添加失败");
        }
        return "template/movies/showMovieDetail";
    }


    @RequestMapping(value = "/toMovieDetail", method = RequestMethod.GET)
    public String forwardMovieDetail(String movieId, Model model) {
        model.addAttribute("Movie", movieService.getMovieById(Integer.parseInt(movieId)));
        return "template/movies/editMovie";
    }

    @RequestMapping(value = "/editMovie", method = RequestMethod.POST)
    public String editMovie(Movie movie, Model model) {
        int i = movieService.updateMovie(movie);
        if (i == 1) {
            model.addAttribute("code_msg", movie.getTitle() + "修改成功");
        } else {
            model.addAttribute("code_msg", movie.getTitle() + "修改失败");
        }
        return "template/movies/showMovieDetail";
    }

    @RequestMapping(value = "/delMovie", method = RequestMethod.GET)
    public String delMovie(String movieId, Model model) {
        int i = movieService.deleteMovie(Integer.parseInt(movieId));
        if (i == 1) {
            model.addAttribute("code_msg", "删除成功");
        } else {
            model.addAttribute("code_msg", "删除失败");
        }
        return getMoviesWithTabs(model, "1");
    }


}