package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import org.springframework.stereotype.Component;
import com.example.demo.dto.FactDTO;

@Component("factService")
public class FactService {

    public List<FactDTO> getFacts() {
        List<FactDTO> factData = new ArrayList<>();
        try {
            Document webPage = Jsoup.connect("https://bestlifeonline.com/useless-facts/").get();
            System.out.println(webPage.title());    
            Elements factdto = webPage.getElementsByClass("main-content");
            for (Element factElement : factdto.get(0).getElementsByClass("title")) {
                factData.add(new FactDTO(factElement.text()));
                System.out.println(factElement.text());
            }
            return factData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
