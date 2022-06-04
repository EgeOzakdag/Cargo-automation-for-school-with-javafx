-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 03 Haz 2022, 15:12:18
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `cargoautomation`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin_table`
--

CREATE TABLE `admin_table` (
  `AdminID` int(11) NOT NULL,
  `UserName` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `Password` varchar(9999) COLLATE utf8_turkish_ci NOT NULL,
  `Name` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `Surname` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `IdentificationNumber` int(11) NOT NULL,
  `PhoneNumber` int(12) NOT NULL,
  `Email` varchar(999) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `admin_table`
--

INSERT INTO `admin_table` (`AdminID`, `UserName`, `Password`, `Name`, `Surname`, `IdentificationNumber`, `PhoneNumber`, `Email`) VALUES
(7, 'admin', '89abc7d1bc8c1a7fc27812049c78f34a', 'adminnn', 'ege', 123333, 123123, 'adinaaaa'),
(8, 'admin1', '228efcfb4e873860d4e97443b767b52d', 'adin133', 'adin133', 12333, 12333, 'adin1@33'),
(9, 'admin12', '228efcfb4e873860d4e97443b767b52d', 'ege11', 'ege11', 12333, 12333, '123333');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `announcement_table`
--

CREATE TABLE `announcement_table` (
  `AnnouncementID` int(11) NOT NULL,
  `AnnouncementContent` varchar(999) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `announcement_table`
--

INSERT INTO `announcement_table` (`AnnouncementID`, `AnnouncementContent`) VALUES
(7, 'Bu Bir Duyuru777'),
(9, 'Bir Duyuru 8');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `cargo_table`
--

CREATE TABLE `cargo_table` (
  `CargoID` int(11) NOT NULL,
  `CargoStatus` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `SenderName` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `SenderSurname` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `SenderIdentificationNumber` int(15) NOT NULL,
  `SenderPhoneNumber` int(15) NOT NULL,
  `SenderEmail` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `SenderAddress` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `RecieverName` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `RecieverSurname` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `RecieverIdentificationNumber` int(15) NOT NULL,
  `RecieverPhoneNumber` int(15) NOT NULL,
  `RecieverEmail` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `RecieverAddress` varchar(999) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `cargo_table`
--

INSERT INTO `cargo_table` (`CargoID`, `CargoStatus`, `SenderName`, `SenderSurname`, `SenderIdentificationNumber`, `SenderPhoneNumber`, `SenderEmail`, `SenderAddress`, `RecieverName`, `RecieverSurname`, `RecieverIdentificationNumber`, `RecieverPhoneNumber`, `RecieverEmail`, `RecieverAddress`) VALUES
(1, 'At the Transfer Center', 'Ege', 'Oz', 123, 538, 'ege@gmail.com', '324 sokak', 'berkay', 'ozka', 12344, 123444, 'ber', '358 sokak'),
(3, 'in the courier', 'Haydar', 'Alkaya', 888, 537, 'haydar@alkaya', '213 sokak no41', 'hüseyin', 'abuşoğluegegege', 111, 32, 'abus@gmail.com', '88 sokak'),
(5, 'In the Shipping Center', 'ege1', 'ege133', 1231, 213, 'ege1', '3251a', 'cem', 'cem', 123, 123, 'cem', '123'),
(6, 'In the Shipping Center', 'ege1', 'ege133', 1231, 12, 'ege1', '3251a', 'hakan', 'hakan', 123, 123, 'hakan', 'asd'),
(10, 'At the Transfer Center', 'ege1', 'ege133', 1231, 12, 'ege1', '3251aaaa', 'ege', 'ege', 12333, 123, 'ege', 'ege12321'),
(16, 'in the courier', 'okan11', 'okan11', 12, 12, 'okan12', '123 sokak123', 'fuat11', 'fuat11', 123, 123, 'fuat@', '122 sokak123'),
(17, 'Request', 'ege1', 'ege133', 123, 12, 'ege1ww', '3251aaaa222333', 'ege', 'ege', 3333, 123, 'ege', '1233');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user_table`
--

CREATE TABLE `user_table` (
  `UserID` int(11) NOT NULL,
  `UserName` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `Password` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `Name` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `Surname` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `Identification` int(15) NOT NULL,
  `PhoneNumber` int(15) NOT NULL,
  `Email` varchar(999) COLLATE utf8_turkish_ci NOT NULL,
  `Address` varchar(999) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `user_table`
--

INSERT INTO `user_table` (`UserID`, `UserName`, `Password`, `Name`, `Surname`, `Identification`, `PhoneNumber`, `Email`, `Address`) VALUES
(3, 'ege', '89abc7d1bc8c1a7fc27812049c78f34a', 'ege1', 'ege133', 123, 1233, 'ege1ww', '3251aaaa222333'),
(7, 'admin33', '228efcfb4e873860d4e97443b767b52d', 'asdmin', 'adnin', 123, 1233, 'ege12333', '324 sokak33'),
(9, 'user', '67144ff2b4b404b2471faa09707f1fd7', 'user2233', 'user2233', 77, 12321333, 'user323', '326323'),
(10, 'asd', '89abc7d1bc8c1a7fc27812049c78f34a', '123', '12323', 1231133, 12312333, 'hüseyin@12333', '321211sokak12333'),
(11, 'ege123', '89abc7d1bc8c1a7fc27812049c78f34a', 'ege', '123', 123, 123, 'ege', 'ege');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin_table`
--
ALTER TABLE `admin_table`
  ADD PRIMARY KEY (`AdminID`);

--
-- Tablo için indeksler `announcement_table`
--
ALTER TABLE `announcement_table`
  ADD PRIMARY KEY (`AnnouncementID`);

--
-- Tablo için indeksler `cargo_table`
--
ALTER TABLE `cargo_table`
  ADD PRIMARY KEY (`CargoID`);

--
-- Tablo için indeksler `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`UserID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admin_table`
--
ALTER TABLE `admin_table`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `announcement_table`
--
ALTER TABLE `announcement_table`
  MODIFY `AnnouncementID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `cargo_table`
--
ALTER TABLE `cargo_table`
  MODIFY `CargoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Tablo için AUTO_INCREMENT değeri `user_table`
--
ALTER TABLE `user_table`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
