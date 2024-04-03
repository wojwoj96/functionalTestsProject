package org.wojciech.hooks;

import org.wojciech.helper.ApiHelper;
import org.wojciech.helper.Context;
import org.wojciech.helper.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

    @Slf4j
    @RequiredArgsConstructor
    public class Hooks {
        public static ScenarioContext scenarioContext;
        public static Scenario scenario;
        public static ApiHelper apiHelper;

        @Before
        public void before(Scenario scenario) {
            log.info("Before Scenario");
            this.scenario = scenario;
            this.scenarioContext = new ScenarioContext();
            this.apiHelper = new ApiHelper();

            this.scenarioContext.setVariable(Context.SCENARIO, scenario);
        }

        @After
        public void after() {
            log.info("After Scenario");
            if (scenario.isFailed()) {
                log.warn("Test Failed --> " + scenario.getName());
            }
            scenarioContext.clear();
        }
}
