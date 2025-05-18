CREATE TABLE tb_ninjas (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255),
  email VARCHAR(255),
  idade INTEGER,
  img_url VARCHAR(255),
  missao_id BIGINT
);
