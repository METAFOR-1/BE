package com.example.hackathon.domain.youtube.service;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class YoutubeService {

    @Value("${youtube.api.key}")
    private  String apiKey;

    public String searchVideo(String query) throws IOException {
        String modifiedQuery = query + " 스트레칭";

        JsonFactory jsonFactory = new JacksonFactory();

        YouTube youtube = new YouTube.Builder(
                new com.google.api.client.http.javanet.NetHttpTransport(),
                jsonFactory,
                Request -> {})
                .build();
        YouTube.Search.List search = youtube.search().list(Collections.singletonList("id,snippet"));

        search.setKey(apiKey);
        search.setQ(modifiedQuery);

        SearchListResponse searchResponse = search.execute();

        List<com.google.api.services.youtube.model.SearchResult> searchResultList = searchResponse.getItems();

        if (searchResultList != null && searchResultList.size() > 0) {
            SearchResult searchResult = searchResultList.get(0); //검색 결과 중 첫 번째 동영상 정보 가져오기

            String videoId = searchResult.getId().getVideoId();
            String videoTitle = searchResult.getSnippet().getTitle();

            return "Title: " + videoTitle + "\nURL: https://www.youtube.com/watch?v=" + videoId;
        }
        return "검색 결과가 없습니다";    }
}
