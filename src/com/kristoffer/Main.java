package com.kristoffer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Test case
        ArrayList<Field> fields = new ArrayList<>();
        fields.add(new Field("Mjømna", "Furenes", 5));
        fields.add(new Field("Furenes", "Eivindvik", 7));
        fields.add(new Field("Eivindvik", "Oppedal", 12));
        fields.add(new Field("Eivindvik", "Rutledal", 15));
        fields.add(new Field("Rutledal", "Oppedal", 10));
        fields.add(new Field("Rutledal", "Daløy", 17));
        fields.add(new Field("Rutledal", "Sløvåg", 10));
        fields.add(new Field("Sløvåg", "Daløy", 9));
        fields.add(new Field("Daløy", "Nåra", 11));
        fields.add(new Field("Rutledal", "Ynnesdal", 20));
        fields.add(new Field("Ynnesdal", "Leirvik", 16));
        fields.add(new Field("Leirvik", "Nåra", 30));
    }
}
