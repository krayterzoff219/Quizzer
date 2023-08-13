BEGIN TRANSACTION;

DROP TABLE IF EXISTS quiz_questions, leaderboard CASCADE;

CREATE TABLE quiz_questions(
    number serial PRIMARY KEY,
    question VARCHAR(250) NOT NULL,
    correct_answer int NOT NULL,
    choice_1 VARCHAR(50) NOT NULL,
    choice_2 VARCHAR(50) NOT NULL,
    choice_3 VARCHAR(50) NOT NULL,
    choice_4 VARCHAR(50) NOT NULL,

    CONSTRAINT UQ_question UNIQUE (question)
);


CREATE TABLE leaderboard(
    player_id serial PRIMARY KEY,
    player_name VARCHAR(50) NOT NULL,
    score int NOT NULL
);


INSERT INTO quiz_questions(question, correct_answer, choice_1, choice_2, choice_3, choice_4)
VALUES('Which of the following is in EVERY Star Wars Episode (1 - 9)?', 1, 'R2-D2', 'Luke Skywalker', 'Yoda', 'Anakin Skywalker/Darth Vader');


INSERT INTO leaderboard(player_name, score) VALUES ('Buch', 100);


COMMIT;