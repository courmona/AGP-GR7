-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.6.32-log - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour voyage
CREATE DATABASE IF NOT EXISTS `voyage` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `voyage`;

-- Export de la structure de la table voyage. activites
CREATE TABLE IF NOT EXISTS `activites` (
  `idActivites` int(11) NOT NULL AUTO_INCREMENT,
  `nomActivites` varchar(50) NOT NULL,
  `prixActivites` int(100) NOT NULL,
  PRIMARY KEY (`idActivites`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Export de données de la table voyage.activites : ~15 rows (environ)
DELETE FROM `activites`;
/*!40000 ALTER TABLE `activites` DISABLE KEYS */;
INSERT INTO `activites` (`idActivites`, `nomActivites`, `prixActivites`) VALUES
	(1, 'Croisiere et decouverte ', 18),
	(2, 'Segway eu foret', 25),
	(3, 'vol eu parapeute', 45),
	(5, 'Survol eu LILM', 90),
	(6, 'Churte libre', 60),
	(7, 'Canioning', 25),
	(8, 'VTT', 10),
	(9, 'Excurssion(moto)', 25),
	(10, 'Jeux d\'actions', 10),
	(11, 'Massage et détente', 30),
	(12, 'Plangée sous marine', 50),
	(13, 'kayak mer ', 50),
	(14, 'Jet ski', 30),
	(15, 'Cirque de Cilaos', 20),
	(16, 'Acqua Parc', 20);
/*!40000 ALTER TABLE `activites` ENABLE KEYS */;

-- Export de la structure de la table voyage. client
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nbJourSejour` int(11) NOT NULL DEFAULT '0',
  `nomClient` varchar(50) DEFAULT NULL,
  `budget` varchar(50) DEFAULT NULL,
  `varThematique` varchar(50) DEFAULT NULL,
  `confort` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.client : ~2 rows (environ)
DELETE FROM `client`;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`idClient`, `nbJourSejour`, `nomClient`, `budget`, `varThematique`, `confort`) VALUES
	(1, 5, 'Alex ', '3000', NULL, 'confortable'),
	(2, 4, 'anne', '1000', NULL, 'non confortable');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Export de la structure de la table voyage. destination
CREATE TABLE IF NOT EXISTS `destination` (
  `idDestination` int(11) NOT NULL AUTO_INCREMENT,
  `nomDestination` varchar(50) NOT NULL,
  PRIMARY KEY (`idDestination`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.destination : ~0 rows (environ)
DELETE FROM `destination`;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` (`idDestination`, `nomDestination`) VALUES
	(1, 'Ile de la Réunion');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;

-- Export de la structure de la table voyage. hotel
CREATE TABLE IF NOT EXISTS `hotel` (
  `idHotel` int(11) NOT NULL AUTO_INCREMENT,
  `nomHotel` varchar(50) DEFAULT '0',
  `prixNuit` int(11) DEFAULT '0',
  `villeHotel` varchar(50) DEFAULT '0',
  `classement` varchar(50) DEFAULT '0',
  PRIMARY KEY (`idHotel`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.hotel : ~12 rows (environ)
DELETE FROM `hotel`;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` (`idHotel`, `nomHotel`, `prixNuit`, `villeHotel`, `classement`) VALUES
	(1, 'Luse Reunion', 275, 'saint Gilles les Bains', '5 '),
	(2, 'Palm Hotel et SPA', 210, 'Petite ile', '5'),
	(3, 'Akoya et SPA', 180, 'Les Saline les Bains', '5'),
	(4, 'Lodje Roche Tamarin et SPA', 210, 'La Possession', '4'),
	(5, 'Ville Angelique', 120, 'Saint Denid', '4'),
	(6, 'Hotel Mercure Grealia', 115, 'Saint Denid', '4'),
	(7, 'Les Juliettes Dodu', 111, 'Saint Denid', '3'),
	(8, 'Les Battant des Laures', 100, 'Saint Pierre', '3'),
	(9, 'Les Neiges', 95, 'Gilaos', '3'),
	(10, 'Le Nautile Beachfont', 161, 'Les Saline les Bains', '3'),
	(11, 'Dina Morgabine', 93, 'Les Saline les Bains', '3'),
	(12, 'Alamanda', 84, 'saint Gilles les Bains', '2');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;

-- Export de la structure de la table voyage. hotelactivites
CREATE TABLE IF NOT EXISTS `hotelactivites` (
  `idHotel` int(11) NOT NULL,
  `idActivites` int(11) NOT NULL,
  KEY `FK_activitesclient_hotel` (`idHotel`),
  KEY `FK_activitesclient_activites` (`idActivites`),
  CONSTRAINT `FK_activitesclient_activites` FOREIGN KEY (`idActivites`) REFERENCES `activites` (`idActivites`),
  CONSTRAINT `FK_activitesclient_hotel` FOREIGN KEY (`idHotel`) REFERENCES `hotel` (`idHotel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table voyage.hotelactivites : ~2 rows (environ)
DELETE FROM `hotelactivites`;
/*!40000 ALTER TABLE `hotelactivites` DISABLE KEYS */;
INSERT INTO `hotelactivites` (`idHotel`, `idActivites`) VALUES
	(1, 6),
	(1, 8);
/*!40000 ALTER TABLE `hotelactivites` ENABLE KEYS */;

-- Export de la structure de la table voyage. site
CREATE TABLE IF NOT EXISTS `site` (
  `idSite` int(11) NOT NULL AUTO_INCREMENT,
  `nomSite` varchar(50) NOT NULL DEFAULT '0',
  `villeSite` varchar(50) NOT NULL DEFAULT '0',
  `idTransport` int(11) DEFAULT '0',
  PRIMARY KEY (`idSite`),
  KEY `FK_site_transport` (`idTransport`),
  CONSTRAINT `FK_site_transport` FOREIGN KEY (`idTransport`) REFERENCES `transport` (`idTransport`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.site : ~17 rows (environ)
DELETE FROM `site`;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` (`idSite`, `nomSite`, `villeSite`, `idTransport`) VALUES
	(1, 'Cap Noir', 'La Possession', 0),
	(2, 'La Roche Merveilleuse', 'Cilaos', 0),
	(3, 'Plaine de Sables', 'Sainte Rose', 0),
	(4, 'Grand Bassin', 'Le tempon', 0),
	(5, 'Grand Etang', 'Saint Benois', 0),
	(6, 'Plage de Saint Pierre', 'Saint Pierre ', 0),
	(7, 'Pas de Bellecombe', 'Sainte Rose', 0),
	(8, 'Montagne Piton des Neiges', 'Cilaos', 0),
	(9, 'Cascade Blanche', 'Salazie', 0),
	(10, 'Belvedere de Bois court', 'Tampon', 0),
	(11, 'Plage de Saint Leu', 'Saint Leu', 0),
	(12, 'Plage de l\'hermitage Aqua Parc', 'Saint Paul', 0),
	(13, 'Montagne des trois Salazes', 'Cilaos', 0),
	(14, 'Temple Kali Kampal', 'Saint Denis', 0),
	(15, 'Jardin de l\'Etat', 'Saint Denis', 0),
	(16, 'Port de Saint Pierre', 'Saint Pierre', 0),
	(17, 'Notre Dame De l\'Assomption', 'Salazie', 0);
/*!40000 ALTER TABLE `site` ENABLE KEYS */;

-- Export de la structure de la table voyage. transport
CREATE TABLE IF NOT EXISTS `transport` (
  `idTransport` int(11) NOT NULL AUTO_INCREMENT,
  `moyenDeTransport` varchar(50) DEFAULT NULL,
  `prixTransport` int(100) NOT NULL,
  PRIMARY KEY (`idTransport`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Export de données de la table voyage.transport : ~2 rows (environ)
DELETE FROM `transport`;
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
INSERT INTO `transport` (`idTransport`, `moyenDeTransport`, `prixTransport`) VALUES
	(3, 'Autobus', 10),
	(4, 'Bateau', 60);
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
