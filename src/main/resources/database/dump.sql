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
insert into users (login, password, email, address, phone, firstName, lastName, photo, type) values ('a', 'a', 'a', 'a', 'a', 'a', 'a', 'https://icon-library.net/images/default-user-icon/default-user-icon-8.jpg', 1);

-- -----------------------------------------------------
-- Table `BookOfRecipes`.`CategoriesOfRecipes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`CategoriesOfRecipes` (
  `categoryOfRecipesId` INT NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`categoryOfRecipesId`),
  UNIQUE INDEX `cathegoryOfRecipesIdUniqueIndex` (`categoryOfRecipesId` ASC))
ENGINE = InnoDB;

insert into categoriesofrecipes (categoryOfRecipesId, category) values (1, 'Hot dishes');
insert into categoriesofrecipes (categoryofrecipesId, category) values (2, 'salads');
insert into categoriesofrecipes (categoryofrecipesId, category) values (3, 'snacks');
insert into categoriesofrecipes (categoryofrecipesId, category) values (4, 'soups');
insert into categoriesofrecipes (categoryofrecipesId, category) values (5, 'baking');
insert into categoriesofrecipes (categoryofrecipesId, category) values (6, 'desserts');
insert into categoriesofrecipes (categoryofrecipesId, category) values (7, 'drinks');
-- -----------------------------------------------------
-- Table `BookOfRecipes`.`Recipes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`Recipes` (
  `recipeId` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `userLogin` VARCHAR(45) NOT NULL,
  `uploadDate` DATE NOT NULL,
  `photo` TEXT NOT NULL,
  `description` TEXT NOT NULL,
  `categoryId` INT NOT NULL,
  PRIMARY KEY (`recipeId`),
  UNIQUE INDEX `recipeIdUniqueIndex` (`recipeId` ASC),
  UNIQUE INDEX `name_UNIQUE` (`title` ASC),
  INDEX `RecipesCategoriesOfRecipesFK_idx` (`categoryId` ASC),
  CONSTRAINT `RecipesUsersFK`
    FOREIGN KEY (`userLogin`)
    REFERENCES `BookOfRecipes`.`Users` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `RecipesCategoriesOfRecipesFK`
    FOREIGN KEY (`categoryId`)
    REFERENCES `BookOfRecipes`.`CategoriesOfRecipes` (`categoryOfRecipesId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

insert into recipes (title, userLogin, uploadDate, photo, description, categoryId) values ('Hot dish', 'a', '2019-09-19', 'http://www.good-cook.ru/articles/2016/07/16-1-domashnyaya-eda.jpg', 'aaaaa', 1);
-- -----------------------------------------------------
-- Table `BookOfRecipes`.`Marks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookOfRecipes`.`Marks` (
  `markId` INT NOT NULL,
  `recipeName` VARCHAR(45) NOT NULL,
  `userLogin` VARCHAR(45) NOT NULL,
  `mark` INT NOT NULL,
  PRIMARY KEY (`markId`),
  UNIQUE INDEX `markIdUniqueIndex` (`markId` ASC),
  UNIQUE INDEX `userUniqueIndex` (`userLogin` ASC),
  UNIQUE INDEX `markUniqueIndex` (`mark` ASC),
  INDEX `MarksRecipesFK_idx` (`recipeName` ASC),
  CONSTRAINT `MarksRecipesFK`
    FOREIGN KEY (`recipeName`)
    REFERENCES `BookOfRecipes`.`Recipes` (`title`)
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
    REFERENCES `BookOfRecipes`.`Recipes` (`title`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `CommentsUsersFK`
    FOREIGN KEY (`userLogin`)
    REFERENCES `BookOfRecipes`.`Users` (`login`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;