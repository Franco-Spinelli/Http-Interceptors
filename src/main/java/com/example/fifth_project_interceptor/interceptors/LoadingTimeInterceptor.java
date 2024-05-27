package com.example.fifth_project_interceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Random;

@Component("loadingtimeinterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);
        logger.info("LoadingTimeInterceptor: postHandle() coming out ...." + controller.getMethod().getName());
        long start = System.currentTimeMillis();
        request.setAttribute("start",start);
        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);


      /*  ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(Collections.singletonMap("error","You dont have access"));
        response.setContentType("application/json");
        response.setStatus(401);
        response.getWriter().write(jsonString);
        return false;*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;
        logger.info("time elapsed:" + result + "milliseconds");
        logger.info("LoadingTimeInterceptor: preHandle() entering ...." + ((HandlerMethod)handler).getMethod().getName());

    }
}
