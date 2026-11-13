package com.example.lab9_20233429.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stf_puzzle_sv")

public class StfPuzzleSv {

    @Id
    @Column(name = "stf_games_board_structure", nullable = false, length = 255)
    private String stf_games_board_structure;

    @Column(name = "image",columnDefinition = "LongText")
    private String image;

    public StfPuzzleSv() {

    }

    public StfPuzzleSv(String stf_games_board_structure, String image) {
        this.stf_games_board_structure = stf_games_board_structure;
        this.image = image;
    }

    public String getStf_games_board_structure() {
        return stf_games_board_structure;
    }

    public void setStf_games_board_structure(String stf_games_board_structure) {
        this.stf_games_board_structure = stf_games_board_structure;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
