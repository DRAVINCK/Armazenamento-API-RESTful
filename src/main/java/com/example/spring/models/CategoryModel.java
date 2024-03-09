package com.example.spring.models;


import jakarta.persistence.Table;


@Table(name = "CATEGORY")
public enum CategoryModel {
    INFORMATICA, ELETRODOMESTICOS, VESTUARIO, COZINHA
}
