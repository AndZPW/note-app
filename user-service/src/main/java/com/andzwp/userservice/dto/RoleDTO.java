package com.andzwp.userservice.dto;

import lombok.Builder;

@Builder
public record RoleDTO(int id, String name) {
}
