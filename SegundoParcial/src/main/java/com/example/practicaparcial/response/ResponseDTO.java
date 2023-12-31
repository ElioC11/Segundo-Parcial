package com.example.practicaparcial.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO {
    @JsonProperty("response")
    private String response;

    @JsonProperty("orden")
    private OrdenResponse orden;

    public OrdenResponse getOrden() {
        return orden;
    }

    public void setOrden(OrdenResponse orden) {
        this.orden = orden;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }


}
