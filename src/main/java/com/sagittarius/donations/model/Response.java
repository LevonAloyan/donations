package com.sagittarius.donations.model;

/**
 * @author LEVON
 */
public class Response {

    private String content;

    public Response(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
