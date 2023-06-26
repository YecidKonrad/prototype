INSERT INTO acceso.countries (country) VALUES ('Colombia');

INSERT INTO acceso.identification_types (identification, name, id_country) VALUES ('CC', 'Cedula de ciudadanía', 1);
INSERT INTO acceso.identification_types (identification, name, id_country) VALUES ('TI', 'Tarjeta de identidad', 1);
INSERT INTO acceso.identification_types (identification, name, id_country) VALUES ('CE', 'Cédula de Extranjería', 1);

INSERT INTO acceso.state_phase (state) VALUES ('En ejecución');
INSERT INTO acceso.state_phase (state) VALUES ('Por ejecutar');
INSERT INTO acceso.state_phase (state) VALUES ('Finalizada');

INSERT INTO acceso.state_activity (state) VALUES ('Por ejecutar');
INSERT INTO acceso.state_activity (state) VALUES ('En ejecución');
INSERT INTO acceso.state_activity (state) VALUES ('Finalizada');

INSERT INTO acceso.state_task (state) VALUES ('Por ejecutar');
INSERT INTO acceso.state_task (state) VALUES ('En ejecución');
INSERT INTO acceso.state_task (state) VALUES ('Finalizada');

INSERT INTO acceso.user (email,first_name,institution,is_active,is_not_locked,join_date, last_name,`password`, profile_image_url,user_id,`username`,id_identification_type) VALUES ('estebanheredia@yopmail.com', 'Esteban','Fundación universitaria Konrad Lorenz', 1,1,'2023-04-13 02:21:29.655000', 'Heredia','3', 'https://api.multiavatar.com/1.svg','1NG3N1ER0','eheredia',1 );
INSERT INTO acceso.user (email,first_name,institution,is_active,is_not_locked,join_date, last_name,`password`,profile_image_url,user_id,`username`,id_identification_type) VALUES ('edgarpoveda@yopmail.com', 'Edgar','Fundación universitaria Konrad Lorenz', 1,1,'2023-04-13 02:21:29.655000','Poveda','3','https://api.multiavatar.com/2.svg','1NG3N1ER0','epoveda',1 );
INSERT INTO acceso.user (email,first_name,institution,is_active,is_not_locked,join_date, last_name,`password`,profile_image_url,user_id,`username`,id_identification_type) VALUES ('jorgebacca@yopmail.com', 'Jorge','Fundación universitaria Konrad Lorenz', 1,1,'2023-04-13 02:21:29.655000','Bacca','3','https://api.multiavatar.com/3.svg','D0C3NT3','jbacca',1 );

INSERT INTO acceso.phases(created_date,`description`,end_duration,ordering,`phase`,start_duration,created_by,id_state_phase) VALUES (now(), 'fase inicial',  now()+ interval 10 day, 1, 'fase inicial', now(), 2,1);
INSERT INTO acceso.phases(created_date,`description`,end_duration,ordering,`phase`,start_duration,created_by,id_state_phase) VALUES (now(), 'fase segunda',  now()+ interval 20 day, 2, 'fase segunda', now(), 2,1);
INSERT INTO acceso.phases(created_date,`description`,end_duration,ordering,`phase`,start_duration,created_by,id_state_phase) VALUES (now(), 'fase tercera',  now()+ interval 30 day, 3, 'fase terciaria', now(), 2,1);

INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (1,1);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (2,1);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (2,3);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (3,1);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (3,2);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (3,3);