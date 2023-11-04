package com.andzwp.userservice.dto;

import lombok.Builder;

@Builder
public record UserDTO(long id, String email, String password, RoleDTO roleDTO) {
}
