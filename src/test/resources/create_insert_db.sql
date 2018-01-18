-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.7.20-log - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour voyage
CREATE DATABASE IF NOT EXISTS `voyage` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `voyage`;

-- Export de la structure de la table voyage. client
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nbJourSejour` int(11) NOT NULL DEFAULT '0',
  `idVoyage` int(11) NOT NULL DEFAULT '0',
  `nomClient` varchar(50) DEFAULT NULL,
  `budget` varchar(50) DEFAULT NULL,
  `varThematique` varchar(50) DEFAULT NULL,
  `confort` varchar(50) DEFAULT NULL,
  `activite` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  KEY `FK_client_voyage` (`idVoyage`),
  CONSTRAINT `FK_client_voyage` FOREIGN KEY (`idVoyage`) REFERENCES `voyage` (`idVoyage`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.client : ~2 rows (environ)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`idClient`, `nbJourSejour`, `idVoyage`, `nomClient`, `budget`, `varThematique`, `confort`, `activite`) VALUES
	(1, 5, 1, 'arij', '3000', NULL, 'confortable', 'sport'),
	(4, 4, 2, 'ali', '1000', NULL, 'non confortable', 'massage');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Export de la structure de la table voyage. destination
CREATE TABLE IF NOT EXISTS `destination` (
  `idDestination` int(11) NOT NULL AUTO_INCREMENT,
  `nomDestination` varchar(50) NOT NULL,
  PRIMARY KEY (`idDestination`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.destination : ~1 rows (environ)
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` (`idDestination`, `nomDestination`) VALUES
	(1, 'ile reunion');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;

-- Export de la structure de la table voyage. hotel
CREATE TABLE IF NOT EXISTS `hotel` (
  `idHotel` int(11) NOT NULL AUTO_INCREMENT,
  `nomHotel` varchar(50) DEFAULT '0',
  `prixNuit` int(11) DEFAULT '0',
  `villeHotel` varchar(50) DEFAULT '0',
  `classement` varchar(50) DEFAULT '0',
  PRIMARY KEY (`idHotel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.hotel : ~2 rows (environ)
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` (`idHotel`, `nomHotel`, `prixNuit`, `villeHotel`, `classement`) VALUES
	(1, 'luse reunion', 275, 'saint gilles', '5'),
	(2, 'palm hotel et spa', 210, 'petite ile', '3');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;

-- Export de la structure de la table voyage. site
CREATE TABLE IF NOT EXISTS `site` (
  `idSite` int(11) NOT NULL AUTO_INCREMENT,
  `nomSite` varchar(50) NOT NULL DEFAULT '0',
  `villeSite` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idSite`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.site : ~1 rows (environ)
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` (`idSite`, `nomSite`, `villeSite`) VALUES
	(1, 'louvre', 'paris');
/*!40000 ALTER TABLE `site` ENABLE KEYS */;

-- Export de la structure de la table voyage. transport
CREATE TABLE IF NOT EXISTS `transport` (
  `idTransport` int(11) NOT NULL AUTO_INCREMENT,
  `moyenDeTransport` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idTransport`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.transport : ~2 rows (environ)
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
INSERT INTO `transport` (`idTransport`, `moyenDeTransport`) VALUES
	(1, 'autobus'),
	(2, 'bateau');
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;

-- Export de la structure de la table voyage. voyage
CREATE TABLE IF NOT EXISTS `voyage` (
  `idVoyage` int(11) NOT NULL AUTO_INCREMENT,
  `idHotel` int(11) NOT NULL DEFAULT '0',
  `idDestination` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idVoyage`),
  KEY `FK_voyage_destination` (`idDestination`),
  KEY `FK_voyage_hotel` (`idHotel`),
  CONSTRAINT `FK_voyage_destination` FOREIGN KEY (`idDestination`) REFERENCES `destination` (`idDestination`),
  CONSTRAINT `FK_voyage_hotel` FOREIGN KEY (`idHotel`) REFERENCES `hotel` (`idHotel`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.voyage : ~2 rows (environ)
/*!40000 ALTER TABLE `voyage` DISABLE KEYS */;
INSERT INTO `voyage` (`idVoyage`, `idHotel`, `idDestination`) VALUES
	(1, 1, 1),
	(2, 2, 1);
/*!40000 ALTER TABLE `voyage` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
