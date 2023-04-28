package com.sofkau.stepdefinitions;

import com.github.javafaker.Faker;
import com.sofkau.models.Descriptor;
import com.sofkau.models.Radar;
import com.sofkau.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

import static com.sofkau.questions.ReturnResponse.returnResponse;
import static com.sofkau.tasks.DoPost.doPost;
import static com.sofkau.utils.UrlResources.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class NewRadarStepDefinitions extends ApiSetUp {

    public static Logger LOGGER = Logger.getLogger(NewPhotoStepDefinition.class);
    private Response res;
    JSONObject resBody = null;
    JSONParser parser = new JSONParser();
    private Faker faker = new Faker();
    private Radar radar = new Radar();
    private Descriptor descriptor1 = new Descriptor();
    private Descriptor descriptor2 = new Descriptor();
    private List<Descriptor> descriptors = new ArrayList<>();
    @Given("that I am an Operation Leader")
    public void thatIAmAnOperationLeader() {
        try {
            LOGGER.info("Starting The New Radar Automation");
            setUp(APPRENTICE_RADAR_BASE_URL.getValue());
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }

    }
    @When("I create a new radar by providing a name and defining the evaluation criteria and level of appropriateness for each descriptor in the knowledge areas")
    public void iCreateANewRadarByProvidingANameAndDefiningTheEvaluationCriteriaAndLevelOfAppropriatenessForEachDescriptorInTheKnowledgeAreas() {
        radar.setRadarId("BorrarDespues");
        setDescriptorValues();
        LOGGER.warn(radar);
        try {
            actor.attemptsTo(
                    doPost()
                            .withTheResource(RADAR_POST_URL.getValue())
                            .andTheRequestBody(radar)
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }

    @Then("the new radar should be successfully created and added to the list of available radars.")
    public void theNewRadarShouldBeSuccessfullyCreatedAndAddedToTheListOfAvailableRadars() {
        try {
            actor.should(
                    seeThatResponse("El codigo de respuesta de JsonPlaceholder es: " + HttpStatus.SC_OK,
                            response -> response.statusCode(201))
            );
            Response actualResponse = returnResponse().answeredBy(actor);
            resBody = (JSONObject) parser.parse(actualResponse.getBody().asString());
            JSONObject descriptor_List = (JSONObject) resBody.get("descriptorList");
            actor.should(
                    seeThat("Retorna info",
                            act -> actualResponse, notNullValue()),
                    seeThat("name de la region",
                            descriptor_list ->descriptor_List.size(), equalTo(7))
            );
            LOGGER.warn("Todo bien hasta ahora");
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }


    public void setDescriptorValues(){
        descriptors.add(descriptor1);
        descriptors.add(descriptor2);
        for (Descriptor descriptor : descriptors) {
            descriptor.setKnowledgeArea(faker.book().genre());
            descriptor.setDescription(faker.book().title());
            descriptor.setFactual(faker.random().nextInt(50) / 10.0);
            descriptor.setConceptual(faker.random().nextInt(50) / 10.0);
            descriptor.setProcedural(faker.random().nextInt(50) / 10.0);
            descriptor.setMetacognitive(faker.random().nextInt(50) / 10.0);
            descriptor.setApprovalLevel(faker.random().nextInt(50) / 10.0);
        }
        radar.setDescriptorList(descriptors);
    }
}
