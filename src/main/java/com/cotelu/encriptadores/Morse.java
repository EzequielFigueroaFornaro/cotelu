package com.cotelu.encriptadores;

import com.google.common.collect.Lists;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Morse extends Clave implements Encriptador {

    public Morse(String nombre, List<Pair<String,String>> hojaDeClave) {
        super("Morse", generaTuHoja());
    }

    @Override
    public String dameTuNombre(String texto) {
        return this.nombre;
    }

    @Override
    public String encripta(String texto) {
        String textroTraducido = "";
        List<String> listaDeTextoTraducido = Arrays.stream(texto.split("\\|"))
                .map(m ->{
                    if (m.equals(" ")){
                        return "|";
                    }
                    return generaTuHoja().stream()
                            .filter(c -> c.getKey().equals(m))
                            .map(Pair::getValue)
                            .findFirst()
                            .orElse(m);
                })
                .collect(Collectors.toList());
        for (String letra : listaDeTextoTraducido) {
            textroTraducido=textroTraducido+letra+"|";
        }
        return textroTraducido;
    }

    @Override
    public String desEncripta(String texto) {
        String textroTraducido = "";
        List<String> listaDeTextoTraducido = Arrays.stream(texto.split("\\|"))
                .map(m ->{
                    if (m.equals("")){
                        return " ";
                    }
                    return generaTuHoja().stream()
                            .filter(c -> c.getValue().equals(m))
                            .map(Pair::getKey)
                            .findFirst()
                            .orElse(m);
                })
                .collect(Collectors.toList());
        for (String letra : listaDeTextoTraducido) {
            textroTraducido=textroTraducido+letra;
        }
        return textroTraducido;
    }


    private static List<Pair<String,String>> generaTuHoja() {
        List<Pair<String,String>> hoja = Lists.newArrayList(
        new Pair<>("A","· —"),
        new Pair<>("N","— ·"),
        new Pair<>("0","— — — — —"),
        new Pair<>("B","— · · ·"),
        new Pair<>("Ñ","— — · — —"),
        new Pair<>("1","· — — — —"),
        new Pair<>("C","— · — ·"),
        new Pair<>("O","— — —"),
        new Pair<>("2","· · — — —"),
        new Pair<>("CH","— — — —"),
        new Pair<>("P","· — — ·"),
        new Pair<>("3","· · · — —"),
        new Pair<>("D","— · ·"),
        new Pair<>("Q","— — · —"),
        new Pair<>("4","· · · · —"),
        new Pair<>("E","·"),
        new Pair<>("R","· — ·"),
        new Pair<>("5","· · · · ·"),
        new Pair<>("F","· · — ·"),
        new Pair<>("S","· · ·"),
        new Pair<>("6","— · · · ·"),
        new Pair<>("G","— — ·"),
        new Pair<>("T","—"),
        new Pair<>("7","— — · · ·"),
        new Pair<>("H","· · · ·"),
        new Pair<>("U","· · —"),
        new Pair<>("8","— — — · ·"),
        new Pair<>("I","· ·"),
        new Pair<>("V","· · · —"),
        new Pair<>("9","— — — — ·"),
        new Pair<>("J","· — — —"),
        new Pair<>("W","· — —"),
        new Pair<>(".","· — · — · —"),
        new Pair<>("K","— · —"),
        new Pair<>("X","— · · —"),
        new Pair<>(",","— · — · — —"),
        new Pair<>("L","· — · ·"),
        new Pair<>("Y","— · — —"),
        new Pair<>("?","· · — — · ·"),
        new Pair<>("M","— —"),
        new Pair<>("Z","— — · ·"),
        new Pair<>("!","— — · · — —"));

        return hoja;
    }


























}
