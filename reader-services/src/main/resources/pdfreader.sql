-- phpMyAdmin SQL Dump
-- version 3.5.8.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 27, 2014 at 01:28 PM
-- Server version: 5.5.31-0ubuntu0.13.04.1
-- PHP Version: 5.4.9-4ubuntu2.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pdfreader`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE IF NOT EXISTS `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_name` text,
  `book_author` text,
  `rating` float DEFAULT NULL,
  `total_points_gained` bigint(20) DEFAULT NULL,
  `total_user_rated` bigint(20) DEFAULT NULL,
  `book_link` text,
  `added_by` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `book_name`, `book_author`, `rating`, `total_points_gained`, `total_user_rated`, `book_link`, `added_by`) VALUES
(1, 'Admit Card', 'IIMK', 0, 0, 0, 'IIM - Admit Card.pdf', 1),
(2, 'Springs MVC 3.0', 'springs', 0, 0, 0, 'spring-framework-reference.pdf', 1),
(3, 'Ticket', 'IRCTTC', 0, 0, 0, 'IRCTC Ltd,Booked Ticket Printing.pdf', 1),
(4, 'Alfresco', 'Alfresco', 0, 0, 0, '0596516681.pdf', 5),
(5, 'Effective Java', 'Java', 0, 0, 0, 'EffectiveJAVA.pdf', 12);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `address` text NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` text NOT NULL,
  `user_type` varchar(10) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `age`, `address`, `username`, `password`, `user_type`, `enabled`) VALUES
(1, 'Test', 'Test', 23, 'Shivnagar Delhisss', 'test', 'test', 'admin', 1),
(3, 'Ankur', 'Jain', 25, 'Room 26 Hostel-B', 'smishra', '123456', 'reader', 1),
(4, 'Praveen', 'Kumar', 40, 'delhi', 'praveen', '1234', 'reader', 1),
(5, 'Code For Survival', 'Survival of the Fittest', 2, 'CFFFF', 'cfs', 'cfs', 'admin', 1),
(6, 'Test1', 'Test1', 40, 'BSD', 'test1', 'test1', 'reader', 1),
(7, 'Test2', 'test2', 12, 'tttt', 'test2', 'test2', 'reader', 1),
(8, 'ASD', 'ASD', 12, 'asddd', 'asd', 'asd', 'reader', 1),
(10, 'Ankur', 'Dwivedi', 12, '122222', 'qwe', '123', 'reader', 1),
(11, 'Ankur', 'Jain', 12, '11111', 'preetam', '123', 'reader', 1),
(12, 'Ankur', 'Test1', 12, '178979\r\n', 'zxc', 'zxc', 'reader', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_role_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `user_id`, `authority`) VALUES
(1, 1, 'ROLE_USER'),
(2, 2, 'ROLE_USER'),
(3, 3, 'ROLE_USER'),
(4, 4, 'ROLE_USER'),
(5, 5, 'ROLE_USER'),
(6, 12, 'ROLE_USER');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
