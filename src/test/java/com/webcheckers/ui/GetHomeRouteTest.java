package com.webcheckers.ui;

import com.webcheckers.application.GameCenter;
import com.webcheckers.application.PlayerLobby;
import com.webcheckers.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spark.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class GetHomeRouteTest {
    private GetHomeRoute CuT;

    // friendly objects
    private GameCenter gameCenter;

    // mock objects
    private Request request;
    private Session session;
    private TemplateEngine engine;
    private Response response;

    private PlayerLobby PL;

    /**
     * Setup new mock objects for each test.
     */
    @BeforeEach
    public void setup() {
        request = mock(Request.class);
        session = mock(Session.class);
        when(request.session()).thenReturn(session);
        response = mock(Response.class);
        engine = mock(TemplateEngine.class);

        // create a unique CuT for each test
        // the GameCenter is friendly but the engine mock will need configuration
        gameCenter = new GameCenter();
        PL = new PlayerLobby(gameCenter);
        CuT = new GetHomeRoute(engine, PL, gameCenter);
    }

    /**
     * Test that CuT shows the Home view when the session is brand new.
     */
    @Test
    public void new_GetHomeRouteTest() {
        // To analyze what the Route created in the View-Model map you need
        // to be able to extract the argument to the TemplateEngine.render method.
        // Mock up the 'render' method by supplying a Mockito 'Answer' object
        // that captures the ModelAndView data passed to the template engine
        final TemplateEngineTester testHelper = new TemplateEngineTester();
        when(engine.render(any(ModelAndView.class))).thenAnswer(testHelper.makeAnswer());

        // Invoke the test
        CuT.handle(request, response);

        // Analyze the results:
        //   * model is a non-null Map
        testHelper.assertViewModelExists();
        testHelper.assertViewModelIsaMap();
        testHelper.assertViewModelAttribute(GetHomeRoute.MSG_ATTR, GetHomeRoute.WELCOME_MSG);
        //   * model contains all necessary View-Model data
        //   * test view name
        testHelper.assertViewName(GetHomeRoute.VIEW_NAME);
    }
}