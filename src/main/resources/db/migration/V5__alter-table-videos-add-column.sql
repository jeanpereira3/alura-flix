ALTER TABLE videos ADD free tinyint  NOT NULL;
UPDATE videos SET free = 0;
