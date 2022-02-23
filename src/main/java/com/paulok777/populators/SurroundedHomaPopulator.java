package com.paulok777.populators;

import java.security.SecureRandom;

import static com.paulok777.config.CaveConfig.*;

public class SurroundedHomaPopulator extends Populator {

    @Override
    public void populate(String[][] cave) {
        SecureRandom random = new SecureRandom();
        cave[HOMA_X_COORDINATE][HOMA_Y_COORDINATE] = HOMA_BRUT;

        if (random.nextBoolean()) {
            cave[HOMA_X_COORDINATE][HOMA_Y_COORDINATE + 1] = VIY;
            cave[HOMA_X_COORDINATE + 1][HOMA_Y_COORDINATE] = MISS;
        } else {
            cave[HOMA_X_COORDINATE + 1][HOMA_Y_COORDINATE] = VIY;
            cave[HOMA_X_COORDINATE][HOMA_Y_COORDINATE + 1] = MISS;
        }

        populateEntity(cave, TREASURE, TREASURE_NUMBER);
        populateEntity(cave, MISS, MISS_NUMBER - 1);
    }
}
