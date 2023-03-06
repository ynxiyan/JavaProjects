package com.controller;

import com.alibaba.fastjson.JSON;
import com.model.City;
import com.model.Province;
import com.service.ProvinceAndCityService;
import com.service.impl.ProvinceAndCityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 9:45
 * @注释:省份和城市请求的处理接口
 */
@WebServlet(urlPatterns = "/province_city/*")
public class ProvinceAndCityServlet extends BasicServlet {
    private final ProvinceAndCityService provinceAndCityService = new ProvinceAndCityServiceImpl();

    //获取省份列表
    public void getProvince(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取省份列表
        List<Province> provinceList = provinceAndCityService.getProvince();
        //将Java对象转为json字符串
        String jsonString = JSON.toJSONString(provinceList);
        //将数据响应给前端axios
        response.getWriter().write(jsonString);
    }

    //获取城市列表
    public void getCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取省份列表
        int province_id = Integer.parseInt(request.getParameter("province"));
        Province newProvince = new Province();
        newProvince.setId(province_id);
        List<City> cityList = provinceAndCityService.getCity(newProvince);
        //将Java对象转为json字符串
        String jsonString = JSON.toJSONString(cityList);
        //将数据响应给前端axios
        response.getWriter().write(jsonString);
    }
}
