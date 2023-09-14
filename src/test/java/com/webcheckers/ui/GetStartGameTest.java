package com.webcheckers.ui;

import com.google.gson.Gson;
import com.webcheckers.application.GameCenter;
import com.webcheckers.application.PlayerLobby;
import com.webcheckers.model.Message;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.webcheckers.ui.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.TemplateEngine;

public class GetStartGameTest {
    
    private GetStartGameRoute route;
    private Request request;
    private Session session;
    private TemplateEngine TemplateEngine;
    private Response response;
    private GameCenter GameCenter;
    private Gson Gson;
    private PlayerLobby PlayerLobby;
    
    @BeforeEach
    public void setup(){
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);
        TemplateEngine = mock(TemplateEngine.class);
        PlayerLobby = mock(PlayerLobby.class);
        GameCenter = mock(GameCenter.class) ;
        route = new GetStartGameRoute(TemplateEngine, PlayerLobby, GameCenter);
    }
    @Test
    public void newGetStartGameTest(){
        route.handle(request, response);
        final TemplateEngineTester tester = new TemplateEngineTester();
        when(TemplateEngine.render(any(ModelAndView.class))).thenAnswer(tester.makeAnswer());
        route.handle(request, response);
        tester.assertViewModelExists();
        tester.assertViewModelIsaMap();
        tester.assertViewModelAttribute(GetSignInRoute.MSG_ATTR, GetStartGameRoute.GAME_START_MSG);
        tester.assertViewName("game.ftl");
    }
    
}
