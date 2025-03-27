package com.example.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.client.Utilities.saveBase64Image;
import static com.example.client.Utilities.testValidBase64Image;
import static org.assertj.core.api.Assertions.assertThat;


//  TDODO-09: Define this test class as a Spring Boot test.

@SpringBootTest
public class OpenAIClientTests {

    //  TDODO-10: Use the @Autowired annotation to inject an instance of our AIClient.
    @Autowired private AIClient client;


    //  TDODO-11: Define a test method to call the createImageUrl method of the client.
    //  Pass in a string that describes the image you want to generate, for example
    //  "Two golden retrievers playing tug-o-war in the snow.".
    //  Use AssertJ's Assertions.assertThat() method to ensure that the returned URL is not blank.
    //  Print the URL that is returned.
    @Test
    public void testCreateImageUrl() {
        String url = client.createImageUrl("Two golden retrievers playing tug-o-war in the snow.");
        assertThat(url).isNotBlank();
        System.out.println("URL: " + url);
    }

    //  TDODO-12: Organize your imports and save your work.
    //  Run this test.  Expect it to take a few moments to run, and it should pass.
    //  Find the URL of the generated image and open it in a browser to see the result.



    //  TDODO-17 (Optional): Using your earlier @Test method as an example, define a new test method
    //  to test the client's createImageB64 method.  Pass in whatever image description you like.
    //  As before, use assertThat() to ensure that the returned Base-64 encoded String is not blank.
    //  Call the provided testValidBase64Image() method to check that the returned string appears to be a valid image.
    //  Call the provided saveBase64Image() to save a copy of your image.
    //  Organize your imports and save your work.
    //  Run this test.  Expect it to take a few moments to run, and it should pass.
    //  Open the newly generated image an admire your handiwork!

    @Test
    public void testCreateImageB64() {
        String imageB64 = client.createImageB64("Two golden retrievers playing tug-o-war in the snow.");
        assertThat(imageB64).isNotBlank();
        testValidBase64Image(imageB64);
        saveBase64Image(imageB64, "image.png");
    }


}
