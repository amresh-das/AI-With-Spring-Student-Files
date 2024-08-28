package com.example.client;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.zhipuai.ZhiPuAiImageOptions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//  TODO-04: Use a stereotype annotation to mark this class as a Spring bean.
//  Use an annotation to assign it to the "zhipuai" profile.


public class ZhiPuAIClient implements AIClient {

    //  TODO-05: Define a private final field named "model" of type ImageModel.
    //   Define a constructor which dependency injects this field:


    private static final ZhiPuAiImageOptions DEFAULT_OPTIONS =
            ZhiPuAiImageOptions.builder().build();

    public String createImageB64(String request) {

        //  TODO-06: Create an ImagePrompt object using the request and the DEFAULT_OPTIONS:
        //  (Feel free to experiment with your own custom-defined ZhiPuAiImageOptions later).


        //  TODO-07: Create a variable of type ImageResponse.
        //   Populate it by calling model.call(), passing the prompt you've just created:


        //  TODO-08: Remove the "return null;" line.
        //  Return the Base-64 encoded String from the previous call.
        //  It can be found by traversing the result / output.
        //  Organize your imports and save your work:
        return null;

    }

    public String createImageUrl(String request) {
        throw new UnsupportedOperationException("Model does not support URL generation.");
    }

}
