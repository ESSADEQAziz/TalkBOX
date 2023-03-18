-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 16 mars 2023 à 00:06
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `talkbox`
--

-- --------------------------------------------------------

--
-- Structure de la table `tstatus`
--

CREATE TABLE `tstatus` (
  `status_id` int(11) NOT NULL,
  `status` varchar(70) DEFAULT NULL,
  `status_userid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `tstatus`
--

INSERT INTO `tstatus` (`status_id`, `status`, `status_userid`) VALUES
(1, 'This is aziz status', 1),
(2, 'Vivre avec dignité ou mort.', 2),
(3, 'En travail !', 3),
(4, 'Hello there !', 6);

-- --------------------------------------------------------

--
-- Structure de la table `tuser`
--

CREATE TABLE `tuser` (
  `userid` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `age` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `token` int(11) NOT NULL DEFAULT 0,
  `last_connection` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `tuser`
--

INSERT INTO `tuser` (`userid`, `username`, `password`, `email`, `age`, `date_creation`, `token`, `last_connection`) VALUES
(1, 'aziz', 'aziz123', 'aziz.essadeq@gmail.com', 23, '2023-03-01', 1, '00:05:55'),
(2, 'ayoub', 'ayoub123', 'ayoub.essadeq@gmail.com', 26, '2023-03-01', 1, '23:44:34'),
(3, 'youssef', 'youssef123', 'youssef.essadeq@gmail.com', 20, '2023-03-01', 1, '23:44:39'),
(4, 'fatima', 'fatima123', 'fatima.essadeq@gmail.com', 14, '2023-03-01', 1, '15:35:00'),
(6, 'omar', 'omar123', 'omar.essadeq@gmail.com', 12, '2023-03-01', 1, '00:00:00'),
(7, 'test', 'test123', 'test.test@gmail.com', 18, '2023-03-02', 0, '00:00:00'),
(20, 'test22', 'test2123', 'aziz.essadeq@gmail.com', 44, '2023-03-02', 1, '23:43:29');

-- --------------------------------------------------------

--
-- Structure de la table `user_image`
--

CREATE TABLE `user_image` (
  `image_id` int(11) NOT NULL,
  `image_name` varchar(60) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `user_image`
--

INSERT INTO `user_image` (`image_id`, `image_name`, `user_id`) VALUES
(1, 'brouda.jpg', 2),
(3, '7.jpg', 20),
(4, 'Aziz.png', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `tstatus`
--
ALTER TABLE `tstatus`
  ADD PRIMARY KEY (`status_id`),
  ADD KEY `tstatus_ibfk_1` (`status_userid`);

--
-- Index pour la table `tuser`
--
ALTER TABLE `tuser`
  ADD PRIMARY KEY (`userid`);

--
-- Index pour la table `user_image`
--
ALTER TABLE `user_image`
  ADD PRIMARY KEY (`image_id`),
  ADD KEY `user_image_ibfk_1` (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `tstatus`
--
ALTER TABLE `tstatus`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `tuser`
--
ALTER TABLE `tuser`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `user_image`
--
ALTER TABLE `user_image`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `tstatus`
--
ALTER TABLE `tstatus`
  ADD CONSTRAINT `tstatus_ibfk_1` FOREIGN KEY (`status_userid`) REFERENCES `tuser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `user_image`
--
ALTER TABLE `user_image`
  ADD CONSTRAINT `user_image_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tuser` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
