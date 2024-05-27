package com.example.client;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("azure")
public class AzureClientTests {

    @Autowired AzureClient client;

	@Test
	void quickChat() {

        String response = 
            client.callModel(
                "Generate the names of the five great lakes.  Produce JSON output.");

		Assertions.assertThat(response).isNotNull();

		//	Print the results
		System.out.println("The results of the call are: " + response);
    }

}
