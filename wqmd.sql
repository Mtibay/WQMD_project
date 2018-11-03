-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 03, 2018 at 01:56 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wqmd`
--

-- --------------------------------------------------------

--
-- Table structure for table `arduino_messages`
--

CREATE TABLE `arduino_messages` (
  `id` int(11) NOT NULL,
  `sender_number` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `date_received` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `calculated_device_data`
--

CREATE TABLE `calculated_device_data` (
  `cdd_id` int(11) NOT NULL,
  `sensor1_output` double NOT NULL,
  `sensor2_output` double NOT NULL,
  `sensor3_output` double NOT NULL,
  `date_created` char(19) NOT NULL DEFAULT '0000-00-00 00-00-00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `calculated_device_data`
--

INSERT INTO `calculated_device_data` (`cdd_id`, `sensor1_output`, `sensor2_output`, `sensor3_output`, `date_created`) VALUES
(54, 7, 0, 0, '2018-11-03 00-00-00'),
(55, 7, 7, 7, '2018-11-03 00-50-00'),
(56, 2, 4, 9, '2018-11-03 00-50-00'),
(57, 6, 5, 3, '0000-00-00 00-00-00'),
(58, 10.6, 11, 6, '0000-00-00 00-00-00'),
(59, 12.65, 5, 6, '0000-00-00 00-00-00'),
(60, 15, 11, 13, '0000-00-00 00-00-00'),
(61, 14.89, 6, 5.355, '2018-11-03 00-00-00'),
(62, 37.79, 5, 400.908, '2018-11-03 00-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `loc_id` int(11) NOT NULL,
  `loc_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `passcode` varchar(65) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `passcode`) VALUES
(1, 'admin123'),
(2, 'admin1234');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `sender` varchar(255) NOT NULL,
  `receiver` varchar(255) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `raw_device_data`
--

CREATE TABLE `raw_device_data` (
  `id` int(11) NOT NULL,
  `sensor_1` int(11) NOT NULL,
  `sensor_2` int(11) NOT NULL,
  `sensor_3` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `sensor1_reading` int(255) NOT NULL,
  `sensor2_reading` int(255) NOT NULL,
  `sensor3_reading` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `arduino_messages`
--
ALTER TABLE `arduino_messages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `calculated_device_data`
--
ALTER TABLE `calculated_device_data`
  ADD PRIMARY KEY (`cdd_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`loc_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `raw_device_data`
--
ALTER TABLE `raw_device_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `arduino_messages`
--
ALTER TABLE `arduino_messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `calculated_device_data`
--
ALTER TABLE `calculated_device_data`
  MODIFY `cdd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `loc_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `raw_device_data`
--
ALTER TABLE `raw_device_data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
