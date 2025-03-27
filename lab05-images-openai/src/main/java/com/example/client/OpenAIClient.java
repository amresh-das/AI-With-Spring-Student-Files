package com.example.client;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

//  TDODO-04: Use a stereotype annotation to mark this class as a Spring bean.
//  Provide an explicit bean name to avoid naming conflicts with internal SpringAI beans.

@Service("openai.client")
public class OpenAIClient implements AIClient {

    //  TDODO-05: Define a private final field named "model" of type ImageModel.
    //   Define a constructor which dependency injects this field:
    private final ImageModel imageModel;
    private static final OpenAiImageOptions DEFAULT_OPTIONS = OpenAiImageOptions.builder().withN(1).build();

    public OpenAIClient(final ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public String createImageUrl(String request) {

        //  TDODO-06: Create an ImagePrompt object using the request and the DEFAULT_OPTIONS:
        //  (Feel free to experiment with your own custom-defined OpenAiImageOptions later).
        ImagePrompt prompt = new ImagePrompt(request, DEFAULT_OPTIONS);

        //  TDODO-07: Create a variable of type ImageResponse.
        //   Populate it by calling model.call(), passing the prompt you've just created:
        ImageResponse response = imageModel.call(prompt);

        //  TDODO-08: Remove the "return null;" line.
        //  Return the URL String from the previous call.
        //  It can be found by traversing the result / output.
        //  Organize your imports and save your work:

         return response.getResult().getOutput().getUrl();

    }



    public String createImageB64(String request) {

        //  TDODO-13 (Optional): Create an OpenAiImageOptions object named B64_OPTIONS.
        //  Use the builder pattern to set the "responseFormat" property to "b64_json" (Base-64 encoded String):
        OpenAiImageOptions B64_OPTIONS =
                OpenAiImageOptions.builder()
                        .withResponseFormat("b64_json").build();

        //  TDODO-14 (Optional): Using your earlier code as a guide, create an
        //  ImagePrompt object using the request and the B64_OPTIONS:
        ImagePrompt prompt = new ImagePrompt(
                request,
                B64_OPTIONS
        );

        //  TDODO-15 (Optional): Using your earlier code as a guide, create a variable of type ImageResponse.
        //  Populate it by calling model.call(), passing the prompt you've just created.
        ImageResponse response = imageModel.call(prompt);

        //  TDODO-16 (Optional): Remove the "return null;" line.
        //  Using your earlier code as a guide, return the Base-64 encoded String from the previous call.
        //  Organize your imports and save your work.
        return response.getResult().getOutput().getB64Json();

    }


}
