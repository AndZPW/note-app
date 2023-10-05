package com.andzwp.userservice.dto;

import lombok.Builder;

@Builder
public record Role(long id,String name) {
}
