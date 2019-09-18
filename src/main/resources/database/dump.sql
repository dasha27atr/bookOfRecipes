CREATE SCHEMA IF NOT EXISTS `BookOfRecipes` DEFAULT CHARACTER SET utf8 ;
USE `BookOfRecipes` ;

-- -----------------------------------------------------
-- Table `BookOfRecipes`.`TypesOfUsers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`TypesOfUsers` (
  `typeId` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`typeId`),
  UNIQUE INDEX `typeIdUniqueIndex` (`typeId` ASC))
ENGINE = InnoDB;

insert into typesOfUsers (typeId, type) values (1, 'user');

-- -----------------------------------------------------
-- Table `BookOfRecipes`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`Users` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(40) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(60) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `photo` TEXT NOT NULL,
  `type` INT NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userLoginUniqueIndex` (`login` ASC),
  UNIQUE INDEX `userPasswordUniqueIndex` (`password` ASC),
  UNIQUE INDEX `userIdUniqueIndex` (`userId` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC),
  INDEX `UsersTypesOfUsersFK_idx` (`type` ASC),
  CONSTRAINT `UsersTypesOfUsersFK`
    FOREIGN KEY (`type`)
    REFERENCES `BookOfRecipes`.`TypesOfUsers` (`typeId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

insert into users (login, password, email, address, phone, firstName, lastName, photo, type) values ('dasha27atr', 'dasha27', 'dasha27atr@gmail.com', 'Panchenko, 76-96', '80447047452', 'Daria', 'Atrashevskaya', 'https://icon-library.net/images/default-user-icon/default-user-icon-8.jpg',1);

-- -----------------------------------------------------
-- Table `BookOfRecipes`.`CathegoriesOfRecipes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`CathegoriesOfRecipes` (
  `cathegoryOfRecipesId` INT NOT NULL,
  `cathegory` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cathegoryOfRecipesId`),
  UNIQUE INDEX `cathegoryOfRecipesIdUniqueIndex` (`cathegoryOfRecipesId` ASC),
  UNIQUE INDEX `cathegoryOfRecipesUniqueIndex` (`cathegory` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookOfRecipes`.`Recipes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`Recipes` (
  `recipeId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `userLogin` VARCHAR(45) NOT NULL,
  `uploadDate` DATE NOT NULL,
  `photo` TEXT NOT NULL,
  `description` TEXT NOT NULL,
  `categoryId` INT NOT NULL,
  PRIMARY KEY (`recipeId`),
  UNIQUE INDEX `userIdUniqueIndex` (`userLogin` ASC),
  UNIQUE INDEX `recipeIdUniqueIndex` (`recipeId` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  CONSTRAINT `RecipesCathegoriesOfRecipesFK`
    FOREIGN KEY (`categoryId`)
    REFERENCES `BookOfRecipes`.`CathegoriesOfRecipes` (`cathegoryOfRecipesId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `RecipesUsersFK`
    FOREIGN KEY (`userLogin`)
    REFERENCES `BookOfRecipes`.`Users` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookOfRecipes`.`Marks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`Marks` (
  `markId` INT NOT NULL,
  `recipeName` VARCHAR(45) NOT NULL,
  `userLogin` VARCHAR(20) NOT NULL,
  `mark` INT NOT NULL,
  PRIMARY KEY (`markId`),
  UNIQUE INDEX `markIdUniqueIndex` (`markId` ASC),
  UNIQUE INDEX `recipeUniqueIndex` (`recipeName` ASC),
  UNIQUE INDEX `userUniqueIndex` (`userLogin` ASC),
  UNIQUE INDEX `markUniqueIndex` (`mark` ASC),
  CONSTRAINT `MarksRecipesFK`
    FOREIGN KEY (`recipeName`)
    REFERENCES `BookOfRecipes`.`Recipes` (`name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `MarksUsersFK`
    FOREIGN KEY (`userLogin`)
    REFERENCES `BookOfRecipes`.`Users` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookOfRecipes`.`Comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`Comments` (
  `commentId` INT NOT NULL,
  `recipeName` VARCHAR(45) NOT NULL,
  `userLogin` VARCHAR(20) NOT NULL,
  `comment` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`commentId`),
  UNIQUE INDEX `commentIdUniqueIndex` (`commentId` ASC),
  UNIQUE INDEX `recipeUniqueIndex` (`recipeName` ASC),
  UNIQUE INDEX `userUniqueIndex` (`userLogin` ASC),
  UNIQUE INDEX `commentUniqueIndex` (`comment` ASC),
  CONSTRAINT `CommentsRecipesFK`
    FOREIGN KEY (`recipeName`)
    REFERENCES `BookOfRecipes`.`Recipes` (`name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `CommentsUsersFK`
    FOREIGN KEY (`userLogin`)
    REFERENCES `BookOfRecipes`.`Users` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;