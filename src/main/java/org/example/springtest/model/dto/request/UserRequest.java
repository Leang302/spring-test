package org.example.springtest.model.dto.request;

import lombok.Builder;
@Builder
public record UserRequest(
        String name
) {

}
