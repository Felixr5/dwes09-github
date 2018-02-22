-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-02-2018 a las 10:49:33
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `catalogo09`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `albums`
--

CREATE TABLE `albums` (
  `ID_ALBUM` int(11) NOT NULL,
  `ID_AUTOR` int(11) NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `AÑO` date NOT NULL,
  `NUM_CANCIONES` int(2) NOT NULL,
  `PORTADA` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `albums`
--

INSERT INTO `albums` (`ID_ALBUM`, `ID_AUTOR`, `NOMBRE`, `AÑO`, `NUM_CANCIONES`, `PORTADA`) VALUES
(1, 14, '2Pacalypse Now', '1991-09-12', 13, '2PacalypseNow.jpg'),
(2, 14, 'Strictly 4 My N.I.G.G.A.Z...', '1993-02-16', 16, ''),
(3, 14, 'Me Against the World', '1995-03-14', 15, ''),
(4, 14, 'All Eyez on Me', '1996-02-13', 27, ''),
(5, 14, 'The Don Killuminati: The 7 Day Theory', '1996-10-05', 12, ''),
(6, 14, 'R U Still Down? (Remember Me)', '1997-10-25', 26, ''),
(7, 13, 'Cheshire Cat', '1997-02-17', 16, ''),
(8, 13, 'Dude Ranch', '1997-06-19', 15, ''),
(9, 13, 'Enema of the State', '1999-06-01', 12, ''),
(10, 13, 'Take Off Your Pants and Jacket', '2001-06-12', 13, ''),
(11, 13, 'Blink-182', '2003-10-18', 14, ''),
(12, 12, 'Wild World', '2016-09-09', 14, ''),
(13, 12, 'Bad Blood', '2013-03-04', 12, 'BadBlood.jpg'),
(14, 11, 'Dangerously in Love', '2003-06-22', 15, ''),
(15, 11, 'B\'Day', '2006-09-04', 10, ''),
(16, 11, 'I Am... Sasha Fierce', '2008-10-14', 11, ''),
(17, 11, 'BEYONCÉ', '2013-12-13', 14, ''),
(18, 11, 'Lemonade', '2016-04-23', 12, ''),
(19, 11, '4', '2011-06-24', 12, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autores`
--

CREATE TABLE `autores` (
  `ID_AUTOR` int(11) NOT NULL,
  `NOMBRE` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `A_NACIMIENTO` date DEFAULT NULL,
  `A_CREACION` int(4) DEFAULT NULL,
  `NACIONALIDAD` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NACIONALIDAD2` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FOTO` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `autores`
--

INSERT INTO `autores` (`ID_AUTOR`, `NOMBRE`, `A_NACIMIENTO`, `A_CREACION`, `NACIONALIDAD`, `NACIONALIDAD2`, `FOTO`) VALUES
(1, 'Linkin Park', NULL, 1996, 'Estadounidense', NULL, 'LP.jpg'),
(2, 'Nicki Minaj', '1982-12-08', NULL, 'Trinitense', 'Estadounidense', 'Nicki.jpg'),
(3, 'Charlie Puth', '1991-12-02', NULL, 'Estadounidense', NULL, 'Puth.jpg'),
(4, 'Lady Gaga', '1986-03-28', NULL, 'Estadounidense', NULL, 'Gaga.jpg'),
(5, 'Ed Sheeran', '1991-02-17', NULL, 'Británica', NULL, 'Sheeran.jpg'),
(6, 'Michael Jackson', '1958-08-29', NULL, 'Estadounidense', NULL, 'MJ.jpg'),
(7, 'Eminem', '1972-10-19', NULL, 'Estadounidense', NULL, 'Eminem.jpg'),
(8, 'System of a Down', NULL, 1994, 'Estadounidense', NULL, 'System.jpg'),
(9, 'Rihanna', '1988-02-20', NULL, 'Barbadense', 'Estadounidense', 'Rihanna.jpg'),
(10, 'Sum 41', NULL, 1996, 'Canadiense', NULL, 'Sum41.jpg'),
(11, 'Beyoncé', '1981-09-04', NULL, 'Estadounidense', NULL, 'Beyonce.jpg'),
(12, 'Bastille', NULL, 2010, 'Británica', NULL, 'Bastille.jpg'),
(13, 'blink-182', NULL, 1992, 'Estadounidense', NULL, 'Blink.jpg'),
(14, '2Pac', '1971-06-16', NULL, 'Estadounidense', NULL, 'Tupac.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canciones`
--

CREATE TABLE `canciones` (
  `ID_CANCION` int(11) NOT NULL,
  `ID_ALBUM` int(11) NOT NULL,
  `NOMBRE` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `ID_AUTOR` int(11) NOT NULL,
  `DURACION` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `canciones`
--

INSERT INTO `canciones` (`ID_CANCION`, `ID_ALBUM`, `NOMBRE`, `ID_AUTOR`, `DURACION`) VALUES
(1, 13, 'Fake It', 12, 4.04),
(2, 1, 'If My Homie Calls', 14, 4.18),
(3, 18, 'Pray You Catch Me', 11, 3.16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `login` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `descripcion` text COLLATE utf8_spanish_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`login`, `password`, `nombre`, `admin`, `descripcion`) VALUES
('admin', 'admin', 'Félix Rojo', 1, NULL),
('usuario', 'usuario', 'Usuario', 0, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `albums`
--
ALTER TABLE `albums`
  ADD PRIMARY KEY (`ID_ALBUM`),
  ADD KEY `FK_AUTOR3` (`ID_AUTOR`);

--
-- Indices de la tabla `autores`
--
ALTER TABLE `autores`
  ADD PRIMARY KEY (`ID_AUTOR`),
  ADD UNIQUE KEY `NOMBRE` (`NOMBRE`);

--
-- Indices de la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD PRIMARY KEY (`ID_CANCION`),
  ADD KEY `ID_ALBUM` (`ID_ALBUM`),
  ADD KEY `FK_aut` (`ID_AUTOR`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`login`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `albums`
--
ALTER TABLE `albums`
  MODIFY `ID_ALBUM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `autores`
--
ALTER TABLE `autores`
  MODIFY `ID_AUTOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `canciones`
--
ALTER TABLE `canciones`
  MODIFY `ID_CANCION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `albums`
--
ALTER TABLE `albums`
  ADD CONSTRAINT `FK_AUTOR3` FOREIGN KEY (`ID_AUTOR`) REFERENCES `autores` (`ID_AUTOR`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD CONSTRAINT `FK_ALBUM` FOREIGN KEY (`ID_ALBUM`) REFERENCES `albums` (`ID_ALBUM`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_aut` FOREIGN KEY (`ID_AUTOR`) REFERENCES `autores` (`ID_AUTOR`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
