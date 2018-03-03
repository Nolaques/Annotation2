package com.company;

@AnnHtmlUL(border = "1px solid red")
public class DocumentClass {

    private String author;

    @AnnHtmlLI(background = "blue", color = "black")
    public String getDocumentName(){
        return "Java Core";
    }

    @AnnHtmlLI(background = "yellow")
    public String getDocumentVersion(){
        return "1.0";
    }

    @AnnHtmlLI(background = "green")
    public void setAuthor(String author){
        this.author = author;
    }

    @AnnHtmlLI(background = "red", color = "black")
    public String getAuthor(){
        return author;
    }

    public float getPrice(){
        return 100;
    }
}
