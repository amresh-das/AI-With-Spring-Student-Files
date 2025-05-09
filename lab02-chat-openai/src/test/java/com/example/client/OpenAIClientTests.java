package com.example.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

//  TDODO-08: Define this test class as a Spring Boot test.
//  Use the @ActiveProfiles annotation to activate the "openai" profile.

@SpringBootTest
@ActiveProfiles("openai")
public class OpenAIClientTests {

    //  TDODO-09: Use the @Autowired annotation to inject an instance of our AIClient.
    @Autowired private AIClient client;


    private String samplePrompt = "Generate the names of the five great lakes and their sizes in square miles.  Produce JSON output.";
    private String[] sampleResults = {"Huron", "Ontario", "Michigan", "Erie", "Superior"};

    //  TDODO-10: Define a @Test method to test the callApi() method of the client.
    //  Pass in a string that describes the response you wish to generate, 
    //  such as the "samplePrompt" String defined above or an equivalent.
    //  Use AssertJ's Assertions.assertThat() method to ensure that the content is not null.
    //  Use AssertJ's Assertions.assertThat() method to ensure that the content contains expected results.
    //  Print the response string that is returned.

    @Test
    void callApiTest() {

        String response =
                client.callApi(samplePrompt);

        assertThat(response).isNotNull();
        assertThat(response).contains(sampleResults);

        //	Print the results
        System.out.println("The results of the call are: " + response);
    }
    
    //  TDODO-11: Organize your imports and save your work.
    //  Run this test, it should pass.
    //  Check the results in the console.

}
