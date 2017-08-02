package com.msir.service;

import org.springframework.stereotype.Service;

/**
 * Created by Fantasy on 2017/8/2.
 * 第三方接口
 */
@Service("ThirdPartApiService")
public interface ThirdPartApiService {

    Object getMTimeShowTime(int locationId);

    Object getMTimeMovieComingNew(int locationId);

    Object getMTimeMovieDetail(int locationId, String movieId);

    Object getMTimeMovieCreditsWithTypes(int movieId);

    Object getMTimeVideo(int pageIndex, int movieId);

    Object getMTimeImageAll(int movieId);



}
