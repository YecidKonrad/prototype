INSERT INTO acceso.countries (country) VALUES ('Colombia');

INSERT INTO acceso.identification_types (identification, name, id_country) VALUES ('CC', 'Cedula', 1);

INSERT INTO acceso.state_phase (state) VALUES ('En ejecución');
INSERT INTO acceso.state_phase (state) VALUES ('Por ejecutar');
INSERT INTO acceso.state_phase (state) VALUES ('Finalizada');

INSERT INTO acceso.state_activity (state) VALUES ('Por ejecutar');
INSERT INTO acceso.state_activity (state) VALUES ('En ejecución');
INSERT INTO acceso.state_activity (state) VALUES ('Finalizada');

INSERT INTO acceso.state_task (state) VALUES ('Por ejecutar');
INSERT INTO acceso.state_task (state) VALUES ('En ejecución');
INSERT INTO acceso.state_task (state) VALUES ('Finalizada');

INSERT INTO acceso.user (email,first_name,institution,is_active,is_not_locked,join_date, last_name,`password`, profile_image_url,user_id,`username`,id_identification_type) VALUES ('allinas@yopmail.com', 'Andres','Millonarios F.C', 1,1,'2023-04-13 02:21:29.655000', 'Llinas','3', 'https://api.multiavatar.com/1.svg','C3NTR4L','allinas',1 );
INSERT INTO acceso.user (email,first_name,institution,is_active,is_not_locked,join_date, last_name,`password`,profile_image_url,user_id,`username`,id_identification_type) VALUES ('agamero@yopmail.com', 'Alberto','Millonarios F.C', 1,1,'2023-04-13 02:21:29.655000','agamero','3','https://api.multiavatar.com/2.svg','T3CN1C0','agamero',1 );
INSERT INTO acceso.user (email,first_name,institution,is_active,is_not_locked,join_date, last_name,`password`,profile_image_url,user_id,`username`,id_identification_type) VALUES ('dmckallister@yopmail.com', 'David','Millonarios F.C', 1,1,'2023-04-13 02:21:29.655000','Mckallister','3','https://api.multiavatar.com/3.svg','V0L4NT3','dmckallister',1 );

INSERT INTO acceso.phases(created_date,`description`,end_duration,ordering,`phase`,start_duration,created_by,id_state_phase) VALUES (now(), 'fase inicial',  now()+ interval 10 day, 1, 'fase inicial', now(), 2,1);
INSERT INTO acceso.phases(created_date,`description`,end_duration,ordering,`phase`,start_duration,created_by,id_state_phase) VALUES (now(), 'fase segunda',  now()+ interval 20 day, 2, 'fase segunda', now(), 2,1);
INSERT INTO acceso.phases(created_date,`description`,end_duration,ordering,`phase`,start_duration,created_by,id_state_phase) VALUES (now(), 'fase tercera',  now()+ interval 30 day, 3, 'fase terciaria', now(), 2,1);

INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (1,1);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (2,1);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (2,3);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (3,1);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (3,2);
INSERT INTO acceso.phase_user (id_phase, id_user) VALUES (3,3);