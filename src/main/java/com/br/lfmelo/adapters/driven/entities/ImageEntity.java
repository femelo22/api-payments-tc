package com.br.lfmelo.adapters.driven.entities;

import com.br.lfmelo.core.model.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "images")
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link_image", length = 200)
    private String linkImage;

    @Column(name = "key_image", length = 100)
    private String keyImage;

    @ManyToOne
    @JoinColumn(name = "id_product")
    @JsonIgnore
    private ProductEntity product;

    public ImageEntity(Image image) {
        this.linkImage = image.getLinkImage();
        this.keyImage = image.getKeyImage();
    }
}
