-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS odb;
USE odb;


-- uacc – 사용자 가입 정보 테이블
CREATE TABLE uacc (
    userno INT AUTO_INCREMENT PRIMARY KEY,
    uid VARCHAR(50) NOT NULL UNIQUE,
    upw VARCHAR(100) NOT NULL,
    role VARCHAR(100) NOT NULL
);
-- ott – OTT 플랫폼 정의 테이블
CREATE TABLE ott (
    ottno INT AUTO_INCREMENT PRIMARY KEY,
    otype VARCHAR(50) NOT NULL UNIQUE
);
-- oacc – OTT 계정 정보 테이블
CREATE TABLE oacc (
    oaccno INT AUTO_INCREMENT PRIMARY KEY,
    ottno INT NOT NULL,
    oaccema VARCHAR(100) NOT NULL,
    oaccpw VARCHAR(100) NOT NULL,
    FOREIGN KEY (ottno) REFERENCES ott(ottno)
);
-- rent – 대여 정보 테이블
CREATE TABLE rent (
    rentno INT AUTO_INCREMENT PRIMARY KEY,
    userno INT NOT NULL,
    oaccno INT NOT NULL,
    rstart TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    rexpiry DATE,
    FOREIGN KEY (userno) REFERENCES uacc(userno),
    FOREIGN KEY (oaccno) REFERENCES oacc(oaccno)
);


-- 사용자 (uacc)
INSERT INTO uacc (uid, upw, role) VALUES
('admin1', 'adminpw1', 'admin'),
('user1', 'userpw1', 'user'),
('user2', 'userpw2', 'user'),
('user3', 'userpw3', 'user'),
('user4', 'userpw4', 'user'),
('user5', 'userpw5', 'user'),
('user6', 'userpw6', 'user'),
('user7', 'userpw7', 'user');
-- OTT 플랫폼 종류 (ott)
INSERT INTO ott (otype) VALUES
('Netflix'),
('DisneyPlus'),
('Watcha'),
('CoupangPlay');
-- OTT 계정 (oacc)
INSERT INTO oacc (ottno, oaccema, oaccpw) VALUES
(1, 'netflix_a@example.com', 'netpw123'),
(1, 'netflix_b@example.com', 'netpw456'),
(2, 'disney_a@example.com', 'dispw123'),
(3, 'watcha_a@example.com', 'watchapw'),
(4, 'coupang_a@example.com', 'cou1234');
-- 대여 정보 (rent)
INSERT INTO rent (userno, oaccno, rstart, rexpiry) VALUES
(2, 1, '2025-05-15', '2025-06-01'),
(3, 3, '2025-05-10', '2025-05-31'),
(4, 4, '2025-05-15', '2025-06-15'),
(5, 5, '2025-05-16', '2025-06-16'),
(6, 2, '2025-05-17', '2025-06-17'),
(7, 3, '2025-05-18', '2025-06-18');
