INSERT INTO category (group_name)
VALUES ('Animals'),
       ('Military'),
       ('Girls'),
       ('Kids');

INSERT INTO tag (tag_name)
VALUES ('cat'),
       ('happy'),
       ('nature'),
       ('funny'),
       ('tank'),
       ('plane');

# Card 1
SELECT id INTO @category_id FROM category WHERE group_name = 'Animals';
SELECT id INTO @tag_id1 FROM tag WHERE tag_name = 'cat';
SELECT id INTO @tag_id2 FROM tag WHERE tag_name = 'funny';

INSERT INTO card (added, description, group_id, link, dpi, title, version)
VALUES (curtime(), 'Different cats', @category_id, 'http://blablabla', 300, 'Cool cats', 0);

SET @card_id = LAST_INSERT_ID();

INSERT INTO card_tags (card_id, tag_id)
VALUES (@card_id, @tag_id1),
       (@card_id, @tag_id2);

# Card 2
SELECT id INTO @category_id FROM category WHERE group_name = 'Kids';
SELECT id INTO @tag_id1 FROM tag WHERE tag_name = 'funny';
SELECT id INTO @tag_id2 FROM tag WHERE tag_name = 'happy';

INSERT INTO card (added, description, group_id, link, dpi, title, version)
VALUES (curtime(), 'Two baby brothers', @category_id, 'http://blablabla', 300, 'Twins', 0);

SET @card_id = LAST_INSERT_ID();

INSERT INTO card_tags (card_id, tag_id)
VALUES (@card_id, @tag_id1),
       (@card_id, @tag_id2);

# Card 3
SELECT id INTO @category_id FROM category WHERE group_name = 'Kids';
SELECT id INTO @tag_id1 FROM tag WHERE tag_name = 'funny';
SELECT id INTO @tag_id2 FROM tag WHERE tag_name = 'happy';
SELECT id INTO @tag_id3 FROM tag WHERE tag_name = 'cat';

INSERT INTO card (added, description, group_id, link, dpi, title, version)
VALUES (curtime(), 'Kid plays with a cat', @category_id, 'http://blablabla', 300, 'Kid and Cat', 0);

SET @card_id = LAST_INSERT_ID();

INSERT INTO card_tags (card_id, tag_id)
VALUES (@card_id, @tag_id1),
       (@card_id, @tag_id2),
       (@card_id, @tag_id3);

# Card 4
SELECT id INTO @category_id FROM category WHERE group_name = 'Animals';
SELECT id INTO @tag_id1 FROM tag WHERE tag_name = 'funny';
SELECT id INTO @tag_id2 FROM tag WHERE tag_name = 'cat';

INSERT INTO card (added, description, group_id, link, dpi, title, version)
VALUES (curtime(), 'Kitten and his mom', @category_id, 'http://blablabla', 300, 'Mom & kitten', 0);

SET @card_id = LAST_INSERT_ID();

INSERT INTO card_tags (card_id, tag_id)
VALUES (@card_id, @tag_id1),
       (@card_id, @tag_id2);

# Card 5
SELECT id INTO @category_id FROM category WHERE group_name = 'Military';
SELECT id INTO @tag_id FROM tag WHERE tag_name = 'tank';

INSERT INTO card (added, description, group_id, link, dpi, title, version)
VALUES (curtime(), '42 tanks', @category_id, 'http://blablabla', 300, 'Tank battalion', 0);

SET @card_id = LAST_INSERT_ID();

INSERT INTO card_tags (card_id, tag_id)
VALUES (@card_id, @tag_id);

# Card 6
SELECT id INTO @category_id FROM category WHERE group_name = 'Military';
SELECT id INTO @tag_id FROM tag WHERE tag_name = 'plane';

INSERT INTO card (added, description, group_id, link, dpi, title, version)
VALUES (curtime(), 'Airshow during military parade', @category_id, 'http://blablabla', 300, 'Airshow', 0);

SET @card_id = LAST_INSERT_ID();

INSERT INTO card_tags (card_id, tag_id)
VALUES (@card_id, @tag_id);

# Card 7
SELECT id INTO @category_id FROM category WHERE group_name = 'Military';
SELECT id INTO @tag_id1 FROM tag WHERE tag_name = 'plane';
SELECT id INTO @tag_id2 FROM tag WHERE tag_name = 'tank';

INSERT INTO card (added, description, group_id, link, dpi, title, version)
VALUES (curtime(), 'Cool map for the multiplayer', @category_id, 'http://blablabla', 300, 'Red Alert Map', 0);

SET @card_id = LAST_INSERT_ID();

INSERT INTO card_tags (card_id, tag_id)
VALUES (@card_id, @tag_id1),
       (@card_id, @tag_id2);
