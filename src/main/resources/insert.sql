INSERT INTO user(username) VALUES
('Pierre'),
('Morgane'),
('Joatan'),
('Alizée'),
('Alexandra'),
('Laura'),
('Marina'),
('Alric'),
('Romain'),
('Antoine'),
('JS'),
('Mégane');

INSERT INTO channel (general, name) VALUES
(1,'general'),
(0,'java'),
(0,'javascript'),
(0,'python'),
(0,'Les devs sont ils les rois du monde'),
(0,'Centrer une div en css');


INSERT INTO message (content, channel_id, user_id) VALUES
('Bienvenue dans le canal general', 1, 1),
('Java cest top', 2, 4),
('Coder en javascript cest encore mieux', 3, 2),
('OULALAAAAAAA', 3, 8),
('mettre des $ rend til plus riche', 4, 6),
('roi du monde ou roi de stackoverflow', 5, 10),
('bootstrap vs tailwind', 6, 11),
('bulma cest bien aussi', 6, 8),
('react est mieux que angular dapres facebook', 3, 3);