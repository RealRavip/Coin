package com.example.btc.models;

public class CoinData {
    private String name,symbol,image,url;
    private final int type;

    public CoinData(String name, String symbol, String image, String url, int type) {
        this.name = name;
        this.symbol = symbol;
        this.image = image;
        this.url = url;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() { return url; }

    public int getType() {
        return type;
    }
}
