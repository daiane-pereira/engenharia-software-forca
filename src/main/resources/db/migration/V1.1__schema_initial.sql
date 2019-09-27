CREATE TABLE IF NOT EXISTS `categoria` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `descricao` VARCHAR(255) NOT NULL,
   PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `palavra` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `palavra` VARCHAR(255) NOT NULL,
   `dica` VARCHAR(255) NOT NULL,
   `categoria_id` bigint(20) NOT NULL,
   PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `rodada` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `pontuacao` bigint(20) NOT NULL,
   `categoria_id` bigint(20) NOT NULL,
   PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `jogador` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `nome` VARCHAR(255) NOT NULL,
   PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `rodada_jogador` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `rodada_id` bigint(20) NOT NULL,
   `jogador_id` bigint(20) NOT NULL,
   PRIMARY KEY (`id`)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `ranking` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `rodada_jogador_id` bigint(20) NOT NULL,
   PRIMARY KEY (`id`)
)ENGINE=InnoDB;

