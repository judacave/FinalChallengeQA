package com.sofkau.stepdefinitions;

import com.sofkau.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofkau.tasks.DoGet.doGet;
import static com.sofkau.utils.UrlResources.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ListRadarStepDefinitions extends ApiSetUp {

    public static Logger LOGGER = Logger.getLogger(ListRadarStepDefinitions.class);
    @Given("I am an Operation leader")
    public void iAmAnOperationLeader() {
        setUp(APPRENTICE_RADAR_BASE_URL.getValue());
        LOGGER.info("Inicio de la automatizacion de Poke Api");
    }

    @When("I request the list of available radars")
    public void iRequestTheListOfAvailableRadars() {
        try {
            actor.attemptsTo(
                    doGet()
                            .withTheResource(RADAR_POST_URL.getValue())
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }

    @Then("the system should return a list of radars.")
    public void theSystemShouldReturnAListOfRadars() {
        try {
            actor.should(
                    seeThatResponse("El codigo de respuesta dado por la API es: " + HttpStatus.SC_OK,
                            response -> response.statusCode(200))

            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
}
