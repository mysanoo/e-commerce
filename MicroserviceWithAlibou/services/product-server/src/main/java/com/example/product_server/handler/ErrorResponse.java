package com.example.product_server.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
