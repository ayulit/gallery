-- MariaDB
-- SELECT DATABASE();
-- use gallery;

insert into category (group_name) values ('Animals'), ('Military'), ('Girls'), ('Kids');
insert into tag (tag_name) values ('cat'), ('happy'), ('nature'), ('funny'), ('tank'), ('plane');

# Card 1
select id into @category_id from category where group_name = 'Animals';
select id into @tag_id1 from tag where tag_name = 'cat';
select id into @tag_id2 from tag where tag_name = 'funny';

insert into card (added, description, group_id, link, dpi, title, version) values (curtime(), 'Different cats', @category_id, 'http://blablabla', 300, 'Cool cats', 0);
SET @card_id = LAST_INSERT_ID();
insert into card_tags (card_id, tag_id) values (@card_id, @tag_id1), (@card_id, @tag_id2);

# Card 2
select id into @category_id from category where group_name = 'Kids';
select id into @tag_id1 from tag where tag_name = 'funny';
select id into @tag_id2 from tag where tag_name = 'happy';

insert into card (added, description, group_id, link, dpi, title, version) values (curtime(), 'Two baby brothers', @category_id, 'http://blablabla', 300, 'Twins', 0);
SET @card_id = LAST_INSERT_ID();
insert into card_tags (card_id, tag_id) values (@card_id, @tag_id1), (@card_id, @tag_id2);

# Card 3
select id into @category_id from category where group_name = 'Kids';
select id into @tag_id1 from tag where tag_name = 'funny';
select id into @tag_id2 from tag where tag_name = 'happy';
select id into @tag_id3 from tag where tag_name = 'cat';

insert into card (added, description, group_id, link, dpi, title, version) values (curtime(), 'Kid plays with a cat', @category_id, 'http://blablabla', 300, 'Kid and Cat', 0);
SET @card_id = LAST_INSERT_ID();
insert into card_tags (card_id, tag_id) values (@card_id, @tag_id1), (@card_id, @tag_id2), (@card_id, @tag_id3);

# Card 4
select id into @category_id from category where group_name = 'Animals';
select id into @tag_id1 from tag where tag_name = 'funny';
select id into @tag_id2 from tag where tag_name = 'cat';

insert into card (added, description, group_id, link, dpi, title, version) values (curtime(), 'Kitten and his mom', @category_id, 'http://blablabla', 300, 'Mom & kitten', 0);
SET @card_id = LAST_INSERT_ID();
insert into card_tags (card_id, tag_id) values (@card_id, @tag_id1), (@card_id, @tag_id2);

# Card 5
select id into @category_id from category where group_name = 'Military';
select id into @tag_id from tag where tag_name = 'tank';

insert into card (added, description, group_id, link, dpi, title, version) values (curtime(), '42 tanks', @category_id, 'http://blablabla', 300, 'Tank battalion', 0);
SET @card_id = LAST_INSERT_ID();
insert into card_tags (card_id, tag_id) values (@card_id, @tag_id);

# Card 6
select id into @category_id from category where group_name = 'Military';
select id into @tag_id from tag where tag_name = 'plane';

insert into card (added, description, group_id, link, dpi, title, version) values (curtime(), 'Airshow during military parade', @category_id, 'http://blablabla', 300, 'Airshow', 0);
SET @card_id = LAST_INSERT_ID();
insert into card_tags (card_id, tag_id) values (@card_id, @tag_id);

# Card 7
select id into @category_id from category where group_name = 'Military';
select id into @tag_id1 from tag where tag_name = 'plane';
select id into @tag_id2 from tag where tag_name = 'tank';

insert into card (added, description, group_id, link, dpi, title, version) values (curtime(), 'Cool map for the multiplayer', @category_id, 'http://blablabla', 300, 'Red Alert Map', 0);
SET @card_id = LAST_INSERT_ID();
insert into card_tags (card_id, tag_id) values (@card_id, @tag_id1), (@card_id, @tag_id2);
