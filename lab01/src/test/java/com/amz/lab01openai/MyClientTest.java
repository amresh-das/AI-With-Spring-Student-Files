package com.amz.lab01openai;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("openai")
class MyClientTest {

    @Autowired MyClient myClient;

    @Test
    public void testCall() {
        String response = myClient.call(
                "What are the names of the five great lakes.  Produce JSON output.");
        Assertions.assertThat(response).contains(
                "Superior", "Huron", "Erie", "Michigan", "Ontario");
        System.out.println("The response is: " + response);
    }
}