-- Script de poblamiento inicial para MangaStore
-- Base de datos: mangaStore
-- IMPORTANTE: Este script usa los nombres de columnas exactos de la base de datos

-- Insertar usuario administrador por defecto
INSERT INTO usuario (run, nombre, apellidos, email, password, fecha_nacimiento, tipo_usuario, direccion, telefono, fecha_registro, activo, created_by)
VALUES ('11111111-1', 'Admin', 'Sistema', 'admin@mangastore.com', 'admin123', '1990-01-01', 'super-admin', 'Av. Principal 123', '+56912345678', NOW(), 1, NULL);

-- Insertar categorías (mínimo 5)
INSERT INTO categoria (nombre, descripcion, activo) VALUES
('Shonen', 'Manga dirigido a un público juvenil masculino', 1),
('Seinen', 'Manga para adultos jóvenes', 1),
('Shojo', 'Manga dirigido a un público juvenil femenino', 1),
('Kodomo', 'Manga para niños', 1),
('Isekai', 'Historias de mundos alternativos', 1),
('Acción', 'Manga de acción y aventura', 1),
('Romance', 'Historias románticas', 1);

-- Insertar editoriales
INSERT INTO editorial (nombre, pais, activo) VALUES
('Shueisha', 'Japón', 1),
('Kodansha', 'Japón', 1),
('Panini Comics', 'Chile', 1);

-- Insertar productos/mangas (mínimo 15)
INSERT INTO manga (codigo, titulo, titulo_original, autor, ilustrador, descripcion, año_publicacion, isbn, paginas, idioma, estado_serie, editorial_id, precio, stock, stock_critico, imagen_portada, fecha_creacion, fecha_actualizacion, activo)
VALUES
('MNG001', 'One Piece Vol. 1', 'ワンピース', 'Eiichiro Oda', 'Eiichiro Oda', 'La aventura de Monkey D. Luffy en busca del One Piece', 1997, '978-1-56931-901-0', 200, 'Español', 'en_curso', 1, 9990.00, 50, 5, 'https://example.com/onepiece1.jpg', NOW(), NOW(), 1),
('MNG002', 'Naruto Vol. 1', 'ナルト', 'Masashi Kishimoto', 'Masashi Kishimoto', 'La historia del ninja Naruto Uzumaki', 1999, '978-1-56931-900-3', 192, 'Español', 'finalizada', 1, 8990.00, 40, 5, 'https://example.com/naruto1.jpg', NOW(), NOW(), 1),
('MNG003', 'Attack on Titan Vol. 1', '進撃の巨人', 'Hajime Isayama', 'Hajime Isayama', 'Humanidad vs Titanes', 2009, '978-1-61262-024-4', 194, 'Español', 'finalizada', 2, 10990.00, 35, 5, 'https://example.com/aot1.jpg', NOW(), NOW(), 1),
('MNG004', 'Death Note Vol. 1', 'デスノート', 'Tsugumi Ohba', 'Takeshi Obata', 'Un cuaderno que mata', 2003, '978-1-4215-0168-5', 200, 'Español', 'finalizada', 1, 9990.00, 30, 5, 'https://example.com/deathnote1.jpg', NOW(), NOW(), 1),
('MNG005', 'My Hero Academia Vol. 1', '僕のヒーローアカデミア', 'Kohei Horikoshi', 'Kohei Horikoshi', 'Un mundo de superhéroes', 2014, '978-1-4215-7321-6', 192, 'Español', 'en_curso', 1, 8990.00, 60, 5, 'https://example.com/mha1.jpg', NOW(), NOW(), 1),
('MNG006', 'Demon Slayer Vol. 1', '鬼滅の刃', 'Koyoharu Gotouge', 'Koyoharu Gotouge', 'Cazadores de demonios', 2016, '978-1-9747-0144-7', 192, 'Español', 'finalizada', 1, 9990.00, 55, 5, 'https://example.com/demonslayer1.jpg', NOW(), NOW(), 1),
('MNG007', 'Tokyo Ghoul Vol. 1', '東京喰種', 'Sui Ishida', 'Sui Ishida', 'Humanos vs Ghouls', 2011, '978-1-4215-7087-1', 224, 'Español', 'finalizada', 1, 10990.00, 25, 5, 'https://example.com/tokyoghoul1.jpg', NOW(), NOW(), 1),
('MNG008', 'Fullmetal Alchemist Vol. 1', '鋼の錬金術師', 'Hiromu Arakawa', 'Hiromu Arakawa', 'Alquimia y aventura', 2001, '978-1-59116-920-4', 192, 'Español', 'finalizada', 1, 9990.00, 20, 5, 'https://example.com/fma1.jpg', NOW(), NOW(), 1),
('MNG009', 'Jujutsu Kaisen Vol. 1', '呪術廻戦', 'Gege Akutami', 'Gege Akutami', 'Hechicería y maldiciones', 2018, '978-1-9747-1004-3', 192, 'Español', 'en_curso', 1, 8990.00, 45, 5, 'https://example.com/jjk1.jpg', NOW(), NOW(), 1),
('MNG010', 'Chainsaw Man Vol. 1', 'チェンソーマン', 'Tatsuki Fujimoto', 'Tatsuki Fujimoto', 'Demonios y motosierras', 2018, '978-1-9747-1654-0', 192, 'Español', 'finalizada', 1, 10990.00, 38, 5, 'https://example.com/csm1.jpg', NOW(), NOW(), 1),
('MNG011', 'Spy x Family Vol. 1', 'スパイファミリー', 'Tatsuya Endo', 'Tatsuya Endo', 'Una familia de espías', 2019, '978-1-9747-1583-3', 216, 'Español', 'en_curso', 1, 9990.00, 70, 5, 'https://example.com/spyxfamily1.jpg', NOW(), NOW(), 1),
('MNG012', 'Bleach Vol. 1', 'ブリーチ', 'Tite Kubo', 'Tite Kubo', 'Shinigamis y Hollows', 2001, '978-1-59116-441-4', 200, 'Español', 'finalizada', 1, 8990.00, 32, 5, 'https://example.com/bleach1.jpg', NOW(), NOW(), 1),
('MNG013', 'One Punch Man Vol. 1', 'ワンパンマン', 'ONE', 'Yusuke Murata', 'El héroe más fuerte', 2012, '978-1-4215-7075-8', 200, 'Español', 'en_curso', 1, 9990.00, 42, 5, 'https://example.com/opm1.jpg', NOW(), NOW(), 1),
('MNG014', 'Dragon Ball Vol. 1', 'ドラゴンボール', 'Akira Toriyama', 'Akira Toriyama', 'La búsqueda de las esferas del dragón', 1984, '978-1-56931-754-2', 192, 'Español', 'finalizada', 1, 7990.00, 28, 5, 'https://example.com/dragonball1.jpg', NOW(), NOW(), 1),
('MNG015', 'Hunter x Hunter Vol. 1', 'ハンター×ハンター', 'Yoshihiro Togashi', 'Yoshihiro Togashi', 'Gon en busca de su padre', 1998, '978-1-59116-785-9', 200, 'Español', 'en_curso', 1, 9990.00, 33, 5, 'https://example.com/hxh1.jpg', NOW(), NOW(), 1);

-- Relación manga-categoría
INSERT INTO manga_categorias (manga_id, categorias_id) VALUES
(1, 1), (1, 6),  -- One Piece: Shonen, Acción
(2, 1), (2, 6),  -- Naruto: Shonen, Acción
(3, 1), (3, 6),  -- Attack on Titan: Shonen, Acción
(4, 2),          -- Death Note: Seinen
(5, 1), (5, 6),  -- My Hero Academia: Shonen, Acción
(6, 1), (6, 6),  -- Demon Slayer: Shonen, Acción
(7, 2),          -- Tokyo Ghoul: Seinen
(8, 1), (8, 6),  -- FMA: Shonen, Acción
(9, 1), (9, 6),  -- Jujutsu Kaisen: Shonen, Acción
(10, 2),         -- Chainsaw Man: Seinen
(11, 1), (11, 7),-- Spy x Family: Shonen, Romance
(12, 1), (12, 6),-- Bleach: Shonen, Acción
(13, 2), (13, 6),-- One Punch Man: Seinen, Acción
(14, 1), (14, 6),-- Dragon Ball: Shonen, Acción
(15, 1), (15, 6);-- Hunter x Hunter: Shonen, Acción
