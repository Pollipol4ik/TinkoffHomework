package edu.task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private final static Pattern TITLE_FINDER = Pattern.compile("\"title\":\"([^\"]*)\"");

    private static final String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_URL_FORMAT = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    private HackerNews() {

    }

    public static long[] hackerNewsTopStories() {
        HttpRequest request = HttpRequest.newBuilder(URI.create(TOP_STORIES_URL)).build();

        try {
            HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return convertStringToLongArray(response.body());
        } catch (IOException | InterruptedException e) {
            return new long[0];
        }
    }

    private static long[] convertStringToLongArray(String responseBody) {
        String[] codes = responseBody.replaceAll("[\\[\\]]", "").split(",");
        return Arrays.stream(codes).mapToLong(Long::parseLong).toArray();
    }

    public static String news(long id) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(ITEM_URL_FORMAT + id + ".json")).build();

        try {
            HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return parseNews(response.body());
        } catch (IOException | InterruptedException e) {
            return "";
        }
    }

    private static String parseNews(String newsJson) {
        Pattern pattern = Pattern.compile("\"title\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(newsJson);
        return matcher.find() ? matcher.group(1) : "";
    }

}
