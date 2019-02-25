package com.shesterikoff.babblo.model;

import java.util.ArrayList;

public class Costs {
    private ArrayList<Cost> costs;

    public ArrayList<Cost> getCostsList() {
        costs = new ArrayList<>();
        // Calling method filling this list with required costs from DB
        return costs;
    }
}
