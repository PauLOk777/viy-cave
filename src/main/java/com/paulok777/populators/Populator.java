package com.paulok777.populators;

import java.security.SecureRandom;

import static com.paulok777.config.CaveConfig.HEIGHT;
import static com.paulok777.config.CaveConfig.WIDTH;
import static java.util.Objects.nonNull;

public abstract class Populator {

    abstract public void populate(String[][] cave);

    public void populateEntity(String[][] cave, String entity, int number) {
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < number; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);

            if (nonNull(cave[x][y])) {
                i--;
            } else {
                cave[x][y] = entity;
            }
        }
    }
}
