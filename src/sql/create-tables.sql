CREATE TABLE UserApp (
    username VARCHAR(40),
    password VARCHAR(10),
    role VARCHAR(10),
    PRIMARY KEY (username)
)

CREATE TABLE pieceOfArt (
    title VARCHAR(40),
    username VARCHAR(40),
    fcoins INT,
    image_url VARCHAR(1000),
    colection VARCHAR(40),
    PRIMARY KEY(title),
    FOREIGN KEY(username) REFERENCES UserApp(username)
)

CREATE TABLE Colection (
    title VARCHAR(40),
    image_url VARCHAR(1000),
    PRIMARY KEY(title)
)

CREATE TABLE artLikes (
    username VARCHAR(40),
    image_url VARCHAR(100),
    artLikes INT,
    PRIMARY KEY (artLikes),
    FOREIGN KEY (image_url) REFERENCES pieceOfArt (image_url),
    FOREIGN KEY (username) REFERENCES UserApp (username)
)