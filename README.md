```mysql
CREATE TABLE `user`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `userName`     VARCHAR(20),
    `password` VARCHAR(200),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- jack：123456
-- xiaoming：2345678s
INSERT INTO user (userName, password) VALUES
('jack','f8d809a3-6206-4d93-ae2c-3995868535b6'),
('xiaoming', '38d76638-91a6-49dc-b31a-418d2a0c3e0a');
```

