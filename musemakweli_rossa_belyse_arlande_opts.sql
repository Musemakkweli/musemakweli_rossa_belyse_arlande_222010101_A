-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 12:16 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `musemakweli_rossa_belyse_arlande_opts`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(10) NOT NULL,
  `Name` text NOT NULL,
  `Email` text NOT NULL,
  `Role` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `Name`, `Email`, `Role`, `Password`) VALUES
(1, 'Lolie HABIYAREMYE', 'lolie@gmail.com', 'Super Admin', 'lolie123'),
(2, 'Rossa Arlande', 'rossa@gmail.com', ' Obstestrician', 'rossa123'),
(3, 'Denyse', 'denyse@gmail.com', ' Obstestrician', 'denyse123'),
(4, 'Fideline ISHIMWE', 'fideline@gmail.com', 'Doctor', 'fideline123');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `question_id` int(11) NOT NULL,
  `question_text` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`question_id`, `question_text`) VALUES
(1, 'Have you missed your period?'),
(2, 'When was your last sex?'),
(3, 'Did you use condom or any other Contraceptive method?'),
(4, 'Do you currently have any kind of illiness ?'),
(5, 'Are you currently married?'),
(6, 'Is you periods regular ?'),
(7, 'Have you ever made an abortion ?'),
(8, 'Have you experienced any abdominal cramping or discomfort?'),
(9, 'Have you noticed any changes in your urination frequency or habits?'),
(10, 'Have you experienced any unusual fatigue?'),
(11, 'Have you noticed any changes in your breast tender...'),
(12, 'Have you experienced any nausea or morning sicknes...'),
(13, 'Are you currently taking any medications that might affect your menstrual cycle or pregnancy?'),
(14, 'Have you experienced any changes in your body temperature or basal body temperature?'),
(15, 'Have you recently engaged in unprotected sexual intercourse?'),
(16, 'Have you taken a home pregnancy test? If so, what were the results?');

-- --------------------------------------------------------

--
-- Table structure for table `tests`
--

CREATE TABLE `tests` (
  `TestID` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `TestDate` text NOT NULL,
  `Result` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tests`
--

INSERT INTO `tests` (`TestID`, `UserID`, `TestDate`, `Result`) VALUES
(4, 2, '18-02-2024', 'Physical Consultation');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserID` int(11) NOT NULL,
  `Username` text NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `DateOfBirth` text NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Insurance` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `Username`, `Phone`, `Email`, `DateOfBirth`, `Address`, `Password`, `Insurance`) VALUES
(1, '34', 'rzxrrx', 'uvyy', 'ubuvy', 'uu', 'jbjbb', 'vhv'),
(2, 'Belyse', '0780115654', 'belyse@gmail.com', '0000-99-77', 'HUYE', 'belyse12', 'RSSB'),
(3, 'kendra', '0780987654', 'kendra@gmail.com', '21-07-2002', 'kigali', 'kendra123', 'RSSB');

-- --------------------------------------------------------

--
-- Table structure for table `user_responses`
--

CREATE TABLE `user_responses` (
  `response_id` int(11) NOT NULL,
  `UserID` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `response` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_responses`
--

INSERT INTO `user_responses` (`response_id`, `UserID`, `question_id`, `response`) VALUES
(2, 1, 1, 'yes'),
(3, 1, 1, 'yes'),
(4, 1, 2, '2 weeks'),
(5, 1, 3, 'no'),
(6, 1, 1, 'yes'),
(7, 1, 2, '2'),
(8, 1, 3, 'no'),
(9, 1, 4, 'no'),
(10, 1, 5, 'no'),
(11, 1, 1, 'YES'),
(12, 1, 2, 'NO'),
(13, 1, 3, '2'),
(14, 1, 4, '2'),
(15, 1, 5, '5'),
(16, 1, 6, 'YES'),
(17, 1, 7, 'NO'),
(18, 1, 8, 'YES'),
(19, 1, 9, '7'),
(20, 1, 1, '3'),
(21, 1, 2, 'e'),
(22, 1, 3, 'kuk'),
(23, 1, 4, 'lo'),
(24, 1, 5, 'be'),
(25, 1, 6, 'ly'),
(26, 1, 7, 'se'),
(27, 1, 8, 'mu'),
(28, 1, 9, 'se'),
(29, 1, 1, 'yes'),
(30, 1, 2, '2weeks ago'),
(31, 1, 3, 'no'),
(32, 1, 4, 'no'),
(33, 1, 5, 'no'),
(34, 1, 6, 'yes'),
(35, 1, 7, 'no'),
(36, 1, 8, 'hoya'),
(37, 1, 9, 'nawe'),
(38, 1, 10, 'yes'),
(39, 1, 11, 'yes'),
(40, 1, 12, 'yes'),
(41, 2, 1, 'yes'),
(42, 2, 2, '2weeks'),
(43, 2, 3, 'no'),
(44, 2, 4, 'yes'),
(45, 2, 5, 'no'),
(46, 2, 6, 'no'),
(47, 2, 7, 'yes'),
(48, 2, 8, 'ndanze'),
(49, 2, 9, 'hoya'),
(50, 2, 10, 'yes'),
(51, 2, 11, 'yes'),
(52, 2, 12, 'no'),
(53, 2, 1, '22'),
(54, 2, 2, '22'),
(55, 2, 3, '22'),
(56, 2, 4, '22'),
(57, 2, 5, '22'),
(58, 2, 6, '22'),
(59, 2, 7, '22'),
(60, 2, 8, '2222'),
(61, 2, 9, '22'),
(62, 2, 10, '2222'),
(63, 2, 11, '22'),
(64, 2, 12, '22'),
(65, 2, 1, 'yes'),
(66, 2, 2, '1 week ago'),
(67, 2, 3, 'no'),
(68, 2, 4, 'no '),
(69, 2, 5, 'no'),
(70, 2, 6, 'yes'),
(71, 2, 7, 'yes'),
(72, 2, 8, 'ndanze'),
(73, 2, 9, 'no'),
(74, 2, 10, 'yes'),
(75, 2, 11, 'yes '),
(76, 2, 12, 'yes'),
(77, 2, 1, 'w'),
(78, 2, 2, 'w'),
(79, 2, 3, 'w'),
(80, 2, 4, 'w'),
(81, 2, 5, 'w'),
(82, 2, 6, 'w'),
(83, 2, 7, 'w'),
(84, 2, 8, 'w'),
(85, 2, 9, 'w'),
(86, 2, 10, 'w'),
(87, 2, 11, 'w'),
(88, 2, 12, 'w'),
(89, 2, 1, 'yes'),
(90, 2, 2, 'yes'),
(91, 2, 3, 'no'),
(92, 2, 4, 'yes'),
(93, 2, 5, 'no'),
(94, 2, 6, 'yes'),
(95, 2, 7, 'no'),
(96, 2, 8, 'yes'),
(97, 2, 9, 'no'),
(98, 2, 10, 'yes'),
(99, 2, 11, 'yes'),
(100, 2, 12, 'no'),
(101, 2, 13, 'yes'),
(102, 2, 14, 'yes'),
(103, 2, 15, 'yes'),
(104, 2, 16, 'yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`question_id`);

--
-- Indexes for table `tests`
--
ALTER TABLE `tests`
  ADD PRIMARY KEY (`TestID`),
  ADD KEY `user_id` (`UserID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `user_responses`
--
ALTER TABLE `user_responses`
  ADD PRIMARY KEY (`response_id`),
  ADD KEY `user_id` (`UserID`),
  ADD KEY `question_id` (`question_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tests`
--
ALTER TABLE `tests`
  MODIFY `TestID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_responses`
--
ALTER TABLE `user_responses`
  MODIFY `response_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tests`
--
ALTER TABLE `tests`
  ADD CONSTRAINT `tests_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`);

--
-- Constraints for table `user_responses`
--
ALTER TABLE `user_responses`
  ADD CONSTRAINT `user_responses_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`),
  ADD CONSTRAINT `user_responses_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
