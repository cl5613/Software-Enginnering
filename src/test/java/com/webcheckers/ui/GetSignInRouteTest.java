package com.webcheckers.ui;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

@Tag("UI-tier")
public class GetSignInRouteTest {

  private GetSignInRoute CuT;

  // mock objects
  private Request request;
  private TemplateEngine engine;
  private Response response;

  /**
   * Setup new mock objects for each test.
   */
  @BeforeEach
  public void setup() {
    request = mock(Request.class);
    response = mock(Response.class);
    engine = mock(TemplateEngine.class);

    // create a unique CuT for each test
    // the GameCenter is friendly but the engine mock will need configuration
    CuT = new GetSignInRoute(engine);
  }

  @Test
  public void newSignInTest() {

    // Invoke the test
    CuT.handle(request, response);

    final TemplateEngineTester testHelper = new TemplateEngineTester();
    when(engine.render(any(ModelAndView.class))).thenAnswer(testHelper.makeAnswer());

    // Invoke the test (ignore the output)
    CuT.handle(request, response);

    // Analyze the content passed into the render method
    //   * model is a non-null Map
    testHelper.assertViewModelExists();
    testHelper.assertViewModelIsaMap();
    //   * model contains all necessary View-Model data
    testHelper.assertViewModelAttribute(GetSignInRoute.MSG_ATTR, GetSignInRoute.SIGNIN_MSG);
    //   * test view name
    testHelper.assertViewName(WebServer.SIGNIN_URL);
  }
}