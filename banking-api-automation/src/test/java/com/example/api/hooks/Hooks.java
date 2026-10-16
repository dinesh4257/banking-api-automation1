package com.example.api.hooks;

import com.example.api.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private final TestContext context;
    private static Scenario scenario;

    public Hooks(TestContext context) { this.context = context; }

    @Before public void beforeScenario() { context.reset(); }

    @Before
    public void beforeScenario(Scenario scenario) {
        Hooks.scenario = scenario;
    }

    public static void log(String message) {
        scenario.log(message);
    }


    @After public void afterScenario(Scenario scenario) {
        if (scenario.isFailed() && context.getResponse() != null) {
            scenario.attach(context.getResponse().asPrettyString(), "application/json", "Last API response");
        }
    }
}
