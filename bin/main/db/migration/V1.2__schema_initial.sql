ALTER TABLE `palavra` ADD CONSTRAINT `FK_palavra_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria`(`id`);
ALTER TABLE `rodada` ADD CONSTRAINT `FK_rodada_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria`(`id`);
ALTER TABLE `rodada_jogador` ADD CONSTRAINT `FK_rodada_jogador_rodada` FOREIGN KEY (`rodada_id`) REFERENCES `rodada`(`id`);
ALTER TABLE `rodada_jogador` ADD CONSTRAINT `FK_rodada_jogador_jogador` FOREIGN KEY (`jogador_id`) REFERENCES `jogador`(`id`);
ALTER TABLE `ranking` ADD CONSTRAINT `FK_ranking_rodada_jogador` FOREIGN KEY (`rodada_jogador_id`) REFERENCES `rodada_jogador`(`id`);

