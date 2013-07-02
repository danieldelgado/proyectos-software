

INSERT INTO `parametro` (`id_parametro`,`activo`,`codigo`,`descripcion`,`estado`,`fecha_actualizacion`,`fecha_registro`,`nombre`,`tipo`,`valor`) VALUES 
 (1,1,'ffewfewfwfew','dwqdwqd','A','1990-10-10','1990-10-10 00:00:00','validadar formularios','validar','--');


INSERT INTO `recurso` (`id_recurso`,`activo`,`codigo`,`descripcion`,`estado`,`fecha_actualizacion`,`fecha_creacion`) VALUES
 (1,0x01,'Parametro','Lista Parametro','A','1990-10-10','1990-10-10 00:00:00'),
 (2,0x01,'Menu','Menu Parametro','A','1990-10-10','1990-10-10 00:00:00'),
 (3,0x01,'Boton Nuevo','Boton Nuevo','A','1990-10-10','1990-10-10 00:00:00'),
 (4,0x01,'Boton Guardar','Boton Guardar','A','1990-10-10','1990-10-10 00:00:00'),
 (5,0x01,'Menu Perfil','Menu Perfil','A','1990-10-10','1990-10-10 00:00:00'),
 (6,0x01,'Lista Perfil','Lista Perfil','A','1990-10-10','1990-10-10 00:00:00'),
 (7,0x01,'Menu Lista','Menu Lista','A','1990-10-10','1990-10-10 00:00:00'),
 (8,0x01,'Lista Lista','Lista Lista','A','1990-10-10','1990-10-10 00:00:00'),
 (9,0x01,'Menu Usuario','Menu Usuario','A','1990-10-10','1990-10-10 00:00:00'),
 (10,0x01,'Lista Usuario','Lista Usuario','A','1990-10-10','1990-10-10 00:00:00'),
 (11,0x01,'Menu Fechas Evento','Menu Fechas Evento','A','1990-10-10','1990-10-10 00:00:00'),
 (12,0x01,'Lista Fechas Evento','Menu Fechas Evento','A','1990-10-10','1990-10-10 00:00:00'),
 (13,0x01,'Menu Menu','Menu Menu','A','1990-10-10','1990-10-10 00:00:00'),
 (14,0x01,'Lista Menu','Lista Menu','A','1990-10-10','1990-10-10 00:00:00');


INSERT INTO `boton` (`bloqueable`,`icono`,`on_complete`,`on_submit`,`on_click`,`orden`,`parametros_json`,`tipo`,`url`,`id_recurso`) VALUES
 (1,NULL,NULL,NULL,NULL,1,NULL,'nuevo',NULL,3),
 (1,NULL,NULL,NULL,NULL,2,NULL,'guardar',NULL,4);




INSERT INTO `perfil` (`id_perfil`,`activo`,`codigo`,`descripcion`,`estado`,`fecha_actualizacion`,`fecha_creacion`,`nombre`) VALUES 
 (1,1,'12312fwewe','qdqwdqwfqw234','A','1990-10-10','1990-10-10 00:00:00','administrador');


INSERT INTO `persona` (`id_persona`,`activo`,`apellidos`,`celular`,`codigo`,`estado`,`fechaActualizacion`,`fecha_creacion`,`fecha_nacimiento`,`nombre`,`telefono_fijo`) VALUES
 (1,1,'admin',NULL,'63432','A','1990-10-10','1990-10-10 00:00:00','1990-10-10','admin',NULL);




INSERT INTO `recurso_por_perfil` (`responsable`,`id_recurso`,`id_perfil`) VALUES 
 (NULL,1,1),
 (NULL,2,1),
 (NULL,3,1),
 (NULL,4,1),
 (NULL,5,1),
 (NULL,6,1),
 (NULL,7,1),
 (NULL,8,1),
 (NULL,9,1),
 (NULL,10,1),
 (NULL,11,1),
 (NULL,12,1),
 (NULL,13,1),
 (NULL,14,1);

INSERT INTO `usuario` (`clave`,`estado_civil`,`login`,`numero_documento`,`ruc`,`tipo_documento`,`id_persona`) VALUES 
 ('123456',1,'admin','123213','32131',1,1);

INSERT INTO `usuario_por_perfil` (`id_usuario`,`id_perfil`) VALUES 
 (1,1);



INSERT INTO `menu` (`defaultMenu`,`function`,`nombre`,`orden`,`tipo`,`todos`,`url`,`id_recurso`,`menu_id_recurso`) VALUES
 (1,NULL,'Parametro',0,'interno',0,'Parametro',2,NULL),
 (0,NULL,'Perfil',1,'interno',0,'Perfil',5,NULL),
 (0,NULL,'Lista',2,'interno',0,'Lista',7,NULL),
 (0,NULL,'Usuario',3,'interno',0,'Usuario',9,NULL),
 (0,NULL,'Fechas Evento',4,'interno',0,'Fechas Evento',11,NULL);

INSERT INTO `lista` (`id_menu`,`nombre`,`tabla`,`id_recurso`) VALUES
 (2,'Parametro','Parametro',1),
 (5,'Perfil','Perfil',6),
 (7,'Lista','Lista',8),
 (9,'Usuario','Usuario',10),
 (11,'Fecha Evento','Fecha Evento',12),
 (13,'Menu','Menu',14);


INSERT INTO `lista_por_menu` (`id_lista`,`id_recurso`) VALUES
 (1,2);




INSERT INTO `boton_por_menu` (`id_menu`,`id_recurso`) VALUES
 (2,3),
 (2,4);


INSERT INTO `columna` (`id_columna`,`activo`,`addColumn`,`alineacion`,`ancho`,`atributo`,`cabecera`,`codigo`,`estado`,`fecha_actualizacion`,`fecha_registro`,`formato_tipo`,`mapping`,`orden`,`tabla`,`visible`) VALUES 
 (1,1,1,NULL,0,'id',NULL,'wefewfwf',NULL,NULL,NULL,'wefwe',1,1,'Parametro',0),
 (2,1,1,NULL,100,'codigo','Codigo','wefewf',NULL,NULL,NULL,'wefwefgeytjty',1,2,'Parametro',1),
 (3,1,1,NULL,100,'activo','Activo','gghrttr3ewf',NULL,NULL,NULL,'fwefweegweg',1,3,'Parametro',1),
 (4,1,1,NULL,100,'descripcion','Descripcion','gghrttr3ewf45',NULL,NULL,NULL,'wefew',1,4,'Parametro',1),
 (5,1,1,NULL,100,'valor','Valor','gghrttr3ewf455634',NULL,NULL,NULL,'fwewefew',1,5,'Parametro',1),
 (6,1,1,NULL,0,'id',NULL,'weffewfef',NULL,NULL,NULL,'qwdwqd',1,1,'Perfil',0),
 (7,1,1,NULL,100,'codigo','Codigo','wfweewht2',NULL,NULL,NULL,'ewfewfefew',1,2,'Perfil',1),
 (8,1,1,NULL,100,'descripcion','Descripcion','wefewfwf',NULL,NULL,NULL,'wefwe',1,3,'Perfil',1),
 (9,1,1,NULL,100,'estado','Estado','wefewf',NULL,NULL,NULL,'wefwefgeytjty',1,4,'Perfil',1),
 (10,1,1,NULL,100,'nombre','Nombre','gghrttr3ewf',NULL,NULL,NULL,'fwefweegweg',1,5,'Perfil',1),
 (11,1,1,NULL,0,'id',NULL,'fewwe',NULL,NULL,NULL,'wefew',1,1,'Lista',0),
 (12,1,1,NULL,100,'nombre','Nombre','gghrttr3ewf455634',NULL,NULL,NULL,'fwewefew',1,2,'Lista',1),
 (13,1,1,NULL,100,'tabla','Tabla','weffewfef',NULL,NULL,NULL,'qwdwqd',1,3,'Lista',1),
 (14,1,1,NULL,100,'id_menu','Menu','wfweewht2',NULL,NULL,NULL,'ewfewfefew',1,4,'Lista',1),
 (15,1,1,NULL,100,'id',NULL,'regre',NULL,NULL,NULL,'wefwe',1,1,'Menu',0),
 (16,1,1,NULL,100,'nombre','Nombre','hytjyj',NULL,NULL,NULL,'jytjjtyjty',1,2,'Menu',1),
 (17,1,1,NULL,100,'url','Url','ergerg',NULL,NULL,NULL,'wefewf',1,3,'Menu',1),
 (18,1,1,NULL,100,'orden','Orden','jyt',NULL,NULL,NULL,'gewg',1,4,'Menu',1),
 (19,1,1,NULL,100,'tipo','Tipo','kuyk',NULL,NULL,NULL,'weg',1,5,'Menu',1),
 (20,1,1,NULL,100,'todos','Todos','kuykuy',NULL,NULL,NULL,'hthtrhtrh',1,6,'Menu',1),
 (21,1,1,NULL,0,'id',NULL,'qewdffewf',NULL,NULL,NULL,'wfew',1,1,'Usuario',0),
 (22,1,1,NULL,100,'nombre','Nombre','wefewfewg',NULL,NULL,NULL,'fwethtrhr',1,2,'Usuario',1);


INSERT INTO `columna_por_lista` (`id_columna`,`id_recurso`) VALUES
 (1,1),
 (2,1),
 (3,1),
 (4,1),
 (5,1),
 (6,6),
 (7,6),
 (8,6),
 (9,6),
 (10,6),
 (11,8),
 (12,8),
 (13,8),
 (14,8),
 (21,10),
 (22,10),
 (15,14),
 (16,14),
 (17,14),
 (18,14),
 (19,14),
 (20,14);

