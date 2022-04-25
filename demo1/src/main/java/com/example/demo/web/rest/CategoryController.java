package com.example.demo.web.rest;

import com.example.demo.models.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public List<Category> listCategories(){
        return new ArrayList<>(EnumSet.allOf(Category.class));
    }

}
