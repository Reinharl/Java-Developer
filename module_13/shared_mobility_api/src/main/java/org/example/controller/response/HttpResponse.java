package org.example.controller.response;

import com.google.gson.JsonElement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpResponse {

    private String statusResponse;
    private JsonElement data;

    public HttpResponse(String statusResponse, JsonElement data) {
        this.statusResponse = statusResponse;
        this.data = data;
    }
}
