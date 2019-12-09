-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 09, 2019 at 04:07 PM
-- Server version: 5.7.28-0ubuntu0.16.04.2
-- PHP Version: 7.0.33-0ubuntu0.16.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vendormanagedinventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer_product`
--

CREATE TABLE `customer_product` (
  `customer_id` int(11) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantity_flowed` int(11) NOT NULL,
  `flow_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `pictures` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `description`, `quantity`, `pictures`) VALUES
(1, 'Iphone6 samsung ', 450, 'Mobile phone samsung', 5, NULL),
(2, 'Nokia 3310', 45, 'Nokia 3310 mobile phone', 78, NULL),
(3, 'Internal SSD Crucial 1000GB ', 90, 'Internal SSD Crucial 1000GB speed 6kb/s', 60, NULL),
(4, 'Television', 350, 'TV to see footbal', 34, NULL),
(6, 'Blum Screen', 365, 'TV to  very adapted to sunny climat', 30, NULL),
(7, 'ETV Screen', 30, 'ETV screen for smooth upload adapted for tropical climat', 37, NULL),
(9, 'Blum Screen', 365, 'TV to  very adapted to sunny climat', 30, NULL),
(10, 'UBlubbbm Screen', 10, 'For phone screen very adapted to tropical climat', 30, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d31372032302d35372d35352e706e677702002f78),
(11, 'Ultra speed HDD', 120, 'Ultra speed HDD  for huge using memory computers', 722, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32312031312d34312d30302e706e677702002f78),
(12, 'Ultra speed portable Usb', 12, 'Ultra speed HDD  for huge using memory computers', 5, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32312031312d34312d30302e706e677702002f78),
(13, 'phospate ', 250, 'Ressource Minerale pour les angrais ', 5, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d31382031302d31362d33392e706e677702002f78),
(14, 'DEFAULT PRODUCT', 1, 'DEFAULT PRODUCT', 1, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b78707400007702002f78),
(15, 'Gafara gafara', 6, 'Gaskaraty', 23, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32342030392d31332d32362e706e677702002f78),
(16, 'bsbsbsnsn', 40, 'benjis bendis', 76, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32342030392d31332d32362e706e677702002f78),
(24, 'Jusss', 12, 'Some pomes jussss', 277, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32342030372d33302d35382e706e677702002f78),
(26, 'Haricot', 15, 'Graine azotee', 60, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031372d31332d31382e706e677702002f78),
(32, 'Jussary', 15, 'Feuil senegal', 240, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031382d30302d34342e706e677702002f78),
(33, 'Oignon', 15, 'Oignon en sacs', 46, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031362d33312d31352e706e677702002f78),
(34, 'manioc', 10, 'Tubercule rich in magnsiu', 52, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031372d31332d31382e706e677702002f78),
(37, 'crabe', 15, 'Cruistassee d\' origine marine', 23, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031362d33312d31352e706e677702002f78),
(38, 'Iphone 10 ', 100, 'Phone haut de game', 48, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031362d33312d31352e706e677702002f78),
(39, 'Pommes', 43, 'Tubercule bien developee sur le climat mediterraneenne', 268, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031372d31332d31382e706e677702002f78),
(40, 'tilapia', 10, 'Poisson tres riche en calcium', 20, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031382d30302d34342e706e677702002f78),
(41, 'Chaussures tennis', 39, 'Chaussure de sport', 34, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031362d33302d34302e706e677702002f78),
(42, 'Mango', 5, 'Fruit tropical riche en vitamin c', 137, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031352d30312d32352e706e677702002f78),
(43, 'bango', 5, 'Fruit tropical riche en vitamin c', 120, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031352d30312d32352e706e677702002f78),
(44, 'Orange', 8, 'Fruit tropical riche en vitamin c', 20, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031322d35372d30382e706e677702002f78),
(45, 'Orange', 8, 'Fruit tropical riche en vitamin c', 10, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031322d35372d30382e706e677702002f78),
(46, 'Poule', 23, 'Fruit tropical riche en vitamin c', 15, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32362031362d33302d34302e706e677702002f78),
(47, 'eefony', 2, 'Fruit noir riche en fer et encalcium', 85, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d30392d32302031382d35322d33332e706e677702002f78),
(49, 'Basin', 7, 'Tissus d\'origine traditionnelle africaine', 40, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d30392d32302031382d35332d33382e706e677702002f78),
(51, 'agbara', 10, 'Tissus d\'origine traditionnelle africaine Ghana', 30, 0xaced00057372000c6a6176612e696f2e46696c65042da4450e0de4ff0300014c0004706174687400124c6a6176612f6c616e672f537472696e673b787074002753637265656e73686f742066726f6d20323031392d31302d32342030392d31332d32362e706e677702002f78);

-- --------------------------------------------------------

--
-- Table structure for table `product_warehouse`
--

CREATE TABLE `product_warehouse` (
  `product_id` bigint(20) NOT NULL,
  `warehouse_id` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantity_flowed` int(11) NOT NULL,
  `flow_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `trans_vendor_product_warehouse`
--

CREATE TABLE `trans_vendor_product_warehouse` (
  `id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `transactions_date` date NOT NULL,
  `quantity` int(11) NOT NULL,
  `vendor_id` int(11) NOT NULL,
  `warehouse_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trans_vendor_product_warehouse`
--

INSERT INTO `trans_vendor_product_warehouse` (`id`, `description`, `price`, `product_id`, `transactions_date`, `quantity`, `vendor_id`, `warehouse_id`) VALUES
(1, 'Reception of product \'Jussary', 15, 32, '2019-10-30', 15, 12, 5),
(2, 'Reception of product \'Jusss', 21, 24, '2019-10-30', 6, 12, 6),
(3, 'Reception of product \'Jusss', 20, 24, '2019-10-30', 43, 9, 5),
(5, 'Reception of product \'Oignon', 15, 33, '2019-10-30', 23, 12, 6),
(6, 'Reception of product \'manioc', 10, 34, '2019-10-31', 52, 9, 5),
(8, 'Reception of product \'Mango', 3, 36, '2019-10-31', 15, 12, 6),
(13, 'Reception of product \'crabe', 15, 37, '2019-11-05', 23, 17, 5),
(14, 'Reception of product \'Iphone 10 ', 100, 38, '2019-11-05', 48, 9, 5),
(15, 'Reception of product \'Pommes', 43, 39, '2019-11-05', 200, 9, 5),
(17, 'Reception of product \'Pommes', 10, 39, '2019-11-05', 45, 12, 5),
(18, 'Reception of product \'Pommes', 10, 39, '2019-11-05', 23, 12, 5),
(19, 'Reception of product \'Mango', 10, 36, '2019-11-05', 23, 17, 5),
(20, 'Reception of product \'tilapia', 10, 40, '2019-11-07', 20, 12, 5),
(21, 'Reception of product \'Chaussures tennis', 39, 41, '2019-11-07', 34, 12, 5),
(22, 'Reception of product \'bango', 5, 43, '2019-11-10', 120, 12, 5),
(23, 'Reception of product \'Mango', 8, 42, '2019-11-11', 10, 12, 5),
(24, 'Reception of product \'Mango', 10, 42, '2019-11-11', 7, 12, 5),
(25, 'Reception of product \'Poule', 23, 46, '2019-11-11', 15, 12, 5),
(26, 'Reception of product \'eefony', 2, 47, '2019-11-30', 60, 18, 6),
(27, 'Reception of product \'eefony', 2, 47, '2019-11-30', 25, 12, 5),
(28, 'Reception of product \'Basin', 7, 49, '2019-11-30', 40, 18, 5),
(29, 'Reception of product \'agbara', 10, 51, '2019-11-30', 5, 12, 5),
(30, 'Reception of product \'agbara', 10, 51, '2019-11-30', 20, 9, 5);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id`, `city`, `country`, `fax`, `phone`, `street`, `zip_code`, `name`, `product_id`, `email`, `password`) VALUES
(1, 'Saint louis', 'Missouri', '029283765', '423167890', '1039385 Kerry street ', '252437', 'KKKKKKKKKerry Ingredients', NULL, 'kkkk@kerry.com', '000000'),
(4, 'Saint louis', 'Missouri', '029', '4231', '1039385 Goooo street ', '24238', 'MMMMMMKKerry Ingredients', NULL, 'mmekkkk@kerry.com', '000000'),
(5, 'Chicago', 'Illinois', '029', '42310000', '1039385 Gogoooo street ', '242382423', 'MMMMMMK Haender', NULL, 'mmemdek@kym.com', '000000'),
(6, 'Orlando', 'California', '029', '423165', '9385 Gohoooo street ', '3423', 'jmsss@yuei', NULL, 'fffemdek@kym.com', '000'),
(7, 'Miami', 'Florida', '02876', '42390', '9385 Gotyoooo street ', '3423789', 'jmsss@japon.com', NULL, 'hgmdek@kuiiim.com', '00000'),
(8, 'Miami', 'Florida', '02876', '42390', '9385 Gotyoooo street ', '3423789', 'jmsss@japon.com', NULL, 'hgmdek@kuiiim.com', '00000'),
(9, 'Kansas', 'Missouri', '21345', '1234256', '13456 bbbbboooo street ', '6736357', 'BBOOO', 7, 'bbbbooo@bbboo.com', '0000'),
(10, 'Saint Peter', 'Missouri', '9821345', '198234256', '5583456 bbbbboooo street ', '998836357', 'pbbBanzaaa', 1, 'pbbanzaaaaabbab@bbboo.com', '0000'),
(11, 'Saint Peter', 'Missouri', '9821345', '198234256', '5583456 bbbbboooo street ', '998836357', 'pbbBanzaaa', 7, 'pbbanzaaaaabbab@bbboo.com', '0000'),
(12, '', 'TOGO', '58888888', '90000000', '242323232 Rue de la liberation', '233399998', 'OTP TOGO', 1, 'ooooootptogo@oooop.com', '0000'),
(13, 'grggrcity', 'Kenntucky', '54897756', '413122290', '123456 shsharoad 12345', '12334567', 'bbbdue Koffitse', 14, 'ggggrtt@gmail.com', '0000'),
(14, 'Genesiscity', 'Montana', '3534276', '6354890', '23477383 Rue de la liberte', '2524367283843', 'Fffffreeeee', 14, 'ffffrenm@fffr.com', '0000'),
(15, 'Aneho', 'Togo', '222883838339494', '2029292938384874', '24355673', '1243834746', 'benenenenne', 14, 'benene@oooo.com', '00000'),
(16, 'Bunia', 'Congo', '24883838339494', '248292938384874', '355673', '834746', 'Sennnenenenne', 14, 'semmmenene@oooo.com', '00000'),
(17, 'accra', 'Ghana', '0002334871', '0002334870', '23 kuffordway ', '1278', 'Pentano', 14, 'oooopentano@ghana.com', 'password'),
(18, 'cotonou', 'benin', '0034949495878', '00292837788438', '12478 fongbonoutreet', '3645', 'Axxxbraham', 14, 'azppbbbbs@hhham.com', '00000');

-- --------------------------------------------------------

--
-- Table structure for table `vendor_product`
--

CREATE TABLE `vendor_product` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `transactions_date` datetime DEFAULT NULL,
  `vendor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vendor_product_warehouse`
--

CREATE TABLE `vendor_product_warehouse` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `destination_warehouse_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `transactions_date` datetime DEFAULT NULL,
  `vendor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vendor_warehouse`
--

CREATE TABLE `vendor_warehouse` (
  `vendor_id` int(11) NOT NULL,
  `warehouse_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `warehouse`
--

INSERT INTO `warehouse` (`id`, `city`, `country`, `fax`, `phone`, `street`, `zip_code`, `name`, `email`, `password`) VALUES
(5, 'Chicago', 'ILLINOIS', '772536547', '30298', '23432 Obamastreet Drive ', '566', 'Babatunday', 'mmmnf@phrologo.com', '906758'),
(6, 'Saint Louis', 'Missouri', '154647474633534', '2524636374789', '1 Southwest Fifion', '12332424', 'Prologix', 'prologisssssss@prologixooo.com', '000000');

-- --------------------------------------------------------

--
-- Table structure for table `warehouse_customer`
--

CREATE TABLE `warehouse_customer` (
  `warehouse_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `warehouse_products`
--

CREATE TABLE `warehouse_products` (
  `warehouse_warehouse_id` int(11) NOT NULL,
  `products_product_id` int(11) NOT NULL,
  `warehouse_id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_product`
--
ALTER TABLE `customer_product`
  ADD KEY `FKamw6m4xtfpjuhf4we62chd94d` (`product_id`),
  ADD KEY `FK8l04qpcphqsemdfr89i05piww` (`customer_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_warehouse`
--
ALTER TABLE `product_warehouse`
  ADD PRIMARY KEY (`product_id`,`warehouse_id`),
  ADD KEY `FKma5wwcpvatmrf7m725c451sbg` (`warehouse_id`);

--
-- Indexes for table `trans_vendor_product_warehouse`
--
ALTER TABLE `trans_vendor_product_warehouse`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8fyygg9kbjislmrogku89a20o` (`product_id`);

--
-- Indexes for table `vendor_product`
--
ALTER TABLE `vendor_product`
  ADD PRIMARY KEY (`vendor_id`,`product_id`),
  ADD UNIQUE KEY `UK_5uacek9yyknvb208e3teuaxd2` (`product_id`);

--
-- Indexes for table `vendor_product_warehouse`
--
ALTER TABLE `vendor_product_warehouse`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vendor_warehouse`
--
ALTER TABLE `vendor_warehouse`
  ADD KEY `FKai11pdd66iiv3ttxmamd1h1vj` (`warehouse_id`),
  ADD KEY `FK3av81xho94x7lrppr5ux5psla` (`vendor_id`);

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `warehouse_customer`
--
ALTER TABLE `warehouse_customer`
  ADD PRIMARY KEY (`warehouse_id`,`customer_id`),
  ADD KEY `FKnbt6a2sxt36kwvol78q05j52y` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
--
-- AUTO_INCREMENT for table `trans_vendor_product_warehouse`
--
ALTER TABLE `trans_vendor_product_warehouse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `vendor_product`
--
ALTER TABLE `vendor_product`
  MODIFY `vendor_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `vendor_product_warehouse`
--
ALTER TABLE `vendor_product_warehouse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer_product`
--
ALTER TABLE `customer_product`
  ADD CONSTRAINT `FK8l04qpcphqsemdfr89i05piww` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKamw6m4xtfpjuhf4we62chd94d` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `product_warehouse`
--
ALTER TABLE `product_warehouse`
  ADD CONSTRAINT `FKi45e6tbd5k7pu4g7walf5d3rc` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKma5wwcpvatmrf7m725c451sbg` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`);

--
-- Constraints for table `vendor`
--
ALTER TABLE `vendor`
  ADD CONSTRAINT `FK8fyygg9kbjislmrogku89a20o` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `vendor_product`
--
ALTER TABLE `vendor_product`
  ADD CONSTRAINT `FKsg1hhor4sg6ynnem9xnrthv32` FOREIGN KEY (`product_id`) REFERENCES `vendor` (`id`);

--
-- Constraints for table `vendor_warehouse`
--
ALTER TABLE `vendor_warehouse`
  ADD CONSTRAINT `FK3av81xho94x7lrppr5ux5psla` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`),
  ADD CONSTRAINT `FKai11pdd66iiv3ttxmamd1h1vj` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`);

--
-- Constraints for table `warehouse_customer`
--
ALTER TABLE `warehouse_customer`
  ADD CONSTRAINT `FKfype1gl6ksgd2adhqxqjj1oxy` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`),
  ADD CONSTRAINT `FKnbt6a2sxt36kwvol78q05j52y` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
