package com.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //네이버 뉴스
        String url = "https://news.naver.com/main/list.nhn?mode=LS2D&sid2=263&sid1=101&mid=shm&date=20190612&page=1";

        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        }catch (IOException ie){
            System.out.println("읽기 에러");
            return;
        }
        Elements elements = doc.select("div[class=\"list_body newsflash_body\"]");

        for(Element e : elements.select("dt")){
            if(e.className().equals("photo")){
                continue;
            }
            System.out.println(e.text());
        }
    }
}
