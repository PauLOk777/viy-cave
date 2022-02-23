package com.paulok777.generators;

import com.paulok777.populators.Populator;

import static com.paulok777.config.CaveConfig.HEIGHT;
import static com.paulok777.config.CaveConfig.WIDTH;

public class CaveGenerator {

    private Populator populator;

    public CaveGenerator(Populator populator) {
        this.populator = populator;
    }

    public String[][] generateWinlessCave() {
        String[][] cave = new String[WIDTH][HEIGHT];
        populator.populate(cave);
        return cave;
    }
}
