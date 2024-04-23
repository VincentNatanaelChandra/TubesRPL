-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2023 at 02:26 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flightapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `cust_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `cust_id`) VALUES
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `Class_id` int(11) NOT NULL,
  `Class_name` varchar(20) DEFAULT NULL,
  `Class_price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`Class_id`, `Class_name`, `Class_price`) VALUES
(1, 'Economic', 300000),
(2, 'Business', 500000),
(3, 'First Class', 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cust_id` int(11) NOT NULL,
  `cust_name` varchar(55) DEFAULT NULL,
  `cust_password` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cust_id`, `cust_name`, `cust_password`) VALUES
(1, 'Vincent', 'Pingcen'),
(2, 'Steven', 'Tipeng'),
(3, 'Depot', 'Devid');

-- --------------------------------------------------------

--
-- Table structure for table `destination`
--

CREATE TABLE `destination` (
  `destination_id` int(11) NOT NULL,
  `destination_departure` varchar(25) DEFAULT NULL,
  `destination_arrival` varchar(25) DEFAULT NULL,
  `destination_departureDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destination`
--

INSERT INTO `destination` (`destination_id`, `destination_departure`, `destination_arrival`, `destination_departureDate`) VALUES
(1, 'Bandung', 'Jakarta', '2023-11-20'),
(2, 'Jakarta', 'Semarang', '2023-11-19'),
(3, 'Jakarta', 'Surabaya', '2023-11-21'),
(4, 'Bandung', 'Semarang', '2023-11-21');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `flight_id` int(11) NOT NULL,
  `destination_id` int(11) DEFAULT NULL,
  `flight_planeCode` varchar(50) DEFAULT NULL,
  `flight_company` varchar(100) DEFAULT NULL,
  `flight_type` varchar(50) DEFAULT NULL,
  `flight_planeType` varchar(50) DEFAULT NULL,
  `flight_totalSeat` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`flight_id`, `destination_id`, `flight_planeCode`, `flight_company`, `flight_type`, `flight_planeType`, `flight_totalSeat`) VALUES
(1, 1, 'ADN-001', 'Air Dunia', 'Domestic', 'B737-800', 5),
(2, 2, 'CTL-102', 'CountryLink', 'International', 'B737-800', 5),
(3, 3, 'BPA-121', 'BalikpapanAir', 'Domestic', 'B737-800', 5),
(4, 4, 'ADN-021', 'Air Dunia', 'Domestic', 'B737-900', 4);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_id` int(11) NOT NULL,
  `member_email` varchar(55) DEFAULT NULL,
  `member_pinPay` varchar(6) DEFAULT NULL,
  `cust_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`member_id`, `member_email`, `member_pinPay`, `cust_id`) VALUES
(1, 'vin123@gmail.com', '123456', 1),
(2, 'devid@gmail.com', '123567', 3);

-- --------------------------------------------------------

--
-- Table structure for table `planeseat`
--

CREATE TABLE `planeseat` (
  `seat_id` int(11) NOT NULL,
  `flight_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `seat_number` varchar(50) DEFAULT NULL,
  `seat_state` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `planeseat`
--

INSERT INTO `planeseat` (`seat_id`, `flight_id`, `class_id`, `seat_number`, `seat_state`) VALUES
(1, 1, 1, 'E1', 1),
(2, 1, 1, 'E2', 1),
(3, 1, 1, 'E3', 1),
(4, 1, 2, 'B1', 0),
(5, 1, 3, 'F1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `promo`
--

CREATE TABLE `promo` (
  `promo_id` int(11) NOT NULL,
  `promo_code` varchar(50) DEFAULT NULL,
  `promo_type` varchar(50) DEFAULT NULL,
  `promo_expiredDate` date DEFAULT NULL,
  `promo_percent` double(3,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `promo`
--

INSERT INTO `promo` (`promo_id`, `promo_code`, `promo_type`, `promo_expiredDate`, `promo_percent`) VALUES
(1, 'BERSAMAPINGCEN', 'Diskon', '2023-12-31', 0.50),
(2, 'CIPELIPAMPAM', 'Diskon', '2023-12-10', 0.30),
(3, 'TIPENG', 'DISKON', '2023-11-30', 0.50);

-- --------------------------------------------------------

--
-- Table structure for table `refund`
--

CREATE TABLE `refund` (
  `refund_id` int(11) NOT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `refund_status` varchar(50) DEFAULT NULL,
  `refund_total` double(15,2) DEFAULT NULL,
  `refund_reason` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `reschedule`
--

CREATE TABLE `reschedule` (
  `reschedule_id` int(11) NOT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `reschedule_status` varchar(50) DEFAULT NULL,
  `reschedule_reason` varchar(300) DEFAULT NULL,
  `reschedule_date` date DEFAULT NULL,
  `reschedule_seat` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL,
  `flight_id` int(11) DEFAULT NULL,
  `ticket_code` varchar(10) DEFAULT NULL,
  `ticket_date` date DEFAULT NULL,
  `ticket_preference` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `transaction_payMethod` varchar(50) DEFAULT NULL,
  `transaction_seatPrice` double DEFAULT NULL,
  `transation_promoDiscount` double DEFAULT NULL,
  `transaction_totalPrice` double DEFAULT NULL,
  `promo_id` int(11) NOT NULL DEFAULT 0,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `cust_id` (`cust_id`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`Class_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cust_id`);

--
-- Indexes for table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`destination_id`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`flight_id`),
  ADD KEY `destination_id` (`destination_id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`),
  ADD KEY `cust_id` (`cust_id`);

--
-- Indexes for table `planeseat`
--
ALTER TABLE `planeseat`
  ADD PRIMARY KEY (`seat_id`),
  ADD KEY `flight_id` (`flight_id`),
  ADD KEY `class_id` (`class_id`);

--
-- Indexes for table `promo`
--
ALTER TABLE `promo`
  ADD PRIMARY KEY (`promo_id`);

--
-- Indexes for table `refund`
--
ALTER TABLE `refund`
  ADD PRIMARY KEY (`refund_id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- Indexes for table `reschedule`
--
ALTER TABLE `reschedule`
  ADD PRIMARY KEY (`reschedule_id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `ticket_id` (`ticket_id`),
  ADD KEY `promo_id` (`promo_id`),
  ADD KEY `member_id` (`member_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cust_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `planeseat`
--
ALTER TABLE `planeseat`
  MODIFY `seat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `refund`
--
ALTER TABLE `refund`
  MODIFY `refund_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reschedule`
--
ALTER TABLE `reschedule`
  MODIFY `reschedule_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ticket_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`);

--
-- Constraints for table `planeseat`
--
ALTER TABLE `planeseat`
  ADD CONSTRAINT `planeseat_ibfk_1` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`flight_id`),
  ADD CONSTRAINT `planeseat_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `classes` (`Class_id`);

--
-- Constraints for table `refund`
--
ALTER TABLE `refund`
  ADD CONSTRAINT `refund_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`);

--
-- Constraints for table `reschedule`
--
ALTER TABLE `reschedule`
  ADD CONSTRAINT `reschedule_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`promo_id`) REFERENCES `promo` (`promo_id`),
  ADD CONSTRAINT `transaction_ibfk_3` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
