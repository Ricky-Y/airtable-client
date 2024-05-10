package com.freespacenow.airtable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freespacenow.airtable.dto.AirtableResponse;
import com.freespacenow.airtable.dto.Item;
import com.freespacenow.airtable.dto.Record;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class AirtableClient {
    private static final String ITEMS_TABLE = "items";
    private static final String API_KEY = "patm56OK8RPSASW4d.769d246798b7f37c7c5bb1a9de07d71531763aab8596dc64b65919d862f38842";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String FREESPACENOW_BASE_ID = "appis1PQ3XUmfEeKt";

    private final OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Record<Item>> getValidItems() {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.airtable.com")
                .addPathSegment("v0")
                .addPathSegment(FREESPACENOW_BASE_ID)
                .addPathSegment(ITEMS_TABLE)
                .addQueryParameter("filterByFormula", "AND({Deleted}=FALSE(),{Status}='In warehouse')")
                .addQueryParameter("maxRecords", "500")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .header(AUTHORIZATION_HEADER, "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
//            for (int i = 0; i < responseHeaders.size(); i++) {
//                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//            }

            String bodyString = response.body().string();
//            System.out.println(bodyString);

            AirtableResponse<Item> airtableResponse = objectMapper.readValue(bodyString, new TypeReference<AirtableResponse<Item>>() {});
            return airtableResponse.getRecords();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
