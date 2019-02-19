-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2018 at 10:54 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `register`
--

-- --------------------------------------------------------

--
-- Table structure for table `classregister`
--

CREATE TABLE `classregister` (
  `Student_number` int(20) NOT NULL,
  `Student_name` varchar(20) NOT NULL,
  `Student_surname` varchar(20) NOT NULL,
  `Student_subject` varchar(20) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classregister`
--

INSERT INTO `classregister` (`Student_number`, `Student_name`, `Student_surname`, `Student_subject`, `date`) VALUES
(90, 'Jnwd', 'ujihghfwi', 'iuewuw', '2018-08-22'),
(123, 'qe', 'qwe', 'qwe', '2018-08-01'),
(234, '564', '4654', '49884', '2018-08-22'),
(987, 'jhkhjk', 'iyheigf', 'ujhikgh', '2018-08-22'),
(1213, 'qe', 'qwe', 'qwe', '2018-08-01'),
(2343, 'kghkghj', 'iuhuoh', 'uygu', '2018-08-22'),
(5532, 'Jean', 'Wolf', 'uiohfow', '2018-08-22'),
(7988, 'Johnson', 'Michael', 'Gender Studies', '2018-08-22'),
(8099, 'OIHJwh', 'oeghjeh', 'eohgoekm', '2018-08-22'),
(9071, 'jlkjhjw', 'huoe', 'hygi', '2018-08-22'),
(79565, 'Ashley', 'iouwhd', 'rhghrgjfhkr', '2018-08-22');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('John', '1995'),
('Jean', '1996'),
('Michael', '6666');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classregister`
--
ALTER TABLE `classregister`
  ADD PRIMARY KEY (`Student_number`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `password` (`password`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
