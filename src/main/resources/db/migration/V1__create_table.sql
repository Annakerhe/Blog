CREATE TABLE IF NOT EXISTS author
(
    id        bigserial    PRIMARY KEY,
    password  varchar(255) NOT NULL,
    login     varchar(255) NOT NULL UNIQUE,
    full_name varchar(255) NOT NULL,
    age       int2,
    status    varchar(255),
    roles     varchar(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS article
(
    id           bigserial    PRIMARY KEY,
    author_id    bigint REFERENCES author (id) NOT NULL,
    title        varchar(255) NOT NULL,
    publish_date date,
    body         text         NOT NULL,
    tag          varchar(255)
);


CREATE TABLE IF NOT EXISTS comment
(
    id           bigserial PRIMARY KEY,
    author_id    bigint   REFERENCES author (id),
    article_id   bigint   REFERENCES article (id),
    publish_date date,
    body         text      NOT NULL

);

