-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2025 at 04:01 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mangastore`
--

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `activo` tinyint(4) DEFAULT 1,
  `contenido` tinytext NOT NULL,
  `descripcion_corta` varchar(300) DEFAULT NULL,
  `fecha_publicacion` datetime(6) DEFAULT current_timestamp(6),
  `imagen` varchar(255) DEFAULT NULL,
  `titulo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`id`, `activo`, `contenido`, `descripcion_corta`, `fecha_publicacion`, `imagen`, `titulo`) VALUES
(1, 1, 'Este es el contenido completo del blog donde explicamos en detalle las novedades del sector tecnológico...', 'Una breve descripción sobre las tendencias más recientes en tecnología.', '2025-10-05 23:20:00.000000', 'https://miservidor.com/imagenes/tech2025.png', 'Nuevo artículo de tecnología');

-- --------------------------------------------------------

--
-- Table structure for table `carrito`
--

CREATE TABLE `carrito` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT 1,
  `fecha_agregado` datetime(6) DEFAULT current_timestamp(6),
  `manga_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `activo` tinyint(4) DEFAULT 1,
  `descripcion` tinytext DEFAULT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`id`, `activo`, `descripcion`, `nombre`) VALUES
(1, 1, 'Manga dirigido a un público juvenil masculino', 'Shonen'),
(2, 1, 'Manga para adultos jóvenes', 'Seinen'),
(3, 1, 'Manga dirigido a un público juvenil femenino', 'Shojo'),
(4, 1, 'Manga para niños', 'Kodomo'),
(5, 1, 'Historias de mundos alternativos', 'Isekai'),
(6, 1, 'Manga de acción y aventura', 'Acción'),
(7, 1, 'Historias románticas', 'Romance');

-- --------------------------------------------------------

--
-- Table structure for table `comentario`
--

CREATE TABLE `comentario` (
  `id` int(11) NOT NULL,
  `activo` tinyint(4) DEFAULT 1,
  `calificacion` int(11) DEFAULT NULL,
  `comentario` tinytext NOT NULL,
  `fecha_comentario` datetime(6) DEFAULT current_timestamp(6),
  `manga_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `comuna`
--

CREATE TABLE `comuna` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `configuracion`
--

CREATE TABLE `configuracion` (
  `id` int(11) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `valor` tinytext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `detallepedido`
--

CREATE TABLE `detallepedido` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `manga_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `editorial`
--

CREATE TABLE `editorial` (
  `id` int(11) NOT NULL,
  `activo` tinyint(4) DEFAULT 1,
  `nombre` varchar(100) NOT NULL,
  `pais` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `editorial`
--

INSERT INTO `editorial` (`id`, `activo`, `nombre`, `pais`) VALUES
(1, 1, 'Shueisha', 'Japón'),
(2, 1, 'Kodansha', 'Japón'),
(3, 1, 'Panini Comics', 'Chile');

-- --------------------------------------------------------

--
-- Table structure for table `favorito`
--

CREATE TABLE `favorito` (
  `id` int(11) NOT NULL,
  `fecha_agregado` datetime(6) DEFAULT current_timestamp(6),
  `manga_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `manga`
--

CREATE TABLE `manga` (
  `id` int(11) NOT NULL,
  `activo` tinyint(4) DEFAULT 1,
  `autor` varchar(100) NOT NULL,
  `año_publicacion` int(11) DEFAULT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` tinytext DEFAULT NULL,
  `estado_serie` tinytext DEFAULT 'en_curso',
  `fecha_actualizacion` datetime(6) DEFAULT current_timestamp(6),
  `fecha_creacion` datetime(6) DEFAULT current_timestamp(6),
  `idioma` varchar(20) DEFAULT 'Español',
  `ilustrador` varchar(100) DEFAULT NULL,
  `imagen_portada` varchar(255) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `paginas` int(11) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(11) DEFAULT 0,
  `stock_critico` int(11) DEFAULT 5,
  `titulo` varchar(200) NOT NULL,
  `titulo_original` varchar(200) DEFAULT NULL,
  `editorial_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manga`
--

INSERT INTO `manga` (`id`, `activo`, `autor`, `año_publicacion`, `codigo`, `descripcion`, `estado_serie`, `fecha_actualizacion`, `fecha_creacion`, `idioma`, `ilustrador`, `imagen_portada`, `isbn`, `paginas`, `precio`, `stock`, `stock_critico`, `titulo`, `titulo_original`, `editorial_id`) VALUES
(1, 1, 'Eiichiro Oda', 1997, 'MNG001', 'La aventura de Monkey D. Luffy en busca del One Piece', 'en_curso', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Eiichiro Oda', 'https://example.com/onepiece1.jpg', '978-1-56931-901-0', 200, 9990.00, 50, 5, 'One Piece Vol. 1', 'ワンピース', 1),
(2, 1, 'Masashi Kishimoto', 1999, 'MNG002', 'La historia del ninja Naruto Uzumaki', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Masashi Kishimoto', 'https://example.com/naruto1.jpg', '978-1-56931-900-3', 192, 8990.00, 40, 5, 'Naruto Vol. 1', 'ナルト', 1),
(3, 1, 'Hajime Isayama', 2009, 'MNG003', 'Humanidad vs Titanes', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Hajime Isayama', 'https://example.com/aot1.jpg', '978-1-61262-024-4', 194, 10990.00, 35, 5, 'Attack on Titan Vol. 1', '進撃の巨人', 2),
(4, 1, 'Tsugumi Ohba', 2003, 'MNG004', 'Un cuaderno que mata', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Takeshi Obata', 'https://example.com/deathnote1.jpg', '978-1-4215-0168-5', 200, 9990.00, 30, 5, 'Death Note Vol. 1', 'デスノート', 1),
(5, 1, 'Kohei Horikoshi', 2014, 'MNG005', 'Un mundo de superhéroes', 'en_curso', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Kohei Horikoshi', 'https://example.com/mha1.jpg', '978-1-4215-7321-6', 192, 8990.00, 60, 5, 'My Hero Academia Vol. 1', '僕のヒーローアカデミア', 1),
(6, 1, 'Koyoharu Gotouge', 2016, 'MNG006', 'Cazadores de demonios', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Koyoharu Gotouge', 'https://example.com/demonslayer1.jpg', '978-1-9747-0144-7', 192, 9990.00, 55, 5, 'Demon Slayer Vol. 1', '鬼滅の刃', 1),
(7, 1, 'Sui Ishida', 2011, 'MNG007', 'Humanos vs Ghouls', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Sui Ishida', 'https://example.com/tokyoghoul1.jpg', '978-1-4215-7087-1', 224, 10990.00, 25, 5, 'Tokyo Ghoul Vol. 1', '東京喰種', 1),
(8, 1, 'Hiromu Arakawa', 2001, 'MNG008', 'Alquimia y aventura', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Hiromu Arakawa', 'https://example.com/fma1.jpg', '978-1-59116-920-4', 192, 9990.00, 20, 5, 'Fullmetal Alchemist Vol. 1', '鋼の錬金術師', 1),
(9, 1, 'Gege Akutami', 2018, 'MNG009', 'Hechicería y maldiciones', 'en_curso', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Gege Akutami', 'https://example.com/jjk1.jpg', '978-1-9747-1004-3', 192, 8990.00, 45, 5, 'Jujutsu Kaisen Vol. 1', '呪術廻戦', 1),
(10, 1, 'Tatsuki Fujimoto', 2018, 'MNG010', 'Demonios y motosierras', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Tatsuki Fujimoto', 'https://example.com/csm1.jpg', '978-1-9747-1654-0', 192, 10990.00, 38, 5, 'Chainsaw Man Vol. 1', 'チェンソーマン', 1),
(11, 1, 'Tatsuya Endo', 2019, 'MNG011', 'Una familia de espías', 'en_curso', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Tatsuya Endo', 'https://example.com/spyxfamily1.jpg', '978-1-9747-1583-3', 216, 9990.00, 70, 5, 'Spy x Family Vol. 1', 'スパイファミリー', 1),
(12, 1, 'Tite Kubo', 2001, 'MNG012', 'Shinigamis y Hollows', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Tite Kubo', 'https://example.com/bleach1.jpg', '978-1-59116-441-4', 200, 8990.00, 32, 5, 'Bleach Vol. 1', 'ブリーチ', 1),
(13, 1, 'ONE', 2012, 'MNG013', 'El héroe más fuerte', 'en_curso', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Yusuke Murata', 'https://example.com/opm1.jpg', '978-1-4215-7075-8', 200, 9990.00, 42, 5, 'One Punch Man Vol. 1', 'ワンパンマン', 1),
(14, 1, 'Akira Toriyama', 1984, 'MNG014', 'La búsqueda de las esferas del dragón', 'finalizada', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Akira Toriyama', 'https://example.com/dragonball1.jpg', '978-1-56931-754-2', 192, 7990.00, 28, 5, 'Dragon Ball Vol. 1', 'ドラゴンボール', 1),
(15, 1, 'Yoshihiro Togashi', 1998, 'MNG015', 'Gon en busca de su padre', 'en_curso', '2025-10-21 22:30:28.000000', '2025-10-21 22:30:28.000000', 'Español', 'Yoshihiro Togashi', 'https://example.com/hxh1.jpg', '978-1-59116-785-9', 200, 9990.00, 33, 5, 'Hunter x Hunter Vol. 1', 'ハンター×ハンター', 1);

-- --------------------------------------------------------

--
-- Table structure for table `manga_categorias`
--

CREATE TABLE `manga_categorias` (
  `manga_id` int(11) NOT NULL,
  `categorias_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `manga_categorias`
--

INSERT INTO `manga_categorias` (`manga_id`, `categorias_id`) VALUES
(1, 1),
(1, 6),
(2, 1),
(2, 6),
(3, 1),
(3, 6),
(4, 2),
(5, 1),
(5, 6),
(6, 1),
(6, 6),
(7, 2),
(8, 1),
(8, 6),
(9, 1),
(9, 6),
(10, 2),
(11, 1),
(11, 7),
(12, 1),
(12, 6),
(13, 2),
(13, 6),
(14, 1),
(14, 6),
(15, 1),
(15, 6);

-- --------------------------------------------------------

--
-- Table structure for table `mensajecontacto`
--

CREATE TABLE `mensajecontacto` (
  `id` int(11) NOT NULL,
  `comentario` varchar(500) NOT NULL,
  `email` varchar(100) NOT NULL,
  `fecha_envio` datetime(6) DEFAULT current_timestamp(6),
  `leido` tinyint(4) DEFAULT 0,
  `nombre` varchar(100) NOT NULL,
  `respondido` tinyint(4) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `comuna_entrega` varchar(50) NOT NULL,
  `costo_envio` decimal(10,2) DEFAULT 0.00,
  `direccion_entrega` varchar(300) NOT NULL,
  `email_entrega` varchar(100) NOT NULL,
  `estado_pago` tinytext DEFAULT 'pendiente',
  `estado_pedido` tinytext DEFAULT 'pendiente',
  `fecha_pedido` datetime(6) DEFAULT current_timestamp(6),
  `metodo_pago` tinytext DEFAULT 'webpay',
  `nombre_entrega` varchar(150) NOT NULL,
  `notas` tinytext DEFAULT NULL,
  `orden_compra` varchar(50) NOT NULL,
  `region_entrega` varchar(50) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `telefono_entrega` varchar(20) DEFAULT NULL,
  `token_webpay` varchar(100) DEFAULT NULL,
  `total` decimal(10,2) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

CREATE TABLE `region` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `activo` tinyint(4) DEFAULT 1,
  `apellidos` varchar(100) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  `email` varchar(100) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT current_timestamp(6),
  `nombre` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `run` varchar(9) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `tipo_usuario` tinytext DEFAULT 'cliente',
  `created_by` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `activo`, `apellidos`, `direccion`, `email`, `fecha_nacimiento`, `fecha_registro`, `nombre`, `password`, `run`, `telefono`, `tipo_usuario`, `created_by`) VALUES
(1, 1, 'Sistema', 'Av. Principal 123', 'admin@mangastore.com', '1990-01-01', '2025-10-21 22:30:27.000000', 'Admin', 'admin123', '11111111-', '+56912345678', 'super-admin', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1g7cqxii73pvgwutbxs9qwowh` (`manga_id`),
  ADD KEY `FK8ymop2vbmxmjq6ehl5vj3hpqm` (`usuario_id`);

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhpjgkrna0hheljggywk62o9ba` (`manga_id`),
  ADD KEY `FKixspmid2pb85o8ypsd20jakxg` (`usuario_id`);

--
-- Indexes for table `comuna`
--
ALTER TABLE `comuna`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `configuracion`
--
ALTER TABLE `configuracion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1awul6v2k7eyc44r3a4v50dei` (`manga_id`);

--
-- Indexes for table `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `favorito`
--
ALTER TABLE `favorito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmt04xpl0pnm700l0opw3xnqnh` (`manga_id`),
  ADD KEY `FKtexs274tw5tyvj5uowwooa1fw` (`usuario_id`);

--
-- Indexes for table `manga`
--
ALTER TABLE `manga`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtfsoonuy0j5e1h89nn7ss3j6i` (`editorial_id`);

--
-- Indexes for table `manga_categorias`
--
ALTER TABLE `manga_categorias`
  ADD PRIMARY KEY (`manga_id`,`categorias_id`),
  ADD KEY `FKo6ejr3tqfg8u2f9saob46atfh` (`categorias_id`);

--
-- Indexes for table `mensajecontacto`
--
ALTER TABLE `mensajecontacto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6uxomgomm93vg965o8brugt00` (`usuario_id`);

--
-- Indexes for table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkkymwf8xy047tl0035rhlfpq5` (`created_by`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `carrito`
--
ALTER TABLE `carrito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `comentario`
--
ALTER TABLE `comentario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `comuna`
--
ALTER TABLE `comuna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `configuracion`
--
ALTER TABLE `configuracion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `detallepedido`
--
ALTER TABLE `detallepedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `editorial`
--
ALTER TABLE `editorial`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `favorito`
--
ALTER TABLE `favorito`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `manga`
--
ALTER TABLE `manga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `mensajecontacto`
--
ALTER TABLE `mensajecontacto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `region`
--
ALTER TABLE `region`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `FK1g7cqxii73pvgwutbxs9qwowh` FOREIGN KEY (`manga_id`) REFERENCES `manga` (`id`),
  ADD CONSTRAINT `FK8ymop2vbmxmjq6ehl5vj3hpqm` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `FKhpjgkrna0hheljggywk62o9ba` FOREIGN KEY (`manga_id`) REFERENCES `manga` (`id`),
  ADD CONSTRAINT `FKixspmid2pb85o8ypsd20jakxg` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD CONSTRAINT `FK1awul6v2k7eyc44r3a4v50dei` FOREIGN KEY (`manga_id`) REFERENCES `manga` (`id`);

--
-- Constraints for table `favorito`
--
ALTER TABLE `favorito`
  ADD CONSTRAINT `FKmt04xpl0pnm700l0opw3xnqnh` FOREIGN KEY (`manga_id`) REFERENCES `manga` (`id`),
  ADD CONSTRAINT `FKtexs274tw5tyvj5uowwooa1fw` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `manga`
--
ALTER TABLE `manga`
  ADD CONSTRAINT `FKtfsoonuy0j5e1h89nn7ss3j6i` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`id`) ON DELETE SET NULL;

--
-- Constraints for table `manga_categorias`
--
ALTER TABLE `manga_categorias`
  ADD CONSTRAINT `FK8fnlkrvyfwd8622l8ys9pwdb7` FOREIGN KEY (`manga_id`) REFERENCES `manga` (`id`),
  ADD CONSTRAINT `FKo6ejr3tqfg8u2f9saob46atfh` FOREIGN KEY (`categorias_id`) REFERENCES `categoria` (`id`);

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK6uxomgomm93vg965o8brugt00` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FKkkymwf8xy047tl0035rhlfpq5` FOREIGN KEY (`created_by`) REFERENCES `usuario` (`id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
