package com.example

import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals

class DogRouteTest {
    @Test
    fun testGetAllDog() {
        withTestApplication({ module() }) {
            handleRequest(HttpMethod.Get,"/dogs").apply {
                assertEquals(
                    HttpStatusCode.NotFound,
                    response.status()
                )
            }
        }
    }
}