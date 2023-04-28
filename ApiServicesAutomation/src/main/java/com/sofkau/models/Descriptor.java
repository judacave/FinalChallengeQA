package com.sofkau.models;

public class Descriptor {

    private String knowledgeArea;
    private String description;
    private Double factual;
    private Double conceptual;
    private Double procedural;
    private Double metacognitive;
    private Double approvalLevel;

    public Descriptor() {
    }

    public String getKnowledgeArea() {
        return knowledgeArea;
    }

    public void setKnowledgeArea(String knowledgeArea) {
        this.knowledgeArea = knowledgeArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFactual() {
        return factual;
    }

    public void setFactual(Double factual) {
        this.factual = factual;
    }

    public Double getConceptual() {
        return conceptual;
    }

    public void setConceptual(Double conceptual) {
        this.conceptual = conceptual;
    }

    public Double getProcedural() {
        return procedural;
    }

    public void setProcedural(Double procedural) {
        this.procedural = procedural;
    }

    public Double getMetacognitive() {
        return metacognitive;
    }

    public void setMetacognitive(Double metacognitive) {
        this.metacognitive = metacognitive;
    }

    public Double getApprovalLevel() {
        return approvalLevel;
    }

    public void setApprovalLevel(Double approvalLevel) {
        this.approvalLevel = approvalLevel;
    }
}
