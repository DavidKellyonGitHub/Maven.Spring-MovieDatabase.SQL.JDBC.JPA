insert into movies values ('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');
insert into movies values ('Lavalantula', 83, 'Horror', 4.7, 'TV-14');
insert into movies values ('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13');
insert into movies values ('Waltz With Bashir', 90, 'Documentary', 8.0, 'R');
insert into movies values ('Spaceballs', 96, 'Comedy', 7.1, 'PG');
insert into movies values ('Monsters Inc', 92, 'Animation', 8.1, 'G');
insert into movies values ('Temple of Doom', 100, 'Action', 10, 'PG');
insert into movies values ('Last Crusade', 100, 'Action', 10, 'PG');
insert into movies values ('Lost Ark', 100, 'Action', 10, 'PG');

select * from movies where genre = 'Sci-Fi';

select * from movies where IMDB score >= 6.5;

select * from movies where rating in ('PG', 'G') and Runtime <= 100;

select avg(runtime), genre from movies where imdb score < 7.5 group by genre;

update movies set (rating = 'R') where title = 'Starship Troopers';

select id, rating from movies where genre in ('horror', 'documentary');

select avg(imdb score), max(imdb score), min(imdb score), rating from movies group by rating having count(*) > 1;

delete from movies where rating = 'R';
