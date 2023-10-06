package com.andzwp.userservice.dto;

import lombok.Builder;

@Builder
public record User(long id, String email, String password, Role role) {
}
