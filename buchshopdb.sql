SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `buchshopdb`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `buch`
--

CREATE TABLE IF NOT EXISTS `buch` (
  `AID` int(11) NOT NULL,
  `ArtikelNummer` varchar(10) NOT NULL,
  `Titel` varchar(30) NOT NULL,
  `Author` varchar(30) NOT NULL,
  `Verlag` varchar(30) NOT NULL,
  `Erscheinungsjahr` int(11) NOT NULL,
  `Sprache` varchar(20) NOT NULL,
  `Genre` varchar(20) NOT NULL,
  `Seitenanzahl` int(11) NOT NULL,
  `CoverArt` varchar(20) NOT NULL,
  `Preis` double(10,2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `buch`
--



-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `hoerbuch`
--

CREATE TABLE IF NOT EXISTS `hoerbuch` (
  `AID` int(11) NOT NULL,
  `ArtikelNummer` varchar(10) NOT NULL,
  `Titel` varchar(30) NOT NULL,
  `Author` varchar(30) NOT NULL,
  `Verlag` varchar(30) NOT NULL,
  `Erscheinungsjahr` int(11) NOT NULL,
  `Sprache` varchar(20) NOT NULL,
  `Genre` varchar(20) NOT NULL,
  `Dauer` int(11) NOT NULL,
  `Format` varchar(20) NOT NULL,
  `Preis` double(10,2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `hoerbuch`
--



-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kunde`
--

CREATE TABLE IF NOT EXISTS `kunde` (
  `Knr` int(11) NOT NULL,
  `Nachname` varchar(30) NOT NULL,
  `Vorname` varchar(30) NOT NULL,
  `eMail` varchar(30) NOT NULL,
  `Strasse` varchar(30) NOT NULL,
  `Hausnummer` int(11) NOT NULL,
  `PLZ` int(11) NOT NULL,
  `Ort` varchar(30) NOT NULL,
  `Land` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `kunde`
--

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `buch`
--
ALTER TABLE `buch`
  ADD PRIMARY KEY (`AID`);

--
-- Indizes für die Tabelle `hoerbuch`
--
ALTER TABLE `hoerbuch`
  ADD PRIMARY KEY (`AID`);

--
-- Indizes für die Tabelle `kunde`
--
ALTER TABLE `kunde`
  ADD PRIMARY KEY (`Knr`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `buch`
--
ALTER TABLE `buch`
  MODIFY `AID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT für Tabelle `hoerbuch`
--
ALTER TABLE `hoerbuch`
  MODIFY `AID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT für Tabelle `kunde`
--
ALTER TABLE `kunde`
  MODIFY `Knr` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
