package org.wojciech.helper;

import io.restassured.response.Response;
import net.sf.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.wojciech.hooks.Hooks;
import static io.restassured.RestAssured.given;
import static org.wojciech.helper.Context.*;

public class ApiHelper {
    private void storeResponse(Response response) {
        response.then().log().everything();
        Hooks.scenarioContext.setVariable(RESPONSE, response);
        Hooks.scenarioContext.setVariable(RESPONSE_BODY, response.asString());
        Hooks.scenarioContext.setVariable(RESPONSE_STATUS, response.getStatusCode());
    }

    public void sendPutRequest(String url, JSONObject body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " + Hooks.scenarioContext.getScenarioVariables().get("TOKEN"));
        Response response = given()
                .log().all()
                .headers(headers)
                .body(body)
                .relaxedHTTPSValidation()
                .when()
                .put(url)
                .andReturn();

        storeResponse(response);
    }

    public void sendGetRequest(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " + Hooks.scenarioContext.getScenarioVariables().get("TOKEN"));
        Response response = given()
                .log().all()
                .headers(headers)
                .relaxedHTTPSValidation()
                .when()
                .get(url)
                .andReturn();

        storeResponse(response);
    }

    public Integer getReceivedStatusCode() {
        return Integer.parseInt(Hooks.scenarioContext.getScenarioVariables().get(RESPONSE_STATUS.toString()).toString());
    }

    public static Integer getStatusCode(String expectedStatusCode) {
        try {
            return HttpStatus.valueOf(expectedStatusCode).value();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
