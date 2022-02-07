package com.example.myexpandablelistview;

public class ExpdDTO {
    private String title;
    private String content;
    private String date;
    private String answer;


    public ExpdDTO(String title, String content, String date, String answer) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
