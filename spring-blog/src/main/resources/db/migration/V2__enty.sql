create table entries(id bigint auto_increment PRIMARY KEY, title varchar(150), description varchar(250), content varchar(500),
 create_time timestamp, user_id bigint);
insert into entries(title, description, content, create_time, user_id) values ('Őszi böjt 6.nap', 'Öszi böjtöm története',
                'A blog.hu-n található blogomba nem tudok belépni, ezért írtam egy saját blogot, ahol folytathatom a történetemet.
                 A mai napon jól ment a méregtelenítés, eléggé lepedékes volt a nyelvem. Este 59,5 kg voltam.', '2022-12-03 14:04:39', 1);
insert into entries(title, description, content, create_time, user_id) values ('Őszi böjt 7.nap', 'Öszi böjtöm 7.napomnak történései',
                   ' Ezen a napon is volt még méregtelenítés, biztosan azért mert az utolsó böjtöm 1 évvel ezelőtt volt. A mostani böjt nem viselt meg túlzottan, minden úgy ment mint a karikacsapás. Az utóbbi napokban elég sok gyümölcslevet ittam.
                     Este 59,5 kg voltam.', '2022-12-04 14:07:55', 1);
insert into entries(title, description, content, create_time, user_id) values ('Őszi böjt 8.nap', 'Öszi böjtöm 8.napomnak történései',
                 'Ezen a napon reggel még nem terveztem hogy este befejezem, de valahogy így alakult. Este már ettem elég sok főtt krumplit, meg répát is. Keveset akartam de sokat sikerült és nem lett belőle baj. Délben még ettem előtte 1 mandarint.
                  Este 59,5 kg voltam.', '2022-12-05 14:10:19', 1);
insert into entries(title, description, content, create_time, user_id) values ('Nyári böjt 1.nap', 'A böjtöm 1. napjáról szól',
                            'Most már nagyon régen böjtölni szerettem volna, végre sikerült. Az első nap futottam 46km-t. Ennek köszönhetően nem nagyon voltam éhes. Este azért még ettem 2 kekszet.
                             Este 63 kg voltam', '2023-07-08 20:13:50', 1);
insert into entries(title, description, content, create_time, user_id) values ('Nyári böjt 2.nap', 'Nyári böjtöm 2. napjának története',
                       'Ma reggel voltam a kertben. A kajszik között volt olyan ami elég jó volt, és megettem párat belőle. Nem voltak szállíthatóak. Pár kekszet is ettem napközben. A nap többi részében leveket ittam paradicsomlét és körte levet.
                        Este 63 kg voltam.', '2023-07-09 20:19:35', 1);
insert into entries(title, description, content, create_time, user_id) values ('Nyári böjt 3.nap', 'A 3. napot írom le',
                        'Ma voltam bent a siton, egyáltalán nem voltam éhes. 37 fokot jósoltak, de én fáztam a légkondiban, jólesett kint sétálni délben. Kubut és márka multivitamint ittam, este ananászlevet. Nagy jégverés volt délután, az autóm szélvédője is megrepedt.
                         Este 63 kg voltam.', '2023-07-10 17:57:31', 1);
insert into entries(title, description, content, create_time, user_id) values ('Nyári böjt 4.nap', 'A 4. nap leírása',
                         'Jól ment ma a böjt egyáltalán nem voltam éhes. Reggel teát ittam, ahogy szoktam, utána pedig leveket. Voltunk ma a boltban, azért vettem amit szoktam.
                          Este 62.5 kg voltam', '2023-07-11 17:59:34', 1);
insert into entries(title, description, content, create_time, user_id) values ('Nyári böjt 5.nap', 'Ez a bejegyzés a böjtöm 5. napjáról szól',
                'Hú már 5 napja böjtölök. Ma kissé elengedtem magam megettem 3 szem meggyet. Jó volt. Amúgy leveket ittam mint tegnap. Tulajdonképpen jól ment a böjt, bár néha kicsit mintha éhes lettem volna. Még most is elég erősen méregtelenedem.
                 Este 61.5 kg voltam.', '2023-07-12 17:23:25', 1);
insert into entries(title, description, content, create_time, user_id) values ('Nyári böjt 6.nap', 'A böjtöm 6. napja',
               'Ma reggel kicsit nehezen indult a böjt, a hasam mintha kicsit kemény lett volna. Aztán elmúlt ez az érzés. Ma kicsit kevesebb levet ittam, mint tegnap. Eszembe jutott a szárazböjt, így délig azt csináltam. Egész nap itthon voltam, elég meleg volt.
                Este 60.5 kg voltam.', '2023-07-13 18:35:00', 1);
insert into entries(title, description, content, create_time, user_id) values ('Nyári böjt 7.nap', 'Ez a böjtöm 7. napjának története',
            'Ma elérkeztem a böjt utolsó napjához. Holnap elfogynak a leveim, ezért úgy döntöttem, hogy vége a böjtnek. Nem szabad keverni a Cappy és a Happy Day multivitaminos levét, mert rosszul lettem tőle.
             Este 60.5 kg voltam', '2023-07-14 19:36:18', 1);
insert into entries(title, description, content, create_time, user_id) values ('Visszaállás 1. nap', 'Böjt utáni 1. nap',
             'Ezen a napon már elég sokat ettem. Reggel futottam 35km-t. Ez előtt csak egy teát ittam. Majd amikor hazaértem ettem egy szilvát és egy kekszet. A nap folyamán még ettem pár szilvát két zacskó ropit, este pedig jó sok főtt krumplit, kevesebb répát.
              Este 60.5 kg voltam', '2023-07-15 13:28:42', 1);
insert into entries(title, description, content, create_time, user_id) values ('Visszaállás 2. nap', 'A böjt befejezését követő 2. nap',
              'Ma már szinte mindent ettem amit szoktam. reggel mentem a kertbe, ott ettem pár kajszit, és pár őszibarackot, meg fügét. Aztán délután ettem 2 banánt, kekszet meg sós kukit.
               Este 60 kg voltam.', '2023-07-16 17:12:51', 1);
insert into entries(title, description, content, create_time, user_id) values ('Tavaszi böjt 0. nap', 'Ez a 0. nap',
              'Ma végre elkezdtem a böjtöt, kevesebbet ettem mint szoktam. Egész nap egy bucit egy fél fokhagymás kiflit és kevés joghurtot. Jó sok teát ittam, főleg csak délelőtt.
               Délután 61 kg voltam.', '2024-05-16 21:37:33', 1);
insert into entries(title, description, content, create_time, user_id) values ('Tavaszi böjt 1. nap', 'A böjtöm 1 napja',
              'Ma elég jól ment a böjt. Egész estig csak pár pohár teát és kevés narancslevet ittam. Este kicsit megéheztem, akkor ettem egy túrórudit. Jó volt.
               Este 60,5 kg voltam.', '2024-05-17 23:07:51', 1);
insert into entries(title, description, content, create_time, user_id) values ('Tavaszi böjt 2. nap', 'A böjtöm második napját írom le',
              'Ma is elég jól ment a böjt, alig voltam éhes. Kicsit reggel, de akkor ittam teát és elmúlt. Jól méregtelenedtem. Ittam Hohes C-t és fekete ribizli levet.
               Ma ültettem a bárnai kertbe cukkinit, karalábét, céklát és patiszont is.
               Este 60 kg voltam.', '2024-05-18 20:59:09', 1);
insert into entries(title, description, content, create_time, user_id) values ('Tavaszi böjt 3. nap', 'A 3. napon történtek',
              'Ma már kicsit ettem, néhány epret, és egy banánt. A kertben ástam és gyomláltam az epret. Jólesett egy kis mozgás.
               Este 59,5 kg voltam.', '2024-05-19 23:29:41', 1);
insert into entries(title, description, content, create_time, user_id) values ('Tavaszi böjt 4. nap', '4. nap tartalma',
             'Ma is voltam a kertben, befejeztem a tök, uborka, cukkini ültetést. Reggelre jól méregtelenedtem, jólesett a tea. Ettem pár szem epret a kertben és egy csokis parányt, este pedig egy banánt. Nem ártott meg.
              Nappal 60 kg voltam.', '2024-05-20 12:37:03', 1);
insert into entries(title, description, content, create_time, user_id) values ('Tavaszi böjt 5. nap', 'Az 5. nap történései',
              'Eljött ez a nap is. Annyira nem éreztem hogy méregtelenedtem volna reggelre. Reggel a szokásos teával indítottam, aztán narancslevet ittam. Ma lesz a böjt utolsó napja, mert holnapra már nincsenek leveim és nincs kedvem boltba menni. Késő délután már ettem egy csomó kelkáposzta főzeléket. Nem ártott meg, sőt jólesett
               Délután 60 kg voltam.', '2024-05-21 13:11:59', 1);
insert into entries(title, description, content, create_time, user_id) values ('Visszaállás 1. nap', 'Befejeztem a böjtöt',
              'Ma már teljesen úgy ettem, mint máskor. Azt hiszem nem is lesz második visszaállós nap. Nem volt túl támogató a környezet, így nem is sikerült úgy a böjt ahogy szerettem volna. Nem baj, majd legközelebb.',
               '2024-05-22 15:07:22', 1);
insert into entries(title, description, content, create_time, user_id) values ('MűvészTerem tagság', 'Művészterem jelentkezés',
              'Beléptem a MűvészTerem-be. A művészterem facebook csoportja itt található:
               <a href="https://www.facebook.com/muveszterem">MűvészTerem facebook.</a>
               Itt vannak a MűvészTerembe belépett alkotók: <a href="https://www.muveszterem.hu/hu_hu/muveszek/">MűvészTerem alkotói.</a>
               Itt pedig a MűvészTerem privát facebook csoportja:
               <a href="https://www.facebook.com/groups/muveszterem">Privát facebook csoport.</a>', '2024-08-18 17:30:49', 1);
insert into entries(title, description, content, create_time, user_id) values ('Első kiállításom', 'Első kiállításomról szóló bejegyzés',
              'Ma kezdődött az első kiállításom <img src="../assets/Meghivo.jpg" alt="Kiállítás meghívó">', '2024-08-21 16:51:05', 1);

