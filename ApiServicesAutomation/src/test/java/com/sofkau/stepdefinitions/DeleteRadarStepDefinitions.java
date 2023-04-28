package com.sofkau.stepdefinitions;

import com.sofkau.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.sofkau.tasks.DoGet.doGet;
import static com.sofkau.utils.UrlResources.APPRENTICE_RADAR_BASE_URL;
import static com.sofkau.utils.UrlResources.RADAR_POST_URL;

public class DeleteRadarStepDefinitions extends ApiSetUp {

    public static Logger LOGGER = Logger.getLogger(DeleteRadarStepDefinitions.class);
    @Given("that I am An Operation Leader")
    public void thatIAmAnOperationLeader() {
        setUp(APPRENTICE_RADAR_BASE_URL.getValue());
        LOGGER.info("Inicio de la automatizacion de Poke Api");
    }

    @When("I make the request to delete an existing radar")
    public void iMakeTheRequestToDeleteAnExistingRadar() {
        try {
            actor.attemptsTo(
                    doDelete()
                            .withTheResource(RADAR_POST_URL.getValue())
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }

    @Then("the radar should no longer be present in the list of available radars")
    public void theRadarShouldNoLongerBePresentInTheListOfAvailableRadars() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("that i am an operation Leader")
    public void thaIAmAnOperationLeader() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I try to delete a radar with a non-existent id")
    public void iTryToDeleteARadarWithANonExistentId() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should receive a response with status code {int}")
    public void iShouldReceiveAResponseWithStatusCode(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
