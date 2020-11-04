-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='';

-- -----------------------------------------------------
-- Schema tabletennisprojectdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tabletennisprojectdb` ;

-- -----------------------------------------------------
-- Schema tabletennisprojectdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tabletennisprojectdb` DEFAULT CHARACTER SET utf8 ;
USE `tabletennisprojectdb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(100) NULL,
  `city` VARCHAR(45) NULL,
  `state` CHAR(2) NULL,
  `zip` VARCHAR(45) NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skill_level`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill_level` ;

CREATE TABLE IF NOT EXISTS `skill_level` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `level_name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  `role` VARCHAR(45) NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `host` TINYINT(1) NOT NULL DEFAULT 1,
  `travel` TINYINT(1) NOT NULL DEFAULT 1,
  `address_id` INT NOT NULL,
  `skill_level_id` INT NOT NULL,
  `profile_image_url` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address1_idx` (`address_id` ASC),
  INDEX `fk_user_skill_level1_idx` (`skill_level_id` ASC),
  CONSTRAINT `fk_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_skill_level1`
    FOREIGN KEY (`skill_level_id`)
    REFERENCES `skill_level` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game` ;

CREATE TABLE IF NOT EXISTS `game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `d_time` DATETIME NOT NULL,
  `venue` VARCHAR(100) NOT NULL,
  `result` VARCHAR(100) NULL,
  `player_one_id` INT NOT NULL,
  `player_two_id` INT NOT NULL,
  `winner_id` INT NULL,
  `address_id` INT NOT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_game_user1_idx` (`player_one_id` ASC),
  INDEX `fk_game_user2_idx` (`player_two_id` ASC),
  INDEX `fk_game_user3_idx` (`winner_id` ASC),
  INDEX `fk_game_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_game_user1`
    FOREIGN KEY (`player_one_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_user2`
    FOREIGN KEY (`player_two_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_user3`
    FOREIGN KEY (`winner_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_users` ;

CREATE TABLE IF NOT EXISTS `favorite_users` (
  `user_id` INT NOT NULL,
  `favorite_id` INT NOT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`, `favorite_id`),
  INDEX `fk_user_has_user_user2_idx` (`favorite_id` ASC),
  INDEX `fk_user_has_user_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_user_user2`
    FOREIGN KEY (`favorite_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `player_rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `player_rating` ;

CREATE TABLE IF NOT EXISTS `player_rating` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `rated_user_id` INT NOT NULL,
  `rating` INT NULL,
  `comment` TEXT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_player_rating_user1_idx` (`user_id` ASC),
  INDEX `fk_player_rating_user2_idx` (`rated_user_id` ASC),
  CONSTRAINT `fk_player_rating_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_player_rating_user2`
    FOREIGN KEY (`rated_user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `team` ;

CREATE TABLE IF NOT EXISTS `team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `logo_url` VARCHAR(5000) NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `team_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `team_member` ;

CREATE TABLE IF NOT EXISTS `team_member` (
  `user_id` INT NOT NULL,
  `team_id` INT NOT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`, `team_id`),
  INDEX `fk_user_has_team_team1_idx` (`team_id` ASC),
  INDEX `fk_user_has_team_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_team_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_team_team1`
    FOREIGN KEY (`team_id`)
    REFERENCES `team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `game_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game_comment` ;

CREATE TABLE IF NOT EXISTS `game_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `game_id` INT NOT NULL,
  `comment_text` TEXT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_game_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_game_comment_game1_idx` (`game_id` ASC),
  CONSTRAINT `fk_game_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_comment_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS ttpuser@localhost;
SET SQL_MODE='';
CREATE USER 'ttpuser'@'localhost' IDENTIFIED BY 'ttpuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'ttpuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`, `enabled`) VALUES (1, '123 Apple Street', 'New Orleans', 'LA', '70094', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skill_level`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `skill_level` (`id`, `level_name`, `description`, `enabled`) VALUES (1, 'Advanced', 'I am awesome at table tennis ', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `user` (`id`, `email`, `password`, `enabled`, `role`, `first_name`, `last_name`, `host`, `travel`, `address_id`, `skill_level_id`, `profile_image_url`) VALUES (1, 'ashley@email.com', 'admin', 1, 'admin', 'Ashley', 'Davis', 1, 1, 1, 1, 'https://en.wikipedia.org/wiki/File:Gambia_girl.jpg');
INSERT INTO `user` (`id`, `email`, `password`, `enabled`, `role`, `first_name`, `last_name`, `host`, `travel`, `address_id`, `skill_level_id`, `profile_image_url`) VALUES (2, 'socrates@email.com', 'admin2', 1, NULL, 'Socrates', 'Epictetus', 1, 1, 1, 1, 'https://en.wikipedia.org/wiki/File:Laughing_boy_at_golden_hour.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `game`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `game` (`id`, `d_time`, `venue`, `result`, `player_one_id`, `player_two_id`, `winner_id`, `address_id`, `enabled`) VALUES (1, '2020-10-29 13:14:03', 'Ashley\'s house', 'Ashley won', 1, 2, 1, 1, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `favorite_users`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `favorite_users` (`user_id`, `favorite_id`, `enabled`) VALUES (1, 1, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `player_rating`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `player_rating` (`id`, `user_id`, `rated_user_id`, `rating`, `comment`, `enabled`) VALUES (1, 1, 1, 5, NULL, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `team`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `team` (`id`, `name`, `description`, `logo_url`, `enabled`) VALUES (1, 'Sharks', 'a ping pong team', 'https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.clipartmax.com%2Fpng%2Fmiddle%2F242-2423592_shark-contacts-shark-logo-png.png&imgrefurl=https%3A%2F%2Fwww.clipartmax.com%2Fmiddle%2Fm2H7K9G6Z5d3H7b1_shark-contacts-shark-logo-png%2F&tbnid=dORIiZVU2L9whM&vet=12ahUKEwiT57mHo93sAhVDLc0KHUnzCScQMygWegUIARClAg..i&docid=fYDar4OGuaKcCM&w=840&h=691&q=shark%20logo&ved=2ahUKEwiT57mHo93sAhVDLc0KHUnzCScQMygWegUIARClAg', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `team_member`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `team_member` (`user_id`, `team_id`, `enabled`) VALUES (1, 1, DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `game_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `tabletennisprojectdb`;
INSERT INTO `game_comment` (`id`, `comment_date`, `user_id`, `game_id`, `comment_text`, `enabled`) VALUES (1, '2020-10-29', 1, 1, 'Great game!', DEFAULT);

COMMIT;

