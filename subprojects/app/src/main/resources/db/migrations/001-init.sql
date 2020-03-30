DROP SCHEMA IF EXISTS invest_helper CASCADE;
CREATE SCHEMA invest_helper;

CREATE TABLE IF NOT EXISTS invest_helper.user
(
    id            BIGSERIAL,
    email         VARCHAR(128) NOT NULL,
    username      VARCHAR(64)  NOT NULL,
    password      VARCHAR(255) NOT NULL,
    first_name    VARCHAR(45)  NOT NULL,
    last_name     VARCHAR(45)  NOT NULL,
    created_at    TIMESTAMP    NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT email_uidx UNIQUE (email),
    CONSTRAINT username_uidx UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS invest_helper.potfolio
(
    id           BIGSERIAL,
    name         VARCHAR(75) NOT NULL,
    user_id      BIGINT      NOT NULL,
    archived     BOOLEAN     NOT NULL DEFAULT FALSE,
    created_at   TIMESTAMP   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_portfolio_user_user_id
        FOREIGN KEY (user_id)
            REFERENCES invest_helper.user (id)
            ON DELETE RESTRICT
            ON UPDATE NO ACTION
);
CREATE INDEX potfolio_fk_user_id ON invest_helper.potfolio (user_id);