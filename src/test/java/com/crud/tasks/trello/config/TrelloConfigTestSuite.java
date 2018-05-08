package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {
    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void testTrelloApiEndpoint() {
        //given
        //nothing

        //when
        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();

        //then
        assertEquals("https://api.trello.com/1", trelloApiEndpoint);
    }

    @Test
    public void testTrelloAppKey() {
        //given
        //nothing

        //when
        String trelloAppKey = trelloConfig.getTrelloAppKey();

        //then
        assertEquals("01c67adfabee0aa7e3dc57142adb4ed4", trelloAppKey);
    }

    @Test
    public void testTrelloToken() {
        //given
        //nothing

        //when
        String trelloToken = trelloConfig.getTrelloToken();

        //then
        assertEquals("9d5baabe6a141ff7bca87efcc837af667e7cbe9ccfc99de623a0855513fc7fdf", trelloToken);
    }

    @Test
    public void testTrelloUser() {
        //given
        //nothing

        //when
        String trelloUser = trelloConfig.getTrelloUser();

        //then
        assertEquals("testpurposeuser", trelloUser);
    }

}