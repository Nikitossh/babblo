package com.shesterikov.babblo.model;

import java.util.ArrayList;

public class Costs {
    private ArrayList<AbstractCost> costs;

    public ArrayList<AbstractCost> getCostsList() {
        costs = new ArrayList<>();
        // Calling method filling this list with required costs from DB
        return costs;
    }
}
