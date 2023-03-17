package com.spring.hw.controllers;

import com.spring.hw.dao.Dao;
import com.spring.hw.dao.FlatDaoImpl;
import com.spring.hw.model.Flat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FlatFormController {

    @PostMapping("/result-page")
    public String resultPage(HttpServletRequest request, Model model) {
        Dao<Flat> dao = new FlatDaoImpl();
        String region = request.getParameter("region");
        int area = Integer.parseInt(request.getParameter("area"));
        int noRooms = Integer.parseInt(request.getParameter("no_rooms"));
        int price = Integer.parseInt(request.getParameter("price"));
        List<Flat> flatList = dao.flatList(region, area, noRooms, price);
        model.addAttribute("flatList", flatList);
        return "result";
    }
}