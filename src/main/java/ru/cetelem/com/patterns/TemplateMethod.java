package ru.cetelem.com.patterns;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TemplateMethod {

    public static void main(String[] args) {
        new BankWebSite().showPage();
    }

}


class NewsWebSite extends WebSiteTemplate{
    @Override
    protected void showPageBody() {
        System.out.println("NEWS");
    }
}

class BankWebSite extends WebSiteTemplate{
    @Override
    protected void showPageBody() {
        System.out.println("BANK INFO");
    }
}

abstract class WebSiteTemplate{

    protected final void showPage(){
        System.out.println("HEADER");
        showPageBody();
        System.out.println("FOOTER");
    }

    protected void showPageBody(){
        System.out.println("PAGE BODY");
    }

}
