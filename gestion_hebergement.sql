-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 13 juil. 2020 à 18:02
-- Version du serveur :  10.1.31-MariaDB
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_hebergement`
--

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

CREATE TABLE `affectation` (
  `nquittance` int(11) NOT NULL,
  `npavillon` int(11) NOT NULL,
  `nchambre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `affectation`
--

INSERT INTO `affectation` (`nquittance`, `npavillon`, `nchambre`) VALUES
(1001, 1, 50),
(1002, 1, 50),
(2001, 2, 61),
(3001, 3, 72),
(4001, 4, 83),
(5001, 5, 83),
(6001, 6, 83);

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `npavillon` int(11) DEFAULT NULL,
  `nchambre` int(11) NOT NULL,
  `nbplace` int(11) DEFAULT NULL,
  `nbplacedispo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`npavillon`, `nchambre`, `nbplace`, `nbplacedispo`) VALUES
(6, 32, 2, 1),
(5, 34, 4, 3),
(1, 50, 3, 0),
(2, 61, 3, 2),
(3, 72, 3, 2),
(4, 83, 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `netudiant` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `date_nai` date NOT NULL,
  `nquittance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`netudiant`, `nom`, `prenom`, `date_nai`, `nquittance`) VALUES
(90, 'fatima', 'zohta', '1998-11-12', 1001),
(95, 'fatima', 'zohra', '1999-03-01', 6001),
(100, 'fatima', 'derkaoui', '1998-10-10', 1001),
(201, 'derkaoui', 'fatima', '1998-04-24', 1001);

-- --------------------------------------------------------

--
-- Structure de la table `pavillon`
--

CREATE TABLE `pavillon` (
  `npavillon` int(11) NOT NULL,
  `nompavillon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pavillon`
--

INSERT INTO `pavillon` (`npavillon`, `nompavillon`) VALUES
(1, 'sm'),
(2, 'mi'),
(3, 'st'),
(4, 'soc'),
(5, 'ISMk'),
(6, 'ISM'),
(7, 'ISMK'),
(8, 'SC'),
(9, 'F1'),
(20, 'mm'),
(30, 'Gk'),
(31, 'LI'),
(115, 'F15'),
(116, 'MATH'),
(117, 'MATH');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`nquittance`),
  ADD KEY `nchambre` (`nchambre`),
  ADD KEY `npavillon` (`npavillon`) USING BTREE;

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`nchambre`),
  ADD KEY `npavillon` (`npavillon`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`netudiant`),
  ADD KEY `nquittance` (`nquittance`);

--
-- Index pour la table `pavillon`
--
ALTER TABLE `pavillon`
  ADD PRIMARY KEY (`npavillon`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD CONSTRAINT `affectation_ibfk_1` FOREIGN KEY (`npavillon`) REFERENCES `pavillon` (`npavillon`),
  ADD CONSTRAINT `affectation_ibfk_2` FOREIGN KEY (`nchambre`) REFERENCES `chambre` (`nchambre`);

--
-- Contraintes pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `chambre_ibfk_1` FOREIGN KEY (`npavillon`) REFERENCES `pavillon` (`npavillon`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`nquittance`) REFERENCES `affectation` (`nquittance`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
