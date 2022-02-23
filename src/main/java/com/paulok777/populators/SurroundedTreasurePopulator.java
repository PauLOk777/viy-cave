package com.paulok777.populators;

import java.security.SecureRandom;

import static com.paulok777.config.CaveConfig.*;

public class SurroundedTreasurePopulator extends Populator {

    @Override
    public void populate(String[][] cave) {
        SecureRandom random = new SecureRandom();
        cave[HOMA_X_COORDINATE][HOMA_Y_COORDINATE] = HOMA_BRUT;

        int treasureXCoordinate = random.nextBoolean() ? 0 : WIDTH - 1;
        int treasureYCoordinate = treasureXCoordinate == 0 || random.nextBoolean() ? HEIGHT - 1 : 0;
        cave[treasureXCoordinate][treasureYCoordinate] = TREASURE;

        int shiftXCoordinate = -1;
        int shiftYCoordinate = -1;

        if (treasureXCoordinate == 0) {
            shiftXCoordinate = 1;
        } else if (treasureYCoordinate == 0) {
            shiftYCoordinate = 1;
        }

        if (random.nextBoolean()) {
            cave[treasureXCoordinate][treasureYCoordinate + shiftYCoordinate] = VIY;
            cave[treasureXCoordinate + shiftXCoordinate][treasureYCoordinate] = MISS;
        } else {
            cave[treasureXCoordinate + shiftXCoordinate][treasureYCoordinate] = VIY;
            cave[treasureXCoordinate][treasureYCoordinate + shiftYCoordinate] = MISS;
        }

        populateEntity(cave, TREASURE, TREASURE_NUMBER - 1);
        populateEntity(cave, MISS, MISS_NUMBER - 1);
    }
}
