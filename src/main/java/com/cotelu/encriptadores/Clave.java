package com.cotelu.encriptadores;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clave {

    protected String nombre;
    protected List<Pair<String,String>> hojaDeClave;

    public Clave(String nombre, List<Pair<String,String>> hojaDeClave) {
        this.nombre = nombre;
        this.hojaDeClave = hojaDeClave;
    }
}
