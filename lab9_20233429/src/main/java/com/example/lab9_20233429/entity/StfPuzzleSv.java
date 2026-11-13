package com.example.lab9_20233429.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stf_puzzle_sv")
public class StfPuzzleSv {

    @Id
    @Column(name = "stf_game_board_structure", nullable = false, length = 255)
    private String stfGameBoardStructure;

    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;

    public StfPuzzleSv() {
    }

    public StfPuzzleSv(String stfGameBoardStructure, String image) {
        this.stfGameBoardStructure = stfGameBoardStructure;
        this.image = image;
    }

    public String getStfGameBoardStructure() {
        return stfGameBoardStructure;
    }

    public void setStfGameBoardStructure(String stfGameBoardStructure) {
        this.stfGameBoardStructure = stfGameBoardStructure;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
