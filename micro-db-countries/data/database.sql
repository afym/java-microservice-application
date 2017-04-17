DROP DATABASE IF EXISTS country_db;
CREATE DATABASE country_db;
USE country_db;

DROP TABLE IF EXISTS population;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS countries;

CREATE TABLE IF NOT EXISTS countries (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  flag VARCHAR(255) DEFAULT '',
  PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS cities (
  id INT NOT NULL AUTO_INCREMENT,
  name   VARCHAR(100) NOT NULL,
  latitude FLOAT(10,6) NOT NULL,
  longitude FLOAT(10,6) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

ALTER TABLE cities ADD country_id INT NOT NULL DEFAULT 0;
ALTER TABLE cities ADD CONSTRAINT fk_cities_id FOREIGN KEY (country_id) REFERENCES countries(id);

CREATE TABLE IF NOT EXISTS population (
    id INT NOT NULL AUTO_INCREMENT,
    tag   VARCHAR(100) NOT NULL,
    value VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

ALTER TABLE population ADD country_id INT NOT NULL DEFAULT 0;
ALTER TABLE population ADD CONSTRAINT fk_population_id FOREIGN KEY (country_id) REFERENCES countries(id);

INSERT INTO countries (name, flag) VALUES 
('Afghanistan', 'https://www.state.gov/img/14/57790/afghanistan_flag_201403worldfactbook_96_1.jpg'),
('Albania', 'https://www.state.gov/img/14/57819/allgflag_96_1.jpg'),
('Brazil', 'https://www.state.gov/img/14/57702/brazil_96_1.gif'),
('China', 'https://www.state.gov/img/13/55968/chlgflag_120_1.gif'),
('Egypt', 'https://www.state.gov/img/14/58006/egypt_flag_90_1.jpg'),
('Iran', 'https://www.state.gov/img/14/58009/iran_flag_90_1.jpg');

 INSERT INTO cities (country_id, name, latitude, longitude) VALUES
 (1, 'Kabul', 34.528130, 69.172330),
 (1, 'Kandahar', 31.634955, 65.715064),
 (2, 'Fier', 40.726613, 19.543787),
 (2, 'Berat', 40.711479, 19.937238),
 (3, 'Rio de Janeiro', -22.062230,-44.04743),
 (3, 'Manaus', -3.044659, -60.037315),
 (4, 'Tianjin', 39.124694, 117.014667),
 (4, 'Hong Kong', 22.357617, 113.98058),
 (5, 'Alexandria', 31.224091, 29.884678),
 (5, 'Cairo', 30.122973, 31.301838),
 (6, 'Mashhad', 36.297601, 59.509246),
 (6, 'Tabriz', 38.080347, 46.223514);
 
 INSERT INTO population (country_id, tag, value) VALUES
 (1, 'Metropolis', '34,169,169'),
 (1, 'Migrants', '-39,999'),
 (1, 'Median Age', '17.8'),
 (2, 'Metropolis', '2,911,428'),
 (2, 'Migrants', '-10,000'),
 (2, 'Median Age', '34.5	'),
 (3, 'Metropolis', '211,243,220'),
 (3, 'Migrants', '7,439'),
 (3, 'Median Age', '31.7'),
 (4, 'Metropolis', '1,388,232,693'),
 (4, 'Migrants', '-300,000'),
 (4, 'Median Age', '37.3'),
 (5, 'Metropolis', '95,215,102'),
 (5, 'Migrants', '-43,136	'),
 (5, 'Median Age', '24.8	'),
 (6, 'Metropolis', '80,945,718'),
 (6, 'Migrants', '-28,787'),
 (6, 'Median Age', '30.1');