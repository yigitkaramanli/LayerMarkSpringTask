package com.lyrmrk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateBookRequest {
    @JsonProperty("Title")
    @NotBlank(message = "Book title is required.")
    private String title;

    @JsonProperty("Year")
    private Integer year;


}
