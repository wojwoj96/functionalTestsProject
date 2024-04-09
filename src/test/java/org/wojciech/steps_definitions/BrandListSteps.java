package org.wojciech.steps_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.wojciech.config.ServiceName;
import org.wojciech.hooks.Hooks;

import static org.junit.Assert.assertEquals;
import static org.wojciech.helper.ApiHelper.getStatusCode;

public class BrandListSteps {

    @Given("Get all products from store")
    public void acquiredAccessToken() {
        Hooks.apiHelper.sendGetRequest(ServiceName.GET_ALL_PRODUCT);
        Response response = (Response) Hooks.scenarioContext.getScenarioVariables().get("RESPONSE");
        //Hooks.scenarioContext.setVariable(TOKEN, response.path("access_token").toString());
    }

    @Then("Response with 200 is returned")
    public void aResponseWithIsReturned() {
        assertEquals(getStatusCode("OK"), Hooks.apiHelper.getReceivedStatusCode());
    }


}
