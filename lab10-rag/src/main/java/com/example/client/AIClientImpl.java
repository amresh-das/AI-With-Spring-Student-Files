package com.example.client;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//  TDODO-05: Annotate this class as a Spring Service.

@Service
public class AIClientImpl implements AIClient {

    //  TDODO-06: Use the @Autowired annotation to inject an instance of our VectorStore bean.
    @Autowired private VectorStore vectorStore;


    private ChatClient client;
    String defaultSystemMessage =
        """
        You are a helpful product expert that provides product recommendations to customers.
        Each product recommendation should be brief, but MUST include 1) a summary of the product 2) the URL for more details.
        """;

    //  TDODO-07: Create a constructor for this bean.
    //  Inject a ChatModel object into the constructor.
    //  Pass the model to the ChatClient.builder to build a ChatClient object.
    //  Use defaultSystem() to set the default system message to the String defined above.
    //  Save the ChatClient object in the client field.
    public AIClientImpl(final ChatModel model) {
        client = ChatClient.builder(model).defaultSystem(defaultSystemMessage).build();
    }


    @Override
    public void save(List<String> products) {
        //   TODDO-08: Convert the List<String> into a List<Document>,
        //   where each product description String is used to create a Document.
        //   Call the vectorStore's add() method with the List<Document> to add these descriptions to the VectorStore.
        vectorStore.add(products.stream().map(Document::new).toList());
    }


    @Override
    public String getProductRecommendations(String query) {

        //  TDODO-09: Define a new QuestionAnswerAdvisor object.
        //  Inject it with the VectorStore object that was @Autowired earlier.
        final QuestionAnswerAdvisor advisor = QuestionAnswerAdvisor.builder(vectorStore).build();

        //  TDODO-10: Use the client object to call the API.
        //  The .prompt() method can be used to define a prompt.
        //  The .user() method can be used to set the query String parameter as the user message.
        //  The .advisors() method can be used to register the QuestionAnswerAdvisor you just defined.
        //  The .call() method will make the call to the model.
        //  The .content() method will return the content of the response.
        //  Have the method return the content of the response.
        return client.prompt().user(query).advisors(advisor).call().content(); // replace this line
    
    }
}
