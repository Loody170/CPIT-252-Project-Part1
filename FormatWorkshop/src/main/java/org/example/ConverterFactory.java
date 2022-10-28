package org.example;

public class ConverterFactory {
    public Converter getConverter(String type){
        if(type == null) {
            return null;

        } if(type.equalsIgnoreCase("Document")){
            return new DocumentConverter();
        } else if(type.equalsIgnoreCase("Image")){
            return new ImageConverter();
        }
        else if(type.equalsIgnoreCase("Youtube Video")){
            return new YoutubeVideo();
        }
        return null;
    }
}
