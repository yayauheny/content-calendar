CREATE TABLE IF NOT EXISTS Content
(
    id           INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    description  text,
    status       VARCHAR(20)  NOT NULL,
    content_type VARCHAR(50)  NOT NULL,
    created_at   TIMESTAMP    NOT NULL,
    updated_at   TIMESTAMP,
    url          VARCHAR(255)
);

INSERT INTO Content(title, description, status, content_type, created_at, url)
VALUES ('tEST', 'TEST', 'IDEA', 'ARTICLE', '2023-08-18 15:30:45', 'aboba'),
       ('aboba', 'aboba', 'IN_PROGRESS', 'COURSE', '2023-08-17 15:16:45', 'ABBOOBAA');