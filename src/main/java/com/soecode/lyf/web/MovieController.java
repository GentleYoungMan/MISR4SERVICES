package com.soecode.lyf.web;

import com.soecode.lyf.service.MovieService;
import com.soecode.lyf.utils.GlobalUtils;
import org.apache.ibatis.annotations.Param;
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

    private int pagesCache = 0;
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
    @RequestMapping(value = "/ShowMovies/{offset}/{size}/{isPagination}", method = RequestMethod.GET)
    public String getMoviesWithTabs(Model model, @PathVariable("offset") String offset, @PathVariable("size") String size, @PathVariable("isPagination") String isPagination) {
        if (isPagination.equals("default")) {
            pagesCache = 1;
        } else if (isPagination.equals("prev")) {
            pagesCache = pagesCache - 1;
        } else if (isPagination.equals("next")) {
            pagesCache = pagesCache + 1;
        }

        if (pagesCache < 0) {
            pagesCache = 1;
        }
        model.addAttribute("getMoviesWithTabs", movieService.getMoviesWithTabs(pagesCache, 10));
        model.addAttribute("code_msg", "查询成功");
        return "template/showAllMovies";
    }

}
