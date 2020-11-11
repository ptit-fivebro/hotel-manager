create database hotel character set utf8 collate utf8_general_ci;

use hotel;

CREATE TABLE `Part` (
  `ID_PART` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PART_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID_PART`)
);

CREATE TABLE `Employee` (
  `ID_EMPLOYEE` int NOT null auto_increment,
  `PASSWORD` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EMAIL` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CMND` char(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GENDER` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PHONE` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SALARY` float DEFAULT NULL,
  PRIMARY KEY (`ID_EMPLOYEE`)
);

CREATE TABLE `PartEmployee` (
    `ID_EMPLOYEE` int NOT NULL,
  	`ID_PART` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`ID_EMPLOYEE`, `ID_PART`),
    CONSTRAINT `Constr_PartEmployee_Part_fk`
        FOREIGN KEY `Part_fk` (`ID_PART`) REFERENCES `Part` (`ID_PART`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `Constr_PartEmployee_Employee_fk`
        FOREIGN KEY `Employee_fk` (`ID_EMPLOYEE`) REFERENCES `Employee` (`ID_EMPLOYEE`)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Customer` (
  `ID_CUSTOMER` int NOT null auto_increment,
  `CMND` char(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` char(20) NOT NULL,
  `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci not NULL,
  `GENDER` bit(1) DEFAULT 1,
  `ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NATIONALITY` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `ACTIVE` bit(1) DEFAULT 1,
  `IMAGE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_CUSTOMER`)
);

CREATE TABLE `Contact` (
  `ID` int NOT null auto_increment,
  `ID_CUSTOMER` int NOT null,
  `DATE` date NOT NULL,
  `TITLE` text NOT NULL,
  `CONTENT` text NOT NULL,
  PRIMARY KEY (`ID`),
  foreign key (`ID_CUSTOMER`) references `Customer`(`ID_CUSTOMER`)
);

CREATE TABLE `Room_Category` (
  `ID_ROOM_CATEGORY` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NUMBER` int DEFAULT NULL,
  `PRICE` float DEFAULT NULL,
  `IMAGE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DESCRIPTION` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_ROOM_CATEGORY`)
);

CREATE TABLE `Room_Status` (
  `ID_ROOM_STATUS` int NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID_ROOM_STATUS`)
);

CREATE TABLE `Room` (
  `ID_ROOM` int NOT NULL,
  `ID_ROOM_STATUS` int NOT NULL,
  `ID_ROOM_CATEGORY` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FLOOR_NUMBER` int DEFAULT 1,
  PRIMARY KEY (`ID_ROOM`),
  foreign key (`ID_ROOM_STATUS`) references `Room_Status`(`ID_ROOM_STATUS`),
  foreign key (`ID_ROOM_CATEGORY`) references `Room_Category`(`ID_ROOM_CATEGORY`)
);

CREATE TABLE `Booking_Form_Status` (
  `ID_BOOKING_FORM_STATUS` int NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID_BOOKING_FORM_STATUS`)
);

CREATE TABLE `Booking_Form` (
  `ID_BOOKING` int NOT null auto_increment,
  `ID_CUSTOMER` int NOT null,
  `ID_BOOKING_FORM_STATUS` int NOT NULL,
  `BOOKING_DATE` date NOT NULL,
  `EXPECTED_ARRIVAL_DATE` date NOT NULL,
  `EXPECTED_DEPARTURE_DATE` date NOT NULL,
  PRIMARY KEY (`ID_BOOKING`),
  foreign key (`ID_CUSTOMER`) references `Customer`(`ID_CUSTOMER`),
  foreign key (`ID_BOOKING_FORM_STATUS`) references `Booking_Form_Status`(`ID_BOOKING_FORM_STATUS`)
);

CREATE TABLE `Booking_Form_Detail` (
  `ID_BOOKING_DETAIL` int NOT null auto_increment,
  `ID_BOOKING` int NOT NULL,
  `ID_ROOM_CATEGORY` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NUMBER` int NOT NULL,
  PRIMARY KEY (`ID_BOOKING_DETAIL`),
  foreign key (`ID_BOOKING`) references `Booking_Form`(`ID_BOOKING`),
  foreign key (`ID_ROOM_CATEGORY`) references `Room_Category`(`ID_ROOM_CATEGORY`)
);

CREATE TABLE `Rental_Form` (
  `ID_RENTAL_FORM` int NOT null auto_increment,
  `ID_BOOKING` int NOT NULL,
  `ARRIVAL_DATE` date NOT NULL,
  `DEPARTURE_DATE` date NOT NULL,
  PRIMARY KEY (`ID_RENTAL_FORM`),
  foreign key (`ID_BOOKING`) references `Booking_Form`(`ID_BOOKING`)
);

CREATE TABLE `Rental_Form_Detail` (
  `ID_RENTAL_FORM_DETAIL` int NOT null auto_increment,
  `ID_RENTAL_FORM` int NOT NULL,
  `ID_ROOM` int NOT NULL,
  `CUSTOMER1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CMND1` char(9) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CUSTOMER2` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CMND2` char(9) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TOTAL_SERVICE_PRICE` float DEFAULT 0,
  `TOTAL_RENTAL_PRICE` float NOT NULL,
  PRIMARY KEY (`ID_RENTAL_FORM_DETAIL`),
  foreign key (`ID_ROOM`) references `Room`(`ID_ROOM`),
  foreign key (`ID_RENTAL_FORM`) references `Rental_Form`(`ID_RENTAL_FORM`)
);

CREATE TABLE `Service_Category` (
  `ID_SERVICE_CATEGORY` int NOT NULL,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID_SERVICE_CATEGORY`)
);

CREATE TABLE `Service` (
  `ID_SERVICE` int NOT NULL,
  `ID_SERVICE_CATEGORY` int not NULL,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `PRICE_SERVICE` float NOT NULL,
  `UNIT` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DESCRIPTION` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `IMAGE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_SERVICE`),
  foreign key (`ID_SERVICE_CATEGORY`) references `Service_Category`(`ID_SERVICE_CATEGORY`)
);

CREATE TABLE `Service_Detail` (
  `ID_SERVICE_DETAIL` int NOT null auto_increment,
  `ID_RENTAL_FORM_DETAIL` int NOT NULL,
  `ID_SERVICE` int NOT NULL,
  `DATE_USED` date NOT NULL,
  `NUMBER` int NOT NULL,
  `PRICE` float NOT NULL,
  `NOTE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_SERVICE_DETAIL`),
  foreign key (`ID_SERVICE`) references `Service`(`ID_SERVICE`),
  foreign key (`ID_RENTAL_FORM_DETAIL`) references `Rental_Form_Detail`(`ID_RENTAL_FORM_DETAIL`)
);

CREATE TABLE `Bill` (
  `ID_BILL` int NOT null auto_increment,
  `ID_RENTAL_FORM` int NOT NULL,
  `DATE` date NOT NULL,
  `TOTAL_RENTAL_FORM` float NOT NULL,
  `TOTAL_SERVICE` float NOT NULL,
  `RECEIVED_AMOUNT` float NOT NULL,
  `PAYMENT_AMOUNT` float NOT NULL,
  PRIMARY KEY (`ID_BILL`),
  foreign key (`ID_RENTAL_FORM`) references `Rental_Form`(`ID_RENTAL_FORM`)
);