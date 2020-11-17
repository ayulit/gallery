ALTER TABLE person
    ADD CONSTRAINT UQ_person
        UNIQUE (email);

ALTER TABLE tag
    ADD CONSTRAINT UQ_tag
        UNIQUE (tag_name);

ALTER TABLE card
    ADD CONSTRAINT FK_card_category
        FOREIGN KEY (group_id)
            REFERENCES category (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE;

ALTER TABLE card_audit
    ADD CONSTRAINT FK_card_audit_card
        FOREIGN KEY (card_id)
            REFERENCES card (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE;

ALTER TABLE card_tags
    ADD CONSTRAINT FK_card_tags_tag
        FOREIGN KEY (tag_id)
            REFERENCES tag (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE;

ALTER TABLE card_tags
    ADD CONSTRAINT FK_card_tags_card
        FOREIGN KEY (card_id)
            REFERENCES card (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE;
