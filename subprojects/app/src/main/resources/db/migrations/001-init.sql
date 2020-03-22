DROP SCHEMA IF EXISTS task_helper CASCADE;
CREATE SCHEMA task_helper;

CREATE TABLE IF NOT EXISTS  task_helper.user
(
    id            BIGSERIAL,
    email         VARCHAR(128) NOT NULL,
    username      VARCHAR(64)  NOT NULL,
    password      VARCHAR(255) NOT NULL,
    first_name    VARCHAR(45)  NOT NULL,
    last_name     VARCHAR(45)  NOT NULL,
    created_at    TIMESTAMP    NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT email_uidx UNIQUE (email_address),
    CONSTRAINT username_uidx UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS  task_helper.team
(
    id           BIGSERIAL,
    name         VARCHAR(75) NOT NULL,
    user_id      BIGINT      NOT NULL,
    archived     BOOLEAN     NOT NULL DEFAULT FALSE,
    created_at   TIMESTAMP   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_team_user_user_id
        FOREIGN KEY (user_id)
            REFERENCES task_helper.user (id)
            ON DELETE RESTRICT
            ON UPDATE NO ACTION
);
CREATE INDEX team_fk_user_id ON task_helper.team (user_id);