package com.sheryians.major.dto;

import com.sheryians.major.model.Category;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private int categoryId;
    private Category category;
    private double price;
    private double weight;
    private String description;
    private String imageName;
}
