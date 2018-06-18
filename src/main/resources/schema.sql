CREATE TABLE IF NOT EXISTS players(
player_type VARCHAR(1) NOT NULL PRIMARY_KEY,
password VARCHAR(256) NOT NULL,
);


CREATE TABLE IF NOT EXISTS bets (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
match_time DATETIME NOT NULL,
team_1_type VARCHAR(3) NOT NULL,
team_1_score INT(3),
team_1_bet_player1 INT(3),
team_1_bet_player2 INT(3),
team_2_type VARCHAR(3) NOT NULL,
team_2_score INT(3),
team_2_bet_player1 INT(3)
team_2_bet_player2 INT(3)
);

