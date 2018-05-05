package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrelloValidatorTestSuite {

    private List<TrelloList> prepareListOfTrelloList() {
        return Arrays.asList(new TrelloList("0", "name0", true), new TrelloList("1", "name1", false));
    }

    @Test
    public void validateTrelloBoard() {
        //given
        TrelloValidator trelloValidator = new TrelloValidator();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("0", "test", prepareListOfTrelloList()));
        trelloBoards.add(new TrelloBoard("1", "test", prepareListOfTrelloList()));
        trelloBoards.add(new TrelloBoard("2", "testing", prepareListOfTrelloList()));
        trelloBoards.add(new TrelloBoard("3", "test", prepareListOfTrelloList()));
        trelloBoards.add(new TrelloBoard("4", "Tester board", prepareListOfTrelloList()));
        trelloBoards.add(new TrelloBoard("5", "My Board", prepareListOfTrelloList()));
        trelloBoards.add(new TrelloBoard("6", "for test", prepareListOfTrelloList()));

        //when
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoard(trelloBoards);

        //then
        assertEquals(4, filteredBoards.size());
    }
}