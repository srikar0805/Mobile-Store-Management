-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: miniproject
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `Name` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `ProductBought` varchar(60) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `ContactNo` varchar(15) DEFAULT NULL,
  `emailid` varchar(30) DEFAULT NULL,
  `PurchaseNo` int DEFAULT NULL,
  UNIQUE KEY `PurchaseNo` (`PurchaseNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('Atul',20,'Pune','IPhone 13','Male','7890123456','atul125@gmail.com',1),('Tanmay TP',19,'Mumbai','Pixel 6 Pro','Male','9090123456','tanmaytp13@gmail.com',2),('Tanmay U',19,'Nagpur','9 Pro','Male','7012345678','tanmayu32@gmail.com',3),('Srikar',18,'Vijayawada','Galaxy S21','Male','6012345612','srikar123@gmail.com',4),('Sathvika',18,'Hyderabad','Pixel 6 Pro','Female','8901234567','sathvika1234@gmail.com',5),('Shiva',15,'Mumbai','7 Legend','Male','8910213456','shiva1245@gamil.com',6),('Dheeraj',23,'Kolkata','Nord CE','Male','8012501295','dheeraj123@gmail.com',7),('Prashant',25,'Chennai','Galaxy A10','Male','9014501245','prashant123@gmail.com',8),('Ranjith',26,'Hyderabad','Nexus 6','Male','6013501245','ranjith123@gmail.com',9),('Sakshi',31,'Bangalore','IPhone 12','Female','6782501245','sakshi123@gmail.com',10),('Liam',32,'Jammu','Galaxy A10','Male','7012506785','liam123@gmail.com',11),('Noah',35,'Srinagar','Galaxy A10','Female','8992501245','noah123@gmail.com',12),('Oliver',21,'Pune','Galaxy A10','Male','6123591234','oliver123@gmail.com',13),('Elijah',36,'Bhopal','X70 Plus','Male','9876401245','elijah123@gmail.com',14),('William',28,'Ahmedabad','Galaxy A10','Male','9132554712','william123@gmail.com',15),('James',40,'New Mumbai','Nord CE','Male','9734738788','james123@gmail.com',16),('Benjamin',45,'Surat','Galaxy A10','Male','7122507612','benjamin123@gmail.com',17),('Lucas',25,'Vizag','Nord CE','Male','9123348938','lucas123@gmail.com',18),('Henry',36,'Goa','X70 Plus','Male','9127374389','henry123@gmail.com',19),('Alexander',39,'Ranchi','X70 Plus','Male','9123798478','alexander123@gmail.com',20),('Jesica',30,'Kachh','Nexus 6','Female','9129384939','jesica123@gmail.com',21),('Michael',25,'Dharwad','Nord CE','Male','8122342133','michael123@gmail.com',22),('Sansa',32,'Gwalior','X70 Plus','Female','9782434012','sansa123@gmail.com',23),('Daniel',41,'Sultanpur','Nexus 6','Male','9012366583','daniel123@gmail.com',24),('Jenny',45,'Dholakpur','Mate xs','Female','8712344590','jenny123@gmail.com',25);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `empId` int DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `age` int DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `DOJ` varchar(20) DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `phonenumber` varchar(11) DEFAULT NULL,
  `emailId` varchar(40) DEFAULT NULL,
  UNIQUE KEY `empId` (`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,10000,25,'John','Male','03-08-2020','Maintanence','1234657991','john20@gmail.com'),(2,50000,38,'Tom','Male','20-11-2011','HR','1234657992','tom11@gmail.com'),(3,30000,30,'Jenny','Female','23-05-2015','Manager','1234657993','jenny15@gmail.com'),(4,20000,26,'Mary','Female','05-08-2018','Sales Person','1234657994','mary18@gmail.com'),(5,25000,28,'Jack','Male','15-04-2017','Sales Person','1234657995','jack17@gmail.com'),(6,30000,27,'Ram','Male','15-11-2015','Sales Person','1234567996','ram15@gmail.com'),(7,45000,43,'Anil','Male','17 -03-2009','HR Manger','1234567997','anil09@gmail.com'),(8,32000,25,'Gita','Female','18-04-2014','HR','1234567998','gita14@gmail.com'),(9,42000,27,'Raj','Male','15-09-2007','Sales Person','1234567999','raj07@gmail.com'),(10,21000,23,'Abdul','Male','30-05-2018','General Manager','1234567990','abdul18@gmail.com'),(11,25000,21,'Amit','Male','31-01-2020','Sales Person','1234567911','amit20@gmail.com'),(12,18000,36,'Rani','Female','29-03-2018','Maintainance','1234567912','rani18@gmail.com'),(13,27000,30,'Ganesh','Male','14-04-2019','Sales Person','1234567913','ganesh19@gmail.com'),(14,50000,49,'Rina','Female','17-07-2006','HR Manager','1234567914','rina06@gmail.com'),(15,35000,32,'Rama','Female','23-10-2006','Sales Manager','1234567915','rama06@gmail.com'),(16,46000,47,'Rahul','Male','27-11-2010','HR','1234567916','rahul10@gmail.com'),(17,49000,48,'Narayan','Male','12-06-2003','Sales Person','1234567917','narayan03@gmail.com'),(18,24000,37,'Shobha','Female','30-06-2001','HR','1234567918','shobha01@gmail.com'),(19,22000,36,'Pankaj','Male','20-12-2006','Maintainance','1234567919','pankaj06@gmail.com'),(20,28000,24,'Parvati','Female','08-12-2018','Sales Manager','1234567920','parvati18@gmail.com'),(21,19000,23,'Priyanka','Female','07-08-2006','Maintainance','1234567921','priyanka06@gmail.com'),(22,38000,36,'Sandeep','Male','18-05-2004','HR','1234567922','sandeep04@gmail.com'),(23,51000,39,'Deepak','Male','23-10-2007','Sales Person','1234567923','deepak07@gmail.com'),(24,28000,26,'Sandhya','Female','28-06-2014','Sales Person','1234567924','sandhya14@gmail.com'),(25,46000,28,'Amar','Male','28-04-2003','HR','1234567925','amar03@gmail.com');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobile`
--

DROP TABLE IF EXISTS `mobile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mobile` (
  `id` int DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `os` varchar(50) DEFAULT NULL,
  `RAM` int DEFAULT NULL,
  `storage` int DEFAULT NULL,
  `battery` int DEFAULT NULL,
  `processor` varchar(50) DEFAULT NULL,
  `camera` varchar(50) DEFAULT NULL,
  `connectivity` varchar(50) DEFAULT NULL,
  `price` int DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobile`
--

LOCK TABLES `mobile` WRITE;
/*!40000 ALTER TABLE `mobile` DISABLE KEYS */;
INSERT INTO `mobile` VALUES (1,'Apple','IPhone 13','IOS',6,256,4000,'A15 Bionic','64 Megapixel','5G',130000),(2,'Samsung','Galaxy S21','Android',8,256,4000,'Exynos 2100','64 Megapixels','5G',114000),(3,'Oneplus','9 Pro','Android',8,128,4500,'Snapdragon 888','48 Megapixel','5G',56000),(4,'Google','Pixel 6 Pro','Android',12,256,5003,'Google Tensor','50 Megapixel','5G',66790),(5,'IQOO','7 Legend','Android',8,256,4103,'Snapdragon 888','48 Megapixel','5G',43000),(6,'Oneplus','Nord CE','Android',8,128,4400,'Snapdragon 865','48 Megapixel','5G',23000),(7,'Samsung','Galaxy A10','Android',8,128,5100,'Exynos7884','48 Megapixel','4G',21000),(8,'Apple','IPhone 12','IOS',6,128,3300,'A14 Bionic','64 Megapixel','5G',66000),(9,'Google','Nexus 6','Android',12,256,5100,'Google Tensor','50 Megapixel','5G',60000),(10,'Vivo','X70 Plus','Android',12,256,4800,'Snapdragon 888','50 Megapixel','5G',78000),(11,'Huawei','Mate xs','EMUI',8,256,4500,'Kirin 990','64 Megapixels','5G',278000);
/*!40000 ALTER TABLE `mobile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 20:45:23
