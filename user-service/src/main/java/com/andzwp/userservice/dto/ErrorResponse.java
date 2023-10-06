package com.andzwp.userservice.dto;

import java.util.List;

public record ErrorResponse(String status, String message, List<String> errors) {


}
