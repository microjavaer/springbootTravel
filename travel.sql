-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.23-log - MySQL Community Server (GPL)
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for travel
CREATE DATABASE IF NOT EXISTS `travel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `travel`;

-- Dumping structure for table travel.t_place
CREATE TABLE IF NOT EXISTS `t_place` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `picpath` mediumtext,
  `hottime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hotticket` double(7,2) DEFAULT NULL,
  `dimticket` double(7,2) DEFAULT NULL,
  `placedes` text,
  `provinceid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table travel.t_place: ~3 rows (大约)
DELETE FROM `t_place`;
/*!40000 ALTER TABLE `t_place` DISABLE KEYS */;
INSERT INTO `t_place` (`id`, `name`, `picpath`, `hottime`, `hotticket`, `dimticket`, `placedes`, `provinceid`) VALUES
	(2, '颐和园', 'D:/javaDir/images/478888e2-d783-46cf-9b2e-07e91cec2e5e.jpg', '2020-12-16 10:05:32', 100.00, 50.00, '颐和园历史悠久。。。', 5),
	(3, '颐和园', 'D:/javaDir/images/f38803b2-7f3a-40e5-b898-a8bd15b5d555.jpg', '2020-12-16 10:05:36', 100.00, 50.00, '颐和园历史悠久。。。', 5),
	(4, '武夷山', 'D:/javaDir/images/7deeeaa6-320a-49b7-8f91-d95aec5df76f.jpg', '2020-12-16 10:05:40', 300.00, 100.00, '武夷山大红袍全国闻名', 1),
	(5, '鼓浪屿', 'D:/javaDir/images/cb1b2f03-7e55-44c1-95a1-9e129a65de52.jpg', '2020-12-09 08:55:30', 100.00, 50.00, '鼓浪屿玩海', 1);
/*!40000 ALTER TABLE `t_place` ENABLE KEYS */;

-- Dumping structure for table travel.t_province
CREATE TABLE IF NOT EXISTS `t_province` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `tags` varchar(80) DEFAULT NULL,
  `placecounts` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table travel.t_province: ~3 rows (大约)
DELETE FROM `t_province`;
/*!40000 ALTER TABLE `t_province` DISABLE KEYS */;
INSERT INTO `t_province` (`id`, `name`, `tags`, `placecounts`) VALUES
	(1, '福建省', '大红袍，鼓浪屿', 2),
	(2, '上海市', '东方明珠，迪士尼', 2),
	(4, '江苏省', '天平山', 1),
	(5, '北京', '故宫', 5);
/*!40000 ALTER TABLE `t_province` ENABLE KEYS */;

-- Dumping structure for table travel.t_user
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table travel.t_user: ~2 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `username`, `password`, `email`) VALUES
	(1, '张三', '123', NULL),
	(5, 'admin', '123456', 'a@q.com');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
