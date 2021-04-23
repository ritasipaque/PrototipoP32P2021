CREATE DATABASE parcial2;
USE parcial2;
CREATE TABLE usuarios
(
  id int(30) auto_increment PRIMARY KEY ,
  usuario varchar(10) ,
  password varchar(45) ,
  nombre varchar(60) ,
  email varchar(30) ,
  idTipo int(11) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  tbl_cliente (
Id INT(20) NOT NULL, 
Nombre_cliente VARCHAR(25)  NOT NULL,  
Nit_cliente VARCHAR(25)  NOT NULL, 
Telefono_cliente VARCHAR(25)  NOT NULL,
Dpi_cliente VARCHAR(25)  NOT NULL,
Estatus VARCHAR(25)  NOT NULL, 
PRIMARY KEY (Id)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE  tbl_video (
Id INT(20) NOT NULL, 
Nombre_video VARCHAR(25)  NOT NULL,  
Tema_video VARCHAR(25)  NOT NULL, 
Idioma_video VARCHAR(25)  NOT NULL,
Autor_video VARCHAR(25)  NOT NULL,
Estatus VARCHAR(25)  NOT NULL, 
PRIMARY KEY (Id)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

