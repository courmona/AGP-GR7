-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 17 Janvier 2018 à 14:47
-- Version du serveur :  5.7.20-0ubuntu0.16.04.1
-- Version de PHP :  7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `voyage`
--

-- --------------------------------------------------------

--
-- Structure de la table `activites`
--

CREATE TABLE `activites` (
  `idActivites` int(11) NOT NULL,
  `nomActivites` varchar(50) NOT NULL,
  `prixActivites` int(100) NOT NULL,
  `idClient` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `activites`
--

INSERT INTO `activites` (`idActivites`, `nomActivites`, `prixActivites`, `idClient`) VALUES
(1, 'Croisiere et decouverte ', 18, 1),
(2, 'Segway eu foret', 25, 1),
(3, 'vol eu parapeute', 45, 2),
(5, 'Survol eu LILM', 90, 1),
(6, 'Churte libre', 60, 1),
(7, 'Canioning', 25, 1),
(8, 'VTT', 10, 2),
(9, 'Excurssion(moto)', 25, 2),
(10, 'Jeux d\'actions', 10, 1),
(11, 'Massage et détente', 30, 2),
(12, 'Plangée sous marine', 50, 2),
(13, 'kayak mer ', 50, 2),
(14, 'Jet ski', 30, 1),
(15, 'Cirque de Cilaos', 20, 2),
(16, 'Acqua Parc', 20, 2);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nbJourSejour` int(11) NOT NULL DEFAULT '0',
  `idVoyage` int(11) NOT NULL DEFAULT '0',
  `nomClient` varchar(50) DEFAULT NULL,
  `budget` varchar(50) DEFAULT NULL,
  `varThematique` varchar(50) DEFAULT NULL,
  `confort` varchar(50) DEFAULT NULL,
  `activite` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `nbJourSejour`, `idVoyage`, `nomClient`, `budget`, `varThematique`, `confort`, `activite`) VALUES
(1, 5, 1, 'Alex ', '3000', NULL, 'confortable', 'sport'),
(2, 4, 2, 'anne', '1000', NULL, 'non confortable', 'massage');

-- --------------------------------------------------------

--
-- Structure de la table `destination`
--

CREATE TABLE `destination` (
  `idDestination` int(11) NOT NULL,
  `nomDestination` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `destination`
--

INSERT INTO `destination` (`idDestination`, `nomDestination`) VALUES
(1, 'Ile de la Réunion');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE `hotel` (
  `idHotel` int(11) NOT NULL,
  `nomHotel` varchar(50) DEFAULT '0',
  `prixNuit` varchar(11) DEFAULT '0',
  `villeHotel` varchar(50) DEFAULT '0',
  `classement` varchar(50) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `hotel`
--

INSERT INTO `hotel` (`idHotel`, `nomHotel`, `prixNuit`, `villeHotel`, `classement`) VALUES
(1, 'Luse Reunion', '275', 'saint Gilles les Bains', '5 '),
(2, 'Palm Hotel et SPA', '210', 'Petite ile', '5'),
(3, 'Akoya et SPA', '180', 'Les Saline les Bains', '5'),
(4, 'Lodje Roche Tamarin et SPA', '210', 'La Possession', '4'),
(5, 'Ville Angelique', '120', 'Saint Denid', '4'),
(6, 'Hotel Mercure Grealia', '115', 'Saint Denid', '4'),
(7, 'Les Juliettes Dodu', '111', 'Saint Denid', '3'),
(8, 'Les Battant des Laures', '100', 'Saint Pierre', '3'),
(9, 'Les Neiges', '95', 'Gilaos', '3'),
(10, 'Le Nautile Beachfont', '161', 'Les Saline les Bains', '3'),
(11, 'Dina Morgabine', '93', 'Les Saline les Bains', '3'),
(12, 'Alamanda', '84', 'saint Gilles les Bains', '2');

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

CREATE TABLE `site` (
  `idSite` int(11) NOT NULL,
  `nomSite` varchar(50) NOT NULL DEFAULT '0',
  `villeSite` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `site`
--

INSERT INTO `site` (`idSite`, `nomSite`, `villeSite`) VALUES
(1, 'Cap Noir', 'La Possession'),
(2, 'La Roche Merveilleuse', 'Cilaos'),
(3, 'Plaine de Sables', 'Sainte Rose'),
(4, 'Grand Bassin', 'Le tempon'),
(5, 'Grand Etang', 'Saint Benois'),
(6, 'Plage de Saint Pierre', 'Saint Pierre '),
(7, 'Pas de Bellecombe', 'Sainte Rose'),
(8, 'Montagne Piton des Neiges', 'Cilaos'),
(9, 'Cascade Blanche', 'Salazie'),
(10, 'Belvedere de Bois court', 'Tampon'),
(11, 'Plage de Saint Leu', 'Saint Leu'),
(12, 'Plage de l\'hermitage Aqua Parc', 'Saint Paul'),
(13, 'Montagne des trois Salazes', 'Cilaos'),
(14, 'Temple Kali Kampal', 'Saint Denis'),
(15, 'Jardin de l\'Etat', 'Saint Denis'),
(16, 'Port de Saint Pierre', 'Saint Pierre'),
(17, 'Notre Dame De l\'Assomption', 'Salazie');

-- --------------------------------------------------------

--
-- Structure de la table `transport`
--

CREATE TABLE `transport` (
  `idTransport` int(11) NOT NULL,
  `moyenDeTransport` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `transport`
--

INSERT INTO `transport` (`idTransport`, `moyenDeTransport`) VALUES
(1, 'Autobus'),
(2, 'Bateau');

-- --------------------------------------------------------

--
-- Structure de la table `voyage`
--

CREATE TABLE `voyage` (
  `idVoyage` int(11) NOT NULL,
  `idHotel` int(11) NOT NULL DEFAULT '0',
  `idDestination` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `voyage`
--

INSERT INTO `voyage` (`idVoyage`, `idHotel`, `idDestination`) VALUES
(1, 5, 1),
(2, 2, 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `activites`
--
ALTER TABLE `activites`
  ADD PRIMARY KEY (`idActivites`),
  ADD KEY `idClient` (`idClient`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`),
  ADD KEY `FK_client_voyage` (`idVoyage`);

--
-- Index pour la table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`idDestination`);

--
-- Index pour la table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`idHotel`);

--
-- Index pour la table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`idSite`);

--
-- Index pour la table `transport`
--
ALTER TABLE `transport`
  ADD PRIMARY KEY (`idTransport`);

--
-- Index pour la table `voyage`
--
ALTER TABLE `voyage`
  ADD PRIMARY KEY (`idVoyage`),
  ADD KEY `FK_voyage_destination` (`idDestination`),
  ADD KEY `FK_voyage_hotel` (`idHotel`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `activites`
--
ALTER TABLE `activites`
  MODIFY `idActivites` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `destination`
--
ALTER TABLE `destination`
  MODIFY `idDestination` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `idHotel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT pour la table `site`
--
ALTER TABLE `site`
  MODIFY `idSite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT pour la table `transport`
--
ALTER TABLE `transport`
  MODIFY `idTransport` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `voyage`
--
ALTER TABLE `voyage`
  MODIFY `idVoyage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_client_voyage` FOREIGN KEY (`idVoyage`) REFERENCES `voyage` (`idVoyage`);

--
-- Contraintes pour la table `voyage`
--
ALTER TABLE `voyage`
  ADD CONSTRAINT `FK_voyage_destination` FOREIGN KEY (`idDestination`) REFERENCES `destination` (`idDestination`),
  ADD CONSTRAINT `FK_voyage_hotel` FOREIGN KEY (`idHotel`) REFERENCES `hotel` (`idHotel`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
