INSERT INTO DISTILLERY(ID, NAME, FOUNDED, COUNTRY, PROVINCE, CITY) VALUES(NEXTVAL('seq_distillery'), 'Talisker', CURRENT_DATE, 'Scotland', 'Islay', 'Islay');
INSERT INTO TASTING_NOTE(ID, name) VALUES(NEXTVAL('seq_tasting_note'), 'Caramelo');
INSERT INTO TASTING_NOTE(ID, name) VALUES(NEXTVAL('seq_tasting_note'), 'Humo');
INSERT INTO TASTING_NOTE(ID, name) VALUES(NEXTVAL('seq_tasting_note'), 'Coco');