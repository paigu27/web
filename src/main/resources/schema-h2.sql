-- H2 (MySQL mode) schema. Mirrors sql/init.sql used for real MySQL.
CREATE TABLE IF NOT EXISTS message (
  id          BIGINT         PRIMARY KEY AUTO_INCREMENT,
  content     VARCHAR(1000)  NOT NULL,
  created_at  DATETIME       NULL
);

CREATE TABLE IF NOT EXISTS article (
  id          BIGINT         PRIMARY KEY AUTO_INCREMENT,
  title       VARCHAR(200)   NOT NULL,
  content     TEXT           NOT NULL,
  created_at  DATETIME       NULL
);
