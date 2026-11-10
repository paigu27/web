# MyBlog 数据库初始化脚本（Week 06 / Week 08）
# 用法：mysql -uroot -p < sql/init.sql

CREATE DATABASE IF NOT EXISTS myblog CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Week 06：留言表（记忆宫殿的房间）
CREATE TABLE IF NOT EXISTS message (
  id          BIGINT         PRIMARY KEY AUTO_INCREMENT,
  content     VARCHAR(1000)  NOT NULL,
  created_at  DATETIME       NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Week 08：文章表（发布内容）
CREATE TABLE IF NOT EXISTS article (
  id          BIGINT         PRIMARY KEY AUTO_INCREMENT,
  title       VARCHAR(200)   NOT NULL,
  content     TEXT           NOT NULL,
  created_at  DATETIME       NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
