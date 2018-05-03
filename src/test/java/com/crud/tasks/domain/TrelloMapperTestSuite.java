package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    private TrelloBoardDto createTrelloBoardDto(final int id) {
        return new TrelloBoardDto("id" + id, "name" + id, Arrays.asList(createTrelloListDto(0, true)));
    }

    private TrelloBoard createTrelloBoard(final int id) {
        return new TrelloBoard("id" + id, "name" + id, Arrays.asList(createTrelloList(0, true)));
    }

    private TrelloListDto createTrelloListDto(final int id, final boolean isClosed) {
        return new TrelloListDto("id" + id, "name" + id, isClosed);
    }

    private TrelloList createTrelloList(final int id, final boolean isClosed) {
        return new TrelloList("id" + id, "name" + id, isClosed);
    }

    private TrelloCardDto createTrelloCardDto(final int id) {
        return new TrelloCardDto("name" + id, "description" + id, "pos" + id, "listId" + id);
    }

    private TrelloCard createTrelloCard(final int id) {
        return new TrelloCard("name" + id, "description" + id, "pos" + id, "listId" + id);
    }

    @Test
    public void testMapToBoards() {
        //given
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(createTrelloBoardDto(0));

        //when
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        List<TrelloBoard> expected = new ArrayList<>();
        expected.add(createTrelloBoard(0));

        //then
        assertEquals(expected.get(0).getId(), trelloBoards.get(0).getId());
        assertEquals(expected.get(0).getName(), trelloBoards.get(0).getName());
        assertEquals(expected.get(0).getLists().get(0).getId(), trelloBoards.get(0).getLists().get(0).getId());
        assertEquals(expected.get(0).getLists().get(0).getName(), trelloBoards.get(0).getLists().get(0).getName());
        assertEquals(expected.get(0).getLists().get(0).isClosed(), trelloBoards.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToBoardsDto() {
        //given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(createTrelloBoard(0));

        //when
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        List<TrelloBoardDto> expected = new ArrayList<>();
        expected.add(createTrelloBoardDto(0));

        //then
        assertEquals(expected.get(0).getId(), trelloBoardsDto.get(0).getId());
        assertEquals(expected.get(0).getName(), trelloBoardsDto.get(0).getName());
        assertEquals(expected.get(0).getLists().get(0).getId(), trelloBoardsDto.get(0).getLists().get(0).getId());
        assertEquals(expected.get(0).getLists().get(0).getName(), trelloBoardsDto.get(0).getLists().get(0).getName());
        assertEquals(expected.get(0).getLists().get(0).isClosed(), trelloBoardsDto.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToList() {
        //given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(createTrelloListDto(0, true));
        trelloListDtos.add(createTrelloListDto(1, false));

        //when
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        List<TrelloList> expected = new ArrayList<>();
        expected.add(createTrelloList(0, true));
        expected.add(createTrelloList(1, false));

        //then
        assertEquals(expected.get(0).getId(), trelloLists.get(0).getId());
        assertEquals(expected.get(0).getName(), trelloLists.get(0).getName());
        assertEquals(expected.get(0).isClosed(), trelloLists.get(0).isClosed());
        assertEquals(expected.get(1).getId(), trelloLists.get(1).getId());
        assertEquals(expected.get(1).getName(), trelloLists.get(1).getName());
        assertEquals(expected.get(1).isClosed(), trelloLists.get(1).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(createTrelloList(0, true));
        trelloLists.add(createTrelloList(1, false));

        //when
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        List<TrelloListDto> expected = new ArrayList<>();
        expected.add(createTrelloListDto(0, true));
        expected.add(createTrelloListDto(1, false));

        //then
        assertEquals(expected.get(0).getId(), trelloListDtos.get(0).getId());
        assertEquals(expected.get(0).getName(), trelloListDtos.get(0).getName());
        assertEquals(expected.get(0).isClosed(), trelloListDtos.get(0).isClosed());
        assertEquals(expected.get(1).getId(), trelloListDtos.get(1).getId());
        assertEquals(expected.get(1).getName(), trelloListDtos.get(1).getName());
        assertEquals(expected.get(1).isClosed(), trelloListDtos.get(1).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //given
        TrelloCard trelloCard = createTrelloCard(0);

        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        TrelloCardDto expected = createTrelloCardDto(0);

        //then
        assertEquals(expected.getName(), trelloCardDto.getName());
        assertEquals(expected.getDescription(), trelloCardDto.getDescription());
        assertEquals(expected.getPos(), trelloCardDto.getPos());
        assertEquals(expected.getListId(), trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //given
        TrelloCardDto trelloCardDto = createTrelloCardDto(1);

        //when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        TrelloCard expected = createTrelloCard(1);

        //then
        assertEquals(expected.getName(), trelloCard.getName());
        assertEquals(expected.getDescription(), trelloCard.getDescription());
        assertEquals(expected.getPos(), trelloCard.getPos());
        assertEquals(expected.getListId(), trelloCard.getListId());
    }
}