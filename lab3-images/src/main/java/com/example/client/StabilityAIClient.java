package com.example.client;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//  TODO-04: Use a stereotype annotation to mark this class as a Spring bean.
//  Use an annotation to assign it to the "openai" profile.
@Component
@Profile("stabilityai")
public class StabilityAIClient {

    //  TODO-05: Define a private final field named "model" of type StabilityAIImageModel.
    //   Define a constructor which dependency injects this field:
    private final StabilityAiImageModel model;
    public StabilityAIClient(StabilityAiImageModel model) {
        this.model = model;
    }

    private static final StabilityAiImageOptions DEFAULT_OPTIONS =
            StabilityAiImageOptions.builder().withN(1).build();

    public String createImageB64(String request) {

        //  TODO-06: Create an ImagePrompt object using the request and the DEFAULT_OPTIONS:
        //  (Feel free to experiment with your own custom-defined StabilityAiImageOptions later).
        ImagePrompt prompt = new ImagePrompt(
                request,
                DEFAULT_OPTIONS
        );

        //  TODO-07: Create a variable of type ImageResponse.
        //   Populate it by calling model.call(), passing the prompt you've just created:
        ImageResponse response = model.call(prompt);

        //  TODO-08: Remove the "return null;" line.
        //  Return the Base-64 encoded String from the previous call.
        //  It can be found by traversing the result / output.
        //  Organize your imports and save your work:
        return response.getResult().getOutput().getB64Json();
        // return null;

    }

}