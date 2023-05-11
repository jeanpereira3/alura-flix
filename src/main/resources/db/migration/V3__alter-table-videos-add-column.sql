ALTER TABLE videos ADD categoria_id bigint NOT NULL;
UPDATE videos SET categoria_id = 1;
ALTER TABLE videos ADD CONSTRAINT fk_videos_categorias FOREIGN KEY(categoria_id) REFERENCES categorias(id);