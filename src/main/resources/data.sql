insert into ARTICLE(id,title,content) values (1, '가가가', '1111');
insert into ARTICLE(id,title,content) values (2, '나나나', '2222');
insert into ARTICLE(id,title,content) values (3, '다다다', '3333');

-- article 더미 데이터
insert into ARTICLE (id,title,content)values (4, '너가 좋아하는 음식', '댓글ㄱ');
insert into ARTICLE(id,title,content) values (5, '너가 좋아하는 색깔', '댓글ㄱㄱ');
insert into ARTICLE(id,title,content) values (6, '너의 습관', '댓글ㄱㄱ');

-- commnet 더미데이터
-- 4번 게시글의 댓글들
insert into comment(id,article_id,nickname,body) values (1,4, 'park','피자');
insert into comment(id,article_id,nickname,body) values (2,4, 'kim', '치킨');
insert into comment(id,article_id,nickname,body) values (3,4, 'Lee', '족발');
-- 5번 게시글의 댓글들
insert into comment(id,article_id,nickname,body) values (4,5, 'park','빨강');
insert into comment(id,article_id,nickname,body) values (5,5, 'kim', '파랑');
insert into comment(id,article_id,nickname,body) values (6,5, 'Lee', '초록');
-- 6번 게시글의 댓글들
insert into comment(id,article_id,nickname,body) values (7,6, 'park','다리떨기');
insert into comment(id,article_id,nickname,body) values (8,6, 'kim', '펜돌리기');
insert into comment(id,article_id,nickname,body) values (9,6, 'Lee', '손톱만지기');
