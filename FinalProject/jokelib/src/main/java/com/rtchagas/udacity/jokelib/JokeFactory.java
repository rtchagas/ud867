package com.rtchagas.udacity.jokelib;

import java.util.Random;

public class JokeFactory {

    private static final Random RANDOM = new Random();

    /**
     * Returns a random (may be not so funny) joke.
     * @return A joke.
     */
    public static String getJoke() {

        int dbLength = JokesDatabase.JOKES_DB.length;
        int rndIdx = RANDOM.nextInt(dbLength);

        return JokesDatabase.JOKES_DB[rndIdx];
    }
}
