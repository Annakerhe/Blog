CREATE TABLE IF NOT EXISTS author
(
    id        bigserial    NOT NULL,
    full_name varchar(255) NOT NULL,
    age       int2,
    status    varchar(255),
    CONSTRAINT author_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS article
(
    id           bigserial    NOT NULL,
    author_id    integer      NOT NULL,
    title        varchar(255) NOT NULL,
    publish_date date,
    body         text         NOT NULL,
    tag          varchar(255),
    CONSTRAINT article_pkey PRIMARY KEY (id)
);

ALTER TABLE article
    ADD CONSTRAINT article_author_id_fkey FOREIGN KEY (author_id) REFERENCES author (id);

CREATE TABLE IF NOT EXISTS comment
(
    id           bigserial NOT NULL,
    author_id    integer   NOT NULL,
    article_id   integer   NOT NULL,
    publish_date date,
    body         text      NOT NULL,
    CONSTRAINT comment_pkey PRIMARY KEY (id)
);
ALTER TABLE comment
    ADD CONSTRAINT comment_author_id_fkey FOREIGN KEY (author_id) REFERENCES author (id);
ALTER TABLE comment
    ADD CONSTRAINT comment_article_id_fkey FOREIGN KEY (article_id) REFERENCES article (id);
