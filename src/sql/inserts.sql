
INSERT INTO UserApp (username, password, role) VALUES ('juan_carlos02', 'salchipapa', 'artist')
INSERT INTO UserApp (username, password, role) VALUES ('Daniela_02', 'empanadas', 'comprador')
INSERT INTO UserApp (username, password, role) VALUES ('jose', 'cocacola', 'comprador')
INSERT INTO UserApp (username, password, role) VALUES ('johan', 'choclitos', 'artist')

INSERT INTO pieceOfArt (title, Fcoins, image_url) VALUES ('flores', '30', 'C:\fakepath\País-de-origen-de-las-flores-más-bonitas-del-mundo.jpg')
INSERT INTO pieceOfArt (title, Fcoins, image_url) VALUES ('familia', '100', 'https://www.mundoprimaria.com/wp-content/uploads/2020/07/lectura-mi-familia.jpg')

INSERT INTO colection (title, image_url) VALUES ('flores', 'C:\fakepath\País-de-origen-de-las-flores-más-bonitas-del-mundo.jpg')
INSERT INTO colection (title, image_url) VALUES ('familia', 'https://www.mundoprimaria.com/wp-content/uploads/2020/07/lectura-mi-familia.jpg')

INSERT INTO artLikes (username, image_url, artlikes) VALUES ('jose', 'https://www.mundoprimaria.com/wp-content/uploads/2020/07/lectura-mi-familia.jpg', '1')
INSERT INTO artLikes (username, image_url, artLikes) VALUES ('Daniela_02', 'C:\fakepath\País-de-origen-de-las-flores-más-bonitas-del-mundo.jpg', '2')