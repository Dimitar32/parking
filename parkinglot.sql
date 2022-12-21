-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.11.0-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table parkinglot.cars
CREATE TABLE IF NOT EXISTS `cars` (
  `car_id` int(11) NOT NULL,
  `plate_num` varchar(50) NOT NULL,
  `place_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`car_id`),
  UNIQUE KEY `place_id` (`place_id`),
  CONSTRAINT `FK_cars_parking_places` FOREIGN KEY (`place_id`) REFERENCES `parking_places` (`place_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table parkinglot.parkings
CREATE TABLE IF NOT EXISTS `parkings` (
  `parking_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `city` varchar(50) NOT NULL DEFAULT '',
  `street` varchar(50) NOT NULL DEFAULT '',
  `zip` int(11) NOT NULL,
  PRIMARY KEY (`parking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table parkinglot.parking_places
CREATE TABLE IF NOT EXISTS `parking_places` (
  `place_id` int(11) NOT NULL AUTO_INCREMENT,
  `place_num` int(11) NOT NULL DEFAULT 0,
  `zone_id` int(11) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`place_id`),
  UNIQUE KEY `car_id` (`car_id`),
  KEY `FK_parking_places_parking_zones` (`zone_id`),
  CONSTRAINT `FK_parking_places_cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_parking_places_parking_zones` FOREIGN KEY (`zone_id`) REFERENCES `parking_zones` (`zone_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table parkinglot.parking_zones
CREATE TABLE IF NOT EXISTS `parking_zones` (
  `zone_id` int(11) NOT NULL AUTO_INCREMENT,
  `zone_name` varchar(50) NOT NULL,
  `parking_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`zone_id`),
  KEY `FK_parking_zones_parkings` (`parking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
