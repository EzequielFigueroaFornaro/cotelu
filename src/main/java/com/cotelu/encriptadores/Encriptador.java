package com.cotelu.encriptadores;

public interface Encriptador {
    public abstract String dameTuNombre(String texto);
    public abstract String encripta(String texto);
    public abstract String desEncripta(String texto);

}
