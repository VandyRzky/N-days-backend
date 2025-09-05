SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `n_days_backend`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `postcode` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `city`, `postcode`) VALUES
('address-9c473279-f2e3-4a53-9561-7b52d9a213f0', 'coba3', '123'),
('address-e3c6d6a5-cffc-4bc4-93ad-be281420fc13', 'coba1', '123');

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `address_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `first_name`, `last_name`, `address_id`) VALUES
('author-91d182e8-c8bc-4df7-b235-f8f80dea1492', 'coba1', 'coba1', 'address-e3c6d6a5-cffc-4bc4-93ad-be281420fc13'),
('author-be72a387-7b89-495a-9655-510850b101f3', 'coba3', 'coba3', 'address-9c473279-f2e3-4a53-9561-7b52d9a213f0');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` varchar(100) NOT NULL,
  `title` text NOT NULL,
  `added_date` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `title`, `added_date`, `author_id`) VALUES
('book-41b29a82-35d3-44f3-940e-7359b32ac5f7', 'ini buku 4', 'Mon Aug 25 22:51:06 SGT 2025', 'author-91d182e8-c8bc-4df7-b235-f8f80dea1492'),
('book-46fc3c77-351a-4600-868c-864ca4e0ffcd', 'ini buku 2', 'Mon Aug 25 22:50:56 SGT 2025', 'author-91d182e8-c8bc-4df7-b235-f8f80dea1492'),
('book-566cd5c1-bf61-4a63-9c72-3729ca43de32', 'ini buku 3', 'Mon Aug 25 22:51:01 SGT 2025', 'author-91d182e8-c8bc-4df7-b235-f8f80dea1492');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`) VALUES
('user-a414c8b9-b017-4082-8bb4-e87dd8b4c109', 'cobauser2', 'cobauser2'),
('user-dd255765-d5e2-4bd4-9ed6-c4b611d490f0', 'cobauser1', 'cobauser1');

-- --------------------------------------------------------

--
-- Table structure for table `users_book`
--

CREATE TABLE `users_book` (
  `book_id` varchar(100) NOT NULL,
  `user_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkaddress` (`address_id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkauthor` (`author_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_book`
--
ALTER TABLE `users_book`
  ADD PRIMARY KEY (`book_id`,`user_id`),
  ADD KEY `fkuser` (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `author`
--
ALTER TABLE `author`
  ADD CONSTRAINT `fkaddress` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `fkauthor` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users_book`
--
ALTER TABLE `users_book`
  ADD CONSTRAINT `fkbook` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fkuser` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
