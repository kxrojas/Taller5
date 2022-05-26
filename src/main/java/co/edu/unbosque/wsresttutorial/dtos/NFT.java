package co.edu.unbosque.wsresttutorial.dtos;

import com.opencsv.bean.CsvBindByName;

public class NFT {

    @CsvBindByName
    private String title;

    @CsvBindByName
    private String Fcoins;

    @CsvBindByName
    private String image_url;

    public NFT(){
    }

    public NFT(String title, String fcoins, String image_url) {
        this.title = title;
        Fcoins = fcoins;
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFcoins() {
        return Fcoins;
    }

    public void setFcoins(String fcoins) {
        Fcoins = fcoins;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
