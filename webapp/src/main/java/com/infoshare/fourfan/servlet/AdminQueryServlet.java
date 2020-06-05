package com.infoshare.fourfan.servlet;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import javax.servlet.http.HttpServlet;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;

public class AdminQueryServlet extends HttpServlet {
    private String

//    String jsonObject = buildObject().toString();
//    InputStream inputStream = new ByteArrayInputStream(jsonObject.getBytes());
//
//    JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());
//    JsonReader jsonReader = readerFactory.createReader(inputStream);

    JsonParserFactory parserFactory = Json.createParserFactory(Collections.emptyMap());
    JsonParser parser = parserFactory.createParser(buildObject());

//    try (
//    JsonReader jsonReader = readerFactory.createReader(new ByteArrayInputStream(jsonDocument.getBytes()))) {
//        JsonObject jsonObject = jsonReader.readObject();
//        System.out.println(jsonObject
//                .getJsonObject("productList")
//                .get(0).asJsonObject()
//                .getJsonObject("name")
//        );
//    }
while (parser.hasNext()) {
        JsonParser.Event event = parser.next();
        switch (event) {
            case START_OBJECT:
                System.out.println("{");
                break;
            case END_OBJECT:
                System.out.println("}");
                break;
            case START_ARRAY:
                System.out.println("[");
                break;
            case END_ARRAY:
                System.out.println("]");
                break;
            case KEY_NAME:
                System.out.print(String.format("\"%s\": ", parser.getString()));
                break;
            case VALUE_NUMBER:
                System.out.println(parser.getBigDecimal());
                break;
            case VALUE_STRING:
                System.out.println(String.format("\"%s\"", parser.getString()));
                break;
            default:
                System.out.println("true, false or null");
        }
    }


}
