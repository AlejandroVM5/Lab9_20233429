create database	if not exists stf_games_20233429;
USE stf_games_20233429;

drop table if exists stf_puzzle_sv;
create table stf_puzzle_sv (
	stf_games_board_structure varchar(255) not null primary key,
    image longtext
);


