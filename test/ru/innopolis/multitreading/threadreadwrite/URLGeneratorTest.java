package ru.innopolis.multitreading.threadreadwrite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLGeneratorTest {
    private static final int NUMBER_OF_URLS = 2;
    private static final String URL_TEMPLATE = "http:\\/\\/www.gutenberg.org\\/files\\/\\d+\\/\\d+.txt";

    /**
     * Test generated url correct and matches URL_TEMPLATE
     *
     * @throws Exception
     */

    @Test
    public void testGet() throws Exception {
        URLGenerator urlGenerator = new URLGenerator();
        String[] urlsArray = urlGenerator.getUrlMass(NUMBER_OF_URLS);

        for (String urlSrc : urlsArray) {
            assertTrue(urlSrc.matches(URL_TEMPLATE));
        }
    }
}