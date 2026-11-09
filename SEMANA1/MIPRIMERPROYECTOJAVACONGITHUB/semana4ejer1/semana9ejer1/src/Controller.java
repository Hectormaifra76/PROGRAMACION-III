package com.gestorlibros.controller;

import java.util.ArrayList;

import com.gestorlibros.model.GestorLibrosModel;
import com.gestorlibros.model.Libro;
import com.gestorlibros.view.View;

public class Controller {

    private GestorLibrosModel m;
    private View v;

    public Controller(GestorLibrosModel m, View v) {

        this.m = m;
        this.v = v;

        v.setC(this);
    }

    public void initApp() {

        int cargados = m.loadStateOfTheApp();

        if (cargados == -2) {
            v.showInfoMessage(
                    "No se ha encontrado libros.bin en el escritorio. Se inicia una colección vacía.");
        } else if (cargados < 0) {
            v.showErrorMessage(
                    "No se pudo cargar libros.bin. Se inicia una colección vacía.");
        } else {
            v.showInfoMessage(
                    "Se han cargado " + cargados + " libros desde libros.bin.");
        }

        v.startMenu();

        int guardados = m.saveStateOfTheApp();

        if (guardados < 0) {
            v.showErrorMessage(
                    "No se pudo guardar libros.bin en el escritorio.");
        } else {
            v.showInfoMessage(
                    "Estado guardado: " + guardados + " libros.");
        }
    }

    public ArrayList<Libro> getLibros() {
        return m.getLibros();
    }

    public void addLibro(Libro l) {
        m.addLibro(l);
    }

    public void removeLibro(Libro l) {
        m.removeLibro(l);
    }

    public void updateLibro(Libro l) {
        m.updateLibro(l);
    }

    public int exportBooksToCSV() {
        return m.exportBooksToCSV();
    }

    public int exportBooksToJSON() {
        return m.exportBooksToJSON();
    }

    public int importBooksFromJSON() {
        return m.importBooksFromJSON();
    }

    public int importBooksFromCSV() {
        return m.importBooksFromCSV();
    }

    public int importBooksFromXML() {
        return m.importBooksFromXML();
    }

    public int exportBooksToXML() {
        return m.exportBooksToXML();
    }
}