package com.sofkau.stepdefinitions;

import com.sofkau.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.sofkau.tasks.DoDelete.doDelete;
import static com.sofkau.utils.UrlResources.APPRENTICE_RADAR_BASE_URL;
import static com.sofkau.utils.UrlResources.RADAR_POST_URL;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class DeleteRadarStepDefinitions extends ApiSetUp {

    public static Logger LOGGER = Logger.getLogger(DeleteRadarStepDefinitions.class);

    @Given("that I am An Operation Leader")
    public void thatIAmAnOperationLeader() {
        setUp(APPRENTICE_RADAR_BASE_URL.getValue());
        LOGGER.info("Inicio de la automatizacion de Poke Api");
    }

    @When("I make the request to delete an existing radar with {string}")
    public void iMakeTheRequestToDeleteAnExistingRadarWith(String id) {
        try {
            actor.attemptsTo(
                    doDelete()
                            .withTheResource(RADAR_POST_URL.getValue()+"/"+id)
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }

    @Then("Should display a status message {int} depending on whether the id exists or not.")
    public void shouldDisplayAStatusMessageDependingOnWhetherTheIdExistsOrNot(Integer status) {
        try {
            actor.should(
                    seeThatResponse("El codigo de respuesta dado por la API es: " + HttpStatus.SC_OK,
                            response -> response.statusCode(status))
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }
}
