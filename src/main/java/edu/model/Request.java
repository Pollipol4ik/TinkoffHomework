package edu.model;


public record Request(String method, String url, String protocol, String userAgent) {
}
