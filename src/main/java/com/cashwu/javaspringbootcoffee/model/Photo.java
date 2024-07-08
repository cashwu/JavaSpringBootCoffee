package com.cashwu.javaspringbootcoffee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cash.wu
 * @since 2024/07/08
 */
@Entity
public class Photo {

    @Id
    @GeneratedValue
    //    @JsonProperty("id")
    private int id;

//    @JsonProperty("albumId")
//    private int albumId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;

    public Photo(String title,
                 String url,
                 String thumbnailUrl) {
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Photo() {
    }

    @Override
    public String toString() {
        return "Photo{" + "id=" + id + ", title='" + title + '\'' + ", url='" + url + '\''
                + ", thumbnailUrl='" + thumbnailUrl + '\'' + '}';
    }
}
