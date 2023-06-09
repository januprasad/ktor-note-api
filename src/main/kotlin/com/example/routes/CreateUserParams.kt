package com.example.routes

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CreateUserParams(var name: String, var email: String, var password: String)