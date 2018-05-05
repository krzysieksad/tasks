package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.card.AttachmentByType;
import com.crud.tasks.trello.card.Badge;
import com.crud.tasks.trello.card.CreatedTrelloCardDto;
import com.crud.tasks.trello.card.Trello;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {
    @InjectMocks
    private TrelloService trelloService;
    @Mock
    private TrelloClient trelloClient;
    @Mock
    private AdminConfig adminConfig;
    @Mock
    private SimpleEmailService simpleEmailService;

    private CreatedTrelloCardDto createdTrelloCardDto() {
        return new CreatedTrelloCardDto("id", "name", "shortUrl",
                new Badge("votes",
                        new AttachmentByType(
                                new Trello("board", "card"))));
    }

    @Test
    public void createNullTrelloCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(null);

        //when
        CreatedTrelloCardDto createdTrelloCardDto = trelloService.createTrelloCard(trelloCardDto);

        //then
        assertNull(createdTrelloCardDto);
    }

    @Test
    public void createNotNullTrelloCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");
        Mail mail = new Mail("to", "cc", "subject", "message");

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto());
        when(adminConfig.getAdminMail()).thenReturn("admin@kodilla.com");
        doNothing().when(simpleEmailService).send(mail);

        //when
        CreatedTrelloCardDto createdTrelloCardDto = trelloService.createTrelloCard(trelloCardDto);

        //then
        assertNotNull(createdTrelloCardDto);
    }
}